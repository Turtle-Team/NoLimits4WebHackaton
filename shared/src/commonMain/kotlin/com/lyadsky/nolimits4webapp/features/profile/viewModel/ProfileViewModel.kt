package com.lyadsky.nolimits4webapp.features.profile.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.user_data.User
import com.lyadsky.nolimits4webapp.common.user_data.UserDataManager
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.StatefulKmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import com.lyadsky.nolimits4webapp.data.AppDatabaseRepostitory
import com.lyadsky.nolimits4webapp.data.TaskStats
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.koin.core.component.KoinComponent

interface ProfileViewModel : StatefulKmpViewModel<TaskStats?>, SubScreenViewModel {
    fun onSettingsClick()

    fun getUser(): User
}

class ProfileViewModelImpl(
    override val navigator: Navigator,
    private val userDataManager: UserDataManager,
    dao: AppDatabaseRepostitory
) : KoinComponent, KmpViewModelImpl(), ProfileViewModel {


    override val state: StateFlow<TaskStats?> = dao.getStatsAsFlow().stateIn(scope, SharingStarted.Lazily, TaskStats.empty())


    override fun onSettingsClick() {
        navigator.navigateToSettings()
    }

    override fun getUser(): User = userDataManager.getUserData()

}


