package ph.edu.auf.recyclerviewslesson.screens.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import ph.edu.auf.recyclerviewslesson.databinding.ActivitySimpleSearchRecyclerViewBinding
import ph.edu.auf.recyclerviewslesson.models.FruitsModel
import ph.edu.auf.recyclerviewslesson.adapters.SearchRVAdapter

class SimpleSearchRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleSearchRecyclerViewBinding
    private lateinit var adapter: SearchRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleSearchRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fruitList = arrayListOf(
            FruitsModel("Mango", "Mangifera indica"),
            FruitsModel("Apple", "Pyrus malus"),
            FruitsModel("Pomegranate", "Punica granatum"),
            FruitsModel("Pineapple", "Ananus sativus"),
            FruitsModel("Orange", "Citrus aurantium"),
            FruitsModel("Strawberry", "Fragaria × ananassa"),
            FruitsModel("Sweet Potato", "Ipomoea batatas"),
            FruitsModel("Watermelon", "Citrullus lanatus")
        )

        adapter = SearchRVAdapter(fruitList)
        val layoutManager = LinearLayoutManager(this)
        binding.rvSearchable.adapter = adapter
        binding.rvSearchable.layoutManager = layoutManager

        binding.edtSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.getFilter().filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        }
        )
    }
}