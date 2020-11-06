package www.sanju.motiontoast

import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener,
    CompoundButton.OnCheckedChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switch_custom_colors?.setOnCheckedChangeListener(this)
        successBtn.setOnClickListener(this)
        errorBtn.setOnClickListener(this)
        warningBtn.setOnClickListener(this)
        infoBtn.setOnClickListener(this)
        deleteBtn.setOnClickListener(this)
        noInternetBtn.setOnClickListener(this)

        successBtn.setOnLongClickListener(this)
        errorBtn.setOnLongClickListener(this)
        warningBtn.setOnLongClickListener(this)
        infoBtn.setOnLongClickListener(this)
        deleteBtn.setOnLongClickListener(this)
        noInternetBtn.setOnLongClickListener(this)
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
                    "Lorem Ipsum is simply dummy this is very simple text",
                    MotionToast.TOAST_SUCCESS,
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
                    MotionToast.TOAST_ERROR,
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
                    MotionToast.TOAST_WARNING,
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
                    MotionToast.TOAST_INFO,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            R.id.deleteBtn -> {
                MotionToast.createToast(
                    this, "Profile Deleted!",
                    "",
                    MotionToast.TOAST_DELETE,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            R.id.noInternetBtn -> {
                MotionToast.createToast(
                    this, "Please turn on internet connection!",
                    "",
                    MotionToast.TOAST_NO_INTERNET,
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
                    "",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    MotionToast.TOAST_SUCCESS,
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
                    MotionToast.TOAST_ERROR,
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
                    MotionToast.TOAST_WARNING,
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
                    MotionToast.TOAST_INFO,
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
                    MotionToast.TOAST_DELETE,
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
                    MotionToast.TOAST_NO_INTERNET,
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
