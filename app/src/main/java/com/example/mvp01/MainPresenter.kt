package com.example.mvp01

interface MainPresenter {
    // untuk menambahkan data
    fun addData (rekening: String, username: String)
    // menampilkan data
    fun loadData ()
}