package com.example.exerme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.exerme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.EasyChip.setOnClickListener {
            Toast.makeText(this,
                    binding.EasyChip.text,
                    Toast.LENGTH_SHORT
            ).show()
        }
        binding.MediumChip.setOnClickListener {
            Toast.makeText(this,
                binding.MediumChip.text,
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.HardChip.setOnClickListener {
            Toast.makeText(this,
                binding.HardChip.text,
                Toast.LENGTH_SHORT
            ).show()
        }




        val nameQuiz = findViewById<TextView>(R.id.edtTextName)
        val emailQuiz = findViewById<TextView>(R.id.edtTextEmail)
        val buttonQuiz = findViewById<Button>(R.id.signUpButton)
        val intent = Intent(this, DashboardActivity::class.java)

        val preferences = getSharedPreferences("PREFERENCES", 0)

        val nameData = preferences.getString("nameQuiz", null)
        if (nameData != null) {
            startActivity(intent)
            finish()
        }

        buttonQuiz.setOnClickListener {
            val name = nameQuiz.text.toString()
            val email = emailQuiz.text.toString()

            val editor = preferences.edit()
            editor.putString("nameQuiz", name)
            editor.putString("emailQuiz", email)
            editor.apply()

            startActivity(intent)
            finish()
        }
    }
}