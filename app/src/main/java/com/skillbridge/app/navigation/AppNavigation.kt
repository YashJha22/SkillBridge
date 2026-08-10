package com.skillbridge.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skillbridge.app.screens.SplashScreen
import com.skillbridge.app.screens.forgotPassword.ForgetPassword
import com.skillbridge.app.screens.login.LoginScreen
import com.skillbridge.app.screens.signup.SignupScreen

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
                    navController.navigate(Routes.SIGNUP)
                },
                onForgotPasswordClick = {
                    navController.navigate(Routes.Forgot_Password)
                }
            )
        }

        composable(Routes.SIGNUP) {
            SignupScreen(
                onBackToLoginClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.Forgot_Password) {
            ForgetPassword(
                onBackToLoginClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}