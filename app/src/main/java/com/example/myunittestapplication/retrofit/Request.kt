@file:Suppress("unused")

package com.example.myunittestapplication.retrofit

import android.annotation.SuppressLint
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

class Request(@SerializedName("auth")
              var auth: Authentication,
              @SerializedName("consumer")
              private var consumer: String = "em-android",
              @SerializedName("requestId")
              var requestId: String = "1234",
              @SerializedName("appVersion")
              private var appVersion: String? = "1.5.5",
              @SerializedName("method")
              var method: ApiMethod)

@SuppressLint("HardwareIds")
class Authentication(@SerializedName("type")
                     private var type: String? = "em",
                     @SerializedName("password")
                     var password: String? = null,
                     @SerializedName("username")
                     var username: String? = null,
                     @SerializedName("deviceId")
                     var deviceId: String = "12345")

class ApiMethod(@SerializedName("name")
                var name: Method,
                @SerializedName("params")
                var params: Params? = null,
                @SerializedName("version")
                var version: String? = null) {

    enum class Method {
        @SerializedName("getAccessToken")
        GET_ACCESS_TOKEN,

        @SerializedName("getClientSamlSsoDetails")
        GET_CLIENT_SAML_SSO_DETAILS,

        @SerializedName("getInspections")
        GET_INSPECTIONS,

        @SerializedName("getFacilitiesAppPreferences")
        GET_FACILITY_APP_PREFERENCE,

        @SerializedName("getFacilitiesPickLists")
        GET_FACILITY_APP_PICK_LISTS,

        @SerializedName("forgotCompanyUserPassword")
        FORGOT_COMPANY_USER_PASSWORD,

        @SerializedName("getWorkOrders")
        GET_WORK_ORDERS,

        @SerializedName("getPropertyResidentsAndUnits")
        GET_PROPERTY_RESIDENTS_AND_UNITS,

        @SerializedName("sendWorkOrders")
        SEND_WORK_ORDER_REQUEST,

        @SerializedName("sendInspections")
        SEND_INSPECTIONS_REQUEST,

        @SerializedName("sendInspectionAttachments")
        SEND_INSPECTION_ATTACHMENTS,

        @SerializedName("sendLaborLog")
        SEND_LABOR_LOG,

        @SerializedName("getMyTasks")
        GET_MY_TASKS,

        @SerializedName("sendAppFeedbackEmail")
        SEND_FEEDBACK,

        @SerializedName("deleteWorkOrderAttachment")
        DELETE_WORK_ORDER_ATTACHMENT,

        @SerializedName("sendNotificationSettings")
        SEND_NOTIFICATION_SETTINGS,

        @SerializedName("getAppDetails")
        GET_APP_DETAILS,

        @SerializedName("getMaintenanceAttachments")
        GET_MAINTENANCE_ATTACHMENTS,

        @SerializedName("refreshAccessToken")
        REFRESH_ACCESS_TOKEN,

        @SerializedName("getMaintenanceDoorLocks")
        GET_MAINTENANCE_DOOR_LOCKS,

        @SerializedName("changeMaintenanceDoorLock")
        CHANGE_MAINTENANCE_DOOR_LOCK,

        @SerializedName("getMaterialsPickList")
        MATERIAL_PICK_LIST,

        @SerializedName("sendMaterial")
        SEND_MATERIAL,

        @SerializedName("sendCustomMaintenanceEmail")
        SEND_EMAIL,

        @SerializedName("sendMaintenanceSms")
        SEND_SMS,

        @SerializedName("getInspectionFormsList")
        GET_INSPECTION_FORMS,

        @SerializedName("getPropertyApplicants")
        GET_APPLICANTS,

        @SerializedName("getLatestMaintenanceDetailsByReference")
        GET_WO_BY_REFERENCE
    }
}

