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

import java.io.IOException
import okhttp3.Call
import okhttp3.HttpUrl

import com.natio21.nocoiner_control.openapi.client.models.ErrDescr
import com.natio21.nocoiner_control.openapi.client.models.MetricsReply

import com.squareup.moshi.Json

import com.natio21.nocoiner_control.openapi.client.infrastructure.ApiClient
import com.natio21.nocoiner_control.openapi.client.infrastructure.ApiResponse
import com.natio21.nocoiner_control.openapi.client.infrastructure.ClientException
import com.natio21.nocoiner_control.openapi.client.infrastructure.ClientError
import com.natio21.nocoiner_control.openapi.client.infrastructure.ServerException
import com.natio21.nocoiner_control.openapi.client.infrastructure.ServerError
import com.natio21.nocoiner_control.openapi.client.infrastructure.MultiValueMap
import com.natio21.nocoiner_control.openapi.client.infrastructure.PartConfig
import com.natio21.nocoiner_control.openapi.client.infrastructure.RequestConfig
import com.natio21.nocoiner_control.openapi.client.infrastructure.RequestMethod
import com.natio21.nocoiner_control.openapi.client.infrastructure.ResponseType
import com.natio21.nocoiner_control.openapi.client.infrastructure.Success
import com.natio21.nocoiner_control.openapi.client.infrastructure.toMultiValue

class MetricsApi(basePath: kotlin.String = defaultBasePath, client: Call.Factory = ApiClient.defaultClient) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "/api/v1")
        }
    }

    /**
     * Get metrics
     * 
     * @param timeSlice Amount of seconds until now. Max is 3 days (3 * 24 * 60 * 60) Default is 1 day (24 * 60 * 60)
     * @param step Resample step in seconds to count average, default is 15 min (15 * 60)
     * @param until Pet id
     * @return MetricsReply
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun metrics(timeSlice: kotlin.Int, step: kotlin.Int, until: kotlin.Int) : MetricsReply {
        val localVarResponse = metricsWithHttpInfo(timeSlice = timeSlice, step = step, until = until)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as MetricsReply
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Get metrics
     * 
     * @param timeSlice Amount of seconds until now. Max is 3 days (3 * 24 * 60 * 60) Default is 1 day (24 * 60 * 60)
     * @param step Resample step in seconds to count average, default is 15 min (15 * 60)
     * @param until Pet id
     * @return ApiResponse<MetricsReply?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun metricsWithHttpInfo(timeSlice: kotlin.Int, step: kotlin.Int, until: kotlin.Int) : ApiResponse<MetricsReply?> {
        val localVariableConfig = metricsRequestConfig(timeSlice = timeSlice, step = step, until = until)

        return request<Unit, MetricsReply>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation metrics
     *
     * @param timeSlice Amount of seconds until now. Max is 3 days (3 * 24 * 60 * 60) Default is 1 day (24 * 60 * 60)
     * @param step Resample step in seconds to count average, default is 15 min (15 * 60)
     * @param until Pet id
     * @return RequestConfig
     */
    fun metricsRequestConfig(timeSlice: kotlin.Int, step: kotlin.Int, until: kotlin.Int) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
            .apply {
                put("time_slice", listOf(timeSlice.toString()))
                put("step", listOf(step.toString()))
                put("until", listOf(until.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/metrics",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }


    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent).build().encodedPathSegments[0]
}
