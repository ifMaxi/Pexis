# Pexis

A simple "Wallpapers" app that finds and displays photos from the [Pexels API](https://www.pexels.com/es-es/api/documentation)

## Description

The app tries to respect the instructions given by the Pexels API, which means that the application cannot have the functionality of downloading or replicating any function of the page. Every time the user selects an image, an Intent will be activated and will open the default browser, taking them to see the information about the photo and the creator to give them credit, in turn they will be able to download the image from the official [Pexels](https://www.pexels.com) page.

**The app has two screens:**

- The main screen that will obtain photos sequentially thanks to the Paging 3 library.
- And the search screen, like the main screen, will obtain the photos as long as a Query is provided in the search engine. Also the search bar offers a "false" history.

> [!NOTE]
> The app does not support dark mode.

> [!IMPORTANT]
> In order to use the app from the Android Studio emulator you will need an **Api Key or Authorization** that you can obtain by registering on the Pexels page.
>
> Once you obtain the key, you will need to place your ***"local.properties"*** file with the name ***"AUTHORIZATION"***. Then rebuild the project and start the application.

> [!Tip]
> Don't want to do all the above configuration? The following link contains the Apk to download and test it directly on a physical or emulated device.
>
> [Pexis APK](https://drive.google.com/file/d/1011t1cNbOehFF8kZo2lTTkruZF4u4W1K/view?usp=drive_link)

## Architecture
The type of architecture used for this project was MVVM(Model-View-ViewModel).

This is divided into the:

- Model: Which represents the data and business logic
- View: Which represents the UI
- ViewModel: Which represents the bridge between the View and the Model

![Diagram: MVVM Pattern](https://github.com/ifMaxi/Pexis/assets/112733459/6bbcfb2b-30ac-406f-a678-925b612bcdf1)

## Language and libraries

- [Kotlin](https://kotlinlang.org/docs/home.html)
  - [Serialization](https://kotlinlang.org/docs/serialization.html)
  - [Coroutines](https://kotlinlang.org/api/kotlinx.coroutines/)
    - [Flow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/)
- Jetpack
  - [Compose](https://developer.android.com/jetpack/compose?hl=en)
  - [Navigation](https://developer.android.com/guide/navigation?hl=en)
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel?hl=en)
  - [Hilt](https://developer.android.com/training/dependency-injection/hilt-android?hl=en)
  - [Paging 3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview?hl=en)
- [Material Ui 3](https://m3.material.io/)
- [Coil](https://coil-kt.github.io/coil/)
- [Lottie](https://lottiefiles.com/)
- [Retrofit](https://square.github.io/retrofit/)

## Screenshots
| Splash Screen | Main Screen | Search Main |
| ------------- | ----------- | ----------- |
| <img src="https://github.com/ifMaxi/Pexis/assets/112733459/f8b46eb2-122e-4769-ba83-6ed1da01e94a" width="290" height="600"> | <img src="https://github.com/ifMaxi/Pexis/assets/112733459/6028da9c-dfba-4cca-a092-8f02524faece" width="290" height="600"> | <img src="https://github.com/ifMaxi/Pexis/assets/112733459/9763c41e-e0df-4634-bb4e-b1dad64162f5" width="290" height="600"> |

| Search History | Searched Query | After Click |
| ------------- | ----------- | ----------- |
| <img src="https://github.com/ifMaxi/Pexis/assets/112733459/682dc1fa-a63c-470c-b6cc-3e85bb4aa954" width="290" height="600"> | <img src="https://github.com/ifMaxi/Pexis/assets/112733459/302df61e-f689-429f-a126-7272ef776957" width="290" height="600"> | <img src="https://github.com/ifMaxi/Pexis/assets/112733459/bc5e55a9-6a0b-41d1-b307-3f9a6f8ec206" width="290" height="600"> |
