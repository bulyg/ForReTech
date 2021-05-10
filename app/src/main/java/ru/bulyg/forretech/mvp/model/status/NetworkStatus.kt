package ru.bulyg.forretech.mvp.model.status

import io.reactivex.rxjava3.core.Single

interface NetworkStatus {
    fun isOnlineSingle(): Single<Boolean>
}