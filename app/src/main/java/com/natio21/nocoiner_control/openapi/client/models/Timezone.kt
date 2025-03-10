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
 * Current timezone name (code)
 *
 * Values: GMTPlus1,GMTPlus2,GMTPlus3,GMTPlus4,GMTPlus5,GMTPlus6,GMTPlus7,GMTPlus8,GMTPlus9,GMTPlus10,GMTPlus11,GMTPlus12,GMT,GMTMinus1,GMTMinus2,GMTMinus3,GMTMinus4,GMTMinus5,GMTMinus6,GMTMinus7,GMTMinus8,GMTMinus9,GMTMinus10,GMTMinus11
 */

@JsonClass(generateAdapter = false)
enum class Timezone(val value: kotlin.String) {

    @Json(name = "GMT+1")
    GMTPlus1("GMT+1"),

    @Json(name = "GMT+2")
    GMTPlus2("GMT+2"),

    @Json(name = "GMT+3")
    GMTPlus3("GMT+3"),

    @Json(name = "GMT+4")
    GMTPlus4("GMT+4"),

    @Json(name = "GMT+5")
    GMTPlus5("GMT+5"),

    @Json(name = "GMT+6")
    GMTPlus6("GMT+6"),

    @Json(name = "GMT+7")
    GMTPlus7("GMT+7"),

    @Json(name = "GMT+8")
    GMTPlus8("GMT+8"),

    @Json(name = "GMT+9")
    GMTPlus9("GMT+9"),

    @Json(name = "GMT+10")
    GMTPlus10("GMT+10"),

    @Json(name = "GMT+11")
    GMTPlus11("GMT+11"),

    @Json(name = "GMT+12")
    GMTPlus12("GMT+12"),

    @Json(name = "GMT")
    GMT("GMT"),

    @Json(name = "GMT-1")
    GMTMinus1("GMT-1"),

    @Json(name = "GMT-2")
    GMTMinus2("GMT-2"),

    @Json(name = "GMT-3")
    GMTMinus3("GMT-3"),

    @Json(name = "GMT-4")
    GMTMinus4("GMT-4"),

    @Json(name = "GMT-5")
    GMTMinus5("GMT-5"),

    @Json(name = "GMT-6")
    GMTMinus6("GMT-6"),

    @Json(name = "GMT-7")
    GMTMinus7("GMT-7"),

    @Json(name = "GMT-8")
    GMTMinus8("GMT-8"),

    @Json(name = "GMT-9")
    GMTMinus9("GMT-9"),

    @Json(name = "GMT-10")
    GMTMinus10("GMT-10"),

    @Json(name = "GMT-11")
    GMTMinus11("GMT-11");

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
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is Timezone) "$data" else null

        /**
         * Returns a valid [Timezone] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): Timezone? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

