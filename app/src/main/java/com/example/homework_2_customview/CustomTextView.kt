package com.example.homework_2_customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

class CustomTextView(context: Context, attrs: AttributeSet? = null)
    : View(context, attrs) {

    private var text: String = ""
    private var textColor: Int = Color.BLACK

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.textSize = 100f
        paint.textAlign = Paint.Align.CENTER
        paint.color = textColor
        canvas.drawText(text, centerX, centerY, paint)
        Log.d("nikita", text)
    }

    fun setText(newText: String, newTextColor: Int) {
        text = newText
        textColor = newTextColor
        invalidate()  //
    }
}