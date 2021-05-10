package ru.bulyg.forretech.ui.activity

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.bulyg.forretech.App
import ru.bulyg.forretech.R
import ru.bulyg.forretech.mvp.presenter.MainPresenter
import ru.bulyg.forretech.mvp.view.EventListener
import ru.bulyg.forretech.mvp.view.MainView
import ru.bulyg.forretech.ui.fragment.FirstFragment
import ru.bulyg.forretech.ui.fragment.SecondFragment


class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = MainPresenter().apply {
        App.instance.appComponent.inject(this)
    }

    lateinit var eventListener: EventListener

    private val frg1 = FirstFragment()
    private val frg2 = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.instance.appComponent.inject(this)
    }

    fun setListener(eventListener: EventListener) {
        this.eventListener = eventListener
    }

    override fun init() {
        initToolbar()
        initContainers()
        initRefreshBtn()
    }

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar_main)
        val toolbarTitle = findViewById<TextView>(R.id.tv_toolbar_title)
        setSupportActionBar(toolbar)
        toolbarTitle.text = toolbar.title
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun initContainers() {
        supportFragmentManager.beginTransaction().replace(R.id.fc_first, frg1).commit()
        supportFragmentManager.beginTransaction().replace(R.id.fc_second, frg2).commit()
    }

    private fun initRefreshBtn() {
        val refreshBtn = findViewById<ImageButton>(R.id.btn_toolbar_refresh)
        refreshBtn.setOnClickListener {
            setListener(frg1)
            eventListener.refreshEvent()
            setListener(frg2)
            eventListener.refreshEvent()
        }
    }
}