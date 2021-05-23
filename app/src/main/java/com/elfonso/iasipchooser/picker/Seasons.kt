package com.elfonso.iasipchooser.picker

import android.content.Context
import androidx.core.content.ContextCompat

import com.elfonso.iasipchooser.R

class Seasons (var context : Context) {
    var seasons = ArrayList<Season>()

    class Season (var number : Int, var episodes : Int, colorId : Int, context : Context) {
        var color = ContextCompat.getColor(context, colorId)

        fun getEpisodeString() : String {
            val chosenEpisode = (1..this.episodes+1).random()
            return "Episode $chosenEpisode"
        }

        fun getTitleString() : String {
            val number = this.number
            return "Season $number"
        }
    }

    init {
        this.seasons.add(Season(1, 7, R.color.season1, this.context))
        this.seasons.add(Season(2, 10, R.color.season2, this.context))
        this.seasons.add(Season(3, 15, R.color.season3, this.context))
        this.seasons.add(Season(4, 13, R.color.season4, this.context))
        this.seasons.add(Season(5, 12, R.color.season5, this.context))
        this.seasons.add(Season(6, 14, R.color.season6, this.context))
        this.seasons.add(Season(7, 13, R.color.season7, this.context))
        this.seasons.add(Season(8, 10, R.color.season8, this.context))
        this.seasons.add(Season(9, 10, R.color.season9, this.context))
        this.seasons.add(Season(10, 10, R.color.season10, this.context))
        this.seasons.add(Season(11, 10, R.color.season11, this.context))
        this.seasons.add(Season(12, 10, R.color.season12, this.context))
        this.seasons.add(Season(13, 10, R.color.season13, this.context))
        this.seasons.add(Season(14, 10, R.color.season14, this.context))
    }
}
