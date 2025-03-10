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
 * @param asicBoost 
 * @param autoChipThrottling Automatically adjusts chip frequencies based on temperatures
 * @param bitmainDisableVoltComp Disable voltage compensation feature
 * @param disableChainBreakProtection 
 * @param disableIgnoreBrokenChains 
 * @param disableRestartUnbalanced 
 * @param disableVoltChecks 
 * @param downscalePresetOnFailure Automatic preset reduction in case of miner overheating or chain break error
 * @param higherVoltOffset Higher voltage offset during initialization stage
 * @param ignoreBrokenSensors 
 * @param maxRestartAttempts 
 * @param quickStart 
 * @param quietMode 
 * @param remainStoppedOnReboot 
 * @param restartHashrate Percent, `0` to disable
 * @param restartTemp 
 * @param tunerBadChipHrThreshold Autotuning: hashrate threshold below which the chips are marked as bad ones
 */


data class AdvancedSettings (

    @Json(name = "asic_boost")
    val asicBoost: kotlin.Boolean? = null,

    /* Automatically adjusts chip frequencies based on temperatures */
    @Json(name = "auto_chip_throttling")
    val autoChipThrottling: kotlin.Boolean? = null,

    /* Disable voltage compensation feature */
    @Json(name = "bitmain_disable_volt_comp")
    val bitmainDisableVoltComp: kotlin.Boolean? = null,

    @Json(name = "disable_chain_break_protection")
    val disableChainBreakProtection: kotlin.Boolean? = null,

    @Json(name = "disable_ignore_broken_chains")
    val disableIgnoreBrokenChains: kotlin.Boolean? = null,

    @Json(name = "disable_restart_unbalanced")
    val disableRestartUnbalanced: kotlin.Boolean? = null,

    @Json(name = "disable_volt_checks")
    val disableVoltChecks: kotlin.Boolean? = null,

    /* Automatic preset reduction in case of miner overheating or chain break error */
    @Json(name = "downscale_preset_on_failure")
    val downscalePresetOnFailure: kotlin.Boolean? = null,

    /* Higher voltage offset during initialization stage */
    @Json(name = "higher_volt_offset")
    val higherVoltOffset: kotlin.Int? = null,

    @Json(name = "ignore_broken_sensors")
    val ignoreBrokenSensors: kotlin.Boolean? = null,

    @Json(name = "max_restart_attempts")
    val maxRestartAttempts: kotlin.Int? = null,

    @Json(name = "quick_start")
    val quickStart: kotlin.Boolean? = null,

    @Json(name = "quiet_mode")
    val quietMode: kotlin.Boolean? = null,

    @Json(name = "remain_stopped_on_reboot")
    val remainStoppedOnReboot: kotlin.Boolean? = null,

    /* Percent, `0` to disable */
    @Json(name = "restart_hashrate")
    val restartHashrate: kotlin.Int? = null,

    @Json(name = "restart_temp")
    val restartTemp: kotlin.Int? = null,

    /* Autotuning: hashrate threshold below which the chips are marked as bad ones */
    @Json(name = "tuner_bad_chip_hr_threshold")
    val tunerBadChipHrThreshold: kotlin.Int? = null

) {


}

