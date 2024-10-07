package ph.edu.auf.recyclerviewslesson.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ph.edu.auf.recyclerviewslesson.databinding.ContentSimpleRvBinding
import ph.edu.auf.recyclerviewslesson.models.UsersModel

class SimpleRVAdapter(private var nameList: ArrayList<UsersModel>) : RecyclerView.Adapter<SimpleRVAdapter.SimpleRVViewHolder>() {
    private val TAG = SimpleRVAdapter::class.java.simpleName

    inner class SimpleRVViewHolder(val binding: ContentSimpleRvBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(binding: ContentSimpleRvBinding){
            binding.llCardView.setOnClickListener{
                val user = nameList[adapterPosition]
                Log.d(TAG,user.username)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleRVViewHolder {
        val binding = ContentSimpleRvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SimpleRVViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: SimpleRVViewHolder, position: Int) {
        with(holder){
            holder.bind(holder.binding)
//            val data = nameList[position]
//            binding.txtAge.text = data.age.toString()
            with(nameList[position]){
                binding.txtAge.text = this.age.toString()
                binding.txtName.text = this.username
                binding.txtEmail.text = this.email
            }
        }
    }

}