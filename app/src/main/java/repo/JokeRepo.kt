package repo

import com.hermannsterling.jokesapp.model.JokeResponse
import repo.remote.RetrofitInstance

object JokeRepo {

    suspend fun getJokesByCategory(
        categories: String,
        queryMap: Map<String, String>
    ): JokeResponse {
        return RetrofitInstance.jokeService.getJokesByCategory(categories, queryMap)
    }
}