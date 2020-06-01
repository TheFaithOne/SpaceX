package vitaliyr.example.spacex.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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

        viewModel.downloadFailed.observe(viewLifecycleOwner, Observer {
            if(it != null){
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        })


        viewModel.companyInfo.observe(viewLifecycleOwner, Observer {companyInfo ->
            binding.companyInfo.text = companyInfo.summary
            binding.linksTextView.text = companyInfo.links.toString()
        })

        return binding.root
    }

}