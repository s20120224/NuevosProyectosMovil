package com.dado.cuadricula_jesse.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val name: Int,
    @DrawableRes val imageRes: Int
)