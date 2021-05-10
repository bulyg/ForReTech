package ru.bulyg.forretech.mvp.model.datasource

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url
import ru.bulyg.forretech.mvp.model.entity.ResponsePictures
import ru.bulyg.forretech.mvp.model.entity.ResponseInfo

interface MyDataSource {
    @GET
    fun getPicture(@Url url: String): Single<ResponsePictures>

    @GET
    fun getFact(@Url url: String): Single<ResponseInfo>
}