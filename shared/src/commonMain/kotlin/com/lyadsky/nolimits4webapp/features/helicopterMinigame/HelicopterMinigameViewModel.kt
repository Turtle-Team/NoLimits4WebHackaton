package com.lyadsky.nolimits4webapp.features.helicopterMinigame

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.StatefulKmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent
import kotlin.random.Random

data class MinigameState(
    val score: Int = 0,
    val firstExp: Pair<String, Int> = Pair("", 0),
    val secondExp: Pair<String, Int> = Pair("", 0),
    val thirdExp: Pair<String, Int> = Pair("", 0),
    val answer: Int = 0,
    val record: Int = 0
)

interface HelicopterMinigameViewModel : StatefulKmpViewModel<MinigameState>, SubScreenViewModel {

    fun onAddScore()

    fun navigateBack()

    fun onCloudClick(num: Int)
}

class HelicopterMinigameViewModelImpl(
    override val navigator: Navigator
) : KoinComponent,
    KmpViewModelImpl(), HelicopterMinigameViewModel {

    private val _state = MutableStateFlow(MinigameState())
    override val state: StateFlow<MinigameState>
        get() = _state.asStateFlow()

    init {

        val rand = (1..3).random()
        _state.update { stat ->
            stat.copy(
                firstExp = getExpressionWith(stat.record),
                secondExp = getExpressionWith(stat.record),
                thirdExp = getExpressionWith(stat.record),
            )
        }
        _state.update { it.copy(
            answer = when (rand) {
                1 -> it.firstExp.second
                2 -> it.secondExp.second
                3 -> it.thirdExp.second
                else -> it.thirdExp.second
            },
        ) }
    }

    override fun onAddScore() {
        _state.update { it.copy(score = it.score + 1) }
    }

    override fun navigateBack() {
        navigator.navigateBack()
    }

    override fun onCloudClick(num: Int) {
        if (num == _state.value.answer) {
            val rand = (1..3).random()
            _state.update { stat ->
                stat.copy(
                    firstExp = getExpressionWith(stat.record),
                    secondExp = getExpressionWith(stat.record),
                    thirdExp = getExpressionWith(stat.record),
                    record = if (stat.score > stat.record) stat.score else stat.record,
                    score = stat.score + 1
                )
            }
            _state.update { it.copy(
                answer = when (rand) {
                    1 -> it.firstExp.second
                    2 -> it.secondExp.second
                    3 -> it.thirdExp.second
                    else -> it.thirdExp.second
                },
            ) }
        } else {
            val rand = (1..3).random()
            _state.update { stat ->
                stat.copy(
                    firstExp = getExpressionWith(stat.record),
                    secondExp = getExpressionWith(stat.record),
                    thirdExp = getExpressionWith(stat.record),
                    score = if (stat.score>0){ stat.score - 1 } else{stat.score}
                )
            }
            _state.update { it.copy(
                answer = when (rand) {
                    1 -> it.firstExp.second
                    2 -> it.secondExp.second
                    3 -> it.thirdExp.second
                    else -> it.thirdExp.second
                },
            ) }
        }
    }
}

fun getExpressionWith(mmultiplier: Int): Pair<String, Int> {

    val multiplier = if (mmultiplier < 10) 10 else mmultiplier

    val to = (10 * (multiplier.toFloat() / 15F)).toInt()

    val string = StringBuilder()
    val randomInt = (1..to)
    val num1 = randomInt.random()
    val num2 = randomInt.random()

    val answ = if (Random.nextBoolean()) {
        string.append("$num1 + $num2")
        Pair(string.toString(), num1 + num2)
    }else{
        string.append("$num1 - $num2")
        Pair(string.toString(), num1 - num2)
    }

    return answ
}