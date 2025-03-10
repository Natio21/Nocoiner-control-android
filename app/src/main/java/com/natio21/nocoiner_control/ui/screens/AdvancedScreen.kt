package com.natio21.nocoiner_control.ui.screens;

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.natio21.nocoiner_control.DateTimeUtils
import com.natio21.nocoiner_control.MainViewModel
import com.natio21.nocoiner_control.R
import com.natio21.nocoiner_control.ui.theme.NatioOrangeDD
import com.natio21.nocoiner_control.ui.theme.NocoinercontrolTheme
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberBottom
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberStart
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberColumnCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.core.cartesian.CartesianMeasuringContext
import com.patrykandpatrick.vico.core.cartesian.axis.Axis
import com.patrykandpatrick.vico.core.cartesian.axis.HorizontalAxis
import com.patrykandpatrick.vico.core.cartesian.axis.VerticalAxis
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.cartesian.data.CartesianValueFormatter
import com.patrykandpatrick.vico.core.cartesian.data.columnSeries
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter


@Composable
fun AdvancedScreen(viewModel: MainViewModel, navController: NavController) {
    val uiState by viewModel.basicUiState.collectAsState()
    val advancedState by viewModel.advancedUiState.collectAsState()
    val isDarkTheme = isSystemInDarkTheme()
    val colorFilter = if (isDarkTheme) ColorFilter.tint(Color.Gray) else null
    val metrics = uiState.metrics


    NocoinercontrolTheme {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            item {
                DisposableEffect(Unit) {
                    val job = viewModel.viewModelScope.launch {
                        while (true) {
                            viewModel.getSummaryAndSettings()
                            delay(20000)
                        }
                    }
                    onDispose {
                        job.cancel()
                    }
                }
                Image(
                    painter = painterResource(id = R.mipmap.ic_launcher_foreground),
                    contentDescription = "2c Image",
                    modifier = Modifier.size(100.dp),
                    colorFilter = colorFilter
                )
                Spacer(modifier = Modifier.height(16.dp))
            }


            // Miner
            val minerTitles: List<String> = listOf("miner", "status")
            val minerInfo: List<String> = listOf(
                "${advancedState.summary?.miner?.miner_type}",
                "${advancedState.summary?.miner?.miner_status?.miner_state}",

                )
            val minerMatrix = listOf(minerTitles, minerInfo)
            item { MatrixDashboardCard(title = "Miner", dataMatrix = minerMatrix) }

            // Hashrate
            val hashrateInfo: List<String> = listOf(
                String.format(
                    "%.2f",
                    advancedState.summary?.miner?.hr_average?.div(1000) ?: 0.0
                ) + "TH/s",
                String.format(
                    "%.2f",
                    advancedState.summary?.miner?.hr_nominal?.div(1000) ?: 0.0
                ) + "TH/s",
                String.format(
                    "%.2f",
                    advancedState.summary?.miner?.hr_realtime?.div(1000) ?: 0.0
                ) + "TH/s",
                "${advancedState.summary?.miner?.found_blocks}"
            )

            val hasrateTitles: List<String> =
                listOf("average", "realtime", "found blocks")
            val hashrateMatix = listOf(hasrateTitles, hashrateInfo)
            item { MatrixDashboardCard(title = "Hashrate", dataMatrix = hashrateMatix) }


            item {
                metrics?.let {
                    val hashrates = it.map { metric -> metric.data.hashrate }
                    val power_consumption = it.map { metric -> metric.data.power_consumption }
                    val fan_duty = it.map { metric -> metric.data.fan_duty }
                    val chip_max_temp = it.map { metric -> metric.data.chip_max_temp }
                    val pcb_max_temp = it.map { metric -> metric.data.pcb_max_temp }

                    val times = it.map { metric -> DateTimeUtils.getHour(metric.time) }


                    val timesHours =
                        it.map { metric -> DateTimeUtils.convertUnixTimeToReadable(metric.time) }


                    //Log arrays sizes
                    Log.d("HomeScreen", "hashrates size: ${hashrates.size}")
                    Log.d("HomeScreen", "power_consumption size: ${power_consumption.size}")
                    Log.d("HomeScreen", "fan_duty size: ${fan_duty.size}")
                    Log.d("HomeScreen", "chip_max_temp size: ${chip_max_temp.size}")
                    Log.d("HomeScreen", "pcb_max_temp size: ${pcb_max_temp.size}")
                    Log.d("HomeScreen", "times size: ${times.size}")
                    Log.d("HomeScreen", "timesHours size: ${timesHours.size}")


                    Text(
                        "HASHRATE",
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onBackground
                    )


                    val modelProducerHashrate = remember { CartesianChartModelProducer() }
                    LaunchedEffect(Unit) {
                        modelProducerHashrate.runTransaction {
                            columnSeries { series(times, hashrates) }
                        }
                    }
                    CartesianChartHost(
                        rememberCartesianChart(
                            rememberColumnCartesianLayer(
                                //color orange

                            ),
                            startAxis = VerticalAxis.rememberStart(),
                            bottomAxis = HorizontalAxis.rememberBottom(),
                        ),
                        modelProducerHashrate,
                    )


                    val bottomAxisValueFormatter =
                        object : CartesianValueFormatter {

                            override fun format(
                                context: CartesianMeasuringContext,
                                value: Double,
                                verticalAxisPosition: Axis.Position.Vertical?,
                                //) = dateFormat.format(value * MS_IN_H)
                            ) = timesHours[value.toInt()]

                        }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            // Temperature MatrixDashboardCard
            val temperatureInfo: List<String> = listOf(
                "${advancedState.summary?.miner?.pcb_temp?.min}ºC-${advancedState.summary?.miner?.pcb_temp?.max}ºC",
                "${advancedState.summary?.miner?.chip_temp?.min}ºC-${advancedState.summary?.miner?.chip_temp?.max}ºC"
            )
            val temperatureTitles: List<String> = listOf("PCB Temp", "Chip Temp")
            val temperatureMatrix = listOf(temperatureTitles, temperatureInfo)
            item { MatrixDashboardCard(title = "Temperature", dataMatrix = temperatureMatrix) }


            item {
                metrics?.let {
                    val hashrates = it.map { metric -> metric.data.hashrate }
                    val power_consumption = it.map { metric -> metric.data.power_consumption }
                    val fan_duty = it.map { metric -> metric.data.fan_duty }
                    val chip_max_temp = it.map { metric -> metric.data.chip_max_temp }
                    val pcb_max_temp = it.map { metric -> metric.data.pcb_max_temp }

                    val times = it.map { metric -> DateTimeUtils.getHour(metric.time) }


                    val timesHours =
                        it.map { metric -> DateTimeUtils.convertUnixTimeToReadable(metric.time) }


                    //Log arrays sizes
                    Log.d("HomeScreen", "hashrates size: ${hashrates.size}")
                    Log.d("HomeScreen", "power_consumption size: ${power_consumption.size}")
                    Log.d("HomeScreen", "fan_duty size: ${fan_duty.size}")
                    Log.d("HomeScreen", "chip_max_temp size: ${chip_max_temp.size}")
                    Log.d("HomeScreen", "pcb_max_temp size: ${pcb_max_temp.size}")
                    Log.d("HomeScreen", "times size: ${times.size}")
                    Log.d("HomeScreen", "timesHours size: ${timesHours.size}")


                    Text(
                        "TEMPERTATURE ",
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    val modelProducerTemperature = remember { CartesianChartModelProducer() }
                    LaunchedEffect(Unit) {
                        modelProducerTemperature.runTransaction {
                            columnSeries { series(times, chip_max_temp) }
                        }
                    }
                    CartesianChartHost(
                        rememberCartesianChart(
                            rememberColumnCartesianLayer(),
                            startAxis = VerticalAxis.rememberStart(),
                            bottomAxis = HorizontalAxis.rememberBottom(),
                            //bottomAxis = HorizontalAxis.rememberBottom(guideline = null, valueFormatter = bottomAxisValueFormatter),

                        ),
                        modelProducerTemperature,

                        )
                }
            }

            // Power MatrixDashboardCard
            val powerInfo: List<String> = listOf(
                "${advancedState.summary?.miner?.power_consumption}W",
                "${advancedState.summary?.miner?.power_efficiency}%"
            )
            val powerTitles: List<String> = listOf("Power Consumption", "Efficiency")
            val powerMatrix = listOf(powerTitles, powerInfo)
            item { MatrixDashboardCard(title = "Power", dataMatrix = powerMatrix) }

            item {
                metrics?.let {
                    val hashrates = it.map { metric -> metric.data.hashrate }
                    val power_consumption = it.map { metric -> metric.data.power_consumption }
                    val fan_duty = it.map { metric -> metric.data.fan_duty }
                    val chip_max_temp = it.map { metric -> metric.data.chip_max_temp }
                    val pcb_max_temp = it.map { metric -> metric.data.pcb_max_temp }

                    val times = it.map { metric -> DateTimeUtils.getHour(metric.time) }


                    val timesHours =
                        it.map { metric -> DateTimeUtils.convertUnixTimeToReadable(metric.time) }


                    //Log arrays sizes
                    Log.d("HomeScreen", "hashrates size: ${hashrates.size}")
                    Log.d("HomeScreen", "power_consumption size: ${power_consumption.size}")
                    Log.d("HomeScreen", "fan_duty size: ${fan_duty.size}")
                    Log.d("HomeScreen", "chip_max_temp size: ${chip_max_temp.size}")
                    Log.d("HomeScreen", "pcb_max_temp size: ${pcb_max_temp.size}")
                    Log.d("HomeScreen", "times size: ${times.size}")
                    Log.d("HomeScreen", "timesHours size: ${timesHours.size}")


                    Text(
                        "POWER CONSUMPTION",
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    val modelProducerPower = remember { CartesianChartModelProducer() }
                    LaunchedEffect(Unit) {
                        modelProducerPower.runTransaction {
                            columnSeries { series(times, power_consumption) }
                        }
                    }
                    CartesianChartHost(
                        rememberCartesianChart(
                            rememberColumnCartesianLayer(),
                            startAxis = VerticalAxis.rememberStart(),
                            bottomAxis = HorizontalAxis.rememberBottom(),
                            //bottomAxis = HorizontalAxis.rememberBottom(guideline = null, valueFormatter = bottomAxisValueFormatter),

                        ),
                        modelProducerPower,

                        )


                }
            }

            // Pools MatrixDashboardCard
            val poolsTitles: List<String> = listOf("Pool", "Type", "Status", "Lantency")
            val poolsInfo: List<List<String>> = advancedState.summary?.miner?.pools?.map { pool ->
                listOf(pool.url, pool.pool_type, pool.status, pool.ping.toString())
            } ?: emptyList()
            val poolMatrix = listOf(poolsTitles) + poolsInfo
            item { MatrixDashboardCard(title = "Pools", dataMatrix = poolMatrix) }

            // DevFee MatrixDashboardCard
            val devFeeInfo: List<String> = listOf(
                "${advancedState.summary?.miner?.devfee}GH/s",
                "${advancedState.summary?.miner?.devfee_percent}%"
            )
            val devFeeTitles: List<String> = listOf("DevFee", "DevFee Percent")
            val devFeeMatrix = listOf(devFeeTitles, devFeeInfo)
            item { MatrixDashboardCard(title = "DevFee", dataMatrix = devFeeMatrix) }

            // Fans MatrixDashboardCard
            val fansInfo: List<List<String>> =
                listOf(
                    listOf(
                        "${advancedState.summary?.miner?.cooling?.fan_num} Fans",
                        "Duty",
                        "${advancedState.summary?.miner?.cooling?.fan_duty}%"
                    )
                ) +
                        listOf(listOf("", "", "")) +
                        listOf(listOf("id", "RPM", "Status")) +
                        (advancedState.summary?.miner?.cooling?.fans?.map { fan ->
                            listOf(fan.id.toString(), fan.rpm.toString(), fan.status.toString())
                        } ?: emptyList())
            item { MatrixDashboardCard(title = "Fans", dataMatrix = fansInfo) }

            item {
                metrics?.let {
                    val hashrates = it.map { metric -> metric.data.hashrate }
                    val power_consumption = it.map { metric -> metric.data.power_consumption }
                    val fan_duty = it.map { metric -> metric.data.fan_duty }
                    val chip_max_temp = it.map { metric -> metric.data.chip_max_temp }
                    val pcb_max_temp = it.map { metric -> metric.data.pcb_max_temp }

                    val times = it.map { metric -> DateTimeUtils.getHour(metric.time) }


                    val timesHours =
                        it.map { metric -> DateTimeUtils.convertUnixTimeToReadable(metric.time) }


                    //Log arrays sizes
                    Log.d("HomeScreen", "hashrates size: ${hashrates.size}")
                    Log.d("HomeScreen", "power_consumption size: ${power_consumption.size}")
                    Log.d("HomeScreen", "fan_duty size: ${fan_duty.size}")
                    Log.d("HomeScreen", "chip_max_temp size: ${chip_max_temp.size}")
                    Log.d("HomeScreen", "pcb_max_temp size: ${pcb_max_temp.size}")
                    Log.d("HomeScreen", "times size: ${times.size}")
                    Log.d("HomeScreen", "timesHours size: ${timesHours.size}")


                    Text(
                        "FAN DUTY ",
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    val modelProducerFans = remember { CartesianChartModelProducer() }
                    LaunchedEffect(Unit) {
                        modelProducerFans.runTransaction {
                            columnSeries { series(times, fan_duty) }
                        }
                    }
                    CartesianChartHost(
                        rememberCartesianChart(
                            rememberColumnCartesianLayer(),
                            startAxis = VerticalAxis.rememberStart(),
                            bottomAxis = HorizontalAxis.rememberBottom(),
                            //bottomAxis = HorizontalAxis.rememberBottom(guideline = null, valueFormatter = bottomAxisValueFormatter),

                        ),
                        modelProducerFans,

                        )
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /*viewModel.createNewPool()*/
                        navController.navigate("edit_pools")
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(NatioOrangeDD),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Edit Pool", color = Color.White)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { viewModel.openMinerWeb() },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(NatioOrangeDD),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Go to Miner Web", color = Color.White)
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun DashboardCard(title: String, content: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = content, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun MatrixDashboardCard(title: String, dataMatrix: List<List<String>>) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            val longestRowSize = dataMatrix.maxOfOrNull { it.size } ?: 0
            dataMatrix.forEach { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    rowItems.forEach { content ->
                        Text(
                            text = content,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentWidth(Alignment.Start),
                        )
                    }
                    repeat(longestRowSize - rowItems.size) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}