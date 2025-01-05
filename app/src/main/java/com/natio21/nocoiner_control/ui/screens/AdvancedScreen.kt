package com.natio21.nocoiner_control.ui.screens;

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.natio21.nocoiner_control.MainViewModel
import com.natio21.nocoiner_control.Pool
import com.natio21.nocoiner_control.R
import com.natio21.nocoiner_control.ui.theme.NatioOrange40
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun AdvancedScreen(viewModel: MainViewModel) {
    val advancedState by viewModel.advancedUiState.collectAsState()
    val scrollState = rememberScrollState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {

        DisposableEffect(Unit) {
            val job = viewModel.viewModelScope.launch {
                while (true) {
                    viewModel.getSummary()
                    delay(5000)
                }
            }
            onDispose {
                job.cancel()
            }
        }
        Image(
            painter = painterResource(id = R.drawable.dosc),
            contentDescription = "2c Image",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Type: ${advancedState.summary?.miner?.miner_type}",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Status: ${advancedState.summary?.miner?.miner_status?.miner_state}",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (advancedState.isLoading) {
            CircularProgressIndicator()
        } else {
            Text(
                //trunc to 2 decimals hashrate: summary.miner.average_hashrate
                text = "Hashrate: ${
                    String.format(
                        "%.2f",
                        advancedState.summary?.miner?.average_hashrate ?: 0.0
                    )
                } TH/s",
                style = MaterialTheme.typography.titleLarge
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Average Hashrate: ${advancedState.summary?.miner?.hr_average}",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Nominal Hashrate: ${advancedState.summary?.miner?.hr_nominal}",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Found Blocks: ${advancedState.summary?.miner?.found_blocks}",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "PCB temp: ${advancedState.summary?.miner?.pcb_temp?.min}ºC-${advancedState.summary?.miner?.pcb_temp?.max}ºC",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Chip temp: ${advancedState.summary?.miner?.chip_temp?.min}ºC-${advancedState.summary?.miner?.chip_temp?.max}ºC",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Power: ${advancedState.summary?.miner?.power_consumption}W - efficiency ${advancedState.summary?.miner?.power_efficiency}%",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (advancedState.summary?.miner?.pools != null) {
            for (pool in advancedState.summary?.miner?.pools!!) {
                Text(
                    "Pool ${pool.id}: ${pool.url} - ${pool.pool_type} - ${pool.status}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Fan duty: ${advancedState.summary?.miner?.cooling?.fan_duty}% - fan count: ${advancedState.summary?.miner?.cooling?.fan_num}",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (advancedState.summary?.miner?.cooling?.fans != null) {
            for (fan in advancedState.summary?.miner?.cooling?.fans!!) {
                Text(
                    "Fan ${fan.id} : ${fan.rpm}/${fan.maxRpm} RPM - status ${fan.status}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Best share: ${advancedState.summary?.miner?.best_share}",
            style = MaterialTheme.typography.bodyMedium
        )


        Spacer(modifier = Modifier.height(16.dp))
        //LazyColumn {
        //    items(advancedState.pools) { pool ->
        //        PoolItem(
        //            pool = pool,
        //            onEditClick = { viewModel.editPool(pool) },
        //            onDeleteClick = { viewModel.deletePool(pool) }
        //        )
        //    }
        //}
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.createNewPool()
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(NatioOrange40),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Pool")
        }
        Spacer(modifier = Modifier.height(32.dp))
        //Text("Hashrate: ${advancedState.hashrate}")

        Button(
            onClick = {
                viewModel.openMinerWeb()
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(NatioOrange40),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go to Miner Web")
        }
    }
}

@Composable
fun PoolItem(pool: Pool, onEditClick: () -> Unit, onDeleteClick: () -> Unit) {
    Row(Modifier.fillMaxWidth()) {
        Text("URL: ${pool.url} Priority: ${pool.priority}")
        IconButton(onClick = onEditClick) {
            Icon(Icons.Default.Edit, contentDescription = "Edit")
        }
        IconButton(onClick = onDeleteClick) {
            Icon(Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}
