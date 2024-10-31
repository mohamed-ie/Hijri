package com.hijri.core.network.datasource

import com.hijri.core.model.calender.request.ConvertDateRequest
import com.hijri.core.model.calender.request.ConvertMonthRequest
import com.hijri.core.network.model.calender.DateDto
import com.hijri.core.network.model.common.AladhanResponse

interface AladhanIslamicCalenderNetworkDataSource {
    suspend fun gregorianToHijriDate(request: ConvertDateRequest): Result<AladhanResponse<DateDto>>
    suspend fun gregorianToHijriMonth(request: ConvertMonthRequest): Result<AladhanResponse<List<DateDto>>>
    suspend fun hijriToGregorianDate(request: ConvertDateRequest): Result<AladhanResponse<DateDto>>
    suspend fun hijriToGregorianMonth(request: ConvertMonthRequest): Result<AladhanResponse<List<DateDto>>>
}