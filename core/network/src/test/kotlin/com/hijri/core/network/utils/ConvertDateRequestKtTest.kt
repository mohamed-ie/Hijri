package com.hijri.core.network.utils

import com.hijri.core.model.calender.request.ConvertDateRequest
import org.junit.Assert
import org.junit.Test

class ConvertDateRequestKtTest {

    @Test
    fun getAladhanDateFormat() {
        val request = ConvertDateRequest(day = 14, month = 2, year = 1436)

        val expected = "14-02-1436"
        val actual = request.aladhanDateFormat

        Assert.assertEquals(expected, actual)
    }
}