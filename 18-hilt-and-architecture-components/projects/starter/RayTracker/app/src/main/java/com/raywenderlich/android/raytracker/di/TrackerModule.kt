/*
 * Copyright (c) 2020 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.raytracker.di

import com.raywenderlich.android.location.FlowLocationConfiguration
import com.raywenderlich.android.location.di.FlowLocationModule
import com.raywenderlich.android.raytracker.conf.RayTrackFlowLocationConfig
import com.raywenderlich.android.raytracker.service.Tracker
import com.raywenderlich.android.raytracker.service.TrackerImpl
import com.raywenderlich.android.raytracker.state.TrackerStateManager
import com.raywenderlich.android.raytracker.state.TrackerStateManagerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.components.SingletonComponent

interface TrackerModule {

  @Module(
      includes = [FlowLocationModule::class]
  )
  @InstallIn(ServiceComponent::class)
  interface ServiceBindings {
    @Binds
    fun bindTracker(
        impl: TrackerImpl
    ): Tracker
  }

  @Module
  @InstallIn(ServiceComponent::class)
  object ServiceModule {
    @Provides
    fun provideFlowLocationConfiguration(): FlowLocationConfiguration =
        RayTrackFlowLocationConfig
  }

  @Module
  @InstallIn(SingletonComponent::class)
  interface ApplicationBindings {
    @Binds
    fun bindTrackerStateManager(
        impl: TrackerStateManagerImpl
    ): TrackerStateManager
  }
}