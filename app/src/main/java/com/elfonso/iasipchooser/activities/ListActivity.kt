package com.elfonso.iasipchooser.activities

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout

import com.elfonso.iasipchooser.R
import com.elfonso.iasipchooser.utils.ButtonFactory

class ListActivity() : AppCompatActivity() {
    /* TODO: Make argument that passes R.array."string" and creates the buttons
    *   Add argument to buttons that takes a string of the item in the R.array."string" and attach
    *   the PhotoviewActivity to it.*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val buttonFactory = ButtonFactory(this)
        val res: Resources = resources
        val planetButtons = buttonFactory.createButtons(res.getStringArray(R.array.planet_list))
        val layout = findViewById<LinearLayout>(R.id.list_linear_layout)
        layout.gravity = Gravity.CENTER_HORIZONTAL
        for (planet_button in planetButtons) {
            layout.addView(planet_button)
        }
    }
}