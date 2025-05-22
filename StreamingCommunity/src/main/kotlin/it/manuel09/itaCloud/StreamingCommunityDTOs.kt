package it.dogior.hadEnough

import com.fasterxml.jackson.annotation.JsonProperty

data class Section(
    @JsonProperty("name") val name: String,
    @JsonProperty("label") val label: String,
    @JsonProperty("titles") val titles: List<Title>,
)

data class Title(
    @JsonProperty("id") val id: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("slug") val slug: String,
    @JsonProperty("type") val type: String,
    @JsonProperty("images") val images: List<PosterImage>,
) {
    fun getPoster(): String? {
        this.images.forEach {
            if (it.type == "poster") {
                return it.filename
            }
        }
        return null
    }
}


data class PosterImage(
    @JsonProperty("filename") val filename: String,
    @JsonProperty("type") val type: String,
    @JsonProperty("imageable_type") val imageableType: String,
    @JsonProperty("imageable_id") val imageableId: Int,
)

data class Genre(
    @JsonProperty("id") val id: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("type") val type: String,
)


data class InertiaResponse(
    @JsonProperty("props") val props: Props,
    @JsonProperty("url") val url: String,
    @JsonProperty("version") val version: String
)

data class Props(
    @JsonProperty("scws_url") val scwsUrl: String,
    @JsonProperty("cdn_url") val cdnUrl: String,
    @JsonProperty("title") val title: TitleProp?,
    @JsonProperty("loadedSeason") val loadedSeason: Season?,
    @JsonProperty("sliders") val sliders: List<Slider>?,
    @JsonProperty("genres") val genres: List<Genre>?,
    @JsonProperty("label") val label: String?,
    @JsonProperty("browseMoreApiRoute") val browseMoreApiRoute: String?,
    @JsonProperty("titles") val titles: List<Title>? //Only used in searches
)

data class Season(
    @JsonProperty("id") val id: Int,
    @JsonProperty("number") val number: Int,
    @JsonProperty("name") val name: String?,
    @JsonProperty("plot") val plot: String?,
    @JsonProperty("release_date") val releaseDate: String?,
    @JsonProperty("title_id") val titleId: Int,
    @JsonProperty("episodes") val episodes: List<Episode>?
)

data class Episode(
    @JsonProperty("id") val id: Int,
    @JsonProperty("number") val number: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("plot") val plot: String?,
    @JsonProperty("duration") val duration: Int?,
    @JsonProperty("scws_id") val scwsId: Int,
    @JsonProperty("season_id") val seasonId: Int,
    @JsonProperty("images") val images: List<PosterImage>
){
    fun getCover(): String? {
        this.images.forEach {
            if (it.type == "cover") {
                return it.filename
            }
        }
        return null
    }
}

data class Slider(
    @JsonProperty("name") val name: String,
    @JsonProperty("label") val label: String,
    @JsonProperty("titles") val titles: List<Title>,
)

data class MainActor(
    @JsonProperty("id") val id: Int,
    @JsonProperty("name") val name: String,
)

data class TitleProp(
    @JsonProperty("id") val id: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("slug") val slug: String,
    @JsonProperty("plot") val plot: String?,
    @JsonProperty("quality") val quality: String?,
    @JsonProperty("type") val type: String?,
    @JsonProperty("score") val score: String?,
    @JsonProperty("release_date") val releaseDate: String?,
    @JsonProperty("status") val status: String?,
    @JsonProperty("age") val age: Int?,
    @JsonProperty("runtime") val runtime: Int?,
    @JsonProperty("tmdb_id") val tmdbId: Int?,
    @JsonProperty("imdb_id") val imdbId: String?,
    @JsonProperty("seasons_count") val seasonsCount: Int?,
    @JsonProperty("scws_id") val scwsId: Int?,
    @JsonProperty("trailers") val trailers: List<Trailer>?,
    @JsonProperty("seasons") val seasons: List<Season>?,
    @JsonProperty("images") val images: List<PosterImage>,
    @JsonProperty("genres") val genres: List<Genre>,
    @JsonProperty("main_actors") val mainActors: List<MainActor>?
){
    fun getBackgroundImageId(): String? {
        this.images.forEach {
            if (it.type == "background") {
                return it.filename
            }
        }
        return null
    }
    fun getPosterImageId(): String? {
        this.images.forEach {
            if (it.type == "poster") {
                return it.filename
            }
        }
        return null
    }
}


data class Trailer(
    @JsonProperty("id") val id: Int,
    @JsonProperty("name") val name: String?,
    @JsonProperty("youtube_id") val youtubeId: String?,
    @JsonProperty("title_id") val titleId: Int?,
){
    fun getYoutubeUrl(): String? {
        if(this.youtubeId == null) return null
        return "https://www.youtube.com/watch?v=${this.youtubeId}"
    }
}

data class Script(
    @JsonProperty("video") val videoInfo: SourceFile,
    @JsonProperty("streams") val servers: List<Server>,
    @JsonProperty("masterPlaylist") val masterPlaylist: MasterPlaylist,
    @JsonProperty("canPlayFHD") val canPlayFHD: Boolean
)

data class MasterPlaylist(
    @JsonProperty("params") val params: Params,
    @JsonProperty("url") val url: String
) {
    data class Params(
        @JsonProperty("token") val token: String,
        @JsonProperty("expires") val expires: String
    )
}

data class Server(
    @JsonProperty("name") val name: String,
    @JsonProperty("active") val active: Boolean,
    @JsonProperty("url") val url: String
)

data class SourceFile(
    val id: Int,
    val name: String,
    val filename: String?,
    val size: Int,
    val quality: Int,
    val duration: Int,
    val views: Int,
    val is_viewable: Int,
    val status: String,
    val fps: Float?,
    val legacy: Int,
    val folder_id: String,
    val created_at_diff: String
)