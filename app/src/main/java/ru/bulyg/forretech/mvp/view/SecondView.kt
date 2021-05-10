package ru.bulyg.forretech.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface SecondView : MvpView {
    fun init()
    fun updateRecyclerView()
}