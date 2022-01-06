package br.com.cotemig.uxbootcamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ContactDetail : AppCompatActivity() {

    private var contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        initToolbar()
        getExtras()
        bindViews()
    }

    private fun initToolbar(){
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        //setActionBar(toolbar)
        setSupportActionBar(toolbar)
    }

    private fun getExtras(){
            contact = intent.getParcelableExtra(EXTRA_CONTACT)
    }

    //Método para setas os dados na tela
    private fun bindViews(){
        findViewById<TextView>(R.id.tv_nome).text = contact?.name
        findViewById<TextView>(R.id.tv_telefone).text = contact?.phone

    }

    companion object{
        const val EXTRA_CONTACT: String = "EXTRA_CONTACT"
    }
}