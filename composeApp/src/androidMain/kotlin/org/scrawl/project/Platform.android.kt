package org.scrawl.project

import android.os.Build

class AndroidPlatform : Platform {
    override val name: PlatformType = PlatformType.ANDROID
}

actual fun getPlatform(): Platform = AndroidPlatform()