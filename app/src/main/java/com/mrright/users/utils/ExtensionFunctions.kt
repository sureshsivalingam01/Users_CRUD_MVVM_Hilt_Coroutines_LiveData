@file:JvmName("Extensions")
package com.mrright.users.utils

import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*


/*#############################################              LOG             ###########################################################*/


/**
 * [String Log Verbose]
 *
 * @param msg as [String] Default - [ClassName]
 * @param tr as [Throwable] Default - [null]
 * @return [Int]
 */
fun String.verbose(msg: String = this, tr: Throwable? = null): Int {
    return Log.v(this, msg, tr)
}


/**
 * [String Log Debug]
 *
 * @param msg as [String] Default - [ClassName]
 * @param tr as [Throwable] Default - [null]
 * @return [Int]
 */
fun String.debug(msg: String = this, tr: Throwable? = null): Int {
    return Log.d(this, msg, tr)
}


/**
 * [String Log Info]
 *
 * @param msg as [String] Default - [ClassName]
 * @param tr as [Throwable] Default - [null]
 * @return [Int]
 */
fun String.info(msg: String = this, tr: Throwable? = null): Int {
    return Log.i(this, msg, tr)
}


/**
 * [String Log Warn]
 *
 * @param msg as [String] Default - [ClassName]
 * @param tr as [Throwable] Default - [null]
 * @return [Int]
 */
fun String.warn(msg: String = this, tr: Throwable? = null): Int {
    return Log.w(this, msg, tr)
}


/**
 * [String Log Error]
 *
 * @param msg as [String] Default - [ClassName]
 * @param tr as [Throwable] Default - [null]
 * @return [Int]
 */
fun String.error(msg: String = this, tr: Throwable? = null): Int {
    return Log.e(this, msg, tr)
}


/*#############################################              TOAST             ###########################################################*/


/**
 * [Activity Short Toast]
 *  @param text as [String]  Default - [ClassName]
 */
fun Activity.ToastShort(text: String = this.javaClass.simpleName) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

/**
 * [Fragment Short Toast]
 *  @param text as [String]  Default - [ClassName]
 */
fun Fragment.ToastShort(text: String = this.javaClass.simpleName) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}

/**
 * [Activity Long Toast]
 *  @param text as [String]  Default - [ClassName]
 */
fun Activity.ToastLong(text: String = this.javaClass.simpleName) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}


/**
 * [Fragment Long Toast]
 *  @param text as [String]  Default - [ClassName]
 */
fun Fragment.ToastLong(text: String = this.javaClass.simpleName) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
}


/*#############################################            VIEW VISIBILITY          #########################################################*/

/**
 * [View Visible] to [VISIBLE] the view
 *
 */
fun View.visible() {
    this.visibility = View.VISIBLE
}


/**
 * [View InVisible] to [INVISIBLE] the view
 *
 */
fun View.inVisible() {
    this.visibility = View.INVISIBLE
}


/**
 * [View Gone] to [GONE] the view
 *
 */
fun View.gone() {
    this.visibility = View.GONE
}


fun <T> T.generic(a: T) {

}
