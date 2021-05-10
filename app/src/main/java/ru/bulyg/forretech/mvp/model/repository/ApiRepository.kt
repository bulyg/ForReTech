package ru.bulyg.forretech.mvp.model.repository

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.bulyg.forretech.mvp.model.Fact
import ru.bulyg.forretech.mvp.model.datasource.MyDataSource
import ru.bulyg.forretech.mvp.model.status.NetworkStatus
import ru.bulyg.forretech.mvp.model.exception.NoInternetException
import ru.bulyg.forretech.utils.mapToFact

class ApiRepository(val myDataSource: MyDataSource, val networkStatus: NetworkStatus) {
    fun getPicture(): Single<String> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                myDataSource.getPicture("https://aws.random.cat/meow").flatMap {
                    Single.just(it.file)
                }
            } else
                Single.error(NoInternetException())
        }.subscribeOn(Schedulers.io())

    fun getFact(): Single<Fact> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                myDataSource.getFact("https://cat-fact.herokuapp.com/facts/random").flatMap {
                    val fact = mapToFact(it)
                    Single.just(fact)
                }
            } else
                Single.error(NoInternetException())
        }.subscribeOn(Schedulers.io())
}