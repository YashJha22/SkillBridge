package com.skillbridge.app.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skillbridge.app.screens.home.components.ActiveContract
import com.skillbridge.app.screens.home.components.CurrentLearning
import com.skillbridge.app.screens.home.components.HomeBottomNavigation
import com.skillbridge.app.screens.home.components.HomeHeader
import com.skillbridge.app.screens.home.components.HomeStats
import com.skillbridge.app.screens.home.components.MilestoneRail

@Composable
fun HomeScreen(
    uiState: HomeUiState = HomeUiState()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(28.dp)
        ) {
            HomeHeader(
                userName = uiState.user.name
            )

            MilestoneRail(
                learnProgress = uiState.bridge.learnProgress,
                earnProgress = uiState.bridge.earnProgress,
                investProgress = uiState.bridge.investProgress
            )

            HomeStats(
                earnedAmount = uiState.stats.earnedAmount,
                lessonsCompleted = uiState.stats.lessonsCompleted,
                goalFunded = uiState.stats.goalFunded
            )

            ActiveContract(
                title = uiState.activeContract.title,
                company = uiState.activeContract.company,
                completedTasks = uiState.activeContract.completedTasks,
                totalTasks = uiState.activeContract.totalTasks,
                progress = uiState.activeContract.progress
            )

            CurrentLearning(
                title = uiState.currentLearning.title,
                currentLesson = uiState.currentLearning.currentLesson,
                totalLessons = uiState.currentLearning.totalLessons
            )
        }

        HomeBottomNavigation(
            onHomeClick = { },
            onLearnClick = { },
            onEarnClick = { },
            onInvestClick = { },
            onProfileClick = { }
        )
    }
}