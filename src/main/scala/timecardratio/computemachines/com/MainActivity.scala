package timecardratio.computemachines.com

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.graphics.drawable.Animatable
import android.util.Log.{e=>error, v=>log}

class MainActivity extends AppCompatActivity {
    // allows accessing `.value` on TR.resource.constants
    implicit val context = this

    override def onCreate(savedInstanceState: Bundle): Unit = {
        super.onCreate(savedInstanceState)
        // type ascription is required due to SCL-10491
        val vh: TypedViewHolder.main = TypedViewHolder.setContentView(this, TR.layout.main)
        vh.text.setText(s"Hello worlds, from ${TR.string.app_name.value}")
        vh.image.getDrawable match {
          case a: Animatable => {
            a.start()
            log("com.computemachines.timecardratio", "a is animatable")
          }
          case _ => error("com.computemachines.timecardratio", "MainActivity#onCreate: getDrawable not Animatable")
        }
    }
}
