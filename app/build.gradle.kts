plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.smparkworld.multiviewtypesample"

    defaultConfig {
        applicationId = "com.smparkworld.multiviewtypesample"
        versionCode = 1
        versionName = "1.0"
    }
}
apply(from = rootProject.file("core-android-build.gradle"))

dependencies {
    implementation(project(":common:base"))
    implementation(project(":common:design"))
    implementation(project(":feature:mypage"))
    implementation(project(":common:datamodel"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}