package org.scrawl.project

class JVMPlatform: Platform {
    override val name: PlatformType = PlatformType.DESKTOP
}

actual fun getPlatform(): Platform = JVMPlatform()