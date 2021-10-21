package com.raywenderlich.android.raysequence.presenter

import android.util.Log
import com.raywenderlich.android.raysequence.model.SequenceGenerator
import com.raywenderlich.android.raysequence.view.SequenceViewBinder
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class CycledSequencePresenter @Inject constructor(
    private val viewBinder: Provider<SequenceViewBinder>
) : SequencePresenter {

    @Inject
    lateinit var sequenceModel: SequenceGenerator<Int>
    override fun displayNextValue() {
        val binder = viewBinder.get()
        Log.d("DAGGER_LOG", "Binder: $binder")
        binder.showNextValue(sequenceModel.next())
    }

    override fun bind(viewBinder: SequenceViewBinder) {
    }

    override fun unbind() {
    }

    override fun onNextValuePressed() {
        displayNextValue()
    }
}