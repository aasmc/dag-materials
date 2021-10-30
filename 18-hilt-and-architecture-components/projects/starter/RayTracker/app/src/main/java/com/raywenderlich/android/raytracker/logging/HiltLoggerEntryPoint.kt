package com.raywenderlich.android.raytracker.logging

import com.raywenderlich.android.raytracker.di.custom.TrackRunningComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

@EntryPoint
@InstallIn(TrackRunningComponent::class)
interface HiltLoggerEntryPoint {

    fun logger(): HiltLogger

}