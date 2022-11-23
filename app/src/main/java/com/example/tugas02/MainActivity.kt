package com.example.tugas02

import android.content.Intent
import android.content.Intent.getIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.example.tugas02.databinding.LoginBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : LoginBinding
    private val usernametext: String get() = binding.edtUsername.text.toString()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inflate layout ke binding
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMasuk.setOnClickListener {
            Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show()
        }

        binding.edtUsername.doOnTextChanged { _, _, _,_  ->
        validate()
        }
        binding.edtPassword.doOnTextChanged { _, _, _,_  ->
            validate()
        }

        binding.lupaPassword.setOnClickListener {
            startActivity(
                Intent(this@MainActivity,aktivasiAkun::class.java)
            )
//            val intent = Intent(this, aktivasiAkun::class.java)
//            startActivity(intent)

        }

        if (intent.getStringExtra("IdUser")?.isNotBlank() == true){
            binding.frameLayout.isVisible = true
            binding.nameOfUser.text = intent.getStringExtra("IdUser")
            binding.rekUser.text = intent.getStringExtra("IdRek")
        }else
            binding.frameLayout.isVisible = false
    }

    private fun validate(){
        binding.btnMasuk.isEnabled =
            binding.edtUsername.text.toString().isNotBlank() && binding.edtPassword.text.toString().isNotBlank()
                    && ispasswordvalid
    }

    private val ispasswordvalid: Boolean get() {
        val passText = binding.edtPassword.text.toString()

        val isvalid = passText.contains("[a-z]".toRegex())
                && passText.contains("[A-Z]".toRegex())
                && passText.contains("[0-9]".toRegex())
                && passText.length >= 8

        binding.notesPassword.isInvisible = isvalid

        return isvalid
    }

}