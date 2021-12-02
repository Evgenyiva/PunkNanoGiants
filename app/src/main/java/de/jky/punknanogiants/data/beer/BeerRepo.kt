package de.jky.punknanogiants.data.beer

import android.util.Log
import androidx.lifecycle.LiveData
import javax.inject.Inject

class BeerRepo @Inject constructor(
    private val beerDao: BeerDao,
    private val apiService: ApiService
) {
    val list: LiveData<List<BeerEntity>> = beerDao.getAllAsync()

    suspend fun fetchAllFromServer() {
        try {
            apiService.getBeers().body()?.let {
                saveToLocalStorage(it)
            }
        } catch (ex: Exception) {
            Log.e(this.javaClass.simpleName, ex.message.toString(), ex)
        }
    }

    private fun saveToLocalStorage(beers: List<BeerEntity>) {
        if (list.value?.equals(beers) == true) return

        beers.forEach { beerDao.put(it) }
    }

    fun getById(beerId: Long): BeerEntity {
        return list.value?.first { it.id == beerId } ?: throw IllegalStateException("BeerEntity cannot be null!")
    }
}