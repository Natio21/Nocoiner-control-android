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


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param chipMaxTemp 
 * @param fanDuty 
 * @param hashrate 
 * @param pcbMaxTemp 
 * @param powerConsumption 
 */


data class MetricsData (

    @Json(name = "chip_max_temp")
    val chipMaxTemp: kotlin.Int,

    @Json(name = "fan_duty")
    val fanDuty: kotlin.Int,

    @Json(name = "hashrate")
    val hashrate: kotlin.Double,

    @Json(name = "pcb_max_temp")
    val pcbMaxTemp: kotlin.Int,

    @Json(name = "power_consumption")
    val powerConsumption: kotlin.Int

) {


}

