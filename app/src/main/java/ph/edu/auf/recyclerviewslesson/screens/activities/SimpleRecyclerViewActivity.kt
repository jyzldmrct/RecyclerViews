package ph.edu.auf.recyclerviewslesson.screens.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import ph.edu.auf.recyclerviewslesson.adapters.SimpleRVAdapter
import ph.edu.auf.recyclerviewslesson.databinding.ActivitySimpleRecyclerViewBinding
import ph.edu.auf.recyclerviewslesson.models.UsersModel

class SimpleRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleRecyclerViewBinding
    private lateinit var nameList: ArrayList<UsersModel>
    private lateinit var simpleAdapter: SimpleRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        nameList = arrayListOf(
            UsersModel("japhetong1",31,"japhet1@gmail.com",0),
            UsersModel("japhetong2",31,"japhet2@gmail.com",0),
            UsersModel("japhetong3",31,"japhet3@gmail.com",0),
            UsersModel("japhetong4",31,"japhet4@gmail.com",0),
            UsersModel("japhetong5",31,"japhet5@gmail.com",0),
        )

        val layoutManager = LinearLayoutManager(this)
        simpleAdapter = SimpleRVAdapter(nameList)
        binding.rvSimpleName.layoutManager = layoutManager
        binding.rvSimpleName.adapter = simpleAdapter

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                                target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val deletedName = nameList[position]

                nameList.removeAt(position)
                simpleAdapter.notifyItemRemoved(position)
//                Toast.makeText(this@SimpleRecyclerViewActivity,"Removed ${deletedName.username}",Toast.LENGTH_SHORT).show()

                Snackbar.make(binding.rvSimpleName,"Removed ${deletedName.username}", Snackbar.LENGTH_LONG)
                    .setAction("Undo") {
                        nameList.add(position, deletedName)
                        simpleAdapter.notifyItemInserted(position)
                    }.show()
            }

        }).attachToRecyclerView(binding.rvSimpleName)

    }
}