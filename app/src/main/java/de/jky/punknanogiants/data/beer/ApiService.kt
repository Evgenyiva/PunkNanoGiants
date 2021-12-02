package de.jky.punknanogiants.data.beer

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("beers")
    suspend fun getBeers(): Response<List<BeerEntity>>
}