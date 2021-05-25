package com.elfonso.iasipchooser.utils

import android.app.ActionBar
import android.content.Context
import android.widget.Button
import android.widget.LinearLayout
import kotlin.random.Random

import com.elfonso.iasipchooser.R

class ButtonFactory (private var context : Context){
    fun createButtons(names : Array<String>) : ArrayList<Button>{
        val buttonList = ArrayList<Button>()
        for (buttonName in names) {
            val newButton = Button(this.context)
            newButton.text = buttonName
            newButton.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT
            )
            newButton.layoutParams.width = context.resources.getDimensionPixelSize(
                R.dimen.dimen_button)
            newButton.id = Random.nextInt()
            buttonList.add(newButton)
        }
        return buttonList
    }
}