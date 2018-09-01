package com.khilman.www.footbalmatchschedulenetwork.util

import android.content.Context
import java.text.SimpleDateFormat

class Helper(var ctx: Context?) {

    fun localizeDate(date: String?): String {
        val format = SimpleDateFormat("yyyy-MM-dd")
        val newDate = format.parse(date)

        val dateFormat = SimpleDateFormat("EEE, MMM d, yyyy")
        val time = dateFormat.format(newDate)

        return time
    }
}