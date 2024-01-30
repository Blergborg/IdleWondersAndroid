package com.example.idlewonders

import androidx.annotation.StringRes
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
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
//        enterTransition = { EnterTransition.None },
//        exitTransition = { ExitTransition.None },
        startDestination = IdleScreen.Build.name,
        modifier = Modifier
    ) {
        composable(route = IdleScreen.Build.name) {
            HomeScreen(
                viewModel = viewModel,
                employeeNav = { navController.navigate(IdleScreen.Employees.name) },
                spellNav = { navController.navigate(IdleScreen.Spells.name) },
                greatPeopleNav = { navController.navigate(IdleScreen.GreatPeople.name) }
            )
        }
        composable(route = IdleScreen.Employees.name) {
            EmployeesScreen(
                backNav = { navigateToHome(navController) }
            )
        }
        composable(route = IdleScreen.Spells.name) {
            SpellsScreen(
                backNav = { navigateToHome(navController) }
            )
        }
        composable(route = IdleScreen.GreatPeople.name) {
            GreatPeopleScreen(
                backNav = { navigateToHome(navController) }
            )
        }
    }
}

private fun navigateToHome(navController: NavHostController) {
    navController.popBackStack(IdleScreen.Build.name, inclusive = false)
}