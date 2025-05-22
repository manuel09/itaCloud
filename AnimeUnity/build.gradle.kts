// use an integer for version numbers
version = 13


cloudstream {
    // All of these properties are optional, you can safely remove them

    description = "Anime from AnimeUnity"
    authors = listOf("doGior")

    /**
    * Status int as the following:
    * 0: Down
    * 1: Ok
    * 2: Slow
    * 3: Beta only
    * */
    status = 1
    tvTypes = listOf(
        "AnimeMovie",
        "Anime",
        "OVA",
    )

    language = "it"
    requiresResources = false

    iconUrl = "https://www.animeunity.so/apple-touch-icon.png"
}
