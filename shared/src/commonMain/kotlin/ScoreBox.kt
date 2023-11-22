import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
internal fun scoreBox(score: Int) {
    Box(
        contentAlignment = Alignment.TopEnd,
        modifier = androidx.compose.ui.Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        Text(
            text = "Score: $score"
        )
    }
}