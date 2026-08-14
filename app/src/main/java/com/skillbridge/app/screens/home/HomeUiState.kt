package com.skillbridge.app.screens.home

data class HomeUiState(
    val user: UserState = UserState(),
    val bridge: BridgeState = BridgeState(),
    val stats: StatsState = StatsState(),
    val activeContract: ContractState = ContractState(),
    val currentLearning: LearningState = LearningState()
)
data class UserState(
    val name: String = "Yash Jha"
)
data class BridgeState(
    val learnProgress: Int = 100,
    val earnProgress: Int = 45,
    val investProgress: Int = 10
)
data class StatsState(
    val earnedAmount: Int = 8400,
    val lessonsCompleted: Int = 3,
    val goalFunded: Int = 36
)
data class ContractState(
    val title: String = "E-commerce App — MVP",
    val company: String = "Nimbus Retail",
    val completedTasks: Int = 5,
    val totalTasks: Int = 9,
    val progress: Int = 55
)
data class LearningState(
    val title: String = "Kotlin Fundamentals",
    val currentLesson: Int = 6,
    val totalLessons: Int = 12
)