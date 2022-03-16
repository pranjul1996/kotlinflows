plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    kotlin("plugin.serialization")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.macamps.kotlinFlows"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "API_URL",
                "\"https://gorest.co.in/public/v2/\""
            )
        }

        getByName("debug") {
            buildConfigField(
                "String",
                "API_URL",
                "\"https://gorest.co.in/public/v2/\""
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        named("main") {
            java.srcDirs("build/generated/source/navigation-args")
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    buildFeatures {
//        viewBinding = true
        dataBinding = true
    }

    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}
dependencies {
    implementation(Dependency.androidxCore)
    implementation(Dependency.appCompat)
    implementation(Dependency.materialDesign)
    implementation(Dependency.constraintLayout)
    implementation(Dependency.roomDb)
    implementation(Dependency.roomKtx)
    kapt(Dependency.roomCompiler)
//    implementation(Dependency.legacySupport)
    implementation(Dependency.hilt)
    kapt(Dependency.hiltCompiler)
//    implementation("androidx.activity:activity-ktx:1.4.0")

//    debugImplementation("com.readystatesoftware.chuck:library:1.1.0")
//    releaseImplementation("com.readystatesoftware.chuck:library-no-op:1.1.0")


    testImplementation(Dependency.junit)
    androidTestImplementation(Dependency.extJunit)
    androidTestImplementation(Dependency.espressoCore)

    //splash
    implementation(Dependency.splashScreen)

    //spinKit
    implementation(Dependency.spinKit)

    //navigation component
    implementation(Dependency.navigationFragment)
    implementation(Dependency.navigationUi)
    implementation(Dependency.navigationDynamicFeature)
    implementation(Dependency.navigationTesting)

    //responsive size
    implementation(Dependency.sdp)

    //Lifecycle
    implementation(Dependency.lifecycleExtensions)
//    implementation(Dependency.dataBinding)

    //network
    implementation(Dependency.retrofit)
    implementation(Dependency.kotlinConverter)

    // kotlin serialization
    implementation(Dependency.kotlinSerializationCore)
    implementation(Dependency.kotlinSerializationJson)

    implementation(Dependency.converterGson)
    implementation(Dependency.gson)
    implementation(Dependency.okhttp3)

    //interceptor
    implementation(Dependency.okhttpInterceptor)

    //event bus
    implementation(Dependency.eventBus)

    //circle imageview
    implementation(Dependency.circleImageview)

    //dexter
    implementation(Dependency.dexter)

    //glide
    implementation(Dependency.glide)
    kapt(Dependency.glideCompiler)

}
