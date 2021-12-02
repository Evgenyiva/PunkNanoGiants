package de.jky.punknanogiants.data.beer

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BeerDao {
    @Insert
    fun put(beer: BeerEntity)

    @Query("SELECT * FROM beers")
    fun getAll(): List<BeerEntity>

    @Query("SELECT * FROM beers WHERE id = :id")
    fun getById(id: Long): BeerEntity
}