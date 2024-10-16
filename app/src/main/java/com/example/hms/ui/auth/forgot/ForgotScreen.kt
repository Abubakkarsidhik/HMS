package com.example.hms.ui.auth.forgot

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hms.R
import com.example.hms.base.BaseScreen
import com.example.hms.screens.RootInterface
import com.example.hms.screens.Screens
import com.example.hms.screens.goToScreen
import com.example.hms.ui.components.MFilledButton
import com.example.hms.ui.components.MPhoneTextField
import com.example.hms.ui.components.MSpacerH20
import com.example.hms.ui.components.MSpacerH40
import com.example.hms.ui.components.MSpacerH5
import com.example.hms.ui.components.MText14
import com.example.hms.ui.components.MText16
import com.example.hms.ui.components.MTextField
import com.example.hms.ui.theme.AppBG

@Composable
fun TForgotScreen(navController: NavHostController , rootInterface: RootInterface){
    BaseScreen {
        Row(
            modifier = Modifier
                .background(color = AppBG)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.30f)
                    .fillMaxHeight()
                    .background(color = Color.White)
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hms_logo),
                    contentDescription = "hms_logo"
                )
                MSpacerH20()
                MText16(textRes = R.string.forgot_password)
                MSpacerH40()
                MPhoneTextField(
                    titleRes = R.string.username_phone,
                    painter = R.drawable.ic_email,
                    hintRes = R.string.hint_username_phone
                ) {

                }
                MSpacerH20()
                MTextField(painter =  R.drawable.ic_otp, titleRes = R.string.otp, hintRes = R.string.hint_otp) {
                    
                }
                MSpacerH5()
                MText14(
                    textRes = R.string.resend_otp,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
                MSpacerH20()
                MFilledButton(labelRes = R.string.submit) {
                    navController.goToScreen(Screens.PasswordScreen)
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.70f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_login),
                    contentDescription = "img login",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(400.dp)
                )
            }
        }
    }
}