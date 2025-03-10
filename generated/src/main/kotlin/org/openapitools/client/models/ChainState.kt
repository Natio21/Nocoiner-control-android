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
 * Values: initializing,mining,stopped,failure,disconnected,disabled,unknown
 */

@JsonClass(generateAdapter = false)
enum class ChainState(val value: kotlin.String) {

    @Json(name = "initializing")
    initializing("initializing"),

    @Json(name = "mining")
    mining("mining"),

    @Json(name = "stopped")
    stopped("stopped"),

    @Json(name = "failure")
    failure("failure"),

    @Json(name = "disconnected")
    disconnected("disconnected"),

    @Json(name = "disabled")
    disabled("disabled"),

    @Json(name = "unknown")
    unknown("unknown");

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
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is ChainState) "$data" else null

        /**
         * Returns a valid [ChainState] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): ChainState? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

