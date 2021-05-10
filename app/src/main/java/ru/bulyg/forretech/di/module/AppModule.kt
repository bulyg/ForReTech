package ru.bulyg.forretech.di.module

import dagger.Module
import dagger.Provides
import ru.bulyg.forretech.App

@Module
class AppModule(val app: App) {
    @Provides
    fun app(): App {
        return app
    }
}