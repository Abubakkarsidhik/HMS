package com.example.hms.screens

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hms.ui.auth.forgot.TForgotScreen
import com.example.hms.ui.components.log
import com.example.hms.ui.auth.login.TLoginScreen
import com.example.hms.ui.auth.password.TPasswordScreen
import com.example.hms.ui.auth.register.TRegisterScreen
import com.example.hms.ui.auth.splash.SplashScreen
import com.example.hms.ui.home.main.MainScreen
import kotlinx.serialization.json.Json

fun NavGraphBuilder.myComposable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    enterTransition: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = {
        slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(300)
        )
    },
    exitTransition: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = {
        slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(300)
        )
    },
    popEnterTransition: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? =
        {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        },
    popExitTransition: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? =
        {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        },
    sizeTransform: (@JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? = null,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route,
        arguments,
        deepLinks,
        enterTransition,
        exitTransition,
        popEnterTransition,
        popExitTransition,
        sizeTransform,
        content
    )
}

enum class Screens(val route:String){

    AuthRoute("AuthNav-route?data={data}"),
    MainScreen("MainScreen-route?data={data}"),
    LoginScreen("LoginScreen-route?data={data}"),
    SplashScreen("SplashScreen-route?data={data}"),
    RegisterScreen("RegisterScreen-route?data={data}"),
    ForgotScreen("ForgotScreen-route?data={data}"),
    PasswordScreen("PasswordScreen-route?data={data}"),

}

interface RootInterface {
    fun logout(message:String?=null)

}

fun NavGraphBuilder.AuthNav(navHostController :NavHostController,rootInterface: RootInterface){
    navigation(
        startDestination = Screens.SplashScreen.route,
        route = Screens.AuthRoute.route){

        composable(Screens.SplashScreen.route) {
            log("Nav Compose Splash Screen")
            SplashScreen(navHostController , rootInterface)
        }
        composable(Screens.LoginScreen.route){
            TLoginScreen(navHostController,rootInterface)
        }
        composable(Screens.RegisterScreen.route){
            TRegisterScreen(navHostController,rootInterface)
        }
        composable(Screens.ForgotScreen.route){
            TForgotScreen(navController = navHostController, rootInterface = rootInterface)
        }
        composable(Screens.PasswordScreen.route){
            TPasswordScreen(navController = navHostController, rootInterface = rootInterface)
        }

    }
}

fun NavGraphBuilder.MainNav(navController: NavHostController,rootInterface: RootInterface){

}

fun NavGraphBuilder.HomeNav(rootInterface: RootInterface){
    composable(Screens.MainScreen.route){
        MainScreen(rootInterface = rootInterface)
    }
}

@Composable
fun Navigation(navController: NavHostController) {

    val rootNavInt  = object : RootInterface {
        override fun logout(message: String?) {
            navController.goToScreen(Screens.LoginScreen,message)
        }
    }
    NavHost(
        navController = navController,
        startDestination = Screens.AuthRoute.route,
        enterTransition = {
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(300))
        },
        exitTransition = {
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(300))
        },
        popEnterTransition = {
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right, animationSpec = tween(300))
        },
        popExitTransition = {
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, animationSpec = tween(300))
        },
        modifier = Modifier.fillMaxSize()) {


        AuthNav(navController, rootNavInt)
        HomeNav(rootNavInt)

    }
}

fun NavHostController.closeScreen() {
    navigateUp()
}


fun NavOptionsBuilder.popUpToTop(navController: NavHostController) {
    popUpTo(navController.currentBackStackEntry?.destination?.route ?: return) {
        inclusive = true
    }
}


fun NavHostController.openScreen(screen: Screens, data: String? = null) {
    log("Current Route -- open: ${screen.route} , data: $data")
    data?.let {
        run {
            navigate(screen.route.replace(Resource.DATA, data)){
//                restoreState = restoreCurrentState
            }
        }
    } ?: run {
        navigate(screen.route.replace(Resource.DATA, "")){
//            restoreState = restoreCurrentState
        }
    }
}

fun NavHostController.goToScreen(screen: Screens, data: String? = null, singleTop: Boolean = false, skipAnimation: Boolean = false) {
    log("Current Route -- goto: ${screen.route}")
    data?.let {
        log("data != null - $data")
        run {
            navigate(screen.route.replace(Resource.DATA, data)) {
                popUpToTop(this@run)
                if (singleTop){
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    } ?: run {
        log("data = null - $data")
        navigate(screen.route.replace(Resource.DATA, "")) {
            popUpToTop(this@run)
            if (singleTop){
                launchSingleTop = true
                restoreState = true
            }
        }
    }
}

/*fun NavHostController.backToMain(){
    val last = this.currentBackStack.value.reversed().first { it -> it.destination.route in BottomNavItems.map { tab -> tab.route } }
    this.popBackStack(last.destination.route!!, false, false)
}*/


fun <T> NavHostController.resultScreen(key: String, value: T?) {
    previousBackStackEntry?.savedStateHandle?.set(key, value)
    popBackStack()
}

@Composable
inline fun <reified T> NavHostController.getResultScreen(key: String, isString:Boolean= false, callBack: (T) -> Unit) {
    val getResult = currentBackStackEntry?.savedStateHandle?.getStateFlow<T?>(key, null)
        ?.collectAsStateWithLifecycle()
    getResult?.value?.let {
        currentBackStackEntry?.savedStateHandle?.remove<T>(key)
        if (isString) {
            callBack(it)
        } else {
            callBack(Json.decodeFromString<T>(it as String))
        }

    }
}

object Resource {
    const val NOT_SUPPORTED = "Not Supported"
    const val DATA = "{data}"
}

