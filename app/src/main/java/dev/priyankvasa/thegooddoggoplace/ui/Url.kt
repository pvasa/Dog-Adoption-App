package dev.priyankvasa.thegooddoggoplace.ui

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

interface Url : Parcelable {
    val value: Any
}

@Parcelize
inline class NetworkUrl(val url: String) : Url {
    override val value: Any get() = url
}

@Parcelize
inline class DrawableUrl(@DrawableRes val id: Int) : Url {
    override val value: Any get() = id
}
