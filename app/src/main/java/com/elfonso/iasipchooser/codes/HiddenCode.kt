package com.elfonso.iasipchooser.codes

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity


class HiddenCode (private var codeString: String, var associatedActivity: Class<out Activity>) {
    var length = codeString.length

    fun matchesEntry(entryString: String) : Boolean {
        if (entryString == this.codeString) {
            return true
        }
        return false
    }
}