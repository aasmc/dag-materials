package com.raywenderlich.android.busso.ui.view.busstop

import android.view.View
import com.raywenderlich.android.ui.mvp.ViewBinder

interface BusStopListViewBinder : ViewBinder<View> {

    fun displayBusStopList(busStopList: List<BusStopViewModel>)

    fun displayErrorMessage(msg: String)

    interface BusStopItemSelectedListener {

        fun onBusStopSelected(busStopViewModel: BusStopViewModel)

        fun retry()
    }
}