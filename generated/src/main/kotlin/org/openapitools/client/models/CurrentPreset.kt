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

import com.natio21.nocoiner_control.openapi.client.models.AutotunePresetStatus
import com.natio21.nocoiner_control.openapi.client.models.GlobalsRaw

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param moddedPsuRequired 
 * @param name Preset id name
 * @param pretty Preset human-readable name
 * @param status 
 * @param globals Globals passed here when preset is disabled
 */


data class CurrentPreset (

    @Json(name = "modded_psu_required")
    val moddedPsuRequired: kotlin.Boolean,

    /* Preset id name */
    @Json(name = "name")
    val name: kotlin.String,

    /* Preset human-readable name */
    @Json(name = "pretty")
    val pretty: kotlin.String,

    @Json(name = "status")
    val status: AutotunePresetStatus,

    /* Globals passed here when preset is disabled */
    @Json(name = "globals")
    val globals: GlobalsRaw? = null

) {


}

