package com.raywenderlich.android.raysequence.di

import com.raywenderlich.android.raysequence.presenter.CycledSequencePresenter
import com.raywenderlich.android.raysequence.presenter.SequencePresenter
import com.raywenderlich.android.raysequence.presenter.SequencePresenterImpl
import com.raywenderlich.android.raysequence.view.SequenceViewBinder
import com.raywenderlich.android.raysequence.view.SequenceViewBinderImpl
import dagger.Binds
import dagger.Module

@Module
abstract class AppBindings {
    @Binds
    abstract fun bindSequenceViewBinder(impl: SequenceViewBinderImpl): SequenceViewBinder

    @Binds
    abstract fun bindSequencePresenter(impl: CycledSequencePresenter): SequencePresenter

    @Binds
    abstract fun bindViewBinderListener(impl: SequencePresenter):
            SequenceViewBinder.Listener
}