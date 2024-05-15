package com.colab.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.colab.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun ProfileCard() {
    Column {
        Box(
            modifier = Modifier
                .background(color = Color(0xFF00000F))
                .width(128.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = null
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Aashray Bavisa",
                fontSize = 40.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Android Developer Extraordinaire",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

    }
}

@Composable
fun ContactItem(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(
            icon,
            contentDescription = null
        )
        Text(
            text,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
    }


}

@Composable
fun ContactCard() {
    Column(
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        ContactItem(
            icon = Icons.Rounded.Phone,
            text = "+1 (519) 857-8369"
        )
        ContactItem(
            icon = Icons.Rounded.Share,
            text = "@AndroidDev"
        )
        ContactItem(
            icon = Icons.Rounded.Email,
            text = "ashraybavisa@gmail.com"
        )
    }

}

@Composable
fun BusinessCard(){
    Column(
        modifier = Modifier
            .background(color = Color(0x2500000F))
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.weight(1f))
        ProfileCard()
        Spacer(modifier = Modifier.weight(1f))
        ContactCard()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}