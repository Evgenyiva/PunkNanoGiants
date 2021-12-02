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
    val first_brewed: String?,
    val description: String?,
    val image_url: String?,
    val abv: Double?,
    val ibu: Double?,
    val target_fg: Double?,
    val target_og: Double?,
    val ebc: Double?,
    val srm: Double?,
    val ph: Double?,
    val attenuation_level: Double?,
    @Embedded(prefix = "volume_")
    val volume: Volume,
    @Embedded(prefix = "boilVolume_")
    val boil_volume: Volume?,
    @Embedded
    val method: Method?,
    @Embedded
    val ingredients: Ingredients?,
    val food_pairings: List<String>?,
    val brewers_tips: String?,
    val contributed_by: String?
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