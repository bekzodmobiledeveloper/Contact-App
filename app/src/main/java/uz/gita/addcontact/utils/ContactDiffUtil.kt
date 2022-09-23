package uz.gita.addcontact.utils

import androidx.recyclerview.widget.DiffUtil
import uz.gita.addcontact.data.Contact

class ContactDiffUtil(
    private val oldList: ArrayList<Contact>,
    private val newList: ArrayList<Contact>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}