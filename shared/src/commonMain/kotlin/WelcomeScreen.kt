import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
internal fun welcomeScreen(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ){
        Card {
            Row(verticalAlignment = Alignment.CenterVertically){
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Text("Minecraft Quiz", color = Color.Blue, style = MaterialTheme.typography.h4)
                    Text("Welcome to the best Minecraft Quizz App", color = Color.Blue, style = MaterialTheme.typography.h6)
                    Button(onClick = { /*TODO*/ }) {
                        Text("Start Quiz")
                    }
                }
            }
        }
    }
}
