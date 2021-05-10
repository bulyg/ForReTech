package ru.bulyg.forretech

import android.app.Application
import ru.bulyg.forretech.di.AppComponent
import ru.bulyg.forretech.di.DaggerAppComponent
import ru.bulyg.forretech.di.module.AppModule

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)
    }
}