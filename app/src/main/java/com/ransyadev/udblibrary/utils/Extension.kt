package com.ransyadev.udblibrary.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.DisplayMetrics
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.ransyadev.udblibrary.R
import java.text.NumberFormat
import java.util.Locale

fun AppCompatActivity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun <T> Fragment.openActivity(destination: Class<T>, bundleKey: String, id: String) {
    val intent = Intent(requireContext(), destination)
    intent.putExtra(bundleKey, id)
    startActivity(intent)
}

fun <T> Fragment.openActivity(destination: Class<T>) {
    val intent = Intent(requireContext(), destination)
    startActivity(intent)
}

fun <T> Activity.openActivity(destination: Class<T>, bundleKey: String, id: String) {
    val intent = Intent(this, destination)
    intent.putExtra(bundleKey, id)
    startActivity(intent)
}

fun <T> Activity.openActivity(destination: Class<T>) {
    val intent = Intent(this, destination)
    startActivity(intent)
}

fun Activity.closeActivity(){
    hideKeyboard()
    finish()
}

fun View.visible() {
    if (this.visibility == View.GONE || this.visibility == View.INVISIBLE) this.visibility =
        View.VISIBLE
}

fun View.gone() {
    if (this.visibility == View.VISIBLE) this.visibility = View.GONE
}

fun View.invisible() {
    if (this.visibility == View.VISIBLE) this.visibility = View.INVISIBLE
}

fun Activity.hideKeyboard() {
    val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val view = currentFocus
    if (view != null) {
        inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}

fun ImageView.loadImage(
    url: String,
    @DrawableRes error: Int = R.drawable.ic_placeholder,
) {
    val circularProgressDrawable = CircularProgressDrawable(this.context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()

    Glide.with(this.context)
        .load(Uri.parse(url))
        .placeholder(circularProgressDrawable)
        .error(error)
        .into(this)
}

fun ImageView.loadImageDialog(
    url: String,
) {
    Glide.with(this.context)
        .load(Uri.parse(url))
        .placeholder(R.drawable.empty_image)
        .error(R.drawable.empty_image)
        .dontAnimate()
        .into(this)
}

fun convertDpToPixel(dp: Float, context: Context): Float {
    return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}

fun AppCompatActivity.callPhone(data : String) {
    val intent = Intent(Intent.ACTION_CALL)
    intent.data = Uri.parse("tel: ${data}")
    startActivity(intent)
}

fun Fragment.callPhone(data : String) {
    val intent = Intent(Intent.ACTION_CALL)
    intent.data = Uri.parse("tel: ${data}")
    startActivity(intent)
}

fun Context.callPhone(data : String) {
    val intent = Intent(Intent.ACTION_CALL)
    intent.data = Uri.parse("tel: ${data}")
    startActivity(intent)
}

fun Boolean.doThis(job: () -> Unit) {
    if (this)
        job()
}

fun SwipeRefreshLayout.setColorUDBPetShopDefault(){
    this.setColorSchemeColors(resources.getColor(R.color.colorPrimary, null), resources.getColor(R.color.white, null))
}

fun Number?.toRupiahFormat(useCurrencySymbol: Boolean = true): String {
    if (this == null)
        if (useCurrencySymbol)
            return "Rp "

    val formatRupiah = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
    val result =
        formatRupiah
            .format(this)
            .replace(",00", "")
            .replace("Rp", "Rp ")

    return if (!useCurrencySymbol) result.replace("Rp ", "") else result
}

fun View.showSnackBarInfo(
    message: String?,
    duration: Int = Snackbar.LENGTH_LONG,
) {
    val snackbar = Snackbar.make(this, message ?: "", duration)
        .setBackgroundTint(ContextCompat.getColor(this.context, R.color.alert_info_background))
        .setTextColor(ContextCompat.getColor(this.context, R.color.alert_info_text))
    val snackbarView = snackbar.view

    val textView =
        snackbarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)

    textView.maxLines = 4

    snackbar.show()
}

fun Int.isNumeric(): Boolean {
    if (this == KeyEvent.KEYCODE_0
        || this == KeyEvent.KEYCODE_1
        || this == KeyEvent.KEYCODE_2
        || this == KeyEvent.KEYCODE_3
        || this == KeyEvent.KEYCODE_4
        || this == KeyEvent.KEYCODE_5
        || this == KeyEvent.KEYCODE_6
        || this == KeyEvent.KEYCODE_7
        || this == KeyEvent.KEYCODE_8
        || this == KeyEvent.KEYCODE_9
    ) {
        return true
    }
    return false
}
