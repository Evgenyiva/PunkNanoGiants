package de.jky.punknanogiants.ui.punkDetailsView

import android.widget.TextView
import androidx.databinding.BindingAdapter
import de.jky.punknanogiants.R
import de.jky.punknanogiants.data.beer.Hop
import de.jky.punknanogiants.data.beer.Malt
import de.jky.punknanogiants.data.beer.Volume


@BindingAdapter("app:textHops")
fun setHops(textView: TextView, hops: List<Hop>) {
    textView.text = hops.joinToString { it.name.toString() }
}

@BindingAdapter("app:textMalt")
fun setMalt(textView: TextView, malt: List<Malt>) {
    textView.text = malt.joinToString { it.name.toString() }
}

@BindingAdapter("app:textFoodPairing")
fun setFoodPairing(textView: TextView, foodPairing: List<String>?) {
    textView.text = foodPairing?.joinToString { it } ?: textView.context.getString(R.string.unknown)
}

@BindingAdapter("app:textVolume")
fun setFoodPairing(textView: TextView, volume: Volume) {
    textView.text = "${volume.value} ${volume.unit}"
}