package com.lyadsky.nolimits4webapp.features.register.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import com.lyadsky.nolimits4webapp.features.register.state.RegisterState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

interface RegisterViewModel : KmpViewModel, SubScreenViewModel {

    val state: StateFlow<RegisterState>

    fun onNextClick()

    fun onBackAction()

    fun onAgeChanged(age: Int)

    fun onNameChanged(name: String)

    fun onInterestingChanged(list: List<String>)

    fun onPasswordChanged(password: String)

    fun onEmailChanged(email: String)
}

class RegisterViewModelImpl(
    override val navigator: Navigator
) : KoinComponent, KmpViewModelImpl(), RegisterViewModel {
    private val _state = MutableStateFlow(RegisterState())
    override val state: StateFlow<RegisterState> = _state.asStateFlow()

    override fun onNextClick() {
        if (_state.value.stage < 3)
            _state.update { it.copy(stage = _state.value.stage + 1) }
        else {
            navigator.navigateToMain()
            //TODO навигация на главную или куда то ещё и сохранение всех данных о пользователе
        }
    }

    override fun onBackAction() {
        if (_state.value.stage > 1)
            _state.update { it.copy(stage = _state.value.stage - 1) }
        else
            navigator.navigateBack()
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

