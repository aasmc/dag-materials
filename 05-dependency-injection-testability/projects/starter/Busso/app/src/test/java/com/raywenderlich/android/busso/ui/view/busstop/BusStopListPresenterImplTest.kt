package com.raywenderlich.android.busso.ui.view.busstop

import android.os.Build
import com.raywenderlich.android.busso.network.BussoEndpoint
import com.raywenderlich.android.location.api.model.LocationEvent
import com.raywenderlich.android.location.api.model.LocationNotAvailable
import com.raywenderlich.android.ui.navigation.Navigator
import io.reactivex.subjects.PublishSubject
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.*

@RunWith(RobolectricTestRunner::class)
@Config(sdk=[Build.VERSION_CODES.P])
class BusStopListPresenterImplTest {
    lateinit var presenter: BusStopListPresenter
    lateinit var navigator: Navigator
    lateinit var locationObservable: PublishSubject<LocationEvent>
    lateinit var bussoEndpoint: BussoEndpoint
    lateinit var busStopListViewBinder: BusStopListViewBinder

    @Before
    fun setup() {
        navigator = mock(Navigator::class.java)
        locationObservable = PublishSubject.create()
        bussoEndpoint = mock(BussoEndpoint::class.java)
        busStopListViewBinder = mock(BusStopListViewBinder::class.java)
        presenter = BusStopListPresenterImpl(
            navigator,
            locationObservable,
            bussoEndpoint
        )
        presenter.bind(busStopListViewBinder)
    }

    @Test
    fun startWhenLocationNotAvailable_displayErrorMessageInvoked() {
        presenter.start()
        locationObservable.onNext(LocationNotAvailable("Provider"))
        verify(busStopListViewBinder).displayErrorMessage("Location not available")
    }
}

















