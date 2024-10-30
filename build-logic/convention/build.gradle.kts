plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradle)
    compileOnly(libs.kotlin.gradle)
    compileOnly(libs.ksp.gradle)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "hijri.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidLibrary") {
            id = "hijri.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "hijri.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidApplication") {
            id = "hijri.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("koin") {
            id = "hijri.android.koin"
            implementationClass = "AndroidKoinConventionPlugin"
        }

        register("androidFeature") {
            id = "hijri.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
    }
}