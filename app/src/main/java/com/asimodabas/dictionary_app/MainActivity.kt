package com.asimodabas.dictionary_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var kelimelerListe: ArrayList<Kelimeler>
    private lateinit var adapter: KelimelerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veritabaniKopyala()

        toolbar.title = "Dictionary App"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        kelimelerListe = ArrayList()

        val k1 = Kelimeler(1, "Dog", "Köpek")
        val k2 = Kelimeler(2, "Fish", "Balık")
        val k3 = Kelimeler(3, "Table", "Masa")

        kelimelerListe.add(k1)
        kelimelerListe.add(k2)
        kelimelerListe.add(k3)

        adapter = KelimelerAdapter(this, kelimelerListe)

        rv.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        val item = menu?.findItem(R.id.action_ara)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {

        if (query != null) {
            Log.e("Gönderilen arama", query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {

        if (newText != null) {
            Log.e("Harf girdikçe", newText)
        }
        return true
    }

    fun veritabaniKopyala() {

        val copyHelper = DatabaseCopyHelper(this)
        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()

        } catch (e: Exception) {
            e.printStackTrace()

        }
    }

}