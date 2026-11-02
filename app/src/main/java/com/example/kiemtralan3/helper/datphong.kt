package com.example.kiemtralan3.helper

import com.example.kiemtralan3.model.loaiphong
import com.example.kiemtralan3.data.dulieumau

object datphong {
    fun timloaiphong(ma: String): loaiphong? {
        val macantim = ma.trim()
        return dulieumau.dsloaiphong.find { it.ma.equals(macantim, ignoreCase = true) }
    }
    fun hoplesokhach(loai: loaiphong, sokhach: Int): Boolean {
        return sokhach>=1 && sokhach<= (loai.succhua +2)
    }
    fun tinhtienphong_23115053122139(loai: loaiphong, sodem: Int,sokhach: Int): Long {
        if (sodem <1 || !hoplesokhach(loai, sokhach)) {
            return 0L
        }
        var tienphong = loai.giamotdem * sodem
        if (sodem >=4) {
            tienphong = (tienphong*85L)/100L
        }
        val soKhachVuot = if (sokhach > loai.succhua) (sokhach - loai.succhua) else 0
        val phuThu = soKhachVuot.toLong() * 150000L * sodem
        return tienphong + phuThu
    }
}