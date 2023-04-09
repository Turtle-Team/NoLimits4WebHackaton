package com.lyadsky.nolimits4webapp.common.user_data

import kotlinx.serialization.Serializable


@Serializable
data class User(
    val name: String,
    val age: Int,
    val isMale: Boolean,
    val level: Int
)

expect interface NativeUserData

interface UserDataManager: NativeUserData {

    fun getUserData(): User

    fun clearData()
}

expect class NativeUserDataManagerImpl: UserDataManager