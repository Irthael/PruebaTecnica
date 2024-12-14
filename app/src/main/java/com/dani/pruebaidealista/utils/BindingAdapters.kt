package com.dani.pruebaidealista.utils

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.dani.pruebaidealista.R

@Suppress("TooManyFunctions")
object BindingAdapters {
    private const val BLINKING_DURATION = 1500L


    @BindingAdapter("visible")
    @JvmStatic
    fun setVisibile(view: View, value: Boolean?) {
        view.visibility = if (value == true) View.VISIBLE else View.GONE
    }

    @BindingAdapter(value = ["writeDate"])
    @JvmStatic
    fun setDateForFavorite(view: TextView, date: Long?) {
        view.text = date?.toString() ?: ""
    }

    @BindingAdapter(value = ["writePrice"])
    @JvmStatic
    fun setPrice(view: TextView, count: Double) {
        view.text = view.context.getString(R.string.price, count)
    }

    @BindingAdapter(value = ["setFavorite"])
    @JvmStatic
    fun setFavoriteStars(view: RatingBar, favorite: Boolean) {
        view.rating = if (favorite) 1f else 0f
    }

    @BindingAdapter(
        value = ["imageUrl"],
        requireAll = false
    )
    @JvmStatic
    fun setImageUrlWithDefault(
        imageView: ImageView,
        image: String?
    ) {
        if (image==null) imageView.setImageDrawable(null)
        else {
            Glide.with(imageView)
                .load(image)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView)
        }
    }
}