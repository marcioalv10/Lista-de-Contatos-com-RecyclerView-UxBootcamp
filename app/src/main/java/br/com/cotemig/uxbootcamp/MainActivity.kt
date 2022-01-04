package br.com.cotemig.uxbootcamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val rvList: RecyclerView by lazy {
        findViewById(R.id.rv_list)
    }

    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindView()
        updateList()
    }

    private fun bindView(){

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }


    private fun updateList(){
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Marcio",
                    "33211-2122",
                    "img.jpg"
                ),
                Contact(
                    "Kellen ",
                    "33211-2122",
                    "img.jpg"
                ),
                Contact(
                    "Helen ",
                    "33211-2122",
                    "img.jpg"
                ),
                Contact(
                    "Geise ",
                    "33211-2122",
                    "img.jpg"
                ),
                Contact(
                    "Lorrayne ",
                    "33211-2122",
                    "img.jpg"
                ),
                Contact(
                    "Tania ",
                    "33211-2122",
                    "img.jpg"
                ),
                Contact(
                    "Samuel ",
                    "33211-2122",
                    "img.jpg"
                ),
                Contact(
                    "Kleber ",
                    "33211-2122",
                    "img.jpg"
                ),
                Contact(
                    "Thiago ",
                    "33211-2122",
                    "img.jpg"
                ),
                Contact(
                    "Moacir ",
                    "33211-2122",
                    "img.jpg"
                ),
                Contact(
                    "Katia ",
                    "33211-2122",
                    "img.jpg"
                ),
                Contact(
                    "Jussara ",
                    "33211-2122",
                    "img.jpg"
                )



            )
        )
    }
}