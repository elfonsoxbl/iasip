package com.elfonso.iasipchooser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.elfonso.iasipchooser.activities.ListActivity
import com.elfonso.iasipchooser.codes.CodeTracker
import com.elfonso.iasipchooser.codes.HiddenCode
import com.elfonso.iasipchooser.picker.Picker
import com.elfonso.iasipchooser.picker.Seasons

class MainActivity : AppCompatActivity() {
    private lateinit var picker : Picker
    private lateinit var seasonButton : Button
    private lateinit var episodeButton : Button
    private lateinit var hiddenCode : HiddenCode
    private lateinit var seasonChosen : Seasons.Season
    private var codeAccepted = false

    private val codeTracker = CodeTracker(
        mutableListOf<HiddenCode>(
            HiddenCode("0101", ListActivity::class.java)
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.picker = Picker(this)
        this.seasonButton = findViewById<Button>(R.id.button_season)
        this.episodeButton = findViewById<Button>(R.id.button_episode)
        this.seasonChosen = picker.pickEpisode()
    }

    fun pickEpisode(view: View) {
        if (this.codeAccepted) {
            this.showActivity(this.hiddenCode)
        } else {
            this.showRandomEpisode()
        }
    }

    fun codeEntry0(view: View) {
        this.codeEntry("0")
        println("Entered 0")
    }

    fun codeEntry1(view: View) {
        this.codeEntry("1")
        println("Entered 1")
    }

    private fun codeEntry(codeNum : String) {
        val codeIndex = codeTracker.enterCode(codeNum)
        if (codeIndex != -1) {
            this.hiddenCode = codeTracker.getHiddenCode(codeIndex)
            this.codeAccepted = true
        }
    }

    private fun showRandomEpisode() {
        this.seasonChosen = picker.pickEpisode()
        this.showEpisode()
    }

    private fun showEpisode() {
        this.seasonButton.text = this.seasonChosen.getTitleString()
        this.seasonButton.setBackgroundColor(this.seasonChosen.color)
        this.episodeButton.text = this.seasonChosen.getEpisodeString()
        this.episodeButton.setBackgroundColor(this.seasonChosen.color)
        this.codeTracker.resetCodeEntry()
        this.codeAccepted = false
    }

    private fun showActivity(acceptedCode : HiddenCode) {
        val intent = Intent(this, acceptedCode.associatedActivity)
        startActivity(intent)
        this.showEpisode()
    }
}