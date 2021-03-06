package com.timplifier.firebaseauthenticationtest.presentation.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.MediaStore
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.firebaseauthenticationtest.R
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackbar(view: View?, text: CharSequence) {

    view?.let {
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show()
    }
}

fun Fragment.mainNavControllerNavigation() =
    requireActivity().findNavController(R.id.nav_host_fragment)

fun Fragment.checkWhetherPermissionHasBeenGrantedOrNot(
    context: Context,
    permission: String,
    activity: Activity
): Intent {
    val galleryIntent =
        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

    when (ContextCompat.checkSelfPermission(context, permission)) {
        -1 -> ActivityCompat.requestPermissions(
            activity, arrayOf(
                permission
            ), 0
        )
    }
    return galleryIntent
}