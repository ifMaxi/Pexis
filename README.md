# Pexis

A simple "Wallpapers" app that finds and displays photos from the [Pexels API](https://www.pexels.com/es-es/api/documentation)

## Description

The app tries to respect the instructions given by the Pexels API, which means that the application cannot have the functionality of downloading or replicating any function of the page. Every time the user selects an image, an Intent will be activated and will open the default browser, taking them to see the information about the photo and the creator to give them credit, in turn they will be able to download the image from the official [Pexels](https://www.pexels.com) page.

**The app has two screens:**

- The main screen that will obtain photos sequentially thanks to the Paging 3 library.
- And the search screen, like the main screen, will obtain the photos as long as a Query is provided in the search engine.

> [!IMPORTANT]
> In order to use the app from the Android Studio emulator you will need an **Api Key or Authorization** that you can obtain by registering on the Pexels page.
>
> Once you obtain the key, you will need to place your ***"local.properties"*** file with the name ***"AUTHORIZATION"***. Then rebuild the project and start the application.

## Architecture
- TODO

## Language and libraries
- TODO

## Screenshots
- TODO
