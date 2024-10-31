package com.hijri.core.network.ktor.datasource

import com.hijri.core.model.calender.request.ConvertDateRequest
import com.hijri.core.model.calender.request.ConvertMonthRequest
import com.hijri.core.network.AladhanNetworkPaths.IslamicCalender.GREGORIAN_TO_HIJRI_DATE
import com.hijri.core.network.AladhanNetworkPaths.IslamicCalender.GREGORIAN_TO_HIJRI_MONTH
import com.hijri.core.network.AladhanNetworkPaths.IslamicCalender.HIJRI_TO_GREGORIAN_DATE
import com.hijri.core.network.AladhanNetworkPaths.IslamicCalender.HIJRI_TO_GREGORIAN_MONTH
import com.hijri.core.network.datasource.AladhanIslamicCalenderNetworkDataSource
import com.hijri.core.network.ktor.call
import com.hijri.core.network.model.calender.DateDto
import com.hijri.core.network.model.common.AladhanResponse
import com.hijri.core.network.utils.aladhanDateFormat
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import org.koin.core.annotation.Single

@Single
internal class KtorAladhanIslamicCalenderNetworkDataSource(
    private val client: HttpClient
) : AladhanIslamicCalenderNetworkDataSource {
    override suspend fun gregorianToHijriDate(request: ConvertDateRequest): Result<AladhanResponse<DateDto>> =
        client.call {
            client.get("${GREGORIAN_TO_HIJRI_DATE}/${request.aladhanDateFormat}")
        }

    override suspend fun gregorianToHijriMonth(request: ConvertMonthRequest): Result<AladhanResponse<List<DateDto>>> =
        client.call {
            client.get("${GREGORIAN_TO_HIJRI_MONTH}/${request.month}/${request.year}")
        }

    override suspend fun hijriToGregorianDate(request: ConvertDateRequest): Result<AladhanResponse<DateDto>> =
        client.call {
            client.get("${HIJRI_TO_GREGORIAN_DATE}/${request.aladhanDateFormat}")
        }

    override suspend fun hijriToGregorianMonth(request: ConvertMonthRequest): Result<AladhanResponse<List<DateDto>>> =
        client.call {
            client.get("${HIJRI_TO_GREGORIAN_MONTH}/${request.month}/${request.year}")
        }
}