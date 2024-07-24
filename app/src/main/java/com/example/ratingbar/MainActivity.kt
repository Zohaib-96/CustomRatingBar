package com.example.ratingbar

import android.content.Context
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.marginLeft

class MainActivity : AppCompatActivity() {
    lateinit var btnDialog: Button
    lateinit var ratingBar: RatingBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnDialog = findViewById(R.id.showDialogButton)


        btnDialog.setOnClickListener {
            showRatingDialog()
        }
    }

    private fun showRatingDialog() {
        // Inflate the dialog layout

        val inflater = LayoutInflater.from(this)
        val dialogView = inflater.inflate(R.layout.ratingbar_layout, null)

        // Find the RatingBar in the dialog layout
        ratingBar = dialogView.findViewById(R.id.dialogRatingBar)

        // Build and show the dialog
        AlertDialog.Builder(this)
            .setTitle("Rate Us")
            .setView(dialogView)
            .setPositiveButton("OK") { dialog, _ ->
                // Handle the rating value
                val rating = ratingBar.rating
                handleRating(rating)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

    private fun handleRating(rating: Float) {
        // Handle the rating value (e.g., save it, send it to a server)
        // for now we will show a TOAST
        Toast.makeText(this,"Rating $rating", Toast.LENGTH_SHORT).show()
    }
}