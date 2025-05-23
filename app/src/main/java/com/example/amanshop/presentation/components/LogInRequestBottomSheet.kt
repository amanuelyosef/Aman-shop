package com.example.amanshop.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.amanshop.R
import com.example.amanshop.presentation.ui.theme.Dimens
import com.example.amanshop.presentation.ui.theme.customOnPrimaryContainerPink
import com.example.amanshop.presentation.ui.theme.customPrimaryPink
import com.example.amanshop.presentation.ui.theme.facebookBlue

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun LogInRequestBottomSheet(
    modifier: Modifier = Modifier,
    onDismissRequest : ()->Unit,
    navController: NavController
) {

    var createAccount by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = {onDismissRequest()},
        sheetState = sheetState,
        dragHandle = null,
        modifier = modifier
            .padding(vertical = Dimens.MediumPadding)
        ,
        ) {


        Row(
            modifier =  Modifier
                .padding( vertical = Dimens.SmallPadding, horizontal = Dimens.MediumPadding)
                .padding(top = Dimens.LargePadding, bottom = Dimens.SmallPadding)
                .fillMaxWidth()
                .clip(CircleShape)
                .background(Color.LightGray.copy(0.8f))
                .padding(vertical = Dimens.MediumPadding)
            ,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_google_logo),
                contentDescription = null,
                modifier = Modifier.padding(horizontal = Dimens.MiniPadding)
                    .size(Dimens.IconSizeSmall)
            )
            Text(
                text = "Continue with Google",
                fontWeight = FontWeight.SemiBold,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            )
        }

        Row(
            modifier =  Modifier
                .padding( vertical = Dimens.SmallPadding, horizontal = Dimens.MediumPadding)
                .fillMaxWidth()
                .clip(CircleShape)
                .background(facebookBlue)
                .padding(vertical = Dimens.MediumPadding)
            ,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_facebook_logo),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.padding(horizontal = Dimens.MiniPadding)
                    .size(Dimens.IconSizeSmall)
            )
            Text(
                text = "Continue with Facebook",
                fontWeight = FontWeight.SemiBold,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = Color.White
            )
        }


        Row(
            modifier =  Modifier
                .padding( vertical = Dimens.SmallPadding, horizontal = Dimens.MediumPadding)
                .fillMaxWidth()
                .clip(CircleShape)
                .background(customPrimaryPink)
                .clickable {
                    if (createAccount){
                        navController.navigate(ScreenRoute.CreateNewAccountScreen.route)
                    }else{
                        navController.navigate(ScreenRoute.LoginScreen.route)
                    }
                }
                .padding(vertical = Dimens.MediumPadding),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = if(createAccount) "Create account with phone or email" else "Log in with phone or Email",
                fontWeight = FontWeight.SemiBold,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = Color.White
            )
        }


        Row(
            modifier =  Modifier
                .padding( vertical = Dimens.SmallPadding, horizontal = Dimens.MediumPadding)
                .fillMaxWidth()
                .clip(CircleShape)
                .clickable {
                    createAccount = !createAccount
                }
                .padding(vertical = Dimens.MediumPadding),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = buildAnnotatedString {
                    append(if(createAccount) "Already registered? " else "Don't have an account? ")
                    withStyle(
                        SpanStyle(color = customOnPrimaryContainerPink)
                    ){
                        append(if(createAccount) "Log in" else "Create Account")
                    }
                } ,
                fontWeight = FontWeight.SemiBold,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            )
        }

        Text(
            text = "By continuing you agree to the Terms and Conditions and  privacy policy",
            color = Color.Gray,
            fontSize = MaterialTheme.typography.bodySmall.fontSize,
            fontFamily = FontFamily.Default,
            modifier = Modifier
                .padding(horizontal = Dimens.LargePadding)
        )

        Spacer(
            modifier = Modifier
                .height(Dimens.BottomNavigationBarHeight)
                .fillMaxWidth()
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun T() {
    LogInRequestBottomSheet(
        onDismissRequest = {},
        navController = rememberNavController()
    )
}