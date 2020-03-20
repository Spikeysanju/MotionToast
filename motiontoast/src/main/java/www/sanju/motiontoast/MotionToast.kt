package www.sanju.motiontoast

import android.app.Activity
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.Typeface
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.full_color_toast.view.*
import kotlinx.android.synthetic.main.motion_toast.view.*

class MotionToast {
    companion object {

        private lateinit var layoutInflater: LayoutInflater


        fun warningToast(context: Activity, message: String, position: Int, duration: Int, font: Typeface?) {

            val iconDrawable = R.drawable.ic_warning_yellow
            val backgroundTint = R.color.warning_color
            val colorFilter = R.color.warning_bg_color
            val layout = createToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter)
            val toast = Toast(context.applicationContext)
            setDuration(duration, toast)

            setToastGravity(position, toast, layout)
        }

        fun errorToast(context: Activity, message: String, position: Int, duration: Int, font: Typeface?) {
            val iconDrawable = R.drawable.ic_error_
            val backgroundTint = R.color.error_color
            val colorFilter = R.color.error_bg_color
            val descriptionTextColor = Color.GRAY
            val textColor = Color.BLACK
            val text = TOAST_ERROR
            val layout = createCustomToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter, descriptionTextColor, textColor, text)

            val toast = Toast(context.applicationContext)

            setDuration(duration, toast)

