package com.petru.tmdbkmp

actual fun platformName(): String {
    return UIDevice.currentDevice.systemName() +
        " " +
        UIDevice.currentDevice.systemVersion
}
