import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable()
internal fun scoreScreen(navigator: Navigator, score: String){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        background("Background.png")
        Card(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.size(300.dp, 200.dp),
            backgroundColor = Color.Gray
        ) {
            
            Column(horizontalAlignment = Alignment.CenterHorizontally) {


                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Text(
                            fontSize = 25.sp,
                            text = "score",
                        )
                        Text(
                            fontSize = 15.sp,
                            text = score,
                        )
                        Button(
                            modifier = Modifier.padding(bottom = 20.dp),
                            colors = ButtonDefaults.buttonColors(
                                Color(0xff70b237),
                                Color(0xff854f2b),
                                Color(0xff8fca5c),
                                Color(0xff854f2b)
                            ),
                            onClick = {
                                navigator.navigate(route = "/quiz")
                            }
                        ) {
                            Icon(Icons.Filled.Refresh, contentDescription = "Localized description")
                            Text(text = "Retake the Quiz",)

                        }
                    }
            }
        }
    }
}