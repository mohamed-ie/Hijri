import com.build_logic.convention.utils.implementation
import com.build_logic.convention.utils.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("hijri.android.library.compose")
                apply("hijri.android.koin")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            dependencies {
                implementation(project(":core:ui"))

                implementation(library("koin.androidx.compose"))
                implementation(library("kotlinx-serialization-json"))
            }
        }
    }
}