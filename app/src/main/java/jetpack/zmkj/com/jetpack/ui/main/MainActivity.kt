package jetpack.zmkj.com.jetpack.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import jetpack.zmkj.com.jetpack.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }

    }

}