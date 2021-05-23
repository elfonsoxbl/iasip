package com.elfonso.iasipchooser.picker

import android.content.Context

class Picker (context : Context){
    var seasons = Seasons(context).seasons

    fun pickEpisode() : Seasons.Season {
        return seasons.random()
    }
}