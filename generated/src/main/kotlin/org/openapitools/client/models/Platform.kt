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
 * Platform type code aml|bb|cv|stm|xil (Amlogic/BeagleBone/Cvitek/STM/Xilix)
 *
 * Values: aml,bb,cv,stm,xil
 */

@JsonClass(generateAdapter = false)
enum class Platform(val value: kotlin.String) {

    @Json(name = "aml")
    aml("aml"),

    @Json(name = "bb")
    bb("bb"),

    @Json(name = "cv")
    cv("cv"),

    @Json(name = "stm")
    stm("stm"),

    @Json(name = "xil")
    xil("xil");

    /**
     * Override [toString()] to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): kotlin.String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is Platform) "$data" else null

        /**
         * Returns a valid [Platform] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): Platform? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

