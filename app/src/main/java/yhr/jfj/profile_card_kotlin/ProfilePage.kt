package yhr.jfj.profile_card_kotlin

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun ProfilePage() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp)),
        elevation = CardDefaults.cardElevation(6.dp),
    ) {
        BoxWithConstraints() {
            val constraints = if (minWidth < 600.dp) {
                portraitConstraints(16.dp)
            } else {
                // TODO: Landscape Constraints
                portraitConstraints(16.dp)
            }

            ConstraintLayout(constraints) {
                Image(
                    painter = painterResource(id = R.drawable.profile_picture),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color.Red, shape = CircleShape)
                        .layoutId("image"),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Anime", modifier = Modifier
                        .padding(16.dp)
                        .layoutId("nameText")
                )
                Text(text = "Japan", modifier = Modifier.layoutId("countryText"))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .layoutId("rowStats")
                ) {
                    ProfileStats(count = "130", title = "Follower")
                    ProfileStats(count = "500", title = "Following")
                    ProfileStats(count = "20", title = "Post")
                }

                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier.layoutId("followButton")
                ) {
                    Text(text = "Follow")
                }
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier.layoutId("messageButton")
                ) {
                    Text(text = "Message")
                }
            }
        }
    }
}

private fun portraitConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val countryText = createRefFor("countryText")
        val rowStats = createRefFor("rowStats")
        val followButton = createRefFor("followButton")
        val messageButton = createRefFor("messageButton")
        val guideLine_Top = createRefFor("guideLine_Top")

        // Image
        constrain(image) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        // Name
        constrain(nameText) {
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        // Country
        constrain(countryText) {
            top.linkTo(nameText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        // Row for status
        constrain(rowStats) {
            top.linkTo(countryText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        // Follow Button
        constrain(followButton) {
            top.linkTo(rowStats.bottom, margin = margin)
            start.linkTo(parent.start)
            end.linkTo(messageButton.start)
        }
        // Message Button
        constrain(messageButton) {
            top.linkTo(rowStats.bottom, margin = margin)
            start.linkTo(followButton.end)
            end.linkTo(parent.end)
        }
    }
}

@Composable
private fun ProfileStats(count: String, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}
