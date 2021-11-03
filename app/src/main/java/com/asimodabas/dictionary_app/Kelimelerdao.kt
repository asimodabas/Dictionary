package com.asimodabas.dictionary_app

import android.annotation.SuppressLint

class Kelimelerdao {

    @SuppressLint("Range")
    fun tumKelimeler(vt: VeritabaniYardimcisi): ArrayList<Kelimeler> {

        val kelimelerListe = ArrayList<Kelimeler>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM kelimeler", null)

        while (c.moveToNext()) {
            val kelime = Kelimeler(
                c.getInt(c.getColumnIndex("kelime_id")),
                c.getString(c.getColumnIndex("ingilizce")),
                c.getString(c.getColumnIndex("turkce"))
            )
            kelimelerListe.add(kelime)
        }
        return kelimelerListe
    }
    @SuppressLint("Range")
    fun aramaYap(vt: VeritabaniYardimcisi, aramaKelime:String): ArrayList<Kelimeler> {

        val kelimelerListe = ArrayList<Kelimeler>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '½$aramaKelime'", null)

        while (c.moveToNext()) {
            val kelime = Kelimeler(
                c.getInt(c.getColumnIndex("kelime_id")),
                c.getString(c.getColumnIndex("ingilizce")),
                c.getString(c.getColumnIndex("turkce"))
            )
            kelimelerListe.add(kelime)
        }
        return kelimelerListe
    }

}