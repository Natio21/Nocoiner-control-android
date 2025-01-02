package com.natio21.nocoiner_control.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.natio21.nocoiner_control.MainViewModel
import com.natio21.nocoiner_control.R
import com.natio21.nocoiner_control.ui.theme.NatioOrange40

@Composable
fun WizardScreen(
    onWizardComplete: () -> Unit,
    viewModel: MainViewModel,
) {
    val ip by viewModel.ip
    val apiKey by viewModel.apiKey

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.dosc),
            contentDescription = "2c Image",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Setup your Miner")

        OutlinedTextField(
            value = ip,
            onValueChange = { viewModel.updateIp(it) },
            label = { Text("Miner IP or DNS") },
            placeholder = { Text("Miner IP or DNS") },
        )

        OutlinedTextField(
            value = apiKey,
            onValueChange = { viewModel.updateApiKey(it) },
            label = { Text("API Key") },
            placeholder = { Text("API Key") },
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.validateAndSave { isValid ->
                    if (isValid) {
                        viewModel.updateIp(ip)
                        viewModel.updateApiKey(apiKey)
                        Log.d("SettingsScreen", "IP: $ip and API Key: $apiKey saved")
                        onWizardComplete()
                    } else {
                        Log.e("SettingsScreen", "Error saving IP and API Key")
                    }
                }
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(NatioOrange40),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save")
        }

        Spacer(modifier = Modifier.height(16.dp))


    }
}