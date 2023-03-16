package com.example.exerme

import android.content.BroadcastReceiver
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.exerme.databinding.ActivityPreferencesBinding
import com.google.android.material.chip.Chip

class Preferences : AppCompatActivity() {


    private lateinit var binding: ActivityPreferencesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.EasyChip.setOnClickListener {
            Toast.makeText(
                this,
                binding.EasyChip.text,
                Toast.LENGTH_SHORT
            ).show()
        }

        choiceChip()
    }

    private fun choiceChip() {
        binding.IntensityChipGroup
            .setOnCheckedStateChangeListener { group, checkedIds ->
                val chip = group.findViewById<Chip>(checkedIds[0])
                if (chip != null) {
                    Toast.makeText(
                        this@Preferences, chip.text,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}
