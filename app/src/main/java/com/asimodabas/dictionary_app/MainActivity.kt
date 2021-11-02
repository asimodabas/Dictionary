package com.asimodabas.dictionary_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   private lateinit var kelimelerListe:ArrayList<Kelimeler>
   private lateinit var adapter:KelimelerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title="Sözlük Uygulaması"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager=LinearLayoutManager(this)

        kelimelerListe=ArrayList()

        val k1=Kelimeler(1,"Dog","Köpek")
        val k2=Kelimeler(2,"Fish","Balık")
        val k3=Kelimeler(3,"Table","Masa")

        kelimelerListe.add(k1)
        kelimelerListe.add(k2)
        kelimelerListe.add(k3)

        adapter=KelimelerAdapter(this,kelimelerListe)

        rv.adapter=adapter
    }
}