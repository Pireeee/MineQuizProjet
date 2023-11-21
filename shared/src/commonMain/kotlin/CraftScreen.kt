import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import kotlin.math.roundToInt

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun craftScreen(){
    //Background
    Box(
        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
    ) {
        Image(
            painter = painterResource("Crafting3x3.png"),
            contentDescription = "Quiz App",
            modifier = Modifier.fillMaxWidth()
        )
    }
    //Item to drag
    DraggableItem("Oak_Planks.png")
    DraggableItem("Oak_Button.png")
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun DraggableItem(url: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        //Box Coordinates
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }

        Box(
            Modifier
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .background(androidx.compose.ui.graphics.Color.Companion.Blue)
                .size(50.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
        )
        {
            Image(
                painter = painterResource(url),
                contentDescription = "Quiz App",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}