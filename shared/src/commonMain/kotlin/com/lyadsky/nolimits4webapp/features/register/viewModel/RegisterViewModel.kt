package com.lyadsky.nolimits4webapp.features.register.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.user_data.User
import com.lyadsky.nolimits4webapp.common.user_data.UserDataManager
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import com.lyadsky.nolimits4webapp.data.AppDatabaseRepostitory
import com.lyadsky.nolimits4webapp.features.register.state.RegisterState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

interface RegisterViewModel : KmpViewModel, SubScreenViewModel {

    val state: StateFlow<RegisterState>

    fun onNextClick()

    fun onBackAction()

    fun onGenderChanged(isMale: Boolean)

    fun onAgeChanged(age: Int)

    fun onNameChanged(name: String)

    fun onInterestingChanged(list: List<String>)

    fun onPasswordChanged(password: String)

    fun onEmailChanged(email: String)
}

class RegisterViewModelImpl(
    override val navigator: Navigator,
    private val userDataManager: AppDatabaseRepostitory
) : KoinComponent, KmpViewModelImpl(), RegisterViewModel {
    private val _state = MutableStateFlow(RegisterState())
    override val state: StateFlow<RegisterState> = _state.asStateFlow()

    override fun onNextClick() {
        if (_state.value.stage < 3) {
            _state.update { it.copy(stage = _state.value.stage + 1) }
        }
        else {
            scope.launch {
                _state.value.apply {
                    userDataManager.saveUser(User(name,age,isMale?: true, 0))
                }
            }
            navigator.register()
        }
    }

    override fun onBackAction() {
        if (_state.value.stage > 1)
            _state.update { it.copy(stage = _state.value.stage - 1) }
        else
            navigator.navigateBack()
    }

    override fun onGenderChanged(isMale: Boolean) {
        _state.update { it.copy(isMale = isMale) }
    }

    override fun onAgeChanged(age: Int) {
        _state.update { it.copy(age = age) }
    }

    override fun onNameChanged(name: String) {
        _state.update { it.copy(name = name) }
    }

    override fun onInterestingChanged(list: List<String>) {
        _state.update { it.copy(interesting = list) }
    }

    override fun onPasswordChanged(password: String) {
        _state.update { it.copy(password = password) }
    }

    override fun onEmailChanged(email: String) {
        _state.update { it.copy(email = email) }
    }
}

