package de.jky.punknanogiants.ui.punkListView

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.jky.punknanogiants.data.beer.BeerRepo
import javax.inject.Inject

@HiltViewModel
class PunkListViewViewModel @Inject constructor(
    private val beerRepo: BeerRepo
) : ViewModel() {

    fun fetch() = beerRepo.fetchAllFromServer()
}