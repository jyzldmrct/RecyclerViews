package ph.edu.auf.recyclerviewslesson.screens.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ph.edu.auf.recyclerviewslesson.R
import ph.edu.auf.recyclerviewslesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInfiniteScroll.setOnClickListener(this)
        binding.btnRvWithSimpleSearch.setOnClickListener(this)
        binding.btnTwoViews.setOnClickListener(this)
        binding.btnSimpleRecyclerView.setOnClickListener(this)
        binding.btnSimpleRecyclerViewFragments.setOnClickListener(this)
        binding.btnRvVm.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            binding.btnSimpleRecyclerView.id ->{
                val intent = Intent(this,SimpleRecyclerViewActivity::class.java)
                startActivity(intent)
            }
            binding.btnSimpleRecyclerViewFragments.id -> {

            }
            binding.btnTwoViews.id -> {

            }
            binding.btnRvWithSimpleSearch.id -> {
                val intent = Intent(this,SimpleSearchRecyclerViewActivity::class.java)
                startActivity(intent)

            }
            binding.btnInfiniteScroll.id -> {

            }
            binding.btnRvVm.id -> {

            }
        }
    }
}