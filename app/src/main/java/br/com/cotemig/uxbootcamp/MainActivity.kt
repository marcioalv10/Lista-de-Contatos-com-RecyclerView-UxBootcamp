package br.com.cotemig.uxbootcamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
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

    private fun bindView() {

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }


    private fun updateList() {
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //return super.onCreateOptionsMenu(menu)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }


    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return super.onOptionsItemSelected(item)
        return when (item.itemId) {
            R.id.item_menu1 -> {
                showToast("Exibindo item de Menu 1")
                return true
            }
            R.id.item_menu2 -> {
                showToast("Exibindo item de Menu 2")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}