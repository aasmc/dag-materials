package com.raywenderlich.android.raysequence.di

import com.raywenderlich.android.raysequence.presenter.SequencePresenter
import com.raywenderlich.android.raysequence.presenter.SequencePresenterImpl
import com.raywenderlich.android.raysequence.view.SequenceViewBinder
import com.raywenderlich.android.raysequence.view.SequenceViewBinderImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindings {
    @Binds
    fun bindSequenceViewBinder(impl: SequenceViewBinderImpl): SequenceViewBinder

    @Binds
    fun bindSequencePresenter(impl: SequencePresenterImpl): SequencePresenter

    @Binds
    fun bindViewBinderListener(impl: SequencePresenter):
            SequenceViewBinder.Listener
}