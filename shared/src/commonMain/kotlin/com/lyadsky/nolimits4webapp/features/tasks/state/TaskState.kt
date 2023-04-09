package com.lyadsky.nolimits4webapp.features.tasks.state

import com.lyadsky.nolimits4webapp.features.tasks.viewModel.TaskType

data class TaskState(
    val stage: Int = 1,
    val isCorrect: Int = 0,
    val type: TaskType = TaskType.Unspecified
)
