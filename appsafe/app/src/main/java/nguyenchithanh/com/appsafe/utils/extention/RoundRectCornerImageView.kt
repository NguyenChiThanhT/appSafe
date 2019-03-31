package nguyenchithanh.com.appsafe.utils.extention

import android.R.attr.*
import android.graphics.Path
import android.graphics.RectF
import android.content.Context
import android.graphics.Canvas
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.util.AttributeSet
import android.widget.ImageView


class RoundRectCornerImageView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : ImageView(context, attrs, defStyleAttr) {
    private val radius = 18.0f
    private var path: Path? = null
    private var rect: RectF? = null

    init {
        path = Path()
    }

    override fun onDraw(canvas: Canvas?) {
        rect = RectF(0f, 0f, this.width.toFloat(), this.height.toFloat())
        path?.addRoundRect(rect, radius, radius, Path.Direction.CW);
        canvas?.clipPath(path);
        super.onDraw(canvas)
    }
}

