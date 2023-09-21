package com.dado.cuadricula_jesse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dado.cuadricula_jesse.ui.theme.Cuadricula_JesseTheme
import com.dado.cuadricula_jesse.model.Topic
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding

import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.dimensionResource
import com.dado.cuadricula_jesse.data.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cuadricula_JesseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    AffirmationsApp(
                        modifier = Modifier.padding(dimensionResource(androidx.core.R.dimen.notification_small_icon_background_padding))
                    )
                }
            }
        }
    }
}
@Composable
fun AffirmationsApp(modifier: Modifier =Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(androidx.core.R.dimen.notification_small_icon_size_as_large)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(androidx.core.R.dimen.notification_small_icon_background_padding)),
        modifier = modifier
    ) {
        items(DataSource.topics) { topic ->
            AffirmationCard(topic)
        }
    }
}

@Composable
fun AffirmationCard(topic: Topic,modifier: Modifier = Modifier) {
    Card{
        Row{
            Box{
                Image(
                    painter = painterResource(topic.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width =68.dp,height = 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }

        Column {

            Text(
                text = LocalContext.current.getString(topic.name),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(
                    start = dimensionResource(androidx.core.R.dimen.notification_small_icon_background_padding),
                    top = dimensionResource(androidx.core.R.dimen.notification_small_icon_background_padding),
                    end = dimensionResource(androidx.core.R.dimen.notification_small_icon_background_padding),
                    bottom = dimensionResource(androidx.core.R.dimen.notification_small_icon_background_padding)
                )
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = dimensionResource(androidx.core.R.dimen.notification_small_icon_background_padding))
                )
                Text(
                    text = topic.availableCourses.toString(),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(start = dimensionResource(androidx.core.R.dimen.notification_small_icon_background_padding))
                )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TopicCardPreview() {
    Cuadricula_JesseTheme {
        val topic = Topic(R.string.architecture, 321, R.drawable.architecture)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            AffirmationCard(topic= topic)
        }
    }
}