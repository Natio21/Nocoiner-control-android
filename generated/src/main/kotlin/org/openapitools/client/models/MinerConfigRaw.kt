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

import com.natio21.nocoiner_control.openapi.client.models.AdvancedSettings
import com.natio21.nocoiner_control.openapi.client.models.CoolingSettingsRaw
import com.natio21.nocoiner_control.openapi.client.models.OverclockSettingsRaw

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param cooling 
 * @param misc 
 * @param overclock 
 * @param pools 
 */


data class MinerConfigRaw (

    @Json(name = "cooling")
    val cooling: CoolingSettingsRaw? = null,

    @Json(name = "misc")
    val misc: AdvancedSettings? = null,

    @Json(name = "overclock")
    val overclock: OverclockSettingsRaw? = null,

    @Json(name = "pools")
    val pools: kotlin.collections.List<kotlin.Any>? = null

) {


}

