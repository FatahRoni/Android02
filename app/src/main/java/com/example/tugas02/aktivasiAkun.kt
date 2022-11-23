package com.example.tugas02

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas02.databinding.AktivasiAkunBinding
import com.example.tugas02.databinding.LoginBinding

class aktivasiAkun : AppCompatActivity() {
//    companion object {
//        private const val DATA_USER = "Username"
//        fun getIntent (context: Context, userName : String): Intent {
//            return Intent (context,aktivasiAkun::class.java).apply {
//                putExtra(DATA_USER, userName)
//            }
//        }
//    }
    private lateinit var binding : AktivasiAkunBinding
    private val userID: String get() = binding.pengguna.text.toString()
    private val userRek: String get() = binding.rekUser.text.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AktivasiAkunBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.rekening.setText(intent.getStringExtra(DATA_USER))

                // membuat logic setelah user menekan tombol selanjutnya
        binding.aktivasiAkunDone.setOnClickListener {
            startActivity(Intent(this@aktivasiAkun,MainActivity::class.java)
                .putExtra("IdUser",userID).putExtra("IdRek",userRek))

        }
    }
}