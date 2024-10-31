package com.hijri.core.network.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

internal suspend inline fun <reified T> HttpClient.call(
    block: HttpClient.() -> HttpResponse
): Result<T> = runCatching { block().body<T>() }
