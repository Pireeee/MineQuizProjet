import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable()
internal fun welcomeScreen(navigator: Navigator) {


    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        background("Background.png")
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(10.dp).size(200.dp),
            backgroundColor = Color.Gray
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        
                        Text(
                            text = "Quiz",
                            fontSize = 30.sp,
                            modifier = Modifier.padding(all = 10.dp)
                        )
                        Text(
                            modifier = Modifier.padding(all = 10.dp),
                            text = "A simple Quiz to discovers KMP and compose.",
                        )
                        Button(
                            modifier = Modifier.padding(bottom = 20.dp),
                            colors = ButtonDefaults.buttonColors(
                                Color(0xff70b237),
                                Color(0xff854f2b),
                                Color(0xff8fca5c),
                                Color(0xff854f2b)
                            ),
                            onClick = { navigator.navigate(route = "/quiz") }

                        ) {
                            Text("Start the Quiz")
                        }
                    }
            }
        }
    }
}


