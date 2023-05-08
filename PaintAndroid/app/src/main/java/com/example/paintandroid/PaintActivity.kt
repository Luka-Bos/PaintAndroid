package com.example.paintandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Path;

class PaintActivity : AppCompatActivity() {


    private var color: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paint)
        
    }
    fun Stroke(color: Int, strokeWidth: Int, path: Path) {
        this.color = color
        this.strokeWidth = strokeWidth
        this.path = path
    }

}