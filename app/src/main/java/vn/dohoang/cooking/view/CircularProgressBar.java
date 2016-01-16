package vn.dohoang.cooking.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import vn.dohoang.cooking.R;

/**
 * Simple single android view component that can be used to showing a round progress bar.
 * It can be customized with size, stroke size, colors and text etc.
 * Progress change will be animated.;
 * Created by Kristoffer, http://kmdev.se
 * Modified by Do Hoang
 */
public class CircularProgressBar extends View {

    private int mViewWidth;
    private int mViewHeight;

    private final float mStartAngle = -90;      // Always start from top (default is: "3 o'clock on a watch.")
    private float mSweepAngle = 0;              // How long to sweep from mStartAngle
    private float mMaxSweepAngle = 360;         // Max degrees to sweep = full circle
    private int mStrokeWidth = 10;              // Width of outline

    private int mAnimationDuration = 500;       // Animation duration for progress change
    private int mMaxProgress = 100;             // Max progress to use
    private boolean mDrawText = true;           // Set to true if progress text should be drawn
    private boolean mRoundedCorners = true;     // Set to true if rounded corners should be applied to outline ends
    private int mProgressColor = Color.BLACK;   // Outline color
    private int mBackgroundColor = Color.BLACK; // Background color
    private int mTextColor = Color.BLACK;       // Progress text color

    private final Paint mPaint;                 // Allocate paint outside onDraw to avoid unnecessary object creation
    private final Paint mPaintBackground;       // Allocate paint background onDraw to avoid unnecessary object creation

    public CircularProgressBar(Context context) {
        this(context, null);
    }

    public CircularProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircularProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintBackground = new Paint(Paint.ANTI_ALIAS_FLAG);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CircularProgressBar,
                0, 0);

        try {
            mSweepAngle = a.getFloat(R.styleable.CircularProgressBar_sweepAngle, 0);
            mMaxSweepAngle = a.getFloat(R.styleable.CircularProgressBar_maxSweepAngle, 360);
            mStrokeWidth = a.getInteger(R.styleable.CircularProgressBar_strokeWidth, 10);
            mAnimationDuration = a.getInteger(R.styleable.CircularProgressBar_animationDuration, 500);
            mMaxProgress = a.getInteger(R.styleable.CircularProgressBar_maxProgress, 100);
            mDrawText = a.getBoolean(R.styleable.CircularProgressBar_drawText, false);
            mRoundedCorners = a.getBoolean(R.styleable.CircularProgressBar_roundedCorners, false);
            mBackgroundColor = a.getColor(R.styleable.CircularProgressBar_backgroundColor, Color.BLACK);
            mProgressColor = a.getColor(R.styleable.CircularProgressBar_progressColor, Color.BLACK);
            mTextColor = a.getColor(R.styleable.CircularProgressBar_textColor, Color.BLACK);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initMeasurements();
        drawArc(canvas);

        if (mDrawText) {
            drawText(canvas);
        }
    }

    private void initMeasurements() {
        mViewWidth = getWidth();
        mViewHeight = getHeight();
    }

    private void drawArc(Canvas canvas) {
        final int diameter = Math.min(mViewWidth, mViewHeight) - (mStrokeWidth * 2);
        final RectF outerOval = new RectF(mStrokeWidth, mStrokeWidth, diameter, diameter);

        mPaintBackground.setColor(mBackgroundColor);
        mPaintBackground.setStrokeWidth(mStrokeWidth);
        mPaintBackground.setAntiAlias(true);
        mPaintBackground.setStyle(Paint.Style.STROKE);
        // draw background line
        canvas.drawArc(outerOval, 0, 360, false, mPaintBackground);

        // draw progress line
        mPaint.setColor(mProgressColor);
        mPaint.setStrokeWidth(mStrokeWidth);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeCap(mRoundedCorners ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(outerOval, mStartAngle, mSweepAngle, false, mPaint);
    }

    private void drawText(Canvas canvas) {
        mPaint.setTextSize(Math.min(mViewWidth, mViewHeight) / 5f);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setStrokeWidth(0);
        mPaint.setColor(mTextColor);

        // Center text
        int xPos = (canvas.getWidth() / 2);
        int yPos = (int) ((canvas.getHeight() / 2) - ((mPaint.descent() + mPaint.ascent()) / 2));

        canvas.drawText(calcProgressFromSweepAngle(mSweepAngle) + "%", xPos, yPos, mPaint);
    }

    private float calcSweepAngleFromProgress(int progress) {
        return (mMaxSweepAngle / mMaxProgress) * progress;
    }

    private int calcProgressFromSweepAngle(float sweepAngle) {
        return (int) ((sweepAngle * mMaxProgress) / mMaxSweepAngle);
    }

    /**
     * Set progress of the circular progress bar.
     *
     * @param progress progress between 0 and 100.
     */
    public void setProgress(int progress) {
        ValueAnimator animator = ValueAnimator.ofFloat(mSweepAngle, calcSweepAngleFromProgress(progress));
        animator.setInterpolator(new DecelerateInterpolator());
        animator.setDuration(mAnimationDuration);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mSweepAngle = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();
    }

    public void setProgressColor(int color) {
        mProgressColor = color;
        invalidate();
    }

    public void setProgressWidth(int width) {
        mStrokeWidth = width;
        invalidate();
    }

    public void setTextColor(int color) {
        mTextColor = color;
        invalidate();
    }

    public void showProgressText(boolean show) {
        mDrawText = show;
        invalidate();
    }

    /**
     * Toggle this if you don't want rounded corners on progress bar.
     * Default is true.
     *
     * @param roundedCorners true if you want rounded corners of false otherwise.
     */
    public void useRoundedCorners(boolean roundedCorners) {
        mRoundedCorners = roundedCorners;
        invalidate();
    }

    public int getAnimationDuration() {
        return mAnimationDuration;
    }
}