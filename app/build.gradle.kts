plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    ///ozimiz bilgandek hilt daggerga kerak bular
    kotlin("kapt")
    id("com.google.dagger.hilt.android")

    /////roomga kerak
    id("kotlin-kapt")
}

android {
    namespace = "uz.ictschool.bank"
    compileSdk = 34

    defaultConfig {
        applicationId = "uz.ictschool.bank"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    ///rasm string bosa
    implementation("io.coil-kt:coil:2.4.0")

    ///lifecycle livedata tudum sudum
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.3.1")
    implementation("androidx.lifecycle:lifecycle-livedata:2.3.1")

    ///navigation easy
    implementation("androidx.navigation:navigation-compose:2.7.7")

    ///api bn ishlashga
    implementation("com.squareup.retrofit2:retrofit:2.7.2")
    implementation("com.squareup.retrofit2:converter-gson:2.7.2")
///dagger hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

    ////ozmizni jigar
    implementation("androidx.compose.runtime:runtime-livedata:1.6.5")

    ////lottiega kere boladi
    implementation("com.airbnb.android:lottie-compose:6.0.1")

    ////sharedga kerak narsalar
    implementation ("com.google.code.gson:gson:2.9.0")

    ////video gif degandey
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("io.coil-kt:coil-gif:2.2.2")
    implementation ("androidx.compose.animation:animation-graphics:1.6.0-beta03")
    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:chromecast-sender:0.28")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.28.0")
    implementation("androidx.media3:media3-exoplayer:1.2.1")
    implementation("androidx.media3:media3-ui:1.2.1")

    // hilt
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0-alpha01")
}

kapt {
    correctErrorTypes = true
}