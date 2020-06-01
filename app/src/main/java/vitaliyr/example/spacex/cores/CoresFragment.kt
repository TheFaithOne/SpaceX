package vitaliyr.example.spacex.cores

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import vitaliyr.example.spacex.CoreFilter
import vitaliyr.example.spacex.R
import vitaliyr.example.spacex.databinding.FragmentCoresBinding



class CoresFragment : Fragment() {
    private lateinit var viewModel: CoresViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentCoresBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_cores, container, false)

        setHasOptionsMenu(true)


        viewModel = CoresViewModel()

        val adapter = CoresAdapter()
        binding.coresRecycler.adapter = adapter

        viewModel.downloadFailed.observe(viewLifecycleOwner, Observer {
            if(it != null){
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        })

        viewModel.core.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it.toMutableList())
            }
        } )


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.cores_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.activeCores -> viewModel.getCores(CoreFilter.SHOW_ACTIVE)
            R.id.waterLanded -> viewModel.getLandedCores(CoreFilter.SHOW_LANDED)
            else -> viewModel.getCores(CoreFilter.SHOW_ALL)
        }
        return true
    }

}