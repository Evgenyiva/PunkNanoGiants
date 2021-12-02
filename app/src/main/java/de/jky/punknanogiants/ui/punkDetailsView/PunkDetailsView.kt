package de.jky.punknanogiants.ui.punkDetailsView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.jky.punknanogiants.databinding.FragmentPunkDetailsViewBinding

class PunkDetailsView : Fragment() {
    private var _binding: FragmentPunkDetailsViewBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPunkDetailsViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}