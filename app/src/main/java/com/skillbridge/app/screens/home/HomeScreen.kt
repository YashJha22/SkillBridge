package com.skillbridge.app.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skillbridge.app.screens.home.components.ActiveContract
import com.skillbridge.app.screens.home.components.CurrentLearning
import com.skillbridge.app.screens.home.components.HomeHeader
import com.skillbridge.app.screens.home.components.HomeStats
import com.skillbridge.app.screens.home.components.MilestoneRail
import com.skillbridge.app.ui.theme.Background

@Composable
fun HomeScreen(
    uiState: HomeUiState = HomeUiState()
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(horizontal = 20.dp)
    ){
        HomeHeader(
            userName = uiState.user.name
        )

        MilestoneRail(
            learnProgress = uiState.bridge.learnProgress,
            earnProgress = uiState.bridge.earnProgress,
            investProgress = uiState.bridge.investProgress,
            modifier = Modifier.padding(top = 28.dp)
        )

        HomeStats(
            earnedAmount = uiState.stats.earnedAmount,
            lessonsCompleted = uiState.stats.lessonsCompleted,
            goalFunded = uiState.stats.goalFunded,
            modifier = Modifier.padding(top = 28.dp)
        )
        ActiveContract(
            title = uiState.activeContract.title,
            company = uiState.activeContract.company,
            completedTasks = uiState.activeContract.completedTasks,
            totalTasks = uiState.activeContract.totalTasks,
            progress = uiState.activeContract.progress,
            modifier = Modifier.padding(top = 32.dp)
        )

        CurrentLearning(
            title = uiState.currentLearning.title,
            currentLesson = uiState.currentLearning.currentLesson,
            totalLessons = uiState.currentLearning.totalLessons,
            modifier = Modifier.padding(top = 32.dp)
        )
    }
}