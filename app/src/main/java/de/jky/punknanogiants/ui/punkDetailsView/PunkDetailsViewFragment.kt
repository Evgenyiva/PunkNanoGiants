package de.jky.punknanogiants.ui.punkDetailsView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import de.jky.punknanogiants.R
import de.jky.punknanogiants.databinding.FragmentPunkDetailsViewBinding
import de.jky.punknanogiants.ui.punkListView.PunkListViewViewModel

@AndroidEntryPoint
class PunkDetailsViewFragment : Fragment() {
    private var _binding: FragmentPunkDetailsViewBinding? = null
    private val binding get() = _binding!!

    private val navArgs: PunkDetailsViewFragmentArgs by navArgs()
    private val viewModel: PunkListViewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPunkDetailsViewBinding.inflate(inflater, container, false)
        initObserver()
        return binding.root
    }

    private fun initObserver() {
        try {
            val beer = viewModel.getById(navArgs.beerId)
            binding.beer = beer
            Glide
                .with(binding.root.context)
                .load(beer.image_url)
                .centerInside()
                .placeholder(R.drawable.loading_animated)
                .into(binding.beerImage)

        } catch (ex: Exception) {
            findNavController().navigateUp()
            Toast.makeText(requireContext(), ex.message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}