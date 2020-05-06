package com.example.navigation.helper

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.replaceFragment(
    @IdRes id: Int,
    fragment: Fragment,
    addToBackStack: Boolean,
    fragName: String
) {
    supportFragmentManager.beginTransaction().replace(id, fragment).apply {
        if (addToBackStack) addToBackStack(fragName)
    }.commit()
}

fun FragmentActivity.addFragment(
    @IdRes id: Int,
    fragment: Fragment,
    addToBackStack: Boolean,
    fragName: String
) {
    supportFragmentManager.beginTransaction().add(id, fragment).apply {
        if (addToBackStack) addToBackStack(fragName)
    }.commit()
}

fun FragmentActivity.removeFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().remove(fragment).commit()
}

fun FragmentActivity.detachFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().detach(fragment).commit()
}

fun FragmentActivity.attachFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().attach(fragment).commit()
}

fun FragmentActivity.findFragmentByTag(tag: String): Fragment? =
    supportFragmentManager.findFragmentByTag(tag)

fun FragmentActivity.findFragmentById(tag: Int): Fragment? =
    supportFragmentManager.findFragmentById(tag)

