package edu.csce3220.project

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        imageView = findViewById(R.id.imageView)
    }

    fun onButtonClick(view: View) {
        val transition = TransitionDrawable(arrayOf(
            ColorDrawable(android.graphics.Color.TRANSPARENT), // Placeholder
            ContextCompat.getDrawable(this, Companion.getImageResource(view.id))!! // Actual image
        ))

        imageView.setImageDrawable(transition)
        transition.startTransition(500) // Adjust duration as needed
    }

    companion object {
        private fun getImageResource(buttonId: Int): Int {
            return when (buttonId) {
                R.id.button1 -> R.drawable.image3
                R.id.button2 -> R.drawable.image2
                R.id.button3 -> R.drawable.image1
                else -> R.drawable.initial_image
            }
        }
    }
}