package com.example.cryptoapp

import LoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cryptoapp.presentation.ui.auth.components.login.LoginViewModel
import com.example.cryptoapp.presentation.ui.auth.components.register.RegisterScreen
import com.example.cryptoapp.presentation.ui.auth.components.register.RegisterViewModel
import com.example.cryptoapp.presentation.ui.coin_detail.CoinDetailScreen
import com.example.cryptoapp.presentation.ui.coin_detail.CoinDetailViewModel
import com.example.cryptoapp.presentation.ui.coint_list.CoinListScreen
import com.example.cryptoapp.presentation.ui.coint_list.CoinListViewModel
import com.example.cryptoapp.presentation.ui.main.MainScreen
import com.example.cryptoapp.presentation.ui.main.MainViewModel
import com.example.cryptoapp.presentation.ui.splash.SplashScreen
import com.example.cryptoapp.presentation.ui.splash.SplashViewModel
import com.example.cryptoapp.presentation.ui.theme.CryptoAppTheme
import com.example.cryptoapp.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //@RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            CryptoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

//@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            val splashViewModel: SplashViewModel = hiltViewModel()
            SplashScreen(navController, splashViewModel)
        }
        composable(Screen.Register.route) {
            val registerViewModel: RegisterViewModel = hiltViewModel()
            RegisterScreen(navController, registerViewModel)
        }
        composable(Screen.Login.route) {
            val loginViewModel: LoginViewModel = hiltViewModel()
            LoginScreen(navController, loginViewModel)
        }
        composable(Screen.Main.route) {
            val mainViewModel: MainViewModel = hiltViewModel()
            MainScreen(navController, mainViewModel)
        }

        composable(Screen.CoinList.route) {
            val coinListViewModel: CoinListViewModel = hiltViewModel()
            CoinListScreen(navController, coinListViewModel)
        }
        composable(
            Screen.CoinDetail.route + "/{coinId}",
            arguments = listOf(
                navArgument("coinId") {
                    type = NavType.StringType
                }
            )

        ) {
            val coinDetailViewModel: CoinDetailViewModel = hiltViewModel()
            val coinId = it.arguments?.getString("coinId") ?: ""
            CoinDetailScreen(
                coinDetailViewModel,
                coinId
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoAppTheme {

    }
}