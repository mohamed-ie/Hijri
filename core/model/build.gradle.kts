plugins {
    alias(libs.plugins.hijri.android.library)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.hijri.core.model"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    api(libs.kotlinx.datetime)
}