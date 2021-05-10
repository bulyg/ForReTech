package ru.bulyg.forretech.ui.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.bulyg.forretech.App
import ru.bulyg.forretech.R
import ru.bulyg.forretech.mvp.presenter.SecondPresenter
import ru.bulyg.forretech.mvp.view.EventListener
import ru.bulyg.forretech.mvp.view.SecondView
import ru.bulyg.forretech.ui.adapter.SecondRVAdapter

class SecondFragment : MvpAppCompatFragment(R.layout.fragment_second), SecondView, EventListener {
    @InjectPresenter
    lateinit var presenter: SecondPresenter

    @ProvidePresenter
    fun providePresenter() = SecondPresenter().apply {
        App.instance.appComponent.inject(this)
    }

    private var adapter: SecondRVAdapter? = null

    override fun init() {
        initRecyclerView()
    }

    override fun updateRecyclerView() {
        adapter?.notifyDataSetChanged()
    }

    private fun initRecyclerView() {
        val rv = view?.findViewById<RecyclerView>(R.id.rv_second)
        adapter = SecondRVAdapter(presenter.listPresenter)
        rv?.adapter = adapter
        rv?.layoutManager = LinearLayoutManager(context)
    }

    override fun refreshEvent() {
        presenter.loadFact()
    }
}