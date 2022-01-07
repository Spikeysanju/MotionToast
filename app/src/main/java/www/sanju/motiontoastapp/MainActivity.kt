package www.sanju.motiontoastapp

import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle
import www.sanju.motiontoastapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener,
    CompoundButton.OnCheckedChangeListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.switchCustomColors.setOnCheckedChangeListener(this)
        binding.successBtn.setOnClickListener(this)
        binding.errorBtn.setOnClickListener(this)
        binding.warningBtn.setOnClickListener(this)
        binding.infoBtn.setOnClickListener(this)
        binding.deleteBtn.setOnClickListener(this)
        binding.noInternetBtn.setOnClickListener(this)

        binding.successBtn.setOnLongClickListener(this)
        binding.errorBtn.setOnLongClickListener(this)
        binding.warningBtn.setOnLongClickListener(this)
        binding.infoBtn.setOnLongClickListener(this)
        binding.deleteBtn.setOnLongClickListener(this)
        binding.noInternetBtn.setOnLongClickListener(this)
    }

    private fun setToastColors(newColorsEnabled: Boolean) {
        if (newColorsEnabled) {
            MotionToast.setSuccessColor(R.color.custom_success_color)
            MotionToast.setErrorColor(R.color.custom_error_color)
            MotionToast.setDeleteColor(R.color.custom_delete_color)
            MotionToast.setWarningColor(R.color.custom_warning_color)
            MotionToast.setInfoColor(R.color.custom_info_color)
            MotionToast.setSuccessBackgroundColor(R.color.success_bg_color)
            MotionToast.setErrorBackgroundColor(R.color.error_bg_color)
            MotionToast.setDeleteBackgroundColor(R.color.delete_bg_color)
            MotionToast.setWarningBackgroundColor(R.color.warning_bg_color)
            MotionToast.setInfoBackgroundColor(R.color.info_bg_color)
        } else {
            MotionToast.resetToastColors()
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.successBtn -> {
                MotionToast.createToast(
                    this,
                    "Profile saved",
                    "Lorem Ipsum is simply dummy this is very simple text Lorem Ipsum is simply dummy this is very simple text Lorem Ipsum is simply dummy this is very simple text",
                    MotionToastStyle.SUCCESS,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.montserrat_regular)
                )
            }
            R.id.errorBtn -> {
                MotionToast.createToast(
                    this,
                    "Profile failed",
                    "Profile Update Failed due to this reason",
                    MotionToastStyle.ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            R.id.warningBtn -> {

                MotionToast.createToast(
                    this,
                    "",
                    "Please Fill All The Details!",
                    MotionToastStyle.WARNING,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            R.id.infoBtn -> {
                MotionToast.createColorToast(
                    this,
                    "",
                    "Color Toast testing here!",
                    MotionToastStyle.INFO,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            R.id.deleteBtn -> {
                MotionToast.createToast(
                    this, "Profile Deleted!",
                    "Your profile has been deleted!",
                    MotionToastStyle.DELETE,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            R.id.noInternetBtn -> {
                MotionToast.createToast(
                    this, "Please turn on internet connection!",
                    "",
                    MotionToastStyle.NO_INTERNET,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
        }

    }

    override fun onLongClick(v: View?): Boolean {
        when (v!!.id) {
            R.id.successBtn -> {
                MotionToast.createColorToast(
                    this,
                    "Post create 😍",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    MotionToastStyle.SUCCESS,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.montserrat_regular)
                )
            }
            R.id.errorBtn -> {
                MotionToast.darkToast(
                    this,
                    "",
                    "Profile Update Failed!",
                    MotionToastStyle.ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            R.id.warningBtn -> {

                MotionToast.darkColorToast(
                    this,
                    "",
                    "Please Fill All The Details!",
                    MotionToastStyle.WARNING,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            R.id.infoBtn -> {

                MotionToast.darkToast(
                    this,
                    "",
                    "Dark ui testing here!",
                    MotionToastStyle.INFO,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            R.id.deleteBtn -> {
                MotionToast.darkToast(
                    this,
                    "",
                    "Profile Deleted!",
                    MotionToastStyle.DELETE,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            R.id.noInternetBtn -> {
                MotionToast.darkToast(
                    this,
                    "",
                    "Please turn on internet connection!",
                    MotionToastStyle.NO_INTERNET,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
        }

        return true
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        setToastColors(isChecked)
    }
}
