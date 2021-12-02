package de.jky.punknanogiants.data.beer

import android.util.Log
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import javax.inject.Inject

class BeerRepo @Inject constructor(
    private val beerDao: BeerDao,
    private val apiService: ApiService
) {
    private val _cachedList: MutableList<BeerEntity> = mutableListOf()
    private val list get() = _cachedList.toList()

    fun loadAll() {
        _cachedList.addAll(beerDao.getAll())
    }

    fun fetchAllFromServer() {
        try {
            val beers = runBlocking { apiService.getBeers().body() }
        } catch (ex: Exception) {
            Log.e(this.javaClass.simpleName, ex.message.toString(), ex)
        }
    }
}