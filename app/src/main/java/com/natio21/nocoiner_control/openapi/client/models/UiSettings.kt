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

import com.natio21.nocoiner_control.openapi.client.models.Consts
import com.natio21.nocoiner_control.openapi.client.models.Locale
import com.natio21.nocoiner_control.openapi.client.models.Timezone
import com.natio21.nocoiner_control.openapi.client.models.UiTheme

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param consts 
 * @param darkSidePane 
 * @param disableAnimation 
 * @param locale 
 * @param theme 
 * @param timezone 
 */


data class UiSettings (

    @Json(name = "consts")
    val consts: Consts? = null,

    @Json(name = "dark_side_pane")
    val darkSidePane: kotlin.Boolean? = null,

    @Json(name = "disable_animation")
    val disableAnimation: kotlin.Boolean? = null,

    @Json(name = "locale")
    val locale: Locale? = null,

    @Json(name = "theme")
    val theme: UiTheme? = null,

    @Json(name = "timezone")
    val timezone: Timezone? = null

) {


}

