package com.accounting.app.models

data class ApiResponse<T>(
    val success: Boolean,
    val message: String,
    val data: T? = null
) 