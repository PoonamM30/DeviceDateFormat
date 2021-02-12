package com.example.calendardemo

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkFormat()
        formatButton1.setOnClickListener {
            checkFormat()
        }
        formatButton2.setOnClickListener {
        }
    }

    @SuppressLint("SetTextI18n")
    private fun checkFormat(){
        val calendarHelper = CalendarHelper()
        val format = "MMddyyyy"

        val systemDate = calendarHelper.getSystemDate(this)
        val systemDateFormat = calendarHelper.getSystemDateFormat(this)

        calendarText.text = "System Date : $systemDate Format : $systemDateFormat"

        dateText.text = "Formatted Date : ${calendarHelper.getFormattedDate(format,calendarHelper.getCurrentDate().time)} Format : $format"

        timeText.text = "Time : ${calendarHelper.getSystemTime(this)} Format : ${if (calendarHelper.checkIf24(this)) "24 Hr" else " 12 Hr"}"
    }

}