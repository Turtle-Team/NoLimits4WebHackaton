package com.lyadsky.nolimits4webapp.android.di

import com.lyadsky.nolimits4webapp.android.navigation.AndroidNavigator
import com.lyadsky.nolimits4webapp.android.navigation.NavigatorImpl
import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.features.mainNavigation.viewModel.MainNavigationViewModelImpl
import com.lyadsky.nolimits4webapp.features.register.viewModel.RegisterViewModel
import com.lyadsky.nolimits4webapp.features.register.viewModel.RegisterViewModelImpl
import com.lyadsky.nolimits4webapp.features.welcome.viewModel.WelcomeViewModel
import com.lyadsky.nolimits4webapp.features.welcome.viewModel.WelcomeViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun androidModule() = module {
    single<AndroidNavigator> { NavigatorImpl() }
    single<Navigator> { get<AndroidNavigator>() }

    viewModel(named("MainNavigationViewModel")) {
        ViewModelWrapper(MainNavigationViewModelImpl(get()))
    }

    viewModel(named("WelcomeViewModel")) {
        ViewModelWrapper<WelcomeViewModel>(WelcomeViewModelImpl(get()))
    }

    viewModel(named("RegisterViewModel")) {
        ViewModelWrapper<RegisterViewModel>(RegisterViewModelImpl(get()))
    }
}
