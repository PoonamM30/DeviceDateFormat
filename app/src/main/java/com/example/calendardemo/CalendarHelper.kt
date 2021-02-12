package com.example.calendardemo

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.text.format.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class CalendarHelper {

    fun getSystemDate(context: Context): String {

        val shortFormat = SimpleDateFormat(getSystemDateFormat(context), Locale.getDefault())
        val shortDate = shortFormat.format(getCurrentDate().time)

        val mediumFormat = SimpleDateFormat(getSystemDateFormat(context), Locale.getDefault())
        val mediumDate = mediumFormat.format(getCurrentDate().time)
        return mediumDate
    }

    fun getSystemDateFormat(context: Context): String {
        val shortDateFormat = DateFormat.getDateFormat(context)
        val mediumDateFormat = DateFormat.getMediumDateFormat(context)
        return (mediumDateFormat as SimpleDateFormat).toPattern()
    }

    fun getSystemTime(context: Context): String {
        val shortTimeFormat = DateFormat.getTimeFormat(context)

        val timeFormat = SimpleDateFormat((shortTimeFormat as SimpleDateFormat).toPattern(), Locale.getDefault())
        val time = timeFormat.format(getCurrentDate().time)
        return time
    }

    fun checkIf24(context: Context): Boolean {
        return DateFormat.is24HourFormat(context)
    }

    fun getCurrentDate(): Calendar{
        return Calendar.getInstance()
    }

    fun getFormattedDate(format: String, date : Date): String {
        val dateformat = SimpleDateFormat(format, Locale.getDefault())
        return dateformat.format(date)
    }
}