            setToastGravity(position, toast, layout)
        }

        fun successToast(context: Activity, message: String, position: Int, duration: Int, font: Typeface?) {
            val iconDrawable = R.drawable.ic_check_green
            val backgroundTint = R.color.success_color
            val colorFilter = R.color.success_bg_color
            val descriptionTextColor = Color.GRAY
            val textColor = Color.BLACK
            val text = TOAST_SUCCESS
            val layout = createCustomToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter, descriptionTextColor, textColor, text)

            val toast = Toast(context.applicationContext)
            setDuration(duration, toast)

            setToastGravity(position, toast, layout)
        }

        fun infoToast(context: Activity, message: String, position: Int, duration: Int, font: Typeface?) {

            val iconDrawable = R.drawable.ic_info_blue
            val backgroundTint = R.color.info_color
            val colorFilter = R.color.info_bg_color
            val descriptionTextColor = Color.GRAY
            val textColor = Color.BLACK
            val text = TOAST_INFO
            val layout = createCustomToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter, descriptionTextColor, textColor, text)

            val toast = Toast(context.applicationContext)
            setDuration(duration, toast)

            setToastGravity(position, toast, layout)
        }

        fun deleteToast(context: Activity, message: String, style: String, position: Int, duration: Int, font: Typeface?) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(R.layout.motion_toast, (context).findViewById(R.id.motion_toast_view))

            if (style == TOAST_INFO) {
                infoToast(context, message, position, duration, font)
                val toast = Toast(context.applicationContext)
                setDuration(duration, toast)

                setToastGravity(position, toast, layout)
            } else {
                val iconDrawable = R.drawable.ic_delete_
                val backgroundTint = R.color.delete_color
                val colorFilter = R.color.delete_bg_color
                val descriptionTextColor = Color.GRAY
                val textColor = Color.BLACK
                val text = TOAST_DELETE
                createCustomToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter, descriptionTextColor, textColor, text)

                val toast = Toast(context.applicationContext)

                setDuration(duration, toast)

                setToastGravity(position, toast, layout, 3000)

            }

        }


        // all toast CTA
        fun createToast(context: Activity, message: String, style: String, position: Int, duration: Int, font: Typeface?) {
            when (style) {
                // Function for Toast Success
                TOAST_SUCCESS -> {
                    val iconDrawable = R.drawable.ic_check_green
                    val backgroundTint = R.color.success_color
                    val colorFilter = R.color.success_bg_color
                    val descriptionTextColor = Color.GRAY
                    val textColor = Color.BLACK
                    val text = TOAST_SUCCESS
                    val layout = createCustomToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter, descriptionTextColor, textColor, text)

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Error
                TOAST_ERROR -> {
                    val iconDrawable = R.drawable.ic_error_
                    val backgroundTint = R.color.error_color
                    val colorFilter = R.color.error_bg_color
                    val descriptionTextColor = Color.GRAY
                    val textColor = Color.BLACK
                    val text = TOAST_ERROR
                    val layout = createCustomToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter, descriptionTextColor, textColor, text)

                    val toast = Toast(context.applicationContext)
                    setDuration(duration, toast)

                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Warning
                TOAST_WARNING -> {
                    val iconDrawable = R.drawable.ic_warning_yellow
                    val backgroundTint = R.color.warning_color
                    val colorFilter = R.color.warning_bg_color
                    val layout = createToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter)
                    val toast = Toast(context.applicationContext)
                    setDuration(duration, toast)

                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    val iconDrawable = R.drawable.ic_info_blue
                    val backgroundTint = R.color.info_color
                    val colorFilter = R.color.info_bg_color
                    val descriptionTextColor = Color.GRAY
                    val textColor = Color.BLACK
                    val text = TOAST_INFO
                    val layout = createCustomToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter, descriptionTextColor, textColor, text)
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
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    val iconDrawable = R.drawable.ic_delete_
                    val backgroundTint = R.color.delete_color
                    val colorFilter = R.color.delete_bg_color
                    val descriptionTextColor = Color.GRAY
                    val textColor = Color.BLACK
                    val text = TOAST_DELETE
                    val layout = createCustomToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter, descriptionTextColor, textColor, text)

                    val toast = Toast(context.applicationContext)
                    setDuration(duration, toast)

                    setToastGravity(position, toast, layout)

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    val iconDrawable = R.drawable.ic_no_internet
                    val backgroundTint = R.color.warning_color
                    val colorFilter = R.color.warning_bg_color
                    val descriptionTextColor = Color.GRAY
                    val textColor = ContextCompat.getColor(context, R.color.warning_color)
                    val text = TOAST_NO_INTERNET
                    val layout = createCustomToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter, descriptionTextColor, textColor, text)

                    val toast = Toast(context.applicationContext)
                    setDuration(duration, toast)

                    setToastGravity(position, toast, layout)
                }
            }

        }

        // all color toast CTA
        fun createColorToast(context: Activity, message: String, style: String, position: Int, duration: Int, font: Typeface?) {
            when (style) {
                // Function for Toast Success
                TOAST_SUCCESS -> {
                    val iconDrawable = R.drawable.ic_check_green
                    val colorFilter = R.color.success_color
                    val textColor = Color.WHITE
                    val text = TOAST_SUCCESS
                    val layout = createColorToastLayout(context, message, font, iconDrawable, colorFilter, textColor, text)

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Error
                TOAST_ERROR -> {
                    val iconDrawable = R.drawable.ic_error_
                    val colorFilter = R.color.error_color
                    val textColor = Color.WHITE
                    val text = TOAST_ERROR
                    val layout = createColorToastLayout(context, message, font, iconDrawable, colorFilter, textColor, text)

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    setDuration(duration, toast)


                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Warning
                TOAST_WARNING -> {
                    val iconDrawable = R.drawable.ic_warning_yellow
                    val colorFilter = R.color.warning_color
                    val textColor = Color.WHITE
                    val text = TOAST_WARNING
                    val layout = createColorToastLayout(context, message, font, iconDrawable, colorFilter, textColor, text)

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    val iconDrawable = R.drawable.ic_info_blue
                    val colorFilter = R.color.info_color
                    val textColor = Color.WHITE
                    val text = TOAST_INFO
                    val layout = createColorToastLayout(context, message, font, iconDrawable, colorFilter, textColor, text)

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    val iconDrawable = R.drawable.ic_delete_
                    val colorFilter = R.color.delete_color
                    val textColor = Color.WHITE
                    val text = TOAST_DELETE
                    val layout = createColorToastLayout(context, message, font, iconDrawable, colorFilter, textColor, text)

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    val iconDrawable = R.drawable.ic_no_internet
                    val colorFilter = R.color.warning_color
                    val textColor = Color.WHITE
                    val text = TOAST_NO_INTERNET
                    val layout = createColorToastLayout(context, message, font, iconDrawable, colorFilter, textColor, text)

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
            }
        }

        // all dark toast CTA
        fun darkToast(context: Activity, message: String, style: String, position: Int, duration: Int, font: Typeface?) {
            when (style) {
                // Function for Toast Success
                TOAST_SUCCESS -> {

                    val iconDrawable = R.drawable.ic_check_green
                    val colorFilter = R.color.dark_bg_color
                    val textColor = ContextCompat.getColor(context, R.color.success_color)
                    val text = TOAST_SUCCESS
                    val layout = createColorToastLayout(context, message, font, iconDrawable, colorFilter, textColor, text)

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Error
                TOAST_ERROR -> {
                    val iconDrawable = R.drawable.ic_error_
                    val colorFilter = R.color.dark_bg_color
                    val textColor = ContextCompat.getColor(context, R.color.error_color)
                    val text = TOAST_ERROR
                    val layout = createColorToastLayout(context, message, font, iconDrawable, colorFilter, textColor, text)

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Warning
                TOAST_WARNING -> {
                    val iconDrawable = R.drawable.ic_warning_yellow
                    val colorFilter = R.color.dark_bg_color
                    val textColor = ContextCompat.getColor(context, R.color.warning_color)
                    val text = TOAST_WARNING
                    val layout = createColorToastLayout(context, message, font, iconDrawable, colorFilter, textColor, text)
                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    val iconDrawable = R.drawable.ic_info_blue
                    val colorFilter = R.color.dark_bg_color
                    val textColor = ContextCompat.getColor(context, R.color.info_color)
                    val text = TOAST_INFO
                    val layout = createColorToastLayout(context, message, font, iconDrawable, colorFilter, textColor, text)

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    val iconDrawable = R.drawable.ic_delete_
                    val colorFilter = R.color.dark_bg_color
                    val textColor = ContextCompat.getColor(context, R.color.delete_color)
                    val text = TOAST_DELETE
                    val layout = createColorToastLayout(context, message, font, iconDrawable, colorFilter, textColor, text)

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    val iconDrawable = R.drawable.ic_no_internet
                    val colorFilter = R.color.dark_bg_color
                    val textColor = ContextCompat.getColor(context, R.color.warning_color)
                    val text = TOAST_NO_INTERNET
                    val layout = createColorToastLayout(context, message, font, iconDrawable, colorFilter, textColor, text)

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)

                }


            }
        }

        // all toast CTA
        fun darkColorToast(context: Activity, message: String, style: String, position: Int, duration: Int, font: Typeface?) {
            when (style) {
                // Function for Toast Success
                TOAST_SUCCESS -> {
                    val iconDrawable = R.drawable.ic_check_green
                    val backgroundTint = R.color.success_color
                    val colorFilter = R.color.dark_bg_color
                    val descriptionTextColor = Color.WHITE
                    val textColor = ContextCompat.getColor(context, R.color.success_color)
                    val text = TOAST_SUCCESS
                    val layout = createCustomToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter, descriptionTextColor, textColor, text)

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Error
                TOAST_ERROR -> {
                    val iconDrawable = R.drawable.ic_error_
                    val backgroundTint = R.color.error_color
                    val colorFilter = R.color.dark_bg_color
                    val descriptionTextColor = Color.WHITE
                    val textColor = ContextCompat.getColor(context, R.color.error_color)
                    val text = TOAST_ERROR
                    val layout = createCustomToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter, descriptionTextColor, textColor, text)

                    val toast = Toast(context.applicationContext)

                    // Setting Toast Duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Warning
                TOAST_WARNING -> {
                    val iconDrawable = R.drawable.ic_warning_yellow
                    val backgroundTint = R.color.warning_color
                    val colorFilter = R.color.dark_bg_color
                    val descriptionTextColor = Color.WHITE
                    val textColor = ContextCompat.getColor(context, R.color.warning_color)
                    val text = TOAST_WARNING
                    val layout = createCustomToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter, descriptionTextColor, textColor, text)

                    val toast = Toast(context.applicationContext)

                    // Setting Toast Duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    val iconDrawable = R.drawable.ic_info_blue
                    val backgroundTint = R.color.info_color
                    val colorFilter = R.color.dark_bg_color
                    val descriptionTextColor = Color.WHITE
                    val textColor = ContextCompat.getColor(context, R.color.info_color)
                    val text = TOAST_INFO
                    val layout = createCustomToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter, descriptionTextColor, textColor, text)

                    val toast = Toast(context.applicationContext)

                    // Setting Toast Duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    val iconDrawable = R.drawable.ic_delete_
                    val backgroundTint = R.color.delete_color
                    val colorFilter = R.color.dark_bg_color
                    val descriptionTextColor = Color.WHITE
                    val textColor = ContextCompat.getColor(context, R.color.delete_color)
                    val text = TOAST_DELETE
                    val layout = createCustomToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter, descriptionTextColor, textColor, text)

                    val toast = Toast(context.applicationContext)
                    setDuration(duration, toast)

                    setToastGravity(position, toast, layout)

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    val iconDrawable = R.drawable.ic_no_internet
                    val backgroundTint = R.color.warning_color
                    val colorFilter = R.color.dark_bg_color
                    val descriptionTextColor = Color.WHITE
                    val textColor = ContextCompat.getColor(context, R.color.warning_color)
                    val text = TOAST_NO_INTERNET
                    val layout = createCustomToastLayout(context, message, font, iconDrawable, backgroundTint, colorFilter, descriptionTextColor, textColor, text)

                    val toast = Toast(context.applicationContext)
                    setDuration(duration, toast)

                    setToastGravity(position, toast, layout)
                }
            }
        }


        /**
         * Creating a Generic Color Toast Layout
         */
        private fun createColorToastLayout(context: Activity, message: String, font: Typeface?, iconDrawable: Int, colorFilter: Int, textColor: Int, text: String): View? {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(R.layout.full_color_toast, (context).findViewById(R.id.color_toast_view))

            layout.color_toast_image.setImageDrawable(ContextCompat.getDrawable(context, iconDrawable))

            // Pulse Animation for Icon
            val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
            layout.color_toast_image.startAnimation(pulseAnimation)

            // round background color
            val drawable = ContextCompat.getDrawable(context, R.drawable.toast_round_background)
            drawable?.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(context, colorFilter), PorterDuff.Mode.MULTIPLY)

            layout.background = drawable

            // Setting up the color for title & Message text
            layout.color_toast_text.setTextColor(textColor)
            layout.color_toast_text.text = text
            layout.color_toast_description.setTextColor(Color.WHITE)
            layout.color_toast_description.text = message

            // Setting typeface for the text
            font?.let {
                layout.color_toast_description.typeface = font
            }
            return layout
        }

        /**
         * Creating a Generic Toast Layout
         */
        private fun createToastLayout(context: Activity, message: String, font: Typeface?, iconDrawable: Int, backgroundTint: Int, colorFilter: Int): View? {
            layoutInflater = LayoutInflater.from(context)

            val layout = layoutInflater.inflate(R.layout.motion_toast, (context).findViewById(R.id.motion_toast_view))

            layout.custom_toast_image.setImageDrawable(ContextCompat.getDrawable(context, iconDrawable))

            val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)

            layout.custom_toast_image.startAnimation(pulseAnimation)

            layout.colorView.backgroundTintList = ContextCompat.getColorStateList(context, backgroundTint)

            val drawable = ContextCompat.getDrawable(context, R.drawable.toast_round_background)
            drawable?.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(context, colorFilter), PorterDuff.Mode.MULTIPLY)

            layout.background = drawable
            layout.custom_toast_description.setTextColor(Color.GRAY)
            layout.custom_toast_description.text = message
            font?.let {
                layout.custom_toast_description.typeface = font
            }
            return layout
        }

        /**
         * Creating a Generic Custom Toast Layout
         */
        private fun createCustomToastLayout(context: Activity, message: String, font: Typeface?, iconDrawable: Int, backgroundTint: Int, colorFilter: Int, descriptionTextColor: Int, textColor: Int, text: String): View? {
            layoutInflater = LayoutInflater.from(context)

            val layout = layoutInflater.inflate(R.layout.motion_toast, (context).findViewById(R.id.motion_toast_view))

            layout.custom_toast_image.setImageDrawable(ContextCompat.getDrawable(context, iconDrawable))

            val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)

            layout.custom_toast_image.startAnimation(pulseAnimation)

            layout.colorView.backgroundTintList = ContextCompat.getColorStateList(context, backgroundTint)

            val drawable = ContextCompat.getDrawable(context, R.drawable.toast_round_background)
            drawable?.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(context, colorFilter), PorterDuff.Mode.MULTIPLY)

            layout.background = drawable
            layout.custom_toast_description.setTextColor(descriptionTextColor)
            layout.custom_toast_description.text = message
            layout.custom_toast_text.setTextColor(textColor)
            layout.custom_toast_text.text = text
            font?.let {
                layout.custom_toast_description.typeface = font
            }
            return layout
        }

        /**
         * Setting the Toast's Gravity.
         * @position -> Where the Toast will be displayed.
         * @toast -> Current toast,
         * @layout -> Custom Layout used on the toast.
         */
        private fun setToastGravity(position: Int, toast: Toast, layout: View?, duration: Long = 0) {
            if (position == GRAVITY_BOTTOM) {
                toast.setGravity(position, 0, 100)
            } else {
                toast.setGravity(position, 0, 0)
            }

            // Setting layout to toast
            toast.view = layout
            if (duration != 0L) {
                layout?.animate()?.alpha(0f)?.duration = duration
            }
            toast.show()
        }

        /**
         * Setting The Toast's Duration.
         * @duration -> Time that the toast should stay visible.
         * @toast -> Current toast.
         */
        private fun setDuration(duration: Int, toast: Toast) {
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
        }
    }
}