package ph.edu.auf.recyclerviewslesson.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import ph.edu.auf.recyclerviewslesson.databinding.ContentSearchRvBinding
import ph.edu.auf.recyclerviewslesson.models.FruitsModel

class SearchRVAdapter(private var fruitlist: ArrayList<FruitsModel>) : RecyclerView.Adapter<SearchRVAdapter.SearchRVViewHolder>() {

    private val initialFruitList = ArrayList<FruitsModel>().apply {
        addAll(fruitlist)
    }

    inner class SearchRVViewHolder(val binding: ContentSearchRvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(fruit: FruitsModel) {
            binding.txtName.text = fruit.name
            binding.txtScientificName.text = fruit.scientificName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRVViewHolder {
        val binding = ContentSearchRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchRVViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return fruitlist.size
    }

    override fun onBindViewHolder(holder: SearchRVViewHolder, position: Int) {
        val fruit = fruitlist[position]
        holder.bind(fruit)
    }

    private val fruitFilter = object : Filter() {
        override fun performFiltering(p0: CharSequence?): FilterResults {
            val filteredList: ArrayList<FruitsModel> = ArrayList()
            if (p0.isNullOrEmpty()) {
                filteredList.addAll(initialFruitList)
            } else {
                val query = p0.toString().trim().uppercase()
                initialFruitList.forEach {
                    if (it.name.uppercase().contains(query)) {
                        filteredList.add(it)
                    }
                }
            }

            val result = FilterResults()
            result.values = filteredList
            return result
        }

        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
            if (p1?.values is ArrayList<*>) {
                fruitlist.clear()
                fruitlist.addAll(p1.values as ArrayList<FruitsModel>)
                notifyDataSetChanged()
            }
        }
    }

    fun getFilter(): Filter {
        return fruitFilter
    }
}