object Versions {
    const val activityComposeVersion = "1.4.0"
    const val androidLifeCycleRuntimeVersion = "2.3.1"
    const val gradleVersion = "7.0.4"
    const val kotlinCompilerVersion = "1.5.31"
    const val appCompatVersion = "1.4.0"
    const val composeVersion = "1.0.5"
    const val materialComposeVersion = "1.1.0-beta03"
    const val roomDbVersion = "2.4.1"
    const val accompanistVersion = "0.22.0-rc"
    const val kotlinGradlePluginVersion = "1.5.31"
    const val androidKtxVersion = "1.7.0"
    const val turbineVersion = "0.7.0"
    const val junitTestExtVersion = "1.1.3"
    const val jUnit4Version = "4.13.2"
    const val mockkVersion = "1.12.1"

    const val minSDK = 23
    const val targetSDK = 31
    const val compileSDK = 31

    const val appVersion = "1.0"
    const val appVersionCode = 1
}

object Dependencies {
    const val androidCoreKtx = "androidx.core:core-ktx:${Versions.androidKtxVersion}"
    const val materialAndroid = "com.google.android.material:material:${Versions.appCompatVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val androidXLifeCycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidLifeCycleRuntimeVersion}"

    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCompilerVersion}"

    const val materialCompose =
        "androidx.compose.material:material:${Versions.materialComposeVersion}"

    const val activityCompose =
        "androidx.activity:activity-compose:${Versions.activityComposeVersion}"

    const val accompanist =
        "com.google.accompanist:accompanist-insets:${Versions.accompanistVersion}"

    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePluginVersion}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomDbVersion}"
    const val roomAnnotationProcessor = "androidx.room:room-compiler:${Versions.roomDbVersion}"

    const val gradle = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"

    const val turbineTest = "app.cash.turbine:turbine:${Versions.turbineVersion}"
    const val mockk = "io.mockk:mockk:${Versions.mockkVersion}"
    const val junit4 = "junit:junit:${Versions.jUnit4Version}"

    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val junitTestExt = "androidx.test.ext:junit:${Versions.junitTestExtVersion}"
}