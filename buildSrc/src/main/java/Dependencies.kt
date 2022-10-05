

object Versions {
    val junit = "4.13.2"
    val androidx_junit = "1.1.3"
    val espresso_core = "3.4.0"
    val core_ktx = "1.7.0"
    val appcompat = "1.5.1"
    val material = "1.6.1"
    val constraint_layout = "2.1.4"
    val navigation = "2.5.2"
    val retrofit = "2.9.0"
    val coroutines = "1.6.4"
    val dagger_hilt = "2.42"
    val glide = "4.14.1"
}

object Deps {

    //Testing
    val junit = "junit:junit:${Versions.junit}"
    val androidx_junit = "androidx.test.ext:junit:${Versions.androidx_junit}"
    val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"

    //AndroidX
    val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    //Design
    val material = "com.google.android.material:material:${Versions.material}"
    val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"

    //Navigation Component - Kotlin
    val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    //Retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val moshi_converter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    //Coroutines
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    //Dagger-Hilt
    val dagger_hilt = "com.google.dagger:hilt-android:${Versions.dagger_hilt}"
    val dagger_hilt_kapt = "com.google.dagger:hilt-compiler:${Versions.dagger_hilt}"

    //Glide
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}