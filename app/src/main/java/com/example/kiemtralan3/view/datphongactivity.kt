package com.example.kiemtralan3.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kiemtralan3.R
import com.example.kiemtralan3.data.dulieumau
import com.example.kiemtralan3.model.loaiphong
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.example.kiemtralan3.helper.datphong
import androidx.core.widget.doAfterTextChanged
class datphongactivity : AppCompatActivity() {

    private lateinit var tilHoTen: TextInputLayout
    private lateinit var tilSdt: TextInputLayout
    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilNgayNhan: TextInputLayout
    private lateinit var tilSoDem: TextInputLayout
    private lateinit var tilSoKhach: TextInputLayout

    private lateinit var edtHoTen: TextInputEditText
    private lateinit var edtSdt: TextInputEditText
    private lateinit var edtEmail: TextInputEditText
    private lateinit var edtNgayNhan: TextInputEditText
    private lateinit var edtSoDem: TextInputEditText
    private lateinit var edtSoKhach: TextInputEditText

    private lateinit var txtLoaiPhong: TextView
    private lateinit var txtTamTinh: TextView
    private lateinit var btnDatPhong: MaterialButton

    private var loaiphongdangchon: loaiphong = dulieumau.dsloaiphong[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datphong)
        anhXaView()
        hienThiLoaiPhong()
        edtSoDem.doAfterTextChanged { capNhatTamTinh() }
        edtSoKhach.doAfterTextChanged { capNhatTamTinh() }

    }

    private fun anhXaView() {
        tilHoTen = findViewById(R.id.tilHoTen)
        tilSdt = findViewById(R.id.tilSdt)
        tilEmail = findViewById(R.id.tilEmail)
        tilNgayNhan = findViewById(R.id.tilNgayNhan)
        tilSoDem = findViewById(R.id.tilSoDem)
        tilSoKhach = findViewById(R.id.tilSoKhach)

        edtHoTen = findViewById(R.id.edtHoTen)
        edtSdt = findViewById(R.id.edtSdt)
        edtEmail = findViewById(R.id.edtEmail)
        edtNgayNhan = findViewById(R.id.edtNgayNhan)
        edtSoDem = findViewById(R.id.edtSoDem)
        edtSoKhach = findViewById(R.id.edtSoKhach)

        txtLoaiPhong = findViewById(R.id.txtLoaiPhong)
        txtTamTinh = findViewById(R.id.txtTamTinh)
        btnDatPhong = findViewById(R.id.btnDatPhong)
    }

    private fun hienThiLoaiPhong() {
        txtLoaiPhong.text = "${loaiphongdangchon.ten} - Giá: ${loaiphongdangchon.giamotdem}"
    }
    private fun capNhatTamTinh() {
        val soDem = edtSoDem.text?.toString()?.trim()?.toIntOrNull() ?: 0
        val soKhach = edtSoKhach.text?.toString()?.trim()?.toIntOrNull() ?: 0
        val tien = datphong.tinhtienphong_23115053122139(loaiphongdangchon, soDem, soKhach)
        txtTamTinh.text = "Tạm tính: $tien"
    }
}