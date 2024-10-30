import com.build_logic.convention.utils.implementation
import com.build_logic.convention.utils.ksp
import com.build_logic.convention.utils.library
import com.google.devtools.ksp.gradle.KspExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidKoinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.google.devtools.ksp")
        }

        extensions.configure<KspExtension> {
            arg("KOIN_DEFAULT_MODULE", "false")
        }

        dependencies {
            implementation(platform(library("koin.bom")))
            implementation(library("koin.annotations"))
            implementation(library("koin.core"))
            ksp(library("koin.ksp.compiler"))
        }
    }
}