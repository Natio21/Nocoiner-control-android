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

package com.natio21.nocoiner_control.openapi.client.apis

import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

import com.natio21.nocoiner_control.openapi.client.apis.LogsApi
import com.natio21.nocoiner_control.openapi.client.models.ErrDescr
import com.natio21.nocoiner_control.openapi.client.models.LogType

class LogsApiTest : ShouldSpec() {
    init {
        // uncomment below to create an instance of LogsApi
        //val apiInstance = LogsApi()

        // to test logsClear
        should("test logsClear") {
            // uncomment below to test logsClear
            //val logType : LogType =  // LogType | Log type
            //apiInstance.logsClear(logType)
        }

        // to test logsGet
        should("test logsGet") {
            // uncomment below to test logsGet
            //val logType : LogType =  // LogType | Log type name. All logs `*` are not implemented for this route
            //apiInstance.logsGet(logType)
        }

    }
}
