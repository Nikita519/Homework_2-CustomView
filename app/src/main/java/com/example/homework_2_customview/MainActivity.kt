package com.example.homework_2_customview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.homework_2_customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SpinListener {

    private lateinit var binding: ActivityMainBinding

    private var images = listOf(
        "https://i.imgur.com/2RiSGbP.jpeg",
        "https://i.imgur.com/VyAlcbq.jpeg",
        "https://i.imgur.com/hgxd45J.jpeg",
        "https://i.imgur.com/0dqdq3m.jpeg",
        "https://i.imgur.com/fBNG4By.png",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.customView.wheel.setSpinListener(this)

        binding.resetButton.setOnClickListener {
            binding.customView.textViewColor.visibility = View.GONE
            binding.customView.imageView.visibility = View.GONE
        }

    }

    override fun onSpinComplete(color: Int) {
        when (color) {
            Color.RED -> {
                binding.customView.textViewColor.text = "Красный"
                binding.customView.textViewColor.setTextColor(color)
                binding.customView.textViewColor.visibility = View.VISIBLE
            }
            Color.YELLOW -> {
                binding.customView.textViewColor.text = "Желтый"
                binding.customView.textViewColor.setTextColor(color)
                binding.customView.textViewColor.visibility = View.VISIBLE
            }
            Color.BLUE -> {
                binding.customView.textViewColor.text = "Голубой"
                binding.customView.textViewColor.setTextColor(color)
                binding.customView.textViewColor.visibility = View.VISIBLE
            }
            Color.rgb(105, 0, 198) -> {
                binding.customView.textViewColor.text = "Фиолетовый"
                binding.customView.textViewColor.setTextColor(color)
                binding.customView.textViewColor.visibility = View.VISIBLE
            }
            Color.rgb(255, 165, 0) -> {
                Glide.with(binding.customView.imageView)
                    .load(getImage())
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(binding.customView.imageView)
                binding.customView.imageView.visibility = View.VISIBLE
            }
            Color.GREEN -> {
                Glide.with(binding.customView.imageView)
                    .load(getImage())
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(binding.customView.imageView)
                binding.customView.imageView.visibility = View.VISIBLE
            }
            Color.rgb(0, 77, 255) -> {
                Glide.with(binding.customView.imageView)
                    .load(getImage())
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(binding.customView.imageView)
                binding.customView.imageView.visibility = View.VISIBLE
            }

        }
    }

    private fun getImage(): String {
        val imageNumber = (Math.random() * images.size) - 1
        return images[imageNumber.toInt()]
    }
}