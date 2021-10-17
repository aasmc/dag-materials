package com.raywenderlich.android.busso.ui.view.busstop

import android.view.View
import androidx.core.os.bundleOf
import com.raywenderlich.android.busso.R
import com.raywenderlich.android.busso.network.BussoEndpoint
import com.raywenderlich.android.busso.ui.view.busarrival.BusArrivalFragment
import com.raywenderlich.android.busso.ui.view.busarrival.BusArrivalFragment.Companion.BUS_STOP_ID
import com.raywenderlich.android.location.api.model.*
import com.raywenderlich.android.ui.mvp.impl.BasePresenter
import com.raywenderlich.android.ui.navigation.FragmentFactoryDestination
import com.raywenderlich.android.ui.navigation.Navigator
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class BusStopListPresenterImpl(
    private val navigator: Navigator,
    private val locationObservable: Observable<LocationEvent>,
    private val bussoEndpoint: BussoEndpoint
) : BasePresenter<View, BusStopListViewBinder>(),
    BusStopListPresenter {
    private val disposables = CompositeDisposable()

    override fun start() {
        disposables.add(
            locationObservable
                .filter(::isLocationEvent)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::handleLocationEvent, ::handleError)
        )
    }

    private fun handleLocationEvent(locationEvent: LocationEvent) {
        when (locationEvent) {
            is LocationNotAvailable -> useViewBinder { displayErrorMessage("Location not available") }
            is LocationData -> useLocation(locationEvent.location)
        }
    }

    private fun useLocation(location: GeoLocation) {
        disposables.add(
            bussoEndpoint
                .findBusStopByLocation(location.latitude, location.longitude, 500)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(::mapBusStop)
                .subscribe(::displayBusStopList, ::handleError)
        )
    }

    private fun displayBusStopList(busStopList: List<BusStopViewModel>) {
        useViewBinder {
            displayBusStopList(busStopList)
        }
    }

    private fun handleError(throwable: Throwable) {
        useViewBinder {
            displayErrorMessage("Error: ${throwable.message}")
        }
    }

    override fun stop() {
        disposables.clear()
    }

    private fun isLocationEvent(locationEvent: LocationEvent): Boolean {
        return locationEvent !is LocationPermissionRequest && locationEvent !is LocationPermissionGranted
    }

    override fun onBusStopSelected(busStopViewModel: BusStopViewModel) {
        navigator.navigateTo(
            FragmentFactoryDestination(
                fragmentFactory = {bundle ->
                    BusArrivalFragment().apply {
                        arguments = bundle
                    }
                },
                anchorId = R.id.anchor_point,
                withBackStack = "BusArrival",
                bundle = bundleOf(
                    BUS_STOP_ID to busStopViewModel.stopId
                )
            )
        )
    }

    override fun retry() {
        start()
    }
}