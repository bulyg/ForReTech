package ru.bulyg.forretech.ui.fragment

import android.app.AlertDialog
import android.widget.ImageView
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.bulyg.forretech.App
import ru.bulyg.forretech.R
import ru.bulyg.forretech.mvp.presenter.FirstPresenter
import ru.bulyg.forretech.mvp.view.EventListener
import ru.bulyg.forretech.mvp.view.FirstView
import ru.bulyg.forretech.utils.loadImage

class FirstFragment : MvpAppCompatFragment(R.layout.fragment_first), FirstView, EventListener {
    @InjectPresenter
    lateinit var presenter: FirstPresenter

    @ProvidePresenter
    fun providePresenter() = FirstPresenter().apply {
        App.instance.appComponent.inject(this)
    }

    override fun loadPicture(url: String) {
        val imageView = view?.findViewById<ImageView>(R.id.iv_first)
        loadImage(url, imageView)
    }

    override fun showAlertDialog() {
        showDialog()
    }

    override fun refreshEvent() {
        presenter.loadPicture()
    }

    private fun showDialog() {
        AlertDialog.Builder(context)
            .setTitle(R.string.error)
            .setMessage(R.string.msg)
            .setCancelable(false)
            .setPositiveButton(R.string.ok) { _, _ ->
            }.show()
    }
}
