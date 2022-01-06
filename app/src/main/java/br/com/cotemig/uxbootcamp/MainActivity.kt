    package br.com.cotemig.uxbootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), ClickItemContactListener{

    private val rvList: RecyclerView by lazy {
        findViewById(R.id.rv_list)
    }

    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        initDrawer()
        bindView()
        updateList()
    }

    //inicialização do Drawer Layout
    private fun initDrawer (){
        val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)

        //setActionBar(toolbar)

       setSupportActionBar(toolbar)

        //Evento de Abrir e fechar o Drawer layout
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)

        /*teste na implementação de clique no Drawer
       drawerLayout.setOnClickListener {
          when () {

          }
        }
        */


        toggle.syncState()


        //Adicionando a captura do clique nos itens Draw Menu
        val navView: NavigationView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener {
          //  it.isChecked = true
             when(it.itemId) {
                R.id.item_menu1 -> {
                    showToast("Aeeee Menu 1")
                    return@setNavigationItemSelectedListener true
                }
                 R.id.item_menu2 -> {
                     showToast("Aeeee Menu 2")
                     return@setNavigationItemSelectedListener true
                 }
                 else -> {

                 return@setNavigationItemSelectedListener true
             }
            }

        }


    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
       // return super.onContextItemSelected(item)
        return when (item.itemId) {
            R.id.item_menu1 -> {
                showToast("Exibindo item de Menu Draw 1")
                return true
            }
            R.id.item_menu2 -> {
                showToast("Exibindo item de Menu Draw 2")
                return true
            }
            else -> super.onContextItemSelected(item)
        }



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

    override fun clickItemcontact(contact: Contact) {
        var intent = Intent(this, ContactDetail::class.java)
        startActivity(intent)
    }


}