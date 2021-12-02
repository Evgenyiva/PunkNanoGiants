package de.jky.punknanogiants.ui.punkListView.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.jky.punknanogiants.R
import de.jky.punknanogiants.data.beer.BeerEntity
import de.jky.punknanogiants.databinding.BeerListItemBinding
import de.jky.punknanogiants.ui.punkListView.PunkListViewFragmentDirections

class BeerListAdapter : ListAdapter<BeerEntity, RecyclerView.ViewHolder>(BeersDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BeerListViewHolder(
            BeerListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BeerListViewHolder).bind(getItem(position))
    }

    inner class BeerListViewHolder(
        private val binding: BeerListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.beer?.let { beer ->
                    navigateToDetails(beer, it)
                }
            }
        }

        private fun navigateToDetails(beerEntity: BeerEntity, view: View) {
            val direction =
                PunkListViewFragmentDirections.actionPunkListViewFragmentToPunkDetailsView(
                    beerEntity.id
                )
            view.findNavController().navigate(direction)
        }

        fun bind(beerEntity: BeerEntity) {
            binding.apply {
                beer = beerEntity
                executePendingBindings()

                beerEntity.image_url?.let {
                    Glide
                        .with(binding.root.context)
                        .load(it)
                        .placeholder(R.drawable.loading_animated)
                        .into(binding.imageView)
                }
            }
        }
    }
}

private class BeersDiffCallback : DiffUtil.ItemCallback<BeerEntity>() {
    override fun areItemsTheSame(oldItem: BeerEntity, newItem: BeerEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BeerEntity, newItem: BeerEntity): Boolean {
        return oldItem == newItem
    }
}