package ru.bulyg.forretech.di.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.bulyg.forretech.AndroidNetworkStatus
import ru.bulyg.forretech.App
import ru.bulyg.forretech.mvp.model.datasource.MyDataSource
import ru.bulyg.forretech.mvp.model.status.NetworkStatus
import ru.bulyg.forretech.utils.BASE_URL
import javax.inject.Singleton

@Module
class ApiModule {
    @Singleton
    @Provides
    fun api(gson: Gson): MyDataSource {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()
            .create(MyDataSource::class.java)
    }

    @Provides
    fun gson(): Gson {
        return GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Provides
    fun networkStatus(app: App): NetworkStatus {
        return AndroidNetworkStatus(app)
    }
}