package ru.bulyg.forretech.mvp.view.item

interface SecondItemView {
    var pos: Int
    fun setFact(text: String)
    fun setDate(date: String)
}