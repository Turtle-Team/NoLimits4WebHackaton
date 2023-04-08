package com.lyadsky.nolimits4webapp.data

import com.lyadsky.database.AppDatabase
import com.lyadsky.database.Tasks
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrNull
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

interface AppDatabaseRepostitory {

    fun getStatsAsFlow(): Flow<TaskStats?>

    suspend fun getStats(): TaskStats

    suspend fun saveStats(stats: TaskStats)
}

internal class AppDatabaseRepostitoryImpl(database: AppDatabase) : AppDatabaseRepostitory {

    private val queries = database.appDatabaseQueries

    override fun getStatsAsFlow(): Flow<TaskStats?> = queries.getAllStats().asFlow().mapToOneOrNull().mapNotNull { it?.toInt() }

    override suspend fun getStats(): TaskStats = try {
        queries.getAllStats().executeAsOne().toInt()
    } catch (e: Exception) {
        saveStats(TaskStats.empty())
        queries.getAllStats().executeAsOne().toInt()
    }

    override suspend fun saveStats(stats: TaskStats) {
        queries.saveStatistics(
            stats.alphabet.toLong(),
            stats.logic.toLong(),
            stats.numbers.toLong(),
            stats.figures.toLong(),
            stats.mathematics.toLong(),
            stats.colors.toLong(),
            stats.english.toLong(),
            stats.helicopter.toLong(),
        )
    }

}

data class TaskStats(
    val alphabet: Int,
    val logic: Int,
    val numbers: Int,
    val figures: Int,
    val mathematics: Int,
    val colors: Int,
    val english: Int,
    val helicopter: Int
) {
    companion object {
        fun empty() = TaskStats(
            0, 0, 0, 0, 0, 0, 0, 0,
        )
    }
}


fun Tasks.toInt() = TaskStats(
    this.alphabet.toInt(),
    this.logic.toInt(),
    this.numbers.toInt(),
    this.figures.toInt(),
    this.mathematics.toInt(),
    this.colors.toInt(),
    this.english.toInt(),
    this.helicopter.toInt()
)