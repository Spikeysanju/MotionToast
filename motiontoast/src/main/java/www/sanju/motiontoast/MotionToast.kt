package www.sanju.motiontoast

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.Typeface
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.android.synthetic.main.full_color_toast.view.*
import kotlinx.android.synthetic.main.motion_toast.view.*

@Suppress("DEPRECATION")
class MotionToast {
    companion object {

        const val LONG_DURATION = 5000L // 5 seconds
        const val SHORT_DURATION = 2000L // 2 seconds
        const val TOAST_SUCCESS = "SUCCESS"
        const val TOAST_ERROR = "FAILED"
        const val TOAST_WARNING = "WARNING"
        const val TOAST_INFO = "INFO"
        const val TOAST_DELETE = "DELETE"
        const val TOAST_NO_INTERNET = "NO INTERNET"
        const val GRAVITY_TOP = 50
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
            title: String? = null,
            message: String,
            style: String,
            position: Int,
            duration: Long,
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
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        successBackgroundToastColor, layout, context
                    )

                    // Setting up the color for title & Message text
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            successToastColor
                        )
                    )
                    layout.custom_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_SUCCESS else title
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

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
                    layout.custom_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_ERROR else title
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val timer = object : CountDownTimer(duration, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            // do nothing
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    setGravity(position, toast)
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

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        warningBackgroundToastColor, layout, context
                    )

                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    layout.custom_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_WARNING else title
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
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

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        infoBackgroundToastColor, layout, context
                    )

                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            infoToastColor
                        )
                    )
                    layout.custom_toast_text.text = if (title.isNullOrBlank()) TOAST_INFO else title
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
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

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        deleteBackgroundToastColor, layout, context
                    )

                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            deleteToastColor
                        )
                    )
                    layout.custom_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_DELETE else title
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
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

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        warningBackgroundToastColor, layout, context
                    )

                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    layout.custom_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_NO_INTERNET else title
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
            }
        }

        private fun startTimer(duration: Long, toast: Toast) {
            val timer = object : CountDownTimer(duration, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    // do nothing
                }

                override fun onFinish() {
                    toast.cancel()
                }
            }
            timer.start()
        }

        // all color toast CTA
        fun createColorToast(
            context: Activity,
            title: String? = null,
            message: String,
            style: String,
            position: Int,
            duration: Long,
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
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        successToastColor, layout, context
                    )

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_SUCCESS else title
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

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
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        errorToastColor, layout, context
                    )

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text = if (title.isNullOrBlank()) TOAST_ERROR else title
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

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
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        warningToastColor, layout, context
                    )

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_WARNING else title
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

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
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        infoToastColor, layout, context
                    )

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text = if (title.isNullOrBlank()) TOAST_INFO else title
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

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
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        deleteToastColor, layout, context
                    )

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_DELETE else title
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

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
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        warningToastColor, layout, context
                    )

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_NO_INTERNET else title
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
            }
        }

        // all dark toast CTA
        fun darkToast(
            context: Activity,
            title: String? = null,
            message: String,
            style: String,
            position: Int,
            duration: Long,
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
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            successToastColor
                        )
                    )
                    layout.color_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_SUCCESS else title
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

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
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            errorToastColor
                        )
                    )
                    layout.color_toast_text.text = if (title.isNullOrBlank()) TOAST_ERROR else title
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

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
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    layout.color_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_WARNING else title
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

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
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            infoToastColor
                        )
                    )
                    layout.color_toast_text.text = if (title.isNullOrBlank()) TOAST_INFO else title
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

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
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            deleteToastColor
                        )
                    )
                    layout.color_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_DELETE else title
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

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
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    layout.color_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_NO_INTERNET else title
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()

                }
            }
        }

        // all toast CTA
        fun darkColorToast(
            context: Activity,
            title: String? = null,
            message: String,
            style: String,
            position: Int,
            duration: Long,
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
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    // Setting up the color for title & Message text
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            successToastColor
                        )
                    )
                    layout.custom_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_SUCCESS else title
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

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

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            errorToastColor
                        )
                    )
                    layout.custom_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_ERROR else title
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
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

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    layout.custom_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_WARNING else title
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
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

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            infoToastColor
                        )
                    )
                    layout.custom_toast_text.text = if (title.isNullOrBlank()) TOAST_INFO else title
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
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

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            deleteToastColor
                        )
                    )
                    layout.custom_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_DELETE else title
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
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

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    layout.custom_toast_text.text =
                        if (title.isNullOrBlank()) TOAST_NO_INTERNET else title
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
            }
        }

        private fun setGravity(position: Int, toast: Toast) {
            if (position == GRAVITY_BOTTOM) {
                toast.setGravity(position, 0, 100)
            } else {
                toast.setGravity(position, 0, 0)
            }
        }

        private fun setBackgroundAndFilter(
            @DrawableRes background: Int,
            @ColorRes colorFilter: Int,
            layout: View,
            context: Context
        ) {
            val drawable = ContextCompat.getDrawable(context, background)
            drawable?.colorFilter = PorterDuffColorFilter(
                ContextCompat.getColor(context, colorFilter),
                PorterDuff.Mode.MULTIPLY
            )
            layout.background = drawable
        }
    }
}