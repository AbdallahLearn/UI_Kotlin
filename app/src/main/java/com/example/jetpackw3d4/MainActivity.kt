package com.example.jetpackw3d4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackw3d4.ui.theme.JetpackW3D4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackW3D4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileCard(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ProfileCard(modifier: Modifier = Modifier) {
    var isFollowing by remember { mutableStateOf(false) }
    var followerCount by remember { mutableStateOf(100) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.breadman),
            contentDescription = "Profile Picture",
            modifier = Modifier.size(100.dp).clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Abdullah Aljohani",
            fontSize = 24.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Full Stack Developer",
            color = Color.Gray,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                isFollowing = !isFollowing
                followerCount = if (isFollowing) followerCount + 1 else followerCount - 1
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            )
        ) {
            Text(text = if (isFollowing) "Following" else "Follow")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "$followerCount Followers",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Add Image Grid Here
        ImageGrid()
    }
}

// Composable function to display a 3-column grid of images
@Composable
fun ImageGrid() {
    val images = listOf(
        R.drawable.explorer, R.drawable.explorer, R.drawable.explorer,
        R.drawable.explorer, R.drawable.explorer, R.drawable.explorer,
        R.drawable.explorer, R.drawable.explorer, R.drawable.explorer
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // 3 images per row
        modifier = Modifier.fillMaxWidth().height(300.dp), // Adjust height if needed
        contentPadding = PaddingValues(8.dp)
    ) {
        items(images) { imageRes ->
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Gallery Image",
                modifier = Modifier
                    .padding(4.dp)
                    .size(100.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
    JetpackW3D4Theme {
        ProfileCard()
    }
}
