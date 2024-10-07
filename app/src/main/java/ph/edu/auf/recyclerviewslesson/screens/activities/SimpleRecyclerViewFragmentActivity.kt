package ph.edu.auf.recyclerviewslesson.screens.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ph.edu.auf.recyclerviewslesson.databinding.ActivitySimpleRecyclerViewFragmentBinding
import ph.edu.auf.recyclerviewslesson.screens.fragments.SimpleRecyclerViewFragment

class SimpleRecyclerViewFragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleRecyclerViewFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleRecyclerViewFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(binding.fragContainer.id, SimpleRecyclerViewFragment())
        fragmentManager.commit()
    }
}