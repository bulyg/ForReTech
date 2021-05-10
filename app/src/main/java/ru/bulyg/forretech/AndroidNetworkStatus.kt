package ru.bulyg.forretech

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject
import ru.bulyg.forretech.mvp.model.status.NetworkStatus
import java.util.concurrent.TimeUnit

class AndroidNetworkStatus(context: Context) : NetworkStatus {

    companion object {
        const val NETWORK_CHECK_TIMEOUT_MILLIS = 500L
    }

    private var statusSubject = BehaviorSubject.create<Boolean>()

    init {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val builder = NetworkRequest.Builder()
        connectivityManager.registerNetworkCallback(
            builder.build(),
            object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    statusSubject.onNext(true)
                }

                override fun onLost(network: Network) {
                    statusSubject.onNext(false)
                }
            })
    }

    override fun isOnlineSingle(): Single<Boolean> =
        statusSubject.timeout(NETWORK_CHECK_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .onErrorReturnItem(false).first(false)

}