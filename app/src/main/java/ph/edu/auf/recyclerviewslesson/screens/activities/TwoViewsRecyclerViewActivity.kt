package ph.edu.auf.recyclerviewslesson.screens.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ph.edu.auf.recyclerviewslesson.databinding.ActivityTwoViewsRecyclerViewBinding
import ph.edu.auf.recyclerviewslesson.models.UsersModel

class TwoViewsRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwoViewsRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwoViewsRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameList = arrayListOf(
            UsersModel("juandelacruz",30,"juandelacruz@gmail.com",0),
            UsersModel("juandelacruz2",31,"juandelacruz2@gmail.com",1,"123 somewhere rd, PH"),
            UsersModel("juandelacruz3",32,"juandelacruz3@gmail.com",0),
            UsersModel("juandelacruz4",33,"juandelacruz4@gmail.com",1, "456 somewhere rd, PH"),
            UsersModel("juandelacruz5",34,"juandelacruz5@gmail.com",0),
            UsersModel("juandelacruz6",35,"juandelacruz6@gmail.com",1, "789 somewhere rd, PH")
        )
    }
}