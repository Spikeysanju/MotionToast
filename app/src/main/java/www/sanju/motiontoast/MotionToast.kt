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
import kotlinx.android.synthetic.main.motion_toast.view.*

class MotionToast {
    companion object {
        val GRAVITY_TOP = 48
        val GRAVITY_CENTER = 17
        val GRAVITY_BOTTOM = 80

        val LONG_DURATION = 4000
        val SHORT_DURATION = 2000
        val TOAST_SUCCESS = "SUCCESS"
        val TOAST_ERROR = "FAILED"
        val TOAST_WARNING = "WARNING"
        val TOAST_INFO = "INFO"
        val TOAST_DELETE = "DELETE"

        private lateinit var layoutInflater: LayoutInflater

        fun warningToast(context: Activity, message: String, position: Int, duration:Int,font: Typeface?) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.motion_toast,
                (context).findViewById(R.id.custom_toast_layout)
            )
            layout.custom_toast_image.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_warning_yellow
                )
            )
            val pulseAnimation = AnimationUtils.loadAnimation(context,R.anim.pulse)
            layout.custom_toast_image.startAnimation(pulseAnimation)
            layout.colorView.backgroundTintList = ContextCompat.getColorStateList(context, R.color.warning_color)

            val drawable = ContextCompat.getDrawable(context, R.drawable.toast_round_background)
            drawable?.colorFilter = PorterDuffColorFilter(
                ContextCompat.getColor(context, R.color.warning_bg_color),
                PorterDuff.Mode.MULTIPLY
            )

            layout.background = drawable
            layout.custom_toast_description.setTextColor(Color.GRAY)
            layout.custom_toast_description.text = message
            font?.let {
                layout.custom_toast_description.typeface = font
            }
            val toast = Toast(context.applicationContext)
            when (duration) {
                LONG_DURATION -> {
                    val timer = object: CountDownTimer(5000, 1000) {
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
                    val timer = object: CountDownTimer(3000, 1000) {
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
                    val timer = object: CountDownTimer(2000, 1000) {
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
        fun errorToast(context: Activity, message: String, position: Int, duration: Int,font: Typeface?) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.motion_toast,
                (context).findViewById(R.id.custom_toast_layout)
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

            when (duration) {
                LONG_DURATION -> {
                    val timer = object: CountDownTimer(5000, 1000) {
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
                    val timer = object: CountDownTimer(3000, 1000) {
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
                    val timer = object: CountDownTimer(2000, 1000) {
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
        fun successToast(context: Activity, message: String, position: Int, duration: Int,font: Typeface?) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.motion_toast,
                (context).findViewById(R.id.custom_toast_layout)
            )
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
            when (duration) {
                LONG_DURATION -> {
                    val timer = object: CountDownTimer(5000, 1000) {
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
                    val timer = object: CountDownTimer(3000, 1000) {
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
                    val timer = object: CountDownTimer(2000, 1000) {
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
        fun infoToast(context: Activity, message: String, position: Int, duration: Int,font: Typeface?) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.motion_toast,
                (context).findViewById(R.id.custom_toast_layout)
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
            when (duration) {
                LONG_DURATION -> {
                    val timer = object: CountDownTimer(5000, 1000) {
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
                    val timer = object: CountDownTimer(3000, 1000) {
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
                    val timer = object: CountDownTimer(2000, 1000) {
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
        fun deleteToast(context: Activity,message: String, style:String, position: Int, duration: Int,font: Typeface?) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.motion_toast,
                (context).findViewById(R.id.custom_toast_layout)
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
                when (duration) {
                    LONG_DURATION -> {
                        val timer = object: CountDownTimer(5000, 1000) {
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
                        val timer = object: CountDownTimer(3000, 1000) {
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
                        val timer = object: CountDownTimer(2000, 1000) {
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
            } else{
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
                when (duration) {
                    LONG_DURATION -> {
                        val timer = object: CountDownTimer(5000, 1000) {
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
                        val timer = object: CountDownTimer(3000, 1000) {
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
                        val timer = object: CountDownTimer(2000, 1000) {
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
                layout.animate().alpha(0f).duration = 3000
                toast.show()

            }

        }


        // all toast CTA
        fun createToast(context: Activity,message: String, style:String, position: Int, duration: Int,font: Typeface?) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.motion_toast,
                (context).findViewById(R.id.custom_toast_layout)
            )
            when(style){
                TOAST_SUCCESS ->{
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
                    layout.custom_toast_text.setTextColor(ContextCompat.getColor(context, R.color.success_color))
                    layout.custom_toast_text.text = TOAST_SUCCESS
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    when (duration) {
                        LONG_DURATION -> {
                            val timer = object: CountDownTimer(5000, 1000) {
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
                            val timer = object: CountDownTimer(3000, 1000) {
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
                            val timer = object: CountDownTimer(2000, 1000) {
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

                    when (duration) {
                        LONG_DURATION -> {
                            val timer = object: CountDownTimer(5000, 1000) {
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
                            val timer = object: CountDownTimer(3000, 1000) {
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
                            val timer = object: CountDownTimer(2000, 1000) {
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
                TOAST_WARNING ->{
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context,R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList = ContextCompat.getColorStateList(context, R.color.warning_color)

                    val drawable = ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.warning_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(ContextCompat.getColor(context, R.color.warning_color))
                    layout.custom_toast_text.text = TOAST_WARNING
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    when (duration) {
                        LONG_DURATION -> {
                            val timer = object: CountDownTimer(5000, 1000) {
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
                            val timer = object: CountDownTimer(3000, 1000) {
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
                            val timer = object: CountDownTimer(2000, 1000) {
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
                TOAST_INFO ->{
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
                    layout.custom_toast_text.setTextColor(ContextCompat.getColor(context, R.color.info_color))
                    layout.custom_toast_text.text = TOAST_INFO
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    when (duration) {
                        LONG_DURATION -> {
                            val timer = object: CountDownTimer(5000, 1000) {
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
                            val timer = object: CountDownTimer(3000, 1000) {
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
                            val timer = object: CountDownTimer(2000, 1000) {
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
                TOAST_DELETE ->{
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
                    layout.custom_toast_text.setTextColor(ContextCompat.getColor(context, R.color.delete_color))
                    layout.custom_toast_text.text = TOAST_DELETE
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    when (duration) {
                        LONG_DURATION -> {
                            val timer = object: CountDownTimer(5000, 1000) {
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
                            val timer = object: CountDownTimer(3000, 1000) {
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
                            val timer = object: CountDownTimer(2000, 1000) {
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
//                    layout.animate().alpha(0f).duration = 3000
                    toast.show()

                }

            }

        }


    }
}