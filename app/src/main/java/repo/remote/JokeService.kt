package repo.remote

import com.hermannsterling.jokesapp.model.JokeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface JokeService {
    @GET("joke/{categories}")
    suspend fun getJokesByCategory(
        @Path("categories") categories: String,
        @QueryMap queryMap: Map<String, String>
    ) : JokeResponse
}