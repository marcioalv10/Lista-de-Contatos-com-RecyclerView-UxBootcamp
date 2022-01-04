package br.com.cotemig.uxbootcamp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    //Atributo de classe onde vai armazenar a lista de Contatos
    private val list: MutableList<Contact> = mutableListOf()

    //Cria cada item visual na tela
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view)
    }

    //Roda em cada item do array, obtem e preenche o item na tela
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    //Quantidade de itens que existe na Lista
    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(lista: List<Contact>) {
        this.list.clear()
        this.list.addAll(lista)

        //Notifica o Adapter q a lista q ele utiliza foi modificada
        notifyDataSetChanged()
    }

    //classe responsável por gerenciar cada item do array
    class ContactAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvNome: TextView = itemView.findViewById(R.id.tv_name)
        private val tvPhone: TextView = itemView.findViewById(R.id.tv_telefone)
        private val ivPhoto: ImageView = itemView.findViewById(R.id.image_view_photograph)

        //Método que popula os dados
        fun bind(contact: Contact) {
            tvNome.text = contact.name
            tvPhone.text = contact.phone
        }
    }

}