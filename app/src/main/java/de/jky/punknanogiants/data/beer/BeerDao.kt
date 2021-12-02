package de.jky.punknanogiants.data.beer

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BeerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun put(beer: BeerEntity)

    @Query("SELECT * FROM beers")
    fun getAllAsync(): LiveData<List<BeerEntity>>

    @Query("SELECT * FROM beers WHERE id = :id")
    fun getByIdAsync(id: Long): LiveData<BeerEntity>
}