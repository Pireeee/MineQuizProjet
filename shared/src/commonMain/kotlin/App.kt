import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import network.QuizRepository
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

private val repository = QuizRepository()

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme (){
        val questions = repository.questionState.collectAsState()

        if(questions.value.isNotEmpty()) {
           // questionScreen(questions.value)
        }
        /*
        var questions = listOf(
            Question(
                1,
                "Android is a great platform ?",
                1,
                listOf(Answer(1, "YES"), Answer(2, "NO"))
            ),
            Question(
                1,
                "On mange quoi ce midi ?",
                1,
                listOf(Answer(1, "Kfc"), Answer(2, "Subway"), Answer(3, "McDo"))
            )
        )
        */
        /*
        Box(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        ) {
            Image(
                painter = painterResource("Background.png"),
                contentDescription = "Quiz App",
                modifier = Modifier.fillMaxWidth()
            )
        }*/
        craftScreen()
    }
}

expect fun getPlatformName(): String

