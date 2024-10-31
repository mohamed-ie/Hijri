package com.hijri.core.network.model.calender

import kotlinx.serialization.Serializable

@Serializable
data class DateDto(
    val gregorian: Day? = null,
    val hijri: Day? = null
) {
    @Serializable
    data class Day(
        val date: String? = null,
        val format: String? = null,
        val day: Int? = null,
        val weekDay: WeekDay? = null,
        val month: Month? = null,
        val year: Int? = null,
        val designation: Designation? = null,
        val holidays: List<String?>? = null
    )

    @Serializable
    data class Month(
        val number: Int? = null,
        val en: String? = null,
        val ar: String? = null
    )

    @Serializable
    data class Designation(
        val abbreviated: String? = null,
        val expanded: String? = null
    )

    @Serializable
    data class WeekDay(
        val en: String? = null,
        val ar: String? = null
    )

}
