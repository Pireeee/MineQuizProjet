import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import moe.tlaster.precompose.navigation.Navigator
import network.data.Question
import kotlin.math.roundToInt

@Composable()
internal fun questionScreen(navigator: Navigator, questions: List<Question>) {

    var questionProgress by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf(1) }
    var score by remember { mutableStateOf(0) }
    var elapsedTime by remember { mutableStateOf(0) }
    var startTime = questions.size*10
    var remainingTime by remember { mutableStateOf(startTime) }
    var bonus = 0;
    var totalScore = score;
    var colorProgress by remember{ mutableStateOf(0xFff87ff00)};
    scoreBox(score)
    LaunchedEffect(true) {
        launch {
            while (true) {
                delay(1000)
                elapsedTime++
                remainingTime--
                if(remainingTime > startTime/1.5){
                    colorProgress = 0xFff87ff00;
                }else if(remainingTime > startTime/2){
                    colorProgress = 0xFffffd100;
                }else if(remainingTime > 0){
                    colorProgress = 0xFffff0800;
                }else{
                    navigator.navigate("/score/$score out of ${questions.size} \n" +
                            "Time : $elapsedTime \n" +
                            "Bonus added to your score : $bonus \n" +
                            "Total score : $totalScore")
                }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.padding(60.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                Text(
                    modifier = Modifier.padding(all = 10.dp),
                    text = questions[questionProgress].label,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center
                )
                Text(text = "Time : $elapsedTime seconds")
                Text(text = "Time remaining : $remainingTime seconds")
                LinearProgressIndicator(strokeCap = StrokeCap.Square,modifier = Modifier.fillMaxWidth().height(20.dp).rotate(
                    180F
                ).background(color = Color(0xFff08f112)), color = Color(colorProgress),progress=elapsedTime.div(startTime.toFloat()).plus(1.div(startTime.toFloat())))
            }
        }
        Column(modifier = Modifier.selectableGroup()) {
            if(questionProgress != 2){
                questions[questionProgress].answers.forEach { answer ->
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            modifier = Modifier.padding(end = 16.dp),
                            selected = (selectedAnswer == answer.id),
                            onClick = { selectedAnswer = answer.id },
                        )
                        Text(text = answer.label)

                    }
                }
            }
            else{
                Row(

                    modifier = Modifier.padding(horizontal = 16.dp).width(300.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(text = selectedAnswer.toString())

                    Slider(
                        value = selectedAnswer.toFloat(),
                        onValueChange = { selectedAnswer = it.roundToInt() },
                        colors = SliderDefaults.colors(
                            thumbColor = Color(0xff70b237),
                            activeTrackColor = Color(0xff854f2b),
                            inactiveTrackColor = Color(0xff8fca5c),
                        ),
                        steps = 2,
                        valueRange = 1f..4f
                    )
                }
            }
        }
    }

        Column(modifier = Modifier.fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {
            Button(
                modifier = Modifier.padding(bottom = 20.dp),
                onClick = {

                    if(selectedAnswer == questions[questionProgress].correctAnswerId) {
                        score++
                    }
                    if (questionProgress < questions.size - 1) {
                        questionProgress++
                        selectedAnswer = 1
                    }else{
                        // Go to the score section
                        if(remainingTime > startTime/1.5){
                            bonus = 2
                            totalScore = score + bonus
                        }else if(remainingTime > startTime/2){
                            bonus++
                            totalScore += bonus
                        }

                        navigator.navigate("/score/$score out of ${questions.size} \n" +
                                "Time : $elapsedTime \n" +
                                "Bonus added to your score : $bonus \n" +
                                "Total score : $totalScore")
                    }
                }
            ) {
                if(questionProgress < questions.size - 1) nextOrDoneButton(Icons.Filled.ArrowForward,"Next")
                else nextOrDoneButton(Icons.Filled.Done,"Done")
            }
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth().height(20.dp), progress = questionProgress.div(questions.size.toFloat()).plus(1.div(questions.size.toFloat())))
        }
    }


@Composable
internal fun nextOrDoneButton(iv: ImageVector, label:String){
    Icon(
        iv,
        contentDescription = "Localized description",
        Modifier.padding(end = 15.dp)
    )
    Text(label)
}