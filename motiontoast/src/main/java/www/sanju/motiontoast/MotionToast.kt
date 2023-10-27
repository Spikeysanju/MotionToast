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
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import www.sanju.motiontoast.databinding.FullColorToastBinding
import www.sanju.motiontoast.databinding.MotionToastBinding

class MotionToast {
    companion object {

        const val LONG_DURATION = 5000L // 5 seconds
        const val SHORT_DURATION = 2000L // 2 seconds
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
            context: Context,
            title: String? = null,
            message: String,
            style: MotionToastStyle,
            position: Int,
            duration: Long,
            font: Typeface?
        ) {
            layoutInflater = LayoutInflater.from(context)
            val binding = MotionToastBinding.inflate(layoutInflater)
            val layout = binding.root
            when (style) {
                // Function for Toast Success
                MotionToastStyle.SUCCESS -> {
                    binding.customToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_check_green
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.customToastImage.drawable),
                        ContextCompat.getColor(context, successToastColor)
                    )

                    // Pulse Animation for Icon
                    startPulseAnimation(context, binding.customToastImage)

                    // Background tint color for side view
                    binding.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, successToastColor)

                    // round background color
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        successBackgroundToastColor, layout, context
                    )

                    // Setting up the color for title & Message text
                    binding.customToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            successToastColor
                        )
                    )
                    binding.customToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.SUCCESS.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.BLACK,
                        message,
                        binding.customToastDescription
                    )

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
                MotionToastStyle.ERROR -> {
                    binding.customToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.customToastImage.drawable),
                        ContextCompat.getColor(context, errorToastColor)
                    )
                    startPulseAnimation(context, binding.customToastImage)
                    binding.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, errorToastColor)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, errorBackgroundToastColor),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    binding.customToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            errorToastColor
                        )
                    )
                    binding.customToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.ERROR.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.BLACK,
                        message,
                        binding.customToastDescription
                    )

                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Warning
                MotionToastStyle.WARNING -> {
                    binding.customToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.customToastImage.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    startPulseAnimation(context, binding.customToastImage)
                    binding.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, warningToastColor)

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        warningBackgroundToastColor, layout, context
                    )

                    binding.customToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    binding.customToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.WARNING.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.BLACK,
                        message,
                        binding.customToastDescription
                    )

                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Info
                MotionToastStyle.INFO -> {
                    binding.customToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.customToastImage.drawable),
                        ContextCompat.getColor(context, infoToastColor)
                    )
                    startPulseAnimation(context, binding.customToastImage)

                    binding.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, infoToastColor)

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        infoBackgroundToastColor, layout, context
                    )

                    binding.customToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            infoToastColor
                        )
                    )
                    binding.customToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.INFO.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.BLACK,
                        message,
                        binding.customToastDescription
                    )

                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Delete
                MotionToastStyle.DELETE -> {
                    binding.customToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.customToastImage.drawable),
                        ContextCompat.getColor(context, deleteToastColor)
                    )
                    startPulseAnimation(context, binding.customToastImage)
                    binding.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, deleteToastColor)

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        deleteBackgroundToastColor, layout, context
                    )

                    binding.customToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            deleteToastColor
                        )
                    )
                    binding.customToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.DELETE.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.BLACK,
                        message,
                        binding.customToastDescription
                    )

                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
                    toast.view = layout//setting the view of custom toast layout
