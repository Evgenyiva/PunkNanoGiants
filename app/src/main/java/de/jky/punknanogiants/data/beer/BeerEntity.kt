package de.jky.punknanogiants.data.beer

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "beers")
data class BeerEntity(
    @PrimaryKey
    val id: Long,
    val name: String?,
    val tagline: String?,
    val firstBrewed: String?,
    val description: String?,
    val imageURL: String?,
    val abv: Double?,
    val ibu: Double?,
    val targetFg: Double?,
    val targetOg: Double?,
    val ebc: Double?,
    val srm: Double?,
    val ph: Double?,
    val attenuationLevel: Double?,
    @Embedded(prefix = "volume_")
    val volume: Volume,
    @Embedded(prefix = "boilVolume_")
    val boilVolume: Volume?,
    @Embedded
    val method: Method?,
    @Embedded
    val ingredients: Ingredients?,
    val foodPairings: List<String>?,
    val brewersTips: String?,
    val contributedBy: String?
)

data class Volume(
    val value: Double?,
    val unit: String?
)

data class Ingredients(
    val malt: List<Malt>?,
    val hops: List<Hop>?,
    val yeast: String?
)

data class Malt(
    val name: String?,
    @Embedded(prefix = "malt_")
    val amount: Volume?
)

data class Hop(
    val name: String?,
    @Embedded(prefix = "hop_")
    val amount: Volume?,
    val add: String?,
    val attribute: String?
)

data class Method(
    val mashTemp: List<MashTemp>?,
    @Embedded
    val fermentation: Fermentation?,
    val twist: String?
)

data class Fermentation(
    @Embedded(prefix = "fermentation_")
    val temp: Volume?
)

data class MashTemp(
    @Embedded(prefix = "mash_temp_")
    val temp: Volume?,
    val duration: Long?
)