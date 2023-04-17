@file:Suppress("unused")

package com.example.myunittestapplication.retrofit

import com.google.gson.annotations.SerializedName

open class ServerResponse(
    @SerializedName("response")
    var response: Response
)

class Response(
    @SerializedName("requestId")
    var requestId: String,
    @SerializedName("code")
    var code: Int,
    @SerializedName("result")
    var result: Result,
    @SerializedName("error")
    var error: Error
)

class Error(
    @SerializedName("code")
    var code: Int,
    @SerializedName("message")
    var message: String
)

class Result(
    @SerializedName("accessToken")
    var accessToken: String,
    @SerializedName("refreshToken")
    var refreshToken: String,
    var userId: Int,
    var cId: Int,
    var companyName: String,
    var companyEmployeeId: Int,
    var userName: String,
    var firstName: String,
    var lastName: String,
    var email: String? = "",
    var userPreferredLocale: String = "",
    @SerializedName("status")
    var status: String,
    @SerializedName("message")
    var message: String,
    @SerializedName("lastSyncOn")
    var lastSyncOn: Long,
    @SerializedName("latestVersion")
    var latestVersion: Int,
    @SerializedName("updateType")
    var updateType: Int,
    @SerializedName("maintenance_request_id")
    var maintenanceRequestId: Int,
    @SerializedName("company_employee_id")
    var company_employee_id: Int,
    @SerializedName("useItemCatalog")
    var useItemCatalog: Boolean?,

    @SerializedName("isSamlSsoEnabled")
    var isSamlSsoEnabled: Boolean,
    @SerializedName("isHideLoginForm")
    var isHideLoginForm: Boolean = false,
    @SerializedName("samlLoginUrl")
    var samlLoginUrl: String? = "",
    @SerializedName("completedDate")
    var completedDate: String? = "",
    @SerializedName("key")
    var key: String? = "",
    @SerializedName("inspectionSignature")
    var inspectionSignature: List<InspectionSignature>,
    @SerializedName("customerProfiles")
    var customerProfiles: List<CustomerProfile>
)


data class InspectionSignature(
    val fileData: String,
    val inspectionSignatureId: Int
)


data class CustomerProfile(
    val customerId: Int,
    val fileData: String?,
    val fileId: Int,
    val fileName: String
)

data class ServerAttachmentResponse(
    val response: AttachmentResponse
)

data class AttachmentResponse(
    val code: Int,
    val requestId: String,
    val result: List<AttachmentResult>,
    var error: Error
)

data class AttachmentResult(
    val code: Int,
    val fileAssociationId: Long,
    val fileId: String,
    val fileName: String,
    val message: String,
    val status: String
)