package com.example.mvp01

class ValidasiAktivasiAkun {
    private var notif : Notifikasi? = null
    fun onAttach(view: Notifikasi) {
        this.notif = view
    }

    fun onDetach() {
        this.notif = null
    }

    fun validasiUsername (username: String): Boolean{
        var validasi = false
        if (username.length >= 10 && username.length <= 30) validasi = true
        return validasi
    }

    fun validasiPanjangPassword (password: String): Boolean{
        var validasi = false
        if (password.length >= 8 && password.length <= 10) validasi = true
        return validasi
    }

    fun validasiKonfirmasiPassword (password: String, konfirmasiPassword : String) {
        if (password.equals(konfirmasiPassword) == false)   notif?.gagal("Kata sandi tidak sama")
        else    notif?.sukses()
    }
}