package com.lyadsky.nolimits4webapp.features.register.state

data class RegisterState(
    val stage: Int = 1,
    val age: Int = 0,
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val interesting: List<String> = emptyList()
)