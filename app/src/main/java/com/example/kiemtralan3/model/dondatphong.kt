package com.example.kiemtralan3.model

import  java.io.Serializable

data class (
    val Hoten: String,
    val sdt: String,
    val email: String,
    val maloaiphong: String,
    val ngaynhan: String,
    val sodem: Int,
    val sokach: Int,
    val ghichu: String = "khong co"
): Serializable {
    fun tomtat(): String {
        return "$Hoten - $maloaiphong - $ngaynhan - $sodem đêm"
    }
}