class Params(key: String? = null, email: String? = null,
             propertyIds: IntArray? = null, isOffline: Boolean? = null,
             propertyId: Int? = null, maintenanceRequestId: Int? = null, workOrders: List<WorkOrder>? = null,
             inspections: List<Inspection>? = null, name: String? = null, feedback: String? = null, diagnosticInfo: String? = null, includeCompanySetup: Boolean? = null, inspectionDetail: List<InspectionDetail>? = null,
             maintenanceRequestIds: Int? = null, inspectionIds: Int? = null, lastSyncOn: Long? = null, excludePropertySetup: Boolean? = null, isFetchMakeReady: Boolean? = null, isNotificationEnabled: Boolean? = null, deviceToken: String? = null, newServiceRequest: Boolean? = null, emergencyNewServiceRequest: Boolean? = null, assignedToMe: Boolean? = null, emergencyAssignedToMe: Boolean? = null, scheduledReminders: Boolean? = null,
             remindMeIn: Int? = null, deviceName: String? = null, deviceOS: String? = null, buildNumber: Int? = null, fileAssociationIds: String? = null, inspectionId: Int? = null, refreshToken: String? = null, smartDeviceId: Long? = null, command: String? = null,
             userToken: String? = null, material: Material? = null, filterData: FilterData? = null, emailContent: EmailContent? = null, smsContent: String? = null,
             inspectionSignatureIds: Int? = null,
             customerIds: Int? = null,
             feedbackSatisfactionRatingTypeId: Int? = null,
             isNewPetInfo: Boolean? = null,
             referenceKeyword: String? = null
) {

    @SerializedName("email")
    var email: String? = null

    @SerializedName("propertyIds")
    var propertyIds: String? = null

    @SerializedName("propertyId")
    var propertyId: Int? = null

    @SerializedName("isOffline")
    var isOffline: Boolean? = null

    @SerializedName("maintenanceRequests")
    var workOrders: List<WorkOrder>? = null

    @SerializedName("inspections")
    var inspections: List<Inspection>? = null

    @SerializedName("maintenanceRequestId")
    var maintenanceRequestId: Int? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("feedback")
    var feedback: String? = null

    @SerializedName("diagnosticInfo")
    var diagnosticInfo: String? = null

    @SerializedName(value = "includeCompanySetup")
    var includeCompanySetup: Boolean? = null

    @SerializedName(value = "inspectionDetails")
    var inspectionDetail: List<InspectionDetail>? = null

    @SerializedName("maintenanceRequestIds")
    var maintenanceRequestIds: Int? = null

    @SerializedName("lastSyncOn")
    var lastSyncOn: Long? = null

    @SerializedName("inspectionIds")
    var inspectionIds: Int? = null

    @SerializedName("excludePropertySetup")
    var excludePropertySetup: Boolean? = null

    @SerializedName("isFetchMakeReady")
    var isFetchMakeReady: Boolean? = null

    @SerializedName("isNotificationEnabled")
    var isNotificationEnabled: Boolean? = null

    @SerializedName("deviceToken")
    var deviceToken: String? = null

    @SerializedName("newServiceRequest")
    var newServiceRequest: Boolean? = null

    @SerializedName("emergencyNewServiceRequest")
    var emergencyNewServiceRequest: Boolean? = null

    @SerializedName("assignedToMe")
    var assignedToMe: Boolean? = null

    @SerializedName("emergencyAssignedToMe")
    var emergencyAssignedToMe: Boolean? = null

    @SerializedName("scheduledReminders")
    var scheduledReminders: Boolean? = null

    @SerializedName("remindMeIn")
    var remindMeIn: Int? = null

    @SerializedName("deviceName")
    var deviceName: String? = null

    @SerializedName("deviceOS")
    var deviceOS: String? = null

    @SerializedName("buildNumber")
    var buildNumber: Int? = null

    @SerializedName(value = "fileAssociationIds")
    var fileAssociationIds: String? = null

    @SerializedName(value = "inspectionId")
    var inspectionId: Int? = null

    @SerializedName("refreshToken")
    var refreshToken: String? = null

    @SerializedName("smartDeviceId")
    var smartDeviceId: Long? = null

    @SerializedName("command")
    var command: String? = null

    @SerializedName("userToken")
    var userToken: String? = null

    @SerializedName("material")
    var material: Material? = null

    @SerializedName(value = "filterData")
    var filterData: FilterData? = null

    @SerializedName(value = "emailContent")
    var emailContent: EmailContent? = null

    @SerializedName(value = "smsContent")
    var smsContent: String? = null

    @SerializedName(value = "inspectionSignatureIds")
    var inspectionSignatureIds: Int? = null

    @SerializedName(value = "customerIds")
    var customerIds: Int? = null

    @SerializedName(value = "feedbackSatisfactionRatingTypeId")
    var feedbackSatisfactionRatingTypeId: Int? = null

    @SerializedName(value = "isNewPetInfo")
    var isNewPetInfo: Boolean? = null

    @SerializedName(value = "referenceKeyword")
    var referenceKeyword: String? = null

    init {
        this.email = email
        this.propertyIds = propertyIds?.joinToString()
        this.isOffline = isOffline
        this.workOrders = workOrders
        this.inspections = inspections
        this.propertyId = propertyId
        this.maintenanceRequestId = maintenanceRequestId
        this.maintenanceRequestIds = maintenanceRequestIds
        this.name = name
        this.feedback = feedback
        this.diagnosticInfo = diagnosticInfo
        this.includeCompanySetup = includeCompanySetup
        this.inspectionDetail = inspectionDetail
        this.lastSyncOn = lastSyncOn
        this.inspectionIds = inspectionIds
        this.excludePropertySetup = excludePropertySetup
        this.isFetchMakeReady = isFetchMakeReady
        this.isNotificationEnabled = isNotificationEnabled
        this.newServiceRequest = newServiceRequest
        this.emergencyNewServiceRequest = emergencyNewServiceRequest
        this.assignedToMe = assignedToMe
        this.emergencyAssignedToMe = emergencyAssignedToMe
        this.scheduledReminders = scheduledReminders
        this.deviceToken = deviceToken
        this.remindMeIn = remindMeIn
        this.deviceName = deviceName
        this.deviceOS = deviceOS
        this.buildNumber = buildNumber
        this.fileAssociationIds = fileAssociationIds
        this.inspectionId = inspectionId
        this.refreshToken = refreshToken
        this.smartDeviceId = smartDeviceId
        this.command = command
        this.userToken = userToken
        this.material = material
        this.filterData = filterData
        this.emailContent = emailContent
        this.smsContent = smsContent
        this.inspectionSignatureIds = inspectionSignatureIds
        this.feedbackSatisfactionRatingTypeId = feedbackSatisfactionRatingTypeId
        this.customerIds = customerIds
        this.isNewPetInfo = isNewPetInfo
        this.referenceKeyword = referenceKeyword
    }
}

