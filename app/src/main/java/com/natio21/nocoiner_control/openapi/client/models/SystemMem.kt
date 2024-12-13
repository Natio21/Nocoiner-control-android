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
 * @param memBuf 
 * @param memBufPercent 
 * @param memFree 
 * @param memFreePercent 
 * @param memTotal 
 */


data class SystemMem (

    @Json(name = "mem_buf")
    val memBuf: kotlin.Int,

    @Json(name = "mem_buf_percent")
    val memBufPercent: kotlin.Int,

    @Json(name = "mem_free")
    val memFree: kotlin.Int,

    @Json(name = "mem_free_percent")
    val memFreePercent: kotlin.Int,

    @Json(name = "mem_total")
    val memTotal: kotlin.Int

) {


}

