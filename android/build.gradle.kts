group = "com.example.design_engine"
version = "1.0-SNAPSHOT"

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.example.design_engine"

    compileSdk = 35

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions {
        jvmTarget = "21"
    }

    buildFeatures {
        compose = true
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/kotlin")
            res.srcDirs(
                "src/main/res",
                "src/main/res-themes/light",
                "src/main/res-themes/dark"
            )
        }
    }

    defaultConfig {
        minSdk = 34
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
        debug {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2025.01.00")
    implementation(composeBom)
    implementation("androidx.compose.ui:ui")
    
    // Modern Material 3 Dependencies
    api("androidx.compose.material3:material3:1.4.0-alpha05")
    api("androidx.compose.material3:material3-window-size-class:1.4.0-alpha05")
    api("androidx.compose.material3:material3-adaptive-navigation-suite:1.5.0-alpha15")
    
    // Icons (Core only — Extended nicht mehr benötigt)
    api("androidx.compose.material:material-icons-core")

    api("com.google.android.material:material:1.13.0")

    // Persistence
    implementation("androidx.datastore:datastore-preferences:1.1.2")
    
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.mockito:mockito-core:5.0.0")
}
