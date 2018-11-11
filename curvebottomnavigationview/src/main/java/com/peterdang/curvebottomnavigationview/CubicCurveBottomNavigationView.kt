package com.peterdang.curvebottomnavigationview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import com.google.android.material.bottomnavigation.BottomNavigationView

class CubicCurveBottomNavigationView : BottomNavigationView {
    private var mNavigationBarHeight: Int = 0
    private var mNavigationBarWidth: Int = 0

    private var fabRadiusSize: Int = 0;

    private var mFirstCurveStart: Point = Point()
    private var mFirstCurveEnd: Point = Point()
    private var mFirstCurveControl1: Point = Point()
    private var mFirstCurveControl2: Point = Point()

    private var mSecondCurveStart: Point = Point()
    private var mSecondCurveEnd: Point = Point()
    private var mSecondCurveControl1: Point = Point()
    private var mSecondCurveControl2: Point = Point()

    private lateinit var mPath: Path
    private lateinit var mPaint: Paint

    private val fabSizeInDp: Float = 70f/2

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        mPaint = Paint()
        mPath = Path()

        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.color = Color.WHITE

        setBackgroundColor(Color.TRANSPARENT)
        fabRadiusSize = SizeConvertor.convertDpToPixel(fabSizeInDp, context).toInt();
    }

    public fun setFabRadiusSize(fabRadiusSize: Int) {
        this.fabRadiusSize = fabRadiusSize
        invalidate()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        mNavigationBarWidth = width
        mNavigationBarHeight = height

        mFirstCurveStart.set((mNavigationBarWidth / 2) - (fabRadiusSize * 2) - (fabRadiusSize / 3), 0);
        mFirstCurveEnd.set(mNavigationBarWidth / 2, fabRadiusSize + (fabRadiusSize / 4));

        mSecondCurveStart = mFirstCurveEnd;
        mSecondCurveEnd.set((mNavigationBarWidth / 2) + (fabRadiusSize * 2) + (fabRadiusSize / 3), 0);

        mFirstCurveControl1.set(mFirstCurveStart.x + fabRadiusSize + (fabRadiusSize / 4), mFirstCurveStart.y)
        mFirstCurveControl2.set(mFirstCurveEnd.x - (fabRadiusSize * 2) + fabRadiusSize, mFirstCurveEnd.y)

        mSecondCurveControl1.set(mSecondCurveStart.x + (fabRadiusSize * 2) - fabRadiusSize, mSecondCurveStart.y)
        mSecondCurveControl2.set(mSecondCurveEnd.x - (fabRadiusSize + (fabRadiusSize / 4)), mSecondCurveEnd.y)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPath.reset()
        mPath.lineTo(mFirstCurveStart.x.toFloat(), mFirstCurveStart.y.toFloat());

        mPath.cubicTo(mFirstCurveControl1.x.toFloat(), mFirstCurveControl1.y.toFloat(),
                mFirstCurveControl2.x.toFloat(), mFirstCurveControl2.y.toFloat(),
                mFirstCurveEnd.x.toFloat(), mFirstCurveEnd.y.toFloat());

        mPath.cubicTo(mSecondCurveControl1.x.toFloat(), mSecondCurveControl1.y.toFloat(),
                mSecondCurveControl2.x.toFloat(), mSecondCurveControl2.y.toFloat(),
                mSecondCurveEnd.x.toFloat(), mSecondCurveEnd.y.toFloat());

        mPath.lineTo(mNavigationBarWidth.toFloat(), 0f);
        mPath.lineTo(mNavigationBarWidth.toFloat(), mNavigationBarHeight.toFloat());
        mPath.lineTo(0f, mNavigationBarHeight.toFloat());
        mPath.close();

        if (canvas != null) {
            canvas.drawPath(mPath, mPaint)
        }
    }
}