package com.example.folkedex.data.remote
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("Akt%C3%B8r?\$inlinecount=allpages&\$filter=substringof('<status>1</status>',biografi) eq true")
    suspend fun getActors(
        @Query("\$skip") skip: Int = 0
    ): ActorResponse

    @GET("Fil?\$top=10&\$orderby=opdateringsdato+desc")
    suspend fun getFiles(
       @Query("\$skip") skip: Int = 0
    ): FileResponse
}