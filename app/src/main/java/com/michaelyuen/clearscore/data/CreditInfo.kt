package com.michaelyuen.clearscore.data

import com.google.gson.annotations.SerializedName

data class CreditInfo (

	@SerializedName("accountIDVStatus") val accountIDVStatus : String,
	@SerializedName("creditReportInfo") val creditReportInfo : CreditReportInfo,
	@SerializedName("dashboardStatus") val dashboardStatus : String,
	@SerializedName("personaType") val personaType : String,
	@SerializedName("coachingSummary") val coachingSummary : CoachingSummary,
	@SerializedName("augmentedCreditScore") val augmentedCreditScore : String
)