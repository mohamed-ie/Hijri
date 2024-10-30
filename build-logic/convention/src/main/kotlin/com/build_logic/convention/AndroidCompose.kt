package com.build_logic.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

fun Project.configureKotlinAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.buildFeatures {
        compose = true
    }
}
