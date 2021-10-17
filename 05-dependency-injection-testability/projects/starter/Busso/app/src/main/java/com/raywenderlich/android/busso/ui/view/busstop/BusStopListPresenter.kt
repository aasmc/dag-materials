package com.raywenderlich.android.busso.ui.view.busstop

import android.view.View
import com.raywenderlich.android.ui.mvp.Presenter

interface BusStopListPresenter : Presenter<View, BusStopListViewBinder>,
    BusStopListViewBinder.BusStopItemSelectedListener {

        fun start()

        fun stop()
}