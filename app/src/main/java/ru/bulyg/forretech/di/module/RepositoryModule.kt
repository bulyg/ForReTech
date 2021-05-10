package ru.bulyg.forretech.di.module

import dagger.Module
import dagger.Provides
import ru.bulyg.forretech.mvp.model.repository.ApiRepository
import ru.bulyg.forretech.mvp.model.datasource.MyDataSource
import ru.bulyg.forretech.mvp.model.status.NetworkStatus
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun providesRepository(
        dataSource: MyDataSource, networkStatus: NetworkStatus
    ): ApiRepository {
        return ApiRepository(dataSource, networkStatus)
    }
}