package ph.edu.auf.recyclerviewslesson.screens.activities

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ph.edu.auf.recyclerviewslesson.databinding.ActivityInfiniteScrollRecyclerViewBinding
import ph.edu.auf.recyclerviewslesson.models.CounterModel

class InfiniteScrollRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfiniteScrollRecyclerViewBinding
    private lateinit var counterList : ArrayList<CounterModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfiniteScrollRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        counterList = arrayListOf(
//            CounterModel(1),
//            CounterModel(2),
//            CounterModel(3),
//            CounterModel(4),
//            CounterModel(5)
//        )

    }
}