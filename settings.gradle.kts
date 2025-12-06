pluginManagement {
	repositories {
		gradlePluginPortal()
		google()
		mavenCentral()
	}
	resolutionStrategy {
		eachPlugin {
			when (requested.id.id) {
				"com.android.application", "com.android.library" -> useModule("com.android.tools.build:gradle:8.13.1")
				"org.jetbrains.kotlin.jvm", "org.jetbrains.kotlin.android", "org.jetbrains.kotlin.kapt" -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.21")
			}
		}
	}
}

rootProject.name = "ToremaruUtil"
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		mavenCentral()
	}
}
