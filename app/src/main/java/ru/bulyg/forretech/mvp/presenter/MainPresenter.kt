package ru.bulyg.forretech.mvp.presenter

import moxy.InjectViewState
import moxy.MvpPresenter
import ru.bulyg.forretech.mvp.view.MainView

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }
}