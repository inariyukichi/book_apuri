package com.example.book

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.search.SearchBar
import com.google.android.material.search.SearchView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val searchBar = findViewById<SearchBar>(R.id.search_bar)
        val searchView = findViewById<SearchView>(R.id.search_view)
        val switch = findViewById<MaterialButton>(R.id.janru)


        fun SwichWithgenre() {
            switch.setOnCheckedChangeListener { it, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "ジャンル", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "著者", Toast.LENGTH_SHORT).show()
                }
            }
        }

        searchView.setupWithSearchBar(searchBar)
        searchView.editText.setOnEditorActionListener { v, actionId, event ->
            searchBar.setText(searchView.text)
            searchView.hide()
            Toast.makeText(this, "検索: ${searchView.text}", Toast.LENGTH_SHORT).show()
            false
        }
    }
}