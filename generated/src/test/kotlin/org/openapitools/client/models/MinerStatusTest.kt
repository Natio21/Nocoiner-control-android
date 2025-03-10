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

import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

import com.natio21.nocoiner_control.openapi.client.models.MinerStatus
import com.natio21.nocoiner_control.openapi.client.models.MinerState

class MinerStatusTest : ShouldSpec() {
    init {
        // uncomment below to create an instance of MinerStatus
        //val modelInstance = MinerStatus()

        // to test the property `minerState`
        should("test minerState") {
            // uncomment below to test the property
            //modelInstance.minerState shouldBe ("TODO")
        }

        // to test the property `minerStateTime` - Time spent in the current state. For now implemented for `mining` state only.
        should("test minerStateTime") {
            // uncomment below to test the property
            //modelInstance.minerStateTime shouldBe ("TODO")
        }

        // to test the property `description` - Optional. Description if status is failure
        should("test description") {
            // uncomment below to test the property
            //modelInstance.description shouldBe ("TODO")
        }

    }
}
