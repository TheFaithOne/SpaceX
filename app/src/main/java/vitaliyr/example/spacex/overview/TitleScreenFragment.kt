package vitaliyr.example.spacex.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import vitaliyr.example.spacex.R
import vitaliyr.example.spacex.databinding.FragmentTitleScreenBinding



/**
 * A simple [Fragment] subclass.
 * Use the [TitleScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleScreenFragment : Fragment() {

    private lateinit var viewModel: TitleScreenViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTitleScreenBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_title_screen, container, false)

        viewModel = ViewModelProvider(this).get(TitleScreenViewModel::class.java)

        viewModel.getCompanyInfo()

        //binding.spacexLogo.setImageResource(viewModel.spacexLogo)

        binding.buttonMissions.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_missionsScreenFragment)
        )

        viewModel.companyInfo.observe(viewLifecycleOwner, Observer {companyInfo ->
            binding.companyInfo.text = companyInfo.summary
            binding.linksTextView.text = companyInfo.links.toString()
        })

        return binding.root
    }

}