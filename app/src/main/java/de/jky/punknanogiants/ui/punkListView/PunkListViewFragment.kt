package de.jky.punknanogiants.ui.punkListView

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import de.jky.punknanogiants.databinding.FragmentPunkListViewBinding
import de.jky.punknanogiants.ui.punkListView.adapter.BeerListAdapter

@AndroidEntryPoint
class PunkListViewFragment : Fragment() {
    private var _binding: FragmentPunkListViewBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PunkListViewViewModel by viewModels()

    private val adapter = BeerListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPunkListViewBinding.inflate(inflater, container, false)

        initAdapter()

        return binding.root
    }

    private fun initAdapter() {
        binding.beerListview.adapter = adapter
        viewModel.getList().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}