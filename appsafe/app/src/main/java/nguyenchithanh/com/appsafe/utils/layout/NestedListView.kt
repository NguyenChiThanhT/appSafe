package nguyenchithanh.com.appsafe.utils.layout

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.View.MeasureSpec
import android.view.ViewGroup
import android.widget.AbsListView
import android.view.View.OnTouchListener
import android.widget.ListView


class NestedListView(context: Context, attrs: AttributeSet) : ListView(context, attrs), OnTouchListener,
    AbsListView.OnScrollListener {

    private val listViewTouchAction: Int

    init {
        listViewTouchAction = -1
        setOnScrollListener(this)
        setOnTouchListener(this)
    }

    override fun onScroll(
        view: AbsListView, firstVisibleItem: Int,
        visibleItemCount: Int, totalItemCount: Int
    ) {
        if (getAdapter() != null && getAdapter().getCount() > MAXIMUM_LIST_ITEMS_VIEWABLE) {
            if (listViewTouchAction == MotionEvent.ACTION_MOVE) {
                scrollBy(0, -1)
            }
        }
    }

    override fun onScrollStateChanged(view: AbsListView, scrollState: Int) {}

    protected override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        var newHeight = 0
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        if (heightMode != MeasureSpec.EXACTLY) {
            val listAdapter = getAdapter()
            if (listAdapter != null && !listAdapter!!.isEmpty()) {
                var listPosition = 0
                listPosition = 0
                while (listPosition < listAdapter!!.getCount() && listPosition < MAXIMUM_LIST_ITEMS_VIEWABLE) {
                    val listItem = listAdapter!!.getView(listPosition, null, this)
                    //now it will not throw a NPE if listItem is a ViewGroup instance
                    if (listItem is ViewGroup) {
                        listItem.setLayoutParams(
                            LayoutParams(
                                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT
                            )
                        )
                    }
                    listItem.measure(widthMeasureSpec, heightMeasureSpec)
                    newHeight += listItem.getMeasuredHeight()
                    listPosition++
                }
                newHeight += getDividerHeight() * listPosition
            }
            if (heightMode == MeasureSpec.AT_MOST && newHeight > heightSize) {
                if (newHeight > heightSize) {
                    newHeight = heightSize
                }
            }
        } else {
            newHeight = getMeasuredHeight()
        }
        setMeasuredDimension(getMeasuredWidth(), newHeight)
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        if (getAdapter() != null && getAdapter().getCount() > MAXIMUM_LIST_ITEMS_VIEWABLE) {
            if (listViewTouchAction == MotionEvent.ACTION_MOVE) {
                scrollBy(0, 1)
            }
        }
        return false
    }

    companion object {
        private val MAXIMUM_LIST_ITEMS_VIEWABLE = 99
    }
}