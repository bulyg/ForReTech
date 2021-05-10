package ru.bulyg.forretech.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun loadImage(path: String, container: ImageView?) {
    container?.let {
        Glide.with(it.context)
            .load(path)
            .into(container)
    }
}