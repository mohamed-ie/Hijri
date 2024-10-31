package com.hijri.core.network.ktor.datasource

import com.hijri.core.model.calender.request.ConvertDateRequest
import com.hijri.core.model.calender.request.ConvertMonthRequest
import com.hijri.core.network.datasource.AladhanIslamicCalenderNetworkDataSource
import com.hijri.core.network.di.ktorClient
import com.hijri.core.network.model.calender.DateDto
import com.hijri.core.network.model.calender.DateDto.Day
import com.hijri.core.network.model.calender.DateDto.Designation
import com.hijri.core.network.model.calender.DateDto.Month
import com.hijri.core.network.model.common.AladhanResponse
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class KtorAladhanIslamicCalenderNetworkDataSourceTest {
    private lateinit var dataSource: AladhanIslamicCalenderNetworkDataSource
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        val mockEngine = MockEngine { request ->
            val content = if (request.url.encodedPath.contains("Calender", true)) convertMonthJson
            else convertDateJson
            respond(
                content = ByteReadChannel(content),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        dataSource = KtorAladhanIslamicCalenderNetworkDataSource(ktorClient(mockEngine))
    }

    @Test
    fun testDeserializationOfDate() = runTest(testDispatcher) {
        val expected = expectedDate

        val actual = dataSource.gregorianToHijriDate(convertDateRequest).getOrNull()

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun testDeserializationOfMonth() = runTest(testDispatcher) {
        val expected = expectedMonth

        val actual = dataSource.hijriToGregorianMonth(convertMonthRequest).getOrNull()

        Assert.assertEquals(expected, actual)
    }

}

val convertDateJson
    get() = """
{
    "code": 200,
    "status": "OK",
    "data": {
        "hijri": {
            "date": "14-02-1436",
            "format": "DD-MM-YYYY",
            "day": "14",
            "month": {
                "number": 2,
                "en": "Ṣafar",
                "ar": "صَفَر"
            },
            "year": "1436",
            "designation": {
                "abbreviated": "AH",
                "expanded": "Anno Hegirae"
            }
        },
        "gregorian": {
            "date": "07-12-2014",
            "format": "DD-MM-YYYY",
            "day": "07",
            "month": {
                "number": 12,
                "en": "December"
            },
            "year": "2014",
            "designation": {
                "abbreviated": "AD",
                "expanded": "Anno Domini"
            }
        }
    }
}
"""

val convertDateRequest
    get() = ConvertDateRequest(
        day = 7,
        month = 12,
        year = 2014
    )


val expectedDate
    get() = AladhanResponse(
        status = "OK",
        code = 200,
        data = date
    )

val date
    get() = DateDto(
        hijri = Day(
            date = "14-02-1436",
            format = "DD-MM-YYYY",
            day = 14,
            month = Month(
                number = 2,
                en = "Ṣafar",
                ar = "صَفَر"
            ),
            year = 1436,
            designation = Designation(
                abbreviated = "AH",
                expanded = "Anno Hegirae"
            )
        ),
        gregorian = Day(
            date = "07-12-2014",
            format = "DD-MM-YYYY",
            day = 7,
            month = Month(
                number = 12,
                en = "December",
                ar = null
            ),
            year = 2014,
            designation = Designation(
                abbreviated = "AD",
                expanded = "Anno Domini"
            )
        )
    )


val convertMonthJson
    get() = """
{
    "code": 200,
    "status": "OK",
    "data": [
        {
            "hijri": {
                "date": "14-02-1436",
                "format": "DD-MM-YYYY",
                "day": "14",
                "month": {
                    "number": 2,
                    "en": "Ṣafar",
                    "ar": "صَفَر"
                },
                "year": "1436",
                "designation": {
                    "abbreviated": "AH",
                    "expanded": "Anno Hegirae"
                }
            },
            "gregorian": {
                "date": "07-12-2014",
                "format": "DD-MM-YYYY",
                "day": "07",
                "month": {
                    "number": 12,
                    "en": "December"
                },
                "year": "2014",
                "designation": {
                    "abbreviated": "AD",
                    "expanded": "Anno Domini"
                }
            }
        }
    ]
}
"""

val convertMonthRequest
    get() = ConvertMonthRequest(
        month = 12,
        year = 2014
    )

val expectedMonth
    get() = AladhanResponse(
        status = "OK",
        code = 200,
        data = listOf(date)
    )