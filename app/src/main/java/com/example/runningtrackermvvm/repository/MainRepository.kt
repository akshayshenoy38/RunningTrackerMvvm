package com.example.runningtrackermvvm.repository

import com.example.runningtrackermvvm.db.Run
import com.example.runningtrackermvvm.db.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDao
) {
    suspend fun insertRun(run:Run) = runDao.insertRun(run)

    suspend fun deleteRunRun(run:Run) = runDao.deleteRun(run)

    fun getAllRunsSortedByDate() = runDao.getAllRunSortedByDate()

    fun getAllRunsSortedByDistance() = runDao.getAllRunSortedByDistance()

    fun getAllRunsSortedByTimeInMillis() = runDao.getAllRunSortedByMillis()

    fun getAllRunsSortedByAvgSpeed() = runDao.getAllRunSortedByAverageSpeed()

    fun getAllRunsSortedByCaloriesBurnt() = runDao.getAllRunSortedByCaloriesBurnt()

    fun getTotalAverageSpeed() = runDao.getAverageSpeedInKm()

    fun getTotalDistance() = runDao.getTotalDistanceInMts()

    fun getTotalCaloriesBurnt() = runDao.getTotalCaloriesBurnt()

    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()


}