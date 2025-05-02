package com.example.artspaceapp

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Surface {
                    ArtSpaceApp()
                }
            }
        }
    }
}
//hey this is updated
@Composable
fun ArtSpaceApp( modifier: Modifier = Modifier) {
    //variable to hold the current state of the image
    var currentState by remember { mutableStateOf(1) }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier,
            contentAlignment = Alignment.Center
        ) {
            ArtWorks(currentState = currentState)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,

            ) {
            Button(onClick = {
                //previous state
                if (currentState > 1) {
                    currentState--
                } else if (currentState == 1) {
                    currentState = 10
                }
            }, modifier = Modifier.weight(1f)) { Text("Previous") }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {
                //previous state
                if (currentState < 10) {
                    currentState++
                } else if (currentState == 10) {
                    currentState = 1
                }
            }, modifier = Modifier.weight(1f)) { Text("Next") }
        }
    }


}

@Composable
fun ArtWorks(modifier: Modifier = Modifier,
             currentState : Int) {
    Column(
        modifier = Modifier
            //.fillMaxSize()
            .padding(32.dp),
    ) {
        //image resource based on the current state
        val imageResource = when(currentState) {
            1 -> R.drawable.image1
            2 -> R.drawable.image2
            3 -> R.drawable.image3
            4 -> R.drawable.image4
            5 -> R.drawable.image5
            6 -> R.drawable.image6
            7 -> R.drawable.image7
            8 -> R.drawable.image8
            9 -> R.drawable.image9
            else -> R.drawable.image10
        }
        //string resource based on the current state
        val art_Title = when(currentState) {
            1 -> R.string.shah_jahan_mosque
            2 -> R.string.derawar_fort
            3 -> R.string.noor_mahal
            4 -> R.string.tomb_dai_anga
            5 -> R.string.lahore_fort
            6 -> R.string.pakistan_monument
            7 -> R.string.wazir_khan_mosque
            8 -> R.string.faisal_mosque
            9 -> R.string.tomb_bibi_jawindi
            else -> R.string.tomb_jahangir
        }
        //photographed by
        val Artist_Id = when(currentState) {
            1 -> R.string.photographer_ovais
            2 -> R.string.photographer_ali_mir
            3 -> R.string.photographer_ashar
            4 -> R.string.photographer_ashar
            5 -> R.string.photographer_rohaan
            6 -> R.string.photographer_baqi
            7 -> R.string.photographer_shagufta
            8 -> R.string.photographer_ali_mujtaba
            9 -> R.string.photographer_shah_zaman
            else -> R.string.photographer_sohaib
        }

        val art_Desc = when(currentState) {
            1 -> R.string.shah_jahan_mosque_desc
            2 -> R.string.derawar_fort_desc
            3 -> R.string.noor_mahal_desc
            4 -> R.string.tomb_dai_anga_desc
            5 -> R.string.lahore_fort_desc
            6 -> R.string.pakistan_monument_desc
            7 -> R.string.wazir_khan_mosque_desc
            8 -> R.string.faisal_mosque_desc
            9 -> R.string.tomb_bibi_jawindi_desc
            else -> R.string.tomb_jahangir_desc
        }

        Text(
            stringResource(art_Title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.padding(8.dp))

        Image(painter = painterResource(imageResource),
            contentDescription = imageResource.toString(),
            modifier = Modifier,
            contentScale = ContentScale.FillHeight,

        )
        Spacer(modifier = Modifier.padding(8.dp))

        Text(stringResource(Artist_Id),
            fontWeight = FontWeight.Normal)

        Spacer(modifier = Modifier.padding(8.dp))

        Text(stringResource(art_Desc),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,)
        }
    }

@Preview(showBackground = true, name = "Art Space")
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}