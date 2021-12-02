package de.jky.punknanogiants.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.jky.punknanogiants.data.beer.BeerDao
import de.jky.punknanogiants.data.beer.BeerEntity
import de.jky.punknanogiants.data.beer.RequestConverters

@Database(
    entities = [
        BeerEntity::class
    ],
    version = 1
)

@TypeConverters(RequestConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun beerDao(): BeerDao

    companion object {
        @Volatile
        private var dbInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return dbInstance ?: synchronized(this) {
                dbInstance ?: buildDatabase(context).also { dbInstance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "database.db")
                .build()
        }
    }
}