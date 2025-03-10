/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.natio21.nocoiner_control.openapi.client.models

import com.natio21.nocoiner_control.openapi.client.models.AntmChain
import com.natio21.nocoiner_control.openapi.client.models.Cooling
import com.natio21.nocoiner_control.openapi.client.models.MinerStatus
import com.natio21.nocoiner_control.openapi.client.models.PoolStats
import com.natio21.nocoiner_control.openapi.client.models.TempRange

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param averageHashrate Deprecated. Same as hr_average but measure is MG/s.
 * @param bestShare 
 * @param chains 
 * @param chipTemp 
 * @param cooling 
 * @param devfee 
 * @param devfeePercent 
 * @param foundBlocks 
 * @param hrAverage 
 * @param hrError Errors rate
 * @param hrNominal 
 * @param hrRealtime 
 * @param hrStock 
 * @param hwErrors 
 * @param hwErrorsPercent 
 * @param instantHashrate Deprecated. Same as hr_realtime but measure is MG/s.
 * @param minerStatus 
 * @param minerType 
 * @param pcbTemp 
 * @param pools 
 * @param powerConsumption 
 * @param powerEfficiency 
 * @param powerUsage Deprecated. Same as power_efficiency
 */


data class AntmMinerStats (

    /* Deprecated. Same as hr_average but measure is MG/s. */
    @Json(name = "average_hashrate")
    @Deprecated(message = "This property is deprecated.")
    val averageHashrate: kotlin.Float,

    @Json(name = "best_share")
    val bestShare: kotlin.Long,

    @Json(name = "chains")
    val chains: kotlin.collections.List<AntmChain>,

    @Json(name = "chip_temp")
    val chipTemp: TempRange,

    @Json(name = "cooling")
    val cooling: Cooling,

    @Json(name = "devfee")
    val devfee: kotlin.Float,

    @Json(name = "devfee_percent")
    val devfeePercent: kotlin.Float,

    @Json(name = "found_blocks")
    val foundBlocks: kotlin.Int,

    @Json(name = "hr_average")
    val hrAverage: kotlin.Float,

    /* Errors rate */
    @Json(name = "hr_error")
    val hrError: kotlin.Float,

    @Json(name = "hr_nominal")
    val hrNominal: kotlin.Float,

    @Json(name = "hr_realtime")
    val hrRealtime: kotlin.Float,

    @Json(name = "hr_stock")
    val hrStock: kotlin.Float,

    @Json(name = "hw_errors")
    val hwErrors: kotlin.Int,

    @Json(name = "hw_errors_percent")
    val hwErrorsPercent: kotlin.Float,

    /* Deprecated. Same as hr_realtime but measure is MG/s. */
    @Json(name = "instant_hashrate")
    @Deprecated(message = "This property is deprecated.")
    val instantHashrate: kotlin.Float,

    @Json(name = "miner_status")
    val minerStatus: MinerStatus,

    @Json(name = "miner_type")
    val minerType: kotlin.String,

    @Json(name = "pcb_temp")
    val pcbTemp: TempRange,

    @Json(name = "pools")
    val pools: kotlin.collections.List<PoolStats>,

    @Json(name = "power_consumption")
    val powerConsumption: kotlin.Int,

    @Json(name = "power_efficiency")
    val powerEfficiency: kotlin.Float,

    /* Deprecated. Same as power_efficiency */
    @Json(name = "power_usage")
    @Deprecated(message = "This property is deprecated.")
    val powerUsage: kotlin.Int

) {


}

