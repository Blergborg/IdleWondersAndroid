package com.example.idlewonders

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.idlewonders.data.PlayerViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.idlewonders.ui.EmployeesScreen
import com.example.idlewonders.ui.GreatPeopleScreen
import com.example.idlewonders.ui.HomeScreen
import com.example.idlewonders.ui.SpellsScreen

// TODO: Maybe get rid of title here? Could be useful later for accessibility tools?
enum class IdleScreen(@StringRes val title: Int) {
    Build(title = R.string.home_screen),
    Employees(title = R.string.employee_screen),
    Spells(title = R.string.spell_screen),
    GreatPeople(title = R.string.great_people_screen)
}

@Composable
fun IdleWondersApp(
    viewModel: PlayerViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
    ) {

    NavHost(
        navController = navController,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        startDestination = IdleScreen.Build.name,
        modifier = Modifier
    ) {
        // Home/Build Screen
        composable(
            route = IdleScreen.Build.name,
            exitTransition = {
                ExitTransition.KeepUntilTransitionsFinished
            }
        ) {
            HomeScreen(
                viewModel = viewModel,
                employeeNav = { navController.navigate(IdleScreen.Employees.name) },
                spellNav = { navController.navigate(IdleScreen.Spells.name) },
                greatPeopleNav = { navController.navigate(IdleScreen.GreatPeople.name) }
            )
        }
        // Employees Screen
        composable(
            route = IdleScreen.Employees.name,
            enterTransition = {
                slideIntoContainer(
                    animationSpec = tween(300, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }
        ) {
            EmployeesScreen(
                backNav = { navigateToHome(navController) }
            )
        }
        // Spells Screen
        composable(
            route = IdleScreen.Spells.name,
            enterTransition = {
                slideIntoContainer(
                    animationSpec = tween(300, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Down
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.Up
                )
            }
        ) {
            SpellsScreen(
                backNav = { navigateToHome(navController) }
            )
        }

        // GreatPeople Screen
        composable(
            route = IdleScreen.GreatPeople.name,
            enterTransition = {
                slideIntoContainer(
                    animationSpec = tween(300, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Up
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.Down
                )
            }
        ) {
            GreatPeopleScreen(
                backNav = { navigateToHome(navController) }
            )
        }
    }
}

private fun navigateToHome(navController: NavHostController) {
    navController.popBackStack(IdleScreen.Build.name, inclusive = false)
}