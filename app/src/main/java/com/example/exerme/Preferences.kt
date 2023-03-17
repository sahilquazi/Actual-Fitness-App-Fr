package com.example.exerme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exerme.databinding.ActivityPreferencesBinding
import com.google.android.material.chip.Chip

class Preferences : AppCompatActivity() {

    companion object {
        var difficultyMode = "Insert Chip Selection"
    }


    private lateinit var binding: ActivityPreferencesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val finishPreferences = findViewById<Button>(R.id.GotoDashboardButton)
        finishPreferences.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }


        binding = ActivityPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.EasyChip.setOnClickListener {
            Toast.makeText(
                this,
                binding.EasyChip.text,
                Toast.LENGTH_SHORT
            ).show()
            difficultyMode = "easy"
        }


        binding.MediumChip.setOnClickListener {
            Toast.makeText(
                this,
                binding.MediumChip.text,
                Toast.LENGTH_SHORT
            ).show()
            difficultyMode = "medium"
        }



        binding.HardChip.setOnClickListener {
            Toast.makeText(
                this,
                binding.HardChip.text,
                Toast.LENGTH_SHORT
            ).show()
            difficultyMode = "hard"
        }

        choiceChip()
    }

        val Finish_Preferences = findViewById<Button>(R.id.GotoDashboardButton)
        Finish_Preferences.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
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
