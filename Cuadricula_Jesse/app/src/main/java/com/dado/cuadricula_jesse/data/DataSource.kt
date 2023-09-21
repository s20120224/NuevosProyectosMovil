package com.dado.cuadricula_jesse.data
import com.dado.cuadricula_jesse.R
import com.dado.cuadricula_jesse.model.Topic

class DataSource() {
    fun loadTopics(): List<Topic>{
        return listOf<Topic>(
            Topic(R.string.architecture, R.drawable.architecture),
            Topic(R.string.crafts, R.drawable.crafts),
            Topic(R.string.business, R.drawable.business),
            Topic(R.string.culinary, R.drawable.culinary),
            Topic(R.string.design, R.drawable.design),
            Topic(R.string.fashion, R.drawable.fashion),
            Topic(R.string.film, R.drawable.film),
            Topic(R.string.gaming, R.drawable.gaming),
            Topic(R.string.drawing, R.drawable.drawing),
            Topic(R.string.lifestyle,  R.drawable.lifestyle),
            Topic(R.string.music,  R.drawable.music),
            Topic(R.string.painting,  R.drawable.painting),
            Topic(R.string.photography,  R.drawable.photography),
            Topic(R.string.tech, R.drawable.tech))
    }
}
