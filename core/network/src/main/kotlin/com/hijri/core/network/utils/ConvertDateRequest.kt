package com.hijri.core.network.utils

import com.hijri.core.model.calender.request.ConvertDateRequest
import java.util.Locale

internal val ConvertDateRequest.aladhanDateFormat: String
    get() {
        val day = format("%02d", day)
        val month = format("%02d", month)
        val year = format("%04d", year)
        return "$day-$month-$year"
    }

private fun format(format: String, vararg args: Any) =
    String.format(Locale.US, format, *args)