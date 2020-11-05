package www.sanju.motiontoast

import android.app.Activity
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.Typeface
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.android.synthetic.main.full_color_toast.view.*
import kotlinx.android.synthetic.main.motion_toast.view.*

@Suppress("DEPRECATION")
class MotionToast {
    companion object {

        const val LONG_DURATION = 5000 // 5 seconds
        const val SHORT_DURATION = 2000 // 2 seconds
        const val TOAST_SUCCESS = "SUCCESS"
        const val TOAST_ERROR = "FAILED"
        const val TOAST_WARNING = "WARNING"
        const val TOAST_INFO = "INFO"
        const val TOAST_DELETE = "DELETE"
        const val TOAST_NO_INTERNET = "NO INTERNET"

        const val GRAVITY_TOP = 48
        const val GRAVITY_CENTER = 20
        const val GRAVITY_BOTTOM = 80

        private lateinit var layoutInflater: LayoutInflater

        private var successToastColor: Int = R.color.success_color
        private var errorToastColor: Int = R.color.error_color
        private var warningToastColor: Int = R.color.warning_color
        private var infoToastColor: Int = R.color.info_color
        private var deleteToastColor: Int = R.color.delete_color

        private var successBackgroundToastColor: Int = R.color.success_bg_color
        private var errorBackgroundToastColor: Int = R.color.error_bg_color
        private var warningBackgroundToastColor: Int = R.color.warning_bg_color
        private var infoBackgroundToastColor: Int = R.color.info_bg_color
        private var deleteBackgroundToastColor: Int = R.color.delete_bg_color

        fun resetToastColors() {
            successToastColor = R.color.success_color
            errorToastColor = R.color.error_color
            warningToastColor = R.color.warning_color
            infoToastColor = R.color.info_color
            deleteToastColor = R.color.delete_color

            successBackgroundToastColor = R.color.success_bg_color
            errorBackgroundToastColor = R.color.error_bg_color
            warningBackgroundToastColor = R.color.warning_bg_color
            infoBackgroundToastColor = R.color.info_bg_color
            deleteBackgroundToastColor = R.color.delete_bg_color
        }

        fun setSuccessColor(color: Int) {
            successToastColor = color
        }

        fun setSuccessBackgroundColor(color: Int) {
            successBackgroundToastColor = color
        }

        fun setErrorColor(color: Int) {
            errorToastColor = color
        }

        fun setErrorBackgroundColor(color: Int) {
            errorBackgroundToastColor = color
        }

        fun setWarningColor(color: Int) {
            warningToastColor = color
        }

        fun setWarningBackgroundColor(color: Int) {
            warningBackgroundToastColor = color
        }

        fun setInfoColor(color: Int) {
            infoToastColor = color
        }

        fun setInfoBackgroundColor(color: Int) {
            infoBackgroundToastColor = color
        }

        fun setDeleteColor(color: Int) {
            deleteToastColor = color
        }

        fun setDeleteBackgroundColor(color: Int) {
            deleteBackgroundToastColor = color
        }

        // all toast CTA
        fun createToast(
            context: Activity,
            message: String,
            style: String,
            position: Int,
            duration: Int,
            font: Typeface?
        ) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.motion_toast,
                (context).findViewById(R.id.motion_toast_view)
            )
            when (style) {
                // Function for Toast Success
                TOAST_SUCCESS -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_check_green
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.custom_toast_image.drawable),
                        ContextCompat.getColor(context, successToastColor)
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)

                    // Background tint color for side view
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, successToastColor)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, successBackgroundToastColor),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            successToastColor
                        )
                    )
                    layout.custom_toast_text.text = TOAST_SUCCESS
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Error
                TOAST_ERROR -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.custom_toast_image.drawable),
                        ContextCompat.getColor(context, errorToastColor)
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, errorToastColor)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, errorBackgroundToastColor),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            errorToastColor
                        )
                    )
                    layout.custom_toast_text.text = TOAST_ERROR
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Warning
                TOAST_WARNING -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.custom_toast_image.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, warningToastColor)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, warningBackgroundToastColor),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    layout.custom_toast_text.text = TOAST_WARNING
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.custom_toast_image.drawable),
                        ContextCompat.getColor(context, infoToastColor)
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)

                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, infoToastColor)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, infoBackgroundToastColor),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            infoToastColor
                        )
                    )
                    layout.custom_toast_text.text = TOAST_INFO
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    when (duration) {
                        LONG_DURATION -> {
                            val timer = object : CountDownTimer(5000, 1000) {
                                override fun onTick(millisUntilFinished: Long) {
                                    toast.show()
                                }

                                override fun onFinish() {
                                    toast.cancel()
                                }
                            }
                            timer.start()

                        }
                        SHORT_DURATION -> {
                            val timer = object : CountDownTimer(3000, 1000) {
                                override fun onTick(millisUntilFinished: Long) {
                                    toast.show()
                                }

                                override fun onFinish() {
                                    toast.cancel()
                                }
                            }
                            timer.start()
                        }
                        else -> {
                            val timer = object : CountDownTimer(2000, 1000) {
                                override fun onTick(millisUntilFinished: Long) {
                                    toast.show()
                                }

                                override fun onFinish() {
                                    toast.cancel()
                                }
                            }
                            timer.start()
                        }
                    }
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.custom_toast_image.drawable),
                        ContextCompat.getColor(context, deleteToastColor)
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, deleteToastColor)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, deleteBackgroundToastColor),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            deleteToastColor
                        )
                    )
                    layout.custom_toast_text.text = TOAST_DELETE
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
//                    layout.animate().alpha(0f).duration = 3000
                    toast.show()

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.custom_toast_image.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, warningToastColor)


                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, warningBackgroundToastColor),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    layout.custom_toast_text.text = TOAST_NO_INTERNET
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
//                    layout.animate().alpha(0f).duration = 3000
                    toast.show()

                }
            }
        }

        // all color toast CTA
        fun createColorToast(
            context: Activity,
            message: String,
            style: String,
            position: Int,
            duration: Int,
            font: Typeface?
        ) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.full_color_toast,
                (context).findViewById(R.id.color_toast_view)
            )
            when (style) {
                // Function for Toast Success
                TOAST_SUCCESS -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_check_green
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.color_toast_image.drawable),
                        ContextCompat.getColor(context, successToastColor)
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, successToastColor),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text = TOAST_SUCCESS
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Error
                TOAST_ERROR -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.color_toast_image.drawable),
                        ContextCompat.getColor(context, errorToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, errorToastColor),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text = TOAST_ERROR
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Warning
                TOAST_WARNING -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.color_toast_image.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, warningToastColor),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text = TOAST_WARNING
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.color_toast_image.drawable),
                        ContextCompat.getColor(context, infoToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, infoToastColor),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text = TOAST_INFO
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.color_toast_image.drawable),
                        ContextCompat.getColor(context, deleteToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, deleteToastColor),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text = TOAST_DELETE
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.color_toast_image.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, warningToastColor),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text = TOAST_NO_INTERNET
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
            }
        }

        // all dark toast CTA
        fun darkToast(
            context: Activity,
            message: String,
            style: String,
            position: Int,
            duration: Int,
            font: Typeface?
        ) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.full_color_toast,
                (context).findViewById(R.id.color_toast_view)
            )
            when (style) {
                // Function for Toast Success
                TOAST_SUCCESS -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_check_green
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.color_toast_image.drawable),
                        ContextCompat.getColor(context, successToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            successToastColor
                        )
                    )
                    layout.color_toast_text.text = TOAST_SUCCESS
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Error
                TOAST_ERROR -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.color_toast_image.drawable),
                        ContextCompat.getColor(context, errorToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            errorToastColor
                        )
                    )
                    layout.color_toast_text.text = TOAST_ERROR
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Warning
                TOAST_WARNING -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.color_toast_image.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    layout.color_toast_text.text = TOAST_WARNING
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.color_toast_image.drawable),
                        ContextCompat.getColor(context, infoToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            infoToastColor
                        )
                    )
                    layout.color_toast_text.text = TOAST_INFO
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.color_toast_image.drawable),
                        ContextCompat.getColor(context, deleteToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            deleteToastColor
                        )
                    )
                    layout.color_toast_text.text = TOAST_DELETE
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.color_toast_image.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    layout.color_toast_text.text = TOAST_NO_INTERNET
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()

                }
            }
        }

        // all toast CTA
        fun darkColorToast(
            context: Activity,
            message: String,
            style: String,
            position: Int,
            duration: Int,
            font: Typeface?
        ) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.motion_toast,
                (context).findViewById(R.id.motion_toast_view)
            )
            when (style) {
                // Function for Toast Success
                TOAST_SUCCESS -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_check_green
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.custom_toast_image.drawable),
                        ContextCompat.getColor(context, successToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)

                    // Background tint color for side view
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, successToastColor)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            successToastColor
                        )
                    )
                    layout.custom_toast_text.text = TOAST_SUCCESS
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Error
                TOAST_ERROR -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.custom_toast_image.drawable),
                        ContextCompat.getColor(context, errorToastColor)
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, errorToastColor)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            errorToastColor
                        )
                    )
                    layout.custom_toast_text.text = TOAST_ERROR
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Warning
                TOAST_WARNING -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.custom_toast_image.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, warningToastColor)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    layout.custom_toast_text.text = TOAST_WARNING
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.custom_toast_image.drawable),
                        ContextCompat.getColor(context, infoToastColor)
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)

                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, infoToastColor)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            infoToastColor
                        )
                    )
                    layout.custom_toast_text.text = TOAST_INFO
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.custom_toast_image.drawable),
                        ContextCompat.getColor(context, deleteToastColor)
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, deleteToastColor)


                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            deleteToastColor
                        )
                    )
                    layout.custom_toast_text.text = TOAST_DELETE
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
//                    layout.animate().alpha(0f).duration = 3000
                    toast.show()

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(layout.custom_toast_image.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, warningToastColor)


                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    layout.custom_toast_text.text = TOAST_NO_INTERNET
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
            }
        }
    }
}