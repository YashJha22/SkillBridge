package com.skillbridge.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.skillbridge.app.screens.SplashScreen
import com.skillbridge.app.screens.forgotPassword.ForgetPassword
import com.skillbridge.app.screens.login.LoginScreen
import com.skillbridge.app.screens.signup.ProfileScreen
import com.skillbridge.app.screens.signup.RoleAndSkillsScreen
import com.skillbridge.app.screens.signup.SignupScreen
import com.skillbridge.app.screens.signup.SignupViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {

        composable(Routes.SPLASH) {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.SPLASH) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Routes.LOGIN) {
            LoginScreen(
                onSignUpClick = {
                    navController.navigate(Routes.SIGNUP_FLOW)
                },
                onForgotPasswordClick = {
                    navController.navigate(Routes.FORGOT_PASSWORD)
                }
            )
        }

        navigation(
            route = Routes.SIGNUP_FLOW,
            startDestination = Routes.SIGNUP
        ) {

            composable(Routes.SIGNUP) {

                val signupFlowEntry = remember {
                    navController.getBackStackEntry(
                        Routes.SIGNUP_FLOW
                    )
                }

                val signupViewModel: SignupViewModel = viewModel(
                    viewModelStoreOwner = signupFlowEntry
                )

                SignupScreen(
                    navController = navController,
                    viewModel = signupViewModel,
                    onContinueClick = {
                        navController.navigate(
                            Routes.ROLE_AND_SKILLS
                        )
                    }
                )
            }

            composable(Routes.ROLE_AND_SKILLS) {

                val signupFlowEntry = remember {
                    navController.getBackStackEntry(
                        Routes.SIGNUP_FLOW
                    )
                }

                val signupViewModel: SignupViewModel = viewModel(
                    viewModelStoreOwner = signupFlowEntry
                )

                RoleAndSkillsScreen(
                    viewModel = signupViewModel,
                    onContinueClick = {
                        navController.navigate(
                            Routes.PROFILE
                        )
                    }
                )
            }

            composable(Routes.PROFILE) {

                val signupFlowEntry = remember {
                    navController.getBackStackEntry(
                        Routes.SIGNUP_FLOW
                    )
                }

                val signupViewModel: SignupViewModel = viewModel(
                    viewModelStoreOwner = signupFlowEntry
                )

                ProfileScreen(
                    viewModel = signupViewModel,
                    onBackClick = {
                        navController.popBackStack()
                    },
                    onContinueClick = {
                        // Home will be connected here next.
                    }
                )
            }
        }

        composable(Routes.FORGOT_PASSWORD) {
            ForgetPassword(
                onBackToLoginClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}