class WorkOrder(@SerializedName("companyEmployeeId")
                var companyEmployeeId: Int? = null,
                @SerializedName("maintenanceRequestId")
                var maintenanceRequestId: Int? = null,
                @SerializedName("propertyId")
                var propertyId: Int? = 0,
                @SerializedName("maintenanceStatusId")
                var maintenanceStatusId: Int? = null,
                @SerializedName("attachments")
                var attachments: List<Attachment>? = null,
                @SerializedName("notes")
                var notes: List<Note>? = null,
                @SerializedName("laborLogs")
                var expenseHistory: List<ExpenseHistory>? = null,
                @SerializedName("maintenanceLocationId")
                var maintenanceLocationId: Int? = null,
                @SerializedName("maintenanceProblemId")
                var maintenanceProblemId: Int? = null,
                @SerializedName("maintenancePriorityId")
                var maintenancePriorityId: Int? = null,
                @SerializedName("leaseId")
                var leaseId: Int? = null,
                @SerializedName("maintenanceCategoryId")
                var maintenanceCategoryId: Int? = null,
                @SerializedName("unitSpaceId")
                var unitSpaceId: Int? = null,
                @SerializedName("isAllowFloatingMaintenanceRequest")
                var isAllowFloatingMaintenanceRequest: Boolean? = null,
                @SerializedName("isResidentVisible")
                var isVisibleToResident: Boolean? = null,
                @SerializedName("problemDescription")
                var problemDescription: String? = null,
                @SerializedName("permissionToEnter")
                var permissionToEnter: String? = null,
                @SerializedName("propertyUnitId")
                var propertyUnitId: Int? = null,
                @SerializedName("customerId")
                var customerId: Int? = null,
                @SerializedName("parentMaintenanceRequestId")
                var parentMaintenanceRequestId: Int? = null,
                @Transient
                var isCreatedFromApp: Boolean = false,
                @SerializedName("isDeleted")
                var isDeleted: Boolean? = null,
                @SerializedName("subtasks")
                var subTaskList: List<WorkOrder>? = null,
                @SerializedName("isFromBulkCompleteSubtasks")
                var isFromBulkCompleteSubtasks: Boolean? = null,
                @SerializedName(value = "subMaintenanceProblemId")
                var companyActionId: Int? = null,
                @SerializedName("completedDatetime")
                var completedDatetime: String? = null)

