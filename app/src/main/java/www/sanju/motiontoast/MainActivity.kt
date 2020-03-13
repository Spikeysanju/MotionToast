package www.sanju.motiontoast

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() , View.OnClickListener {

    private val name :String = "Spikey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        successBtn.setOnClickListener(this)
        errorBtn.setOnClickListener(this)
        warningBtn.setOnClickListener(this)
        infoBtn.setOnClickListener(this)
        deleteBtn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.successBtn -> {
                MotionToast.createToast(this,"Profile Completed!",
                MotionToast.TOAST_SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(this,R.font.helvetica_regular))

            }
            R.id.errorBtn -> {
                MotionToast.createToast(this,"Profile Update Failed!",
                    MotionToast.TOAST_ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))         }
            R.id.warningBtn ->{

                MotionToast.createToast(this,"Please Fill All The Details!",
                    MotionToast.TOAST_WARNING,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))
            }
            R.id.infoBtn ->{

                MotionToast.createToast(this,name + " " + "Have Earned 30 Loyalty Points!",
                    MotionToast.TOAST_INFO,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))
            }
            R.id.deleteBtn ->{
                MotionToast.createToast(this,"Profile Deleted!",
                    MotionToast.TOAST_DELETE,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))
            }
            else -> {
                MotionToast.infoToast(this, "You have no buttons!",
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.SHORT_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))
            }
        }

    }
}
