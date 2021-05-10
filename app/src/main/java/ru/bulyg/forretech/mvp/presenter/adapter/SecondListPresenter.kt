package ru.bulyg.forretech.mvp.presenter.adapter

import ru.bulyg.forretech.mvp.view.item.SecondItemView

interface SecondListPresenter {
    fun getCount(): Int
    fun bindView(view: SecondItemView)
}