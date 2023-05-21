package com.example.paintandroid

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.example.paintandroid.PaintView.Companion.currentBrush

class Paint : AppCompatActivity() {

    companion object{
        var path = Path()
        var paintBrush = Paint()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paint)
        supportActionBar?.hide()

        val redBtn = findViewById<ImageButton>(R.id.redColor)
        val bluBtn = findViewById<ImageButton>(R.id.blueColor)
        val grnBtn = findViewById<ImageButton>(R.id.greenColor)
        val eraser = findViewById<ImageButton>(R.id.whiteColor)
        val blkBtn = findViewById<ImageButton>(R.id.blackColor)

        redBtn.setOnClickListener {
            paintBrush.color = Color.RED
            currentColor(paintBrush.color)

        }

        bluBtn.setOnClickListener {
            paintBrush.color = Color.BLUE
            currentColor(paintBrush.color)
        }

        grnBtn.setOnClickListener {
            paintBrush.color = Color.GREEN
            currentColor(paintBrush.color)

        }

        blkBtn.setOnClickListener {
            paintBrush.color = Color.BLACK
            currentColor(paintBrush.color)

        }

        eraser.setOnClickListener {
            paintBrush.color = Color.WHITE
            currentColor(paintBrush.color)

        }
    }

    private fun currentColor(color: Int){
        currentBrush = color
        path = Path()
    }

}