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
import androidx.compose.foundation.shape.RoundedCornerShape
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

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        DisposableEffect(Unit) {
            val job = viewModel.viewModelScope.launch {
                while (true) {
                    viewModel.getHashrate()
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
        if (advancedState.isLoading) {
            CircularProgressIndicator()
        } else {
            Text(
                //trunc to 2 decimals hashrate: summary.miner.average_hashrate
                text = "Hashrate: ${String.format("%.2f", advancedState.hashrate.toDoubleOrNull() ?: 0.0)} TH/s",
                style = MaterialTheme.typography.titleLarge
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Mining Pools", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(advancedState.pools) { pool ->
                PoolItem(
                    pool = pool,
                    onEditClick = { viewModel.editPool(pool) },
                    onDeleteClick = { viewModel.deletePool(pool) }
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.createNewPool() },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(NatioOrange40),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Pool")
        }
        Spacer(modifier = Modifier.height(32.dp))
        //Text("Hashrate: ${advancedState.hashrate}")

        Button(onClick = {
            viewModel.openMinerWeb()},
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
