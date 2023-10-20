package yhr.jfj.profile_card_kotlin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfilePage(){
    Column {
        Image(painter = painterResource(id = R.drawable.profile_picture), contentDescription = "Profile Picture")
        Text(text = "Anime")
        Text(text = "Japan")
    }
}
@Preview(showBackground = true)
@Composable
fun ProfilePagePreview(){
    ProfilePage()
}
