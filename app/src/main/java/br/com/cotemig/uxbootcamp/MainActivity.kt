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
import br.com.cotemig.uxbootcamp.ContactDetail.Companion.EXTRA_CONTACT
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
                    "99555-2122",
                    "img.jpg"
                ),
                Contact(
                    "Helen ",
                    "88888-8888",
                    "img.jpg"
                ),
                Contact(
                    "Geise ",
                    "54585-5544",
                    "img.jpg"
                ),
                Contact(
                    "Lorrayne ",
                    "35522-1542",
                    "img.jpg"
                ),
                Contact(
                    "Tania ",
                    "85545-6355",
                    "img.jpg"
                ),
                Contact(
                    "Samuel ",
                    "955598-1544",
                    "img.jpg"
                ),
                Contact(
                    "Kleber ",
                    "99888-5455",
                    "img.jpg"
                ),
                Contact(
                    "Thiago ",
                    "99887-7848",
                    "img.jpg"
                ),
                Contact(
                    "Moacir ",
                    "99988-1222",
                    "img.jpg"
                ),
                Contact(
                    "Katia ",
                    "888777-2122",
                    "img.jpg"
                ),
                Contact(
                    "Jussara ",
                    "66884-2157",
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
        //Método chave-valor para enviar os dados através de telas android
        intent.putExtra(EXTRA_CONTACT, contact)
        startActivity(intent)
    }


}