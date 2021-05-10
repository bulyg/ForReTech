package ru.bulyg.forretech.di

import dagger.Component
import ru.bulyg.forretech.App
import ru.bulyg.forretech.di.module.ApiModule
import ru.bulyg.forretech.di.module.AppModule
import ru.bulyg.forretech.di.module.RepositoryModule
import ru.bulyg.forretech.mvp.presenter.FirstPresenter
import ru.bulyg.forretech.mvp.presenter.MainPresenter
import ru.bulyg.forretech.mvp.presenter.SecondPresenter
import ru.bulyg.forretech.ui.activity.MainActivity
import ru.bulyg.forretech.ui.fragment.FirstFragment
import ru.bulyg.forretech.ui.fragment.SecondFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {
    fun inject(app: App)
    fun inject(activity: MainActivity)
    fun inject(presenter: MainPresenter)
    fun inject(fragment: FirstFragment)
    fun inject(presenter: FirstPresenter)
    fun inject(fragment: SecondFragment)
    fun inject(presenter: SecondPresenter)
}