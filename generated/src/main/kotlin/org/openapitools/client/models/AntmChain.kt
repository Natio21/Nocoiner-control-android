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

import com.natio21.nocoiner_control.openapi.client.models.ChainChipStatuses
import com.natio21.nocoiner_control.openapi.client.models.ChainStatus
import com.natio21.nocoiner_control.openapi.client.models.TempRange

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param chipStatuses 
 * @param chipTemp 
 * @param frequency 
 * @param hashrateIdeal 
 * @param hashratePercentage 
 * @param hashrateRt 
 * @param hrError 
 * @param hwErrors 
 * @param id 
 * @param pcbTemp 
 * @param powerConsumption 
 * @param status 
 * @param voltage 
 */


data class AntmChain (

    @Json(name = "chip_statuses")
    val chipStatuses: ChainChipStatuses,

    @Json(name = "chip_temp")
    val chipTemp: TempRange,

    @Json(name = "frequency")
    val frequency: kotlin.Float,

    @Json(name = "hashrate_ideal")
    val hashrateIdeal: kotlin.Float,

    @Json(name = "hashrate_percentage")
    val hashratePercentage: kotlin.Float,

    @Json(name = "hashrate_rt")
    val hashrateRt: kotlin.Float,

    @Json(name = "hr_error")
    val hrError: kotlin.Float,

    @Json(name = "hw_errors")
    val hwErrors: kotlin.Int,

    @Json(name = "id")
    val id: kotlin.Int,

    @Json(name = "pcb_temp")
    val pcbTemp: TempRange,

    @Json(name = "power_consumption")
    val powerConsumption: kotlin.Int,

    @Json(name = "status")
    val status: ChainStatus,

    @Json(name = "voltage")
    val voltage: kotlin.Int

) {


}

