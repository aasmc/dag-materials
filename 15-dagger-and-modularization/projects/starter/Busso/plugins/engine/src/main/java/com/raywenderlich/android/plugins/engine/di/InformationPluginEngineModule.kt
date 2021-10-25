package com.raywenderlich.android.plugins.engine.di

import com.raywenderlich.android.di.scopes.ApplicationScope
import com.raywenderlich.android.plugins.api.ComplexInfoKey
import com.raywenderlich.android.plugins.api.InformationPluginRegistry
import com.raywenderlich.android.plugins.api.InformationPluginSpec
import com.raywenderlich.android.plugins.engine.impl.InformationPluginRegistryImpl
import com.raywenderlich.android.plugins.engine.ui.InformationPluginPresenter
import com.raywenderlich.android.plugins.engine.ui.InformationPluginPresenterImpl
import com.raywenderlich.android.plugins.engine.ui.InformationPluginViewBinder
import com.raywenderlich.android.plugins.engine.ui.InformationPluginViewBinderImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object InformationPluginEngineModule {

    @Provides
    @ApplicationScope
    fun provideInformationPluginRegistry(
        retrofit: Retrofit,
        informationPlugins: @JvmSuppressWildcards Map<ComplexInfoKey, InformationPluginSpec>
    ): InformationPluginRegistry =
        InformationPluginRegistryImpl(retrofit, informationPlugins)

    @Module
    interface FragmentBindings {
        @Binds
        fun bindInformationPluginPresenter(
            impl: InformationPluginPresenterImpl
        ): InformationPluginPresenter

        @Binds
        fun bindInformationPluginViewBinder(
            impl: InformationPluginViewBinderImpl
        ): InformationPluginViewBinder
    }
}