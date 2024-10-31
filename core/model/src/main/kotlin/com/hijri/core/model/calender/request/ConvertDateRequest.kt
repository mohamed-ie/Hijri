package com.hijri.core.model.calender.request

import kotlinx.serialization.Serializable

@Serializable
data class ConvertDateRequest(
    val day: Int,
    val month: Int,
    val year: Int
)