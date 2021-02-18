package hphuc5453.custom_library

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable


class TextDrawable(text: String, color: Int, textSize: Float? = null) : Drawable() {

    private var textSize = Utils.convertDpToPx(16f)
    private var mPaint: Paint? = null
    private var mText: CharSequence? = null

    init {
        mText = text
        this.textSize = textSize ?: this.textSize
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint?.color = color
        mPaint?.textAlign = Paint.Align.CENTER
        mPaint?.textSize = this.textSize
    }

    override fun draw(canvas: Canvas) {
        val bounds: Rect = bounds
        canvas.drawText(
            mText!!,
            0,
            mText!!.length,
            bounds.centerX().toFloat(),
            bounds.centerY() + mPaint!!.getFontMetricsInt(null) / 3f,
            mPaint!!
        )
    }

    override fun setAlpha(alpha: Int) {
        mPaint?.alpha = alpha
    }

    override fun getOpacity(): Int {
        return mPaint?.alpha ?: 0
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mPaint?.colorFilter = colorFilter
    }
}