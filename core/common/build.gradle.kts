plugins {
    alias(libs.plugins.hijri.android.library)
    alias(libs.plugins.hijri.android.koin)
}

android {
    namespace = "com.hijri.core.common"
}

dependencies {
    api(libs.kotlinx.coroutines.core)
}