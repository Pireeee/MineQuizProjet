import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun background(image :String) {
    Image(
        painter = painterResource(image),
        contentDescription = "background",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}