package com.example.databindingmvvm.utils

import android.app.Activity
import android.app.Dialog
import com.example.databindingmvvm.R

fun Activity.createProgressDialog() = Dialog(this).apply {
    setContentView(R.layout.progress_dialog)
    setCancelable(false)
    setCanceledOnTouchOutside(false)
}