//                    binding.animate().alpha(0f).duration = 3000
                    toast.show()

                }
                // CTA for Toast No Internet
                MotionToastStyle.NO_INTERNET -> {
                    binding.customToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.customToastImage.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    startPulseAnimation(context, binding.customToastImage)
                    binding.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, warningToastColor)

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        warningBackgroundToastColor, layout, context
                    )

                    binding.customToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    binding.customToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.NO_INTERNET.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.BLACK,
                        message,
                        binding.customToastDescription
                    )

                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
            }
        }

        // all color toast CTA
        fun createColorToast(
            context: Activity,
            title: String? = null,
            message: String,
            style: MotionToastStyle,
            position: Int,
            duration: Long,
            font: Typeface?
        ) {
            layoutInflater = LayoutInflater.from(context)
            val binding = FullColorToastBinding.inflate(layoutInflater)
            val layout = binding.root
            when (style) {
                // Function for Toast Success
                MotionToastStyle.SUCCESS -> {
                    binding.colorToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_check_green
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.colorToastImage.drawable),
                        ContextCompat.getColor(context, successToastColor)
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    binding.colorToastImage.startAnimation(pulseAnimation)

                    // round background color
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        successToastColor, layout, context
                    )

                    // Setting up the color for title & Message text
                    binding.colorToastText.setTextColor(Color.WHITE)
                    binding.colorToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.SUCCESS.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.colorToastDescription
                    )

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
                MotionToastStyle.ERROR -> {
                    binding.colorToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.colorToastImage.drawable),
                        ContextCompat.getColor(context, errorToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    binding.colorToastImage.startAnimation(pulseAnimation)

                    // round background color
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        errorToastColor, layout, context
                    )

                    // Setting up the color for title & Message text
                    binding.colorToastText.setTextColor(Color.WHITE)
                    binding.colorToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.ERROR.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.colorToastDescription
                    )

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
                MotionToastStyle.WARNING -> {
                    binding.colorToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.colorToastImage.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    binding.colorToastImage.startAnimation(pulseAnimation)

                    // round background color
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        warningToastColor, layout, context
                    )

                    // Setting up the color for title & Message text
                    binding.colorToastText.setTextColor(Color.WHITE)
                    binding.colorToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.WARNING.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.colorToastDescription
                    )

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
                MotionToastStyle.INFO -> {
                    binding.colorToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.colorToastImage.drawable),
                        ContextCompat.getColor(context, infoToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    binding.colorToastImage.startAnimation(pulseAnimation)

                    // round background color
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        infoToastColor, layout, context
                    )

                    // Setting up the color for title & Message text
                    binding.colorToastText.setTextColor(Color.WHITE)
                    binding.colorToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.INFO.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.colorToastDescription
                    )

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
                MotionToastStyle.DELETE -> {
                    binding.colorToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.colorToastImage.drawable),
                        ContextCompat.getColor(context, deleteToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    binding.colorToastImage.startAnimation(pulseAnimation)

                    // round background color
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        deleteToastColor, layout, context
                    )

                    // Setting up the color for title & Message text
                    binding.colorToastText.setTextColor(Color.WHITE)
                    binding.colorToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.DELETE.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.colorToastDescription
                    )

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
                MotionToastStyle.NO_INTERNET -> {
                    binding.colorToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.colorToastImage.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    binding.colorToastImage.startAnimation(pulseAnimation)

                    // round background color
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        warningToastColor, layout, context
                    )

                    // Setting up the color for title & Message text
                    binding.colorToastText.setTextColor(Color.WHITE)
                    binding.colorToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.NO_INTERNET.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.colorToastDescription
                    )

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
            style: MotionToastStyle,
            position: Int,
            duration: Long,
            font: Typeface?
        ) {
            layoutInflater = LayoutInflater.from(context)
            val binding = FullColorToastBinding.inflate(layoutInflater)
            val layout = binding.root
            when (style) {
                // Function for Toast Success
                MotionToastStyle.SUCCESS -> {
                    binding.colorToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_check_green
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.colorToastImage.drawable),
                        ContextCompat.getColor(context, successToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    binding.colorToastImage.startAnimation(pulseAnimation)

                    // round background color
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    binding.colorToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            successToastColor
                        )
                    )
                    binding.colorToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.SUCCESS.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.colorToastDescription
                    )

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
                MotionToastStyle.ERROR -> {
                    binding.colorToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.colorToastImage.drawable),
                        ContextCompat.getColor(context, errorToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    binding.colorToastImage.startAnimation(pulseAnimation)

                    // round background color
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    // Setting up the color for title & Message text
                    binding.colorToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            errorToastColor
                        )
                    )
                    binding.colorToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.ERROR.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.colorToastDescription
                    )

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
                MotionToastStyle.WARNING -> {
                    binding.colorToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.colorToastImage.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    binding.colorToastImage.startAnimation(pulseAnimation)

                    // round background color
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    // Setting up the color for title & Message text
                    binding.colorToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    binding.colorToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.WARNING.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.colorToastDescription
                    )

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
                MotionToastStyle.INFO -> {
                    binding.colorToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.colorToastImage.drawable),
                        ContextCompat.getColor(context, infoToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    binding.colorToastImage.startAnimation(pulseAnimation)

                    // round background color
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    // Setting up the color for title & Message text
                    binding.colorToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            infoToastColor
                        )
                    )
                    binding.colorToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.INFO.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.colorToastDescription
                    )

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
                MotionToastStyle.DELETE -> {
                    binding.colorToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.colorToastImage.drawable),
                        ContextCompat.getColor(context, deleteToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    binding.colorToastImage.startAnimation(pulseAnimation)

                    // round background color
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    // Setting up the color for title & Message text
                    binding.colorToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            deleteToastColor
                        )
                    )
                    binding.colorToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.DELETE.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.colorToastDescription
                    )

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
                MotionToastStyle.NO_INTERNET -> {
                    binding.colorToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.colorToastImage.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    binding.colorToastImage.startAnimation(pulseAnimation)

                    // round background color
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    // Setting up the color for title & Message text
                    binding.colorToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    binding.colorToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.NO_INTERNET.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.colorToastDescription
                    )

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
            style: MotionToastStyle,
            position: Int,
            duration: Long,
            font: Typeface?
        ) {
            layoutInflater = LayoutInflater.from(context)
            val binding = MotionToastBinding.inflate(layoutInflater)
            val layout = binding.root
            when (style) {
                // Function for Toast Success
                MotionToastStyle.SUCCESS -> {
                    binding.customToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_check_green
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.customToastImage.drawable),
                        ContextCompat.getColor(context, successToastColor)
                    )
                    // Pulse Animation for Icon
                    startPulseAnimation(context, binding.customToastImage)

                    // Background tint color for side view
                    binding.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, successToastColor)

                    // round background color
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    // Setting up the color for title & Message text
                    binding.customToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            successToastColor
                        )
                    )
                    binding.customToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.SUCCESS.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.customToastDescription
                    )

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
                MotionToastStyle.ERROR -> {
                    binding.customToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.customToastImage.drawable),
                        ContextCompat.getColor(context, errorToastColor)
                    )
                    startPulseAnimation(context, binding.customToastImage)
                    binding.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, errorToastColor)

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    binding.customToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            errorToastColor
                        )
                    )
                    binding.customToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.ERROR.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.customToastDescription
                    )

                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Warning
                MotionToastStyle.WARNING -> {
                    binding.customToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.customToastImage.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    startPulseAnimation(context, binding.customToastImage)
                    binding.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, warningToastColor)

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    binding.customToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    binding.customToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.WARNING.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.customToastDescription
                    )

                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Info
                MotionToastStyle.INFO -> {
                    binding.customToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.customToastImage.drawable),
                        ContextCompat.getColor(context, infoToastColor)
                    )
                    startPulseAnimation(context, binding.customToastImage)

                    binding.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, infoToastColor)

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    binding.customToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            infoToastColor
                        )
                    )
                    binding.customToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.INFO.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.customToastDescription
                    )

                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Delete
                MotionToastStyle.DELETE -> {
                    binding.customToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.customToastImage.drawable),
                        ContextCompat.getColor(context, deleteToastColor)
                    )
                    startPulseAnimation(context, binding.customToastImage)
                    binding.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, deleteToastColor)

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    binding.customToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            deleteToastColor
                        )
                    )
                    binding.customToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.DELETE.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.customToastDescription
                    )

                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    setGravity(position, toast)
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast No Internet
                MotionToastStyle.NO_INTERNET -> {
                    binding.customToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.customToastImage.drawable),
                        ContextCompat.getColor(context, warningToastColor)
                    )
                    startPulseAnimation(context, binding.customToastImage)
                    binding.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, warningToastColor)

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        R.color.dark_bg_color, layout, context
                    )

                    binding.customToastText.setTextColor(
                        ContextCompat.getColor(
                            context,
                            warningToastColor
                        )
                    )
                    binding.customToastText.text =
                        if (title.isNullOrBlank()) MotionToastStyle.NO_INTERNET.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.customToastDescription
                    )
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

        private fun startPulseAnimation(context: Context, customToastImage: ImageView) {
            val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
            customToastImage.startAnimation(pulseAnimation)
        }

        private fun setDescriptionDetails(
            font: Typeface?,
            textColor: Int,
            message: String,
            layout: TextView
        ) {
            layout.setTextColor(textColor)
            layout.text = message
            font?.let {
                layout.typeface = font
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