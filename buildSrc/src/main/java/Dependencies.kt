/**
 * To define plugins
 */
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}" }
    val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }
    val navigation by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationArgs}" }
}

/**
 * To define dependencies
 */
object Dependency {
    val junit by lazy { "junit:junit:${Versions.jUnit}" }
    val extJunit by lazy { "androidx.test.ext:junit:${Versions.extJunit}" }
    val androidxCore by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }

    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }

    val roomDb by lazy { "androidx.room:room-runtime:${Versions.room}" }
    val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.room}" }
    val roomKtx by lazy { "androidx.room:room-ktx:${Versions.room}" }


    //splash
    val splashScreen by lazy { "androidx.core:core-splashscreen:${Versions.splashScreen}" }

    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val legacySupport by lazy { "androidx.legacy:legacy-support-v4:${Versions.legacySupport}" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }


    //navigation component
    val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}" }
    val navigationTesting by lazy { "androidx.navigation:navigation-testing:${Versions.nav_version}" }
    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}" }
    val navigationDynamicFeature by lazy { "androidx.navigation:navigation-dynamic-features-fragment:${Versions.nav_version}" }

    //dexter
    val dexter by lazy { "com.karumi:dexter:${Versions.dexter}" }

    //glide
    val glide by lazy { "com.github.bumptech.glide:glide:${Versions.glide_version}" }
    val glideCompiler by lazy { "com.github.bumptech.glide:compiler:${Versions.glide_version}" }

    //responsive size
    val sdp by lazy { "com.intuit.sdp:sdp-android:${Versions.sdp}" }

    //        spinKit
    val spinKit by lazy { "com.github.ybq:Android-SpinKit:${Versions.spinKit}" }

    //event bus
    val eventBus by lazy { "org.greenrobot:eventbus:${Versions.eventBus}" }

    //circle imageview
    val circleImageview by lazy { "de.hdodenhof:circleimageview:${Versions.circleImageview}" }

    //Lifecycle
    val lifecycleExtensions by lazy { "android.arch.lifecycle:extensions:${Versions.lifecycle_extensions}" }
    val dataBinding by lazy { "com.android.databinding:compiler:${Versions.dataBindingCompiler}" }

    //network
    val gson by lazy { "com.google.code.gson:gson:${Versions.gson}" }
    val okhttp3 by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttp3}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val converterGson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
    val kotlinSerializationCore by lazy { "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinx_serialization}" }
    val kotlinSerializationJson by lazy { "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinx_serialization}" }
    val kotlinConverter by lazy { "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.kotlinx_serialization_converter}" }

    //interceptor
    val okhttpInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}" }
}
