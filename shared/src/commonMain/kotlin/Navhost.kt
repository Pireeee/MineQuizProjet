import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.material.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import network.QuizRepository

private val quizRepository = QuizRepository()

@Composable
internal fun rootNavHost() {

    var navTransition = NavTransition(
        createTransition = fadeIn(),
    )
    val navigator = rememberNavigator()
    NavHost(
        navigator = navigator,
        navTransition = navTransition,
        initialRoute = "/welcome",
    ) {
        scene(
            route = "/welcome",
            navTransition = navTransition,
        ) {
            welcomeScreen(navigator)
        }
        scene(
            route = "/quiz",
            navTransition = navTransition,
        ) {

            val questions = quizRepository.questionState.collectAsState()

            if (questions.value.isNotEmpty()) {
                questionScreen(navigator, questions.value)
            }
        }
        scene(
            route = "/score/{score}",
            navTransition = navTransition,
        ) { backStackEntry ->
            backStackEntry.path<String>("score")?.let { score ->
                scoreScreen(navigator, score)
            }
        }
    }
}