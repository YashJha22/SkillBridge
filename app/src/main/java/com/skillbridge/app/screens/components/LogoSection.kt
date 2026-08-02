package com.skillbridge.app.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skillbridge.app.R

@Composable
fun LogoSection(){

    //column
    Column (
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 30.dp)
            ,  horizontalAlignment = Alignment.CenterHorizontally

    ){
        //logo
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "App logo",
            modifier = Modifier
                .size(80.dp)

        )

        //spacer
        Spacer(modifier = Modifier.height(20.dp))

        //text
        Text(
            text = "SkillBridge",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))

        //text
        Text(
            text = "Learn. Earn. Invest. ",
            fontSize = 18.sp,
            color = Color.Gray

        )
    }
}
