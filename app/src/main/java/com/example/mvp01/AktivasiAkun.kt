package com.example.mvp01

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.doOnTextChanged
import com.example.mvp01.databinding.ActivityAktivasiAkunBinding

class AktivasiAkun : AppCompatActivity(), MainPresenter, Notifikasi{
    private lateinit var binding : ActivityAktivasiAkunBinding
    private val presenter = ValidasiAktivasiAkun()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAktivasiAkunBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.idUser.doOnTextChanged { text, start, before, count ->
            tombolSelanjutnya()
        }

        binding.konfirmasiSandi.doOnTextChanged { text, start, before, count ->
            tombolSelanjutnya()
        }

        binding.selanjutnya.setOnClickListener {
//            val konfirmasi = presenter.validasiKonfirmasiPassword(binding.kataSandi.text.toString(), binding.konfirmasiSandi.text.toString())
            presenter.validasiKonfirmasiPassword(binding.kataSandi.text.toString(), binding.konfirmasiSandi.text.toString())
//            println(konfirmasi)
//            if (konfirmasi == true) startActivity(Intent(this,))
        }
    }

    override fun addData(rekening: String, username: String) {
        TODO("Not yet implemented")
    }

    override fun loadData() {
        TODO("Not yet implemented")
    }

    override fun sukses() {
        Toast.makeText(this, "Login sukses", Toast.LENGTH_SHORT).show()
    }

    override fun gagal(pesan: String) {
        AlertDialog.Builder(this)
            .setMessage(pesan)
            .setPositiveButton("Ok", this::dialogClickListener)
            .setNegativeButton("Cancel", this::dialogClickListener)
            .create()
            .show()
    }

    private fun dialogClickListener(dialogInterface: DialogInterface, button: Int) {
        when (button) {
            DialogInterface.BUTTON_NEGATIVE -> {}
            DialogInterface.BUTTON_POSITIVE -> {}
            DialogInterface.BUTTON_NEUTRAL -> {}
        }
    }

    private fun tombolSelanjutnya() {
        binding.selanjutnya.isEnabled = presenter.validasiUsername(binding.idUser.text.toString()) &&
                presenter.validasiPanjangPassword(binding.konfirmasiSandi.text.toString())
    }


}