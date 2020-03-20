package www.sanju.motiontoast

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.successBtn -> {
                MotionToast.createToast(this,"Profile Completed!",
                TOAST_SUCCESS,
                GRAVITY_BOTTOM,
                LONG_DURATION,
                ResourcesCompat.getFont(this,R.font.helvetica_regular))

            }
            R.id.errorBtn -> {
                MotionToast.createToast(this,"Profile Update Failed!",
                    TOAST_ERROR,
                    GRAVITY_BOTTOM,
                    LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))         }
            R.id.warningBtn ->{

                MotionToast.createToast(this,"Please Fill All The Details!",
                    TOAST_WARNING,
                    GRAVITY_BOTTOM,
                    LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))
            }
            R.id.infoBtn ->{

                MotionToast.createToast(
                    this, "Dark ui testing here!",
                    TOAST_INFO,
                    GRAVITY_BOTTOM,
                    LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))
            }
            R.id.deleteBtn ->{
                MotionToast.createToast(this,"Profile Deleted!",
                    TOAST_DELETE,
                    GRAVITY_BOTTOM,
                    LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))
            }
            R.id.noInternetBtn -> {
                MotionToast.createToast(
                    this, "Please turn on internet connection!",
                    TOAST_NO_INTERNET,
                    GRAVITY_BOTTOM,
                    LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            else -> {
                MotionToast.infoToast(this, "You have no buttons!",
                    GRAVITY_BOTTOM,
                    SHORT_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))
            }
        }

    }

    override fun onLongClick(v: View?): Boolean {

        when (v!!.id) {
            R.id.successBtn -> {
                MotionToast.darkToast(
                    this, "Profile Completed!",
                    TOAST_SUCCESS,
                    GRAVITY_BOTTOM,
                    LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            R.id.errorBtn -> {
                MotionToast.darkToast(
                    this, "Profile Update Failed!",
                    TOAST_ERROR,
                    GRAVITY_BOTTOM,
                    LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            R.id.warningBtn -> {

                MotionToast.darkToast(
                    this, "Please Fill All The Details!",
                    TOAST_WARNING,
                    GRAVITY_BOTTOM,
                    LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            R.id.infoBtn -> {

                MotionToast.darkToast(
                    this, "Dark ui testing here!",
                    TOAST_INFO,
                    GRAVITY_BOTTOM,
                    LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            R.id.deleteBtn -> {
                MotionToast.darkToast(
                    this, "Profile Deleted!",
                    TOAST_DELETE,
                    GRAVITY_BOTTOM,
                    LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            R.id.noInternetBtn -> {
                MotionToast.darkToast(
                    this, "Please turn on internet connection!",
                    TOAST_NO_INTERNET,
                    GRAVITY_BOTTOM,
                    LONG_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
            else -> {
                MotionToast.infoToast(
                    this, "You have no buttons!",
                    GRAVITY_BOTTOM,
                    SHORT_DURATION,
                    ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }
        }

        return true
    }
}
