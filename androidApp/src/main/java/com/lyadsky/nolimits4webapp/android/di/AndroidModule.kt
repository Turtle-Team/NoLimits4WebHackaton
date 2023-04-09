package com.lyadsky.nolimits4webapp.android.di

import com.lyadsky.nolimits4webapp.android.navigation.AndroidNavigator
import com.lyadsky.nolimits4webapp.android.navigation.NavigatorImpl
import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.features.catalog.viewModel.CatalogViewModel
import com.lyadsky.nolimits4webapp.features.catalog.viewModel.CatalogViewModelImpl
import com.lyadsky.nolimits4webapp.features.finish.viewModel.FinishViewModel
import com.lyadsky.nolimits4webapp.features.finish.viewModel.FinishViewModelImpl
import com.lyadsky.nolimits4webapp.features.helicopterMinigame.HelicopterMinigameViewModel
import com.lyadsky.nolimits4webapp.features.helicopterMinigame.HelicopterMinigameViewModelImpl
import com.lyadsky.nolimits4webapp.features.main.viewModel.MainViewModel
import com.lyadsky.nolimits4webapp.features.main.viewModel.MainViewModelImpl
import com.lyadsky.nolimits4webapp.features.mainNavigation.viewModel.MainNavigationViewModelImpl
import com.lyadsky.nolimits4webapp.features.profile.viewModel.ProfileViewModel
import com.lyadsky.nolimits4webapp.features.profile.viewModel.ProfileViewModelImpl
import com.lyadsky.nolimits4webapp.features.register.viewModel.RegisterViewModel
import com.lyadsky.nolimits4webapp.features.register.viewModel.RegisterViewModelImpl
import com.lyadsky.nolimits4webapp.features.settings.viewModel.SettingsViewModel
import com.lyadsky.nolimits4webapp.features.settings.viewModel.SettingsViewModelImpl
import com.lyadsky.nolimits4webapp.features.tasks.viewModel.TaskViewModel
import com.lyadsky.nolimits4webapp.features.tasks.viewModel.TaskViewModelImpl
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
        ViewModelWrapper<RegisterViewModel>(RegisterViewModelImpl(get(), get()))
    }

    viewModel(named("HelicopterViewModel")) {
        ViewModelWrapper<HelicopterMinigameViewModel>(HelicopterMinigameViewModelImpl(get()))
    }

    viewModel(named("MainViewModel")) {
        ViewModelWrapper<MainViewModel>(MainViewModelImpl(get()))
    }

    viewModel(named("ProfileViewModel")) {
        ViewModelWrapper<ProfileViewModel>(ProfileViewModelImpl(get(), get(), get()))
    }

    viewModel(named("SettingsViewModel")) {
        ViewModelWrapper<SettingsViewModel>(SettingsViewModelImpl(get(), get()))
    }

    viewModel(named("CatalogViewModel")) {
        ViewModelWrapper<CatalogViewModel>(CatalogViewModelImpl(get()))
    }

    viewModel(named("TaskViewModel")) {
        ViewModelWrapper<TaskViewModel>(TaskViewModelImpl(get(),get()))
    }

    viewModel(named("FinishViewModel")) {
        ViewModelWrapper<FinishViewModel>(FinishViewModelImpl(get()))
    }
}
