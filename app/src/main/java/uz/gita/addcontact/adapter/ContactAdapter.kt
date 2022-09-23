package uz.gita.addcontact.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.gita.addcontact.R
import uz.gita.addcontact.data.Contact
import uz.gita.addcontact.utils.ContactDiffUtil

class ContactAdapter() : RecyclerView.Adapter<ContactAdapter.VH>() {
    val list = ArrayList<Contact>()
    fun submitList(list: ArrayList<Contact>) {
        val diffUtil = ContactDiffUtil(this.list, list)
        val calculate = DiffUtil.calculateDiff(diffUtil)
        this.list.clear()
        this.list.addAll(list)
        calculate.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name_tv)
        val phone = itemView.findViewById<TextView>(R.id.phone_tv)
        fun onBind(position: Int) {
            name.text = list[position].name
            phone.text = list[position].number
        }
    }
}