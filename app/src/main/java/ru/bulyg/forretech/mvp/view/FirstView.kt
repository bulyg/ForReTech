package ru.bulyg.forretech.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface FirstView : MvpView {
    fun loadPicture(url: String)
    fun showAlertDialog()
}