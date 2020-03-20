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

        fun warningToast(context: Activity, message: String, position: Int, duration:Int,font: Typeface?) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(R.layout.motion_toast, (context).findViewById(R.id.motion_toast_view))
            layout.custom_toast_image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_warning_yellow))

            val pulseAnimation = AnimationUtils.loadAnimation(context,R.anim.pulse)
            layout.custom_toast_image.startAnimation(pulseAnimation)
            layout.colorView.backgroundTintList = ContextCompat.getColorStateList(context, R.color.warning_color)

            val drawable = ContextCompat.getDrawable(context, R.drawable.toast_round_background)
            drawable?.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(context, R.color.warning_bg_color), PorterDuff.Mode.MULTIPLY)

            layout.background = drawable
            layout.custom_toast_description.setTextColor(Color.GRAY)
            layout.custom_toast_description.text = message
            font?.let {
                layout.custom_toast_description.typeface = font
            }
            val toast = Toast(context.applicationContext)
            setDuration(duration, toast)

            setToastGravity(position, toast, layout)
        }

        fun errorToast(context: Activity, message: String, position: Int, duration: Int,font: Typeface?) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.motion_toast,
                (context).findViewById(R.id.motion_toast_view)
            )
            layout.custom_toast_image.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_error_
                )
            )
            val pulseAnimation = AnimationUtils.loadAnimation(context,R.anim.pulse)
            layout.custom_toast_image.startAnimation(pulseAnimation)
            layout.colorView.backgroundTintList = ContextCompat.getColorStateList(context, R.color.error_color)

            val drawable = ContextCompat.getDrawable(context, R.drawable.toast_round_background)
            drawable?.colorFilter = PorterDuffColorFilter(
                ContextCompat.getColor(context, R.color.error_bg_color),
                PorterDuff.Mode.MULTIPLY
            )
            layout.background = drawable
            layout.custom_toast_text.setTextColor(Color.BLACK)
            layout.custom_toast_text.text = "Failed"
            layout.custom_toast_description.setTextColor(Color.GRAY)
            layout.custom_toast_description.text = message
            font?.let {
                layout.custom_toast_description.typeface = font
            }
            val toast = Toast(context.applicationContext)

            setDuration(duration, toast)

            setToastGravity(position, toast, layout)
        }
        fun successToast(context: Activity, message: String, position: Int, duration: Int,font: Typeface?) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(R.layout.motion_toast, (context).findViewById(R.id.motion_toast_view))
            layout.custom_toast_image.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_check_green
                )
            )
            val pulseAnimation = AnimationUtils.loadAnimation(context,R.anim.pulse)
            layout.custom_toast_image.startAnimation(pulseAnimation)

            layout.colorView.backgroundTintList = ContextCompat.getColorStateList(context, R.color.success_color)

            val drawable = ContextCompat.getDrawable(context, R.drawable.toast_round_background)
            drawable?.colorFilter = PorterDuffColorFilter(
                ContextCompat.getColor(context, R.color.success_bg_color),
                PorterDuff.Mode.MULTIPLY
            )
            layout.background = drawable
            layout.custom_toast_text.setTextColor(Color.BLACK)
            layout.custom_toast_text.text = "Success"
            layout.custom_toast_description.setTextColor(Color.GRAY)
            layout.custom_toast_description.text = message
            font?.let {
                layout.custom_toast_description.typeface = font
            }
            val toast = Toast(context.applicationContext)
            setDuration(duration, toast)

            setToastGravity(position, toast, layout)
        }
        fun infoToast(context: Activity, message: String, position: Int, duration: Int,font: Typeface?) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.motion_toast,
                (context).findViewById(R.id.motion_toast_view)
            )
            layout.custom_toast_image.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_info_blue
                )
            )
            val pulseAnimation = AnimationUtils.loadAnimation(context,R.anim.pulse)
            layout.custom_toast_image.startAnimation(pulseAnimation)

            layout.colorView.backgroundTintList = ContextCompat.getColorStateList(context, R.color.info_color)

            val drawable = ContextCompat.getDrawable(context, R.drawable.toast_round_background)
            drawable?.colorFilter = PorterDuffColorFilter(
                ContextCompat.getColor(context, R.color.info_bg_color),
                PorterDuff.Mode.MULTIPLY
            )
            layout.background = drawable
            layout.custom_toast_text.setTextColor(Color.BLACK)
            layout.custom_toast_text.text = "Info"
            layout.custom_toast_description.setTextColor(Color.GRAY)
            layout.custom_toast_description.text = message
            font?.let {
                layout.custom_toast_description.typeface = font
            }
            val toast = Toast(context.applicationContext)
            setDuration(duration, toast)

            setToastGravity(position, toast, layout)
        }
        fun deleteToast(context: Activity,message: String, style:String, position: Int, duration: Int,font: Typeface?) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.motion_toast,
                (context).findViewById(R.id.motion_toast_view)
            )

            if (style == TOAST_INFO){
                layout.custom_toast_image.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_info_blue
                    )
                )
                val pulseAnimation = AnimationUtils.loadAnimation(context,R.anim.pulse)
                layout.custom_toast_image.startAnimation(pulseAnimation)

                layout.colorView.backgroundTintList = ContextCompat.getColorStateList(context, R.color.info_color)

                val drawable = ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                drawable?.colorFilter = PorterDuffColorFilter(
                    ContextCompat.getColor(context, R.color.info_bg_color),
                    PorterDuff.Mode.MULTIPLY
                )
                layout.background = drawable
                layout.custom_toast_text.setTextColor(Color.BLACK)
                layout.custom_toast_text.text = "Info"
                layout.custom_toast_description.setTextColor(Color.GRAY)
                layout.custom_toast_description.text = message
                font?.let {
                    layout.custom_toast_description.typeface = font
                }
                val toast = Toast(context.applicationContext)
                setDuration(duration, toast)

                setToastGravity(position, toast, layout)
            } else {
                layout.custom_toast_image.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_delete_
                    )
                )


                val pulseAnimation = AnimationUtils.loadAnimation(context,R.anim.pulse)
                layout.custom_toast_image.startAnimation(pulseAnimation)
                layout.colorView.backgroundTintList = ContextCompat.getColorStateList(context, R.color.delete_color)


                val drawable = ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                drawable?.colorFilter = PorterDuffColorFilter(
                    ContextCompat.getColor(context, R.color.delete_bg_color),
                    PorterDuff.Mode.MULTIPLY
                )
                layout.background = drawable
                layout.custom_toast_text.setTextColor(Color.BLACK)
                layout.custom_toast_text.text = "Delete"
                layout.custom_toast_description.setTextColor(Color.GRAY)
                layout.custom_toast_description.text = message
                font?.let {
                    layout.custom_toast_description.typeface = font
                }
                val toast = Toast(context.applicationContext)
                setDuration(duration, toast)

                if (position == GRAVITY_BOTTOM) {
                    toast.setGravity(position, 0, 100)
                } else {
                    toast.setGravity(position, 0, 0)
                }
                toast.view = layout//setting the view of custom toast layout
                layout.animate().alpha(0f).duration = 3000
                toast.show()

            }

        }

        // all toast CTA
        fun createToast(context: Activity,message: String, style:String, position: Int, duration: Int,font: Typeface?) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.motion_toast,
                (context).findViewById(R.id.motion_toast_view)
            )
            when(style){
                // Function for Toast Success
                TOAST_SUCCESS ->{
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_check_green
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context,R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)

                    // Background tint color for side view
                    layout.colorView.backgroundTintList = ContextCompat.getColorStateList(context, R.color.success_color)

                    // round background color
                    val drawable = ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.success_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.custom_toast_text.setTextColor(ContextCompat.getColor(context, R.color.success_color))
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
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Error
                TOAST_ERROR ->{
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context,R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList = ContextCompat.getColorStateList(context, R.color.error_color)

                    val drawable = ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.error_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(ContextCompat.getColor(context, R.color.error_color))
                    layout.custom_toast_text.text = TOAST_ERROR
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    setDuration(duration, toast)

                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Warning
                TOAST_WARNING ->{
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context,R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.warning_color)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.warning_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.warning_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_WARNING
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    setDuration(duration, toast)

                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)

                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.info_color)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.info_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.info_color
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
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
                    )


                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.delete_color)


                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.delete_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.delete_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_DELETE
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    setDuration(duration, toast)

                    setToastGravity(position, toast, layout)

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
                    )


                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.warning_color)


                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.warning_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.warning_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_NO_INTERNET
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    setDuration(duration, toast)

                    setToastGravity(position, toast, layout)
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

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.success_color),
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
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Error
                TOAST_ERROR -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.error_color),
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
                    setDuration(duration, toast)


                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Warning
                TOAST_WARNING -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.warning_color),
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
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.info_color),
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
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
                    )


                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.delete_color),
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
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.warning_color),
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
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
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
                            R.color.success_color
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
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Error
                TOAST_ERROR -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
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
                            R.color.error_color
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
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Warning
                TOAST_WARNING -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
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
                            R.color.warning_color
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
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
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
                            R.color.info_color
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
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
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
                            R.color.delete_color
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
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
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
                            R.color.warning_color
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
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)

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

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)

                    // Background tint color for side view
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.success_color)

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
                            R.color.success_color
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
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Error
                TOAST_ERROR -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.error_color)

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
                            R.color.error_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_ERROR
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)

                    // Setting Toast Duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Warning
                TOAST_WARNING -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.warning_color)

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
                            R.color.warning_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_WARNING
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)

                    // Setting Toast Duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)

                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.info_color)

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
                            R.color.info_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_INFO
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)

                    // Setting Toast Duration
                    setDuration(duration, toast)

                    // Setting Toast Gravity
                    setToastGravity(position, toast, layout)
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
                    )


                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.delete_color)


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
                            R.color.delete_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_DELETE
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    setDuration(duration, toast)

                    setToastGravity(position, toast, layout)

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
                    )


                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.warning_color)


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
                            R.color.warning_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_NO_INTERNET
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    setDuration(duration, toast)

                    setToastGravity(position, toast, layout)
                }
            }
        }

        /**
         * Setting the Toast's Gravity.
         * @position -> Where the Toast will be displayed.
         * @toast -> Current toast,
         * @layout -> Custom Layout used on the toast.
         */
        private fun setToastGravity(position: Int, toast: Toast, layout: View?) {
            if (position == GRAVITY_BOTTOM) {
                toast.setGravity(position, 0, 100)
            } else {
                toast.setGravity(position, 0, 0)
            }

            // Setting layout to toast
            toast.view = layout
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