package com.example.world_sinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.world_sinema.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Register"

        auth = FirebaseAuth.getInstance()

        // Обработчик нажатия на кнопку для возврата к экрану входа
        binding.button2.setOnClickListener {
            startActivity(Intent(this, AuthorizationActivity::class.java))
            finish()
        }

        // Обработчик нажатия на кнопку регистрации
        binding.button.setOnClickListener {
            val email = binding.editeEmail.text.toString()
            val password = binding.editPassword.text.toString()
            val name = binding.editName.text.toString()
            val surname = binding.editSurname.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()&&name.isNotEmpty() && surname.isNotEmpty()   ) {
                registerUser(email, password,name, surname)
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerUser(email: String, password: String, name: String, surname: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, AuthorizationActivity::class.java))
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(this, exception.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }
}