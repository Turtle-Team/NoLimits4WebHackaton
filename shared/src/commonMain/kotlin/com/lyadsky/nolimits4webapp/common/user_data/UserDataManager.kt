package com.lyadsky.nolimits4webapp.common.user_data

expect interface NativeUserData

interface UserDataManager: NativeUserData {

    fun getUserData(): String

    fun clearData()
}

expect class NativeUserDataManagerImpl: UserDataManager