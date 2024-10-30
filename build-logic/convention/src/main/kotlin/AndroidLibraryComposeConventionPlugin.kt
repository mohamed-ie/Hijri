import com.android.build.gradle.LibraryExtension
import com.build_logic.convention.configureKotlinAndroid
import com.build_logic.convention.configureKotlinAndroidCompose
import com.build_logic.convention.utils.implementation
import com.build_logic.convention.utils.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.android.library")
            apply("org.jetbrains.kotlin.plugin.compose")
            apply("org.jetbrains.kotlin.android")
        }

        extensions.getByType<LibraryExtension>().apply {
            configureKotlinAndroidCompose(this)
            configureKotlinAndroid(this)
        }

        dependencies {
            implementation(platform(library("androidx.compose.bom")))
        }
    }
}