class InspectionAssignTo(@SerializedName("inspectionId")
                         var inspectionId: Int? = 0,
                         @SerializedName("inspectedBy")
                         var inspectedBy: Int? = 0,
                         @SerializedName("propertyId")
                         var propertyId: Int? = 0)

class Attachment(@SerializedName("fileAssociationId")
                 var fileAssociationId: Long? = null,
                 @SerializedName("isDeleted")
                 var isDeleted: Boolean? = null,
                 @SerializedName("note")
                 var note: String? = null,
                 @SerializedName("fileId")
                 var fileId: String? = null,
                 @SerializedName("attachmentVisibleToResident")
                 var attachmentVisibleToResident: Int? = null
)


class Note(
        @SerializedName("message")
        var message: String? = "",
        @SerializedName("isVisibleToResident")
        var isVisibleToResident: Boolean? = false,
        @SerializedName("isClosingNote")
        var isClosingNote: Boolean? = false,
        @SerializedName("isEntryNote")
        var isEntryNote: Boolean? = false
)

class ExpenseHistory(@SerializedName("laborStartTime")
                     var laborStartTime: Long? = 0,
                     @SerializedName("createdOn")
                     var createdOn: Long? = 0,
                     @SerializedName("labourDate")
                     var laborDate: Long? = 0,
                     @SerializedName("laborEndTime")
                     var laborEndTime: Long? = 0,
                     @SerializedName("propertyId")
                     var propertyId: Int? = 0)

class Inspection(@SerializedName("inspectionId")
                 var inspectionId: Int? = null,
                 @SerializedName("appInspectionId")
                 var appInspectionId: Int? = null,
                 @SerializedName("inspectionTypeId")
                 var inspectionTypeId: Int? = null,
                 @SerializedName("createdOn")
                 var createdOn: Long? = null,
                 @SerializedName("scheduledDate")
                 var inspectionScheduledDate: Long? = null,
                 @SerializedName("inspectionDueDate")
                 var inspectionDueDate: Long? = null,
                 @SerializedName("inspectedBy")
                 var inspectedBy: Int? = null,
                 @SerializedName("inspectionFormId")
                 var inspectionFormId: Int? = null,
                 @SerializedName("propertyId")
                 var propertyId: Int? = null,
                 @SerializedName("inspectedOn")
                 var inspectedOn: Long? = null,
                 @SerializedName("notes")
                 var notes: String? = null,
                 @SerializedName("inspectionSignatureDetails")
                 var inspectionSignatureDetails: List<SignatureDetails>? = null,
                 @SerializedName("locations")
                 var locations: List<Location>? = null,
                 @SerializedName("isAllowFloatingInspection")
                 var isAllowFloatingInspection: Int? = null,
                 @SerializedName("inspectionHazardNote")
                 var inspectionHazardNote: String? = null,
                 @SerializedName("inspectionStatusId")
                 var inspectionStatusId: Int? = null,
                 @SerializedName("unitSpaceId")
                 var unitSpaceId: Int? = null,
                 @SerializedName("hazardNote")
                 var hazardNote: String? = null,
                 @SerializedName("hazardEndDate")
                 var hazardEndDate: Long? = null,
                 @SerializedName("propertyUnitId")
                 var propertyUnitId: Int? = null,
                 @SerializedName("customerType")
                 var customerType: String? = null,
                 @SerializedName("notifyResident")
                 var notifyResident: Boolean? = null,
                 @SerializedName("emailText")
                 var emailText: String? = null,
                 @SerializedName("leaseIds")
                 var leaseIds: Any? = null,
                 @SerializedName("customerIds")
                 var customerIds: Any? = null,
                 @SerializedName("isConsolidated")
                 var isConsolidated: Boolean? = null
   )

class Location(@SerializedName("inspectionFormLocationId")
               var inspectionFormLocationId: Int? = null,
               @SerializedName("maintenanceLocationId")
               var maintenanceLocationId: Int? = null,
               @SerializedName("propertyUnitMaintenanceLocationName")
               var maintenanceLocationName: String? = null,
               @SerializedName("problems")
               var problems: List<Problem>? = null
)

class SignatureDetails(
    @SerializedName("leaseId")
    var leaseId: Int? = null,
    @SerializedName("inspectionSignature")
    var inspectionSignature: String? = null
)

class Problem(@SerializedName("inspectionFormLocationProblemId")
              var inspectionFormLocationProblemId: Int? = 0,
              @SerializedName("maintenanceProblemId")
              var maintenanceProblemId: Int? = 0,
              @SerializedName("isFailed")
              var isFailed: Boolean? = null,
              @SerializedName("note")
              var note: String? = null,
              @SerializedName("actions")
              var actions: List<Action>? = null,
              @SerializedName("attachments")
              var attachments: List<Attachment>? = null

)

class Action(@SerializedName("actionId")
             var actionId: Int? = 0,
             @SerializedName("isSelected")
             var isSelected: Boolean? = null,
             @SerializedName("actionName")
             var actionName: String? = null,
             @SerializedName("actionTypeId")
             var actionTypeId: Int? = null,
             @SerializedName("companyActionId")
             var companyActionId: Int? = null)

class InspectionDetail(@SerializedName("fileId")
                       var fileId: String? = null,
                       @SerializedName("inspectionFormLocationId")
                       var inspectionFormLocationId: Int? = 0,
                       @SerializedName("inspectionFormLocationProblemId")
                       var inspectionFormLocationProblemId: Int? = 0,
                       @SerializedName("inspectionId")
                       var inspectionId: Int? = 0,
                       @SerializedName("propertyId")
                       var propertyId: Int? = 0)

class Material(@SerializedName("assetTypeId")
               var assetTypeId: Int? = 0,
               @SerializedName("apCodeId")
               var apCodeId: Int? = 0,
               @SerializedName("glAccountId")
               var glAccountId: Int? = 0,
               @SerializedName("quantity")
               var quantity: Float? = null,
               @SerializedName("isPostedOn")
               var isPostedOn: Int? = null,
               @SerializedName("postedOn")
               var postedOn: Long? = null,
               @SerializedName("materialId")
               var materialId: Int? = null,
               @SerializedName("assetLocationId")
               var assetLocationId: Int? = null,
               @SerializedName("quantities")
               var quantities: JsonObject? = null,
               @SerializedName("assetId")
               var assetId: Int? = null,
               @SerializedName("retireAssetId")
               var retireAssetId: Int? = null)

class Quantity(
        var quantityOnHand: String? = null,
        var quantity: String? = null,
        var assetId: Int? = null
)

class FilterData(
        @SerializedName("referenceNumber")
        var referenceNumber: String? = null,
        @SerializedName("searchKeyword")
        var searchKeyword: String? = null,
        @SerializedName("propertyIds")
        var propertyIds: String? = null,
        @SerializedName("maintenanceRequestTypes")
        var maintenanceRequestTypes: String? = null,
        @SerializedName("assignedEmployees")
        var assignedEmployees: String? = null,
        @SerializedName("maintenancePriorityTypes")
        var maintenancePriorities: String? = null,
        @SerializedName("maintenanceStatusIds")
        var maintenanceStatusIds: String? = null,
        @SerializedName("maintenanceStatusTypes")
        var maintenanceStatuses: String? = null,
        @SerializedName("inspectionStatusIds")
        var inspectionStatusIds: String? = null,
        @SerializedName("dateType")
        var dateType: String? = null,
        @SerializedName("interval")
        var interval: Int? = null,
        @SerializedName("startDate")
        var startDate: String? = null,
        @SerializedName("endDate")
        var endDate: String? = null,
        @SerializedName("propertyUnitIds")
        var propertyUnitIds: String? = null,
        @SerializedName("unitSpaceIds")
        var unitSpaceIds: String? = null,
        var isIncludeInspection: Boolean? = null,
        var maintenanceTemplateIds: String? = null

)

class EmailContent(@SerializedName("subject")
                   var subject: String? = null,
                   @SerializedName("content")
                   var content: String? = null,
                   @SerializedName("boolIsUseLoggedInUserEmail")
                   var boolIsUseLoggedInUserEmail: Boolean? = null,
                   @SerializedName("attachments")
                   var attachments: List<String>? = null)