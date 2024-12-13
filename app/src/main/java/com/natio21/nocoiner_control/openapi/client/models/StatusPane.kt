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

import com.natio21.nocoiner_control.openapi.client.models.MinerState
import com.natio21.nocoiner_control.openapi.client.models.Warranty

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param minerState 
 * @param minerStateTime Time spent in the current state. For now implemented for `mining` state only.
 * @param rebootRequired Miner restart required to apply
 * @param restartRequired Miner restart required to apply config
 * @param findMiner Flag to switch find_miner function on target devices. Optional, default `false`
 * @param unlocked Show screen-lock status (checks that  any of auth methods satisfies)
 * @param description Optional. Description if status is failure
 * @param warranty 
 */


data class StatusPane (

    @Json(name = "miner_state")
    val minerState: MinerState,

    /* Time spent in the current state. For now implemented for `mining` state only. */
    @Json(name = "miner_state_time")
    val minerStateTime: kotlin.Long,

    /* Miner restart required to apply */
    @Json(name = "reboot_required")
    val rebootRequired: kotlin.Boolean,

    /* Miner restart required to apply config */
    @Json(name = "restart_required")
    val restartRequired: kotlin.Boolean,

    /* Flag to switch find_miner function on target devices. Optional, default `false` */
    @Json(name = "find_miner")
    val findMiner: kotlin.Boolean,

    /* Show screen-lock status (checks that  any of auth methods satisfies) */
    @Json(name = "unlocked")
    val unlocked: kotlin.Boolean,

    /* Optional. Description if status is failure */
    @Json(name = "description")
    val description: kotlin.String? = null,

    @Json(name = "warranty")
    val warranty: Warranty? = null

) {


}

