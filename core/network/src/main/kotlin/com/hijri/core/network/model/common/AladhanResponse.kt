package com.hijri.core.network.model.common

import kotlinx.serialization.Serializable

@Serializable
data class AladhanResponse<T>(
    val code: Int? = null,
    val status: String? = null,
    val data: T? = null
)