package org.scrawl.project

interface Platform {
    val name: PlatformType
}

expect fun getPlatform(): Platform

enum class PlatformType {
    ANDROID,
    DESKTOP
}