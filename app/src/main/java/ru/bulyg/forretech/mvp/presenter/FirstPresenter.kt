package ru.bulyg.forretech.mvp.presenter

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.bulyg.forretech.mvp.model.repository.ApiRepository
import ru.bulyg.forretech.mvp.model.exception.NoInternetException
import ru.bulyg.forretech.mvp.view.FirstView
import javax.inject.Inject

@InjectViewState
class FirstPresenter : MvpPresenter<FirstView>() {
    @Inject
    lateinit var repository: ApiRepository

    fun loadPicture() {
        repository.getPicture().observeOn(AndroidSchedulers.mainThread()).subscribe({
            viewState.loadPicture(it)
        }, {
            if (it is NoInternetException) {
                viewState.showAlertDialog()
            }
        })
    }
}