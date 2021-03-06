package com.elfonso.iasipchooser.activities

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

import com.elfonso.iasipchooser.R
import com.elfonso.iasipchooser.utils.ButtonFactory

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val buttonFactory = ButtonFactory(this)
        val res: Resources = resources
        val planetButtons = buttonFactory.createButtons(res.getStringArray(R.array.planet_list))
        val layout = findViewById<LinearLayout>(R.id.linear_layout)
        for (planet_button in planetButtons) {
            layout.addView(planet_button)
        }
    }
}