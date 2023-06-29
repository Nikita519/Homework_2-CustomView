package com.example.homework_2_customview

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class WheelView(context: Context, attributeSet: AttributeSet?) :
    View(context, attributeSet){

        private val colors = listOf(
            Color.RED,
            Color.rgb(255, 165, 0), //оранжевый
            Color.YELLOW,
            Color.GREEN,
            Color.BLUE,
            Color.rgb(0, 77, 255),
            Color.rgb(105, 0, 198)
        )

    private var spinListener: SpinListener? = null
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val sectors = colors.size
    private var startAngle = 0f
    
    init {
        setOnClickListener {
            rotateWheel()
        }
    }

    private fun rotateWheel() {
        val duration = (2000L..5000L).random()
        val animator = ObjectAnimator.ofFloat(this, "rotation", rotation, rotation + 720f + (Math.random() * 360).toFloat())
        animator.duration = duration
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                val rot = rotation % 360f
                val angle = 360f / sectors
                val selectedColorIndex = (sectors - (rot / angle)) % sectors
                val selectedColor = colors[selectedColorIndex.toInt()]
               spinListener?.onSpinComplete(selectedColor)
            }
        })
        animator.start()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f
        val radius = (Math.min(width, height) / 2f) * 0.8f

        val sweepAngle = 360f / colors.size

        for (color in colors) {
            paint.color = color
            canvas?.drawArc(
                centerX - radius,
                centerY - radius,
                centerX + radius,
                centerY + radius,
                startAngle,
                sweepAngle,
                true,
                paint
            )
            startAngle += sweepAngle
        }

    }

    fun setSpinListener(listener: SpinListener) {
        spinListener = listener
    }

    fun setSize(newSize: Float) {
        scaleX = newSize * 2
        scaleY = newSize * 2
        invalidate()
    }



}