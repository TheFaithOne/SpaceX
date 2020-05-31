package vitaliyr.example.spacex.missions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import vitaliyr.example.spacex.R
import vitaliyr.example.spacex.databinding.FragmentMissionsScreenBinding


/**
 * A simple [Fragment] subclass.
 * Use the [MissionsScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MissionsScreenFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding: FragmentMissionsScreenBinding = DataBindingUtil
           .inflate(inflater, R.layout.fragment_missions_screen, container, false)

        val adapter = MissionsAdapter()
        binding.missionsList.adapter = adapter

        return binding.root
    }

}