package de.jky.punknanogiants.ui.punkListView

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.jky.punknanogiants.data.beer.BeerEntity
import de.jky.punknanogiants.data.beer.BeerRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class PunkListViewViewModel @Inject constructor(
    private val beerRepo: BeerRepo
) : ViewModel() {

    fun fetch() {
        runBlocking(Dispatchers.IO) {
            beerRepo.fetchAllFromServer()
        }
    }

    fun getList() = beerRepo.list

    @Throws
    fun getById(beerId: Long) = beerRepo.getById(beerId)

}