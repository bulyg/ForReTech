package ru.bulyg.forretech.mvp.presenter

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.bulyg.forretech.mvp.model.repository.ApiRepository
import ru.bulyg.forretech.mvp.model.Fact
import ru.bulyg.forretech.mvp.presenter.adapter.SecondListPresenter
import ru.bulyg.forretech.mvp.view.SecondView
import ru.bulyg.forretech.mvp.view.item.SecondItemView
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@InjectViewState
class SecondPresenter : MvpPresenter<SecondView>() {
    @Inject
    lateinit var repository: ApiRepository

    var listPresenter = ListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun loadFact() {
        repository.getFact().observeOn(AndroidSchedulers.mainThread()).subscribe({
            listPresenter.list.add(it)
            viewState.updateRecyclerView()
        }, {

        })
    }

    inner class ListPresenter : SecondListPresenter {
        var list = mutableListOf<Fact>()
        val df = SimpleDateFormat("dd.MM.yyyy' 'HH:mm", Locale.getDefault())

        override fun getCount() = list.size

        override fun bindView(view: SecondItemView) {
            view.setFact(list[view.pos].fact)
            val date = df.format(list[view.pos].date)
            view.setDate(date)
        }
    }
}