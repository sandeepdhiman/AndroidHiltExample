package com.example.androidhilt.request

import com.example.androidhilt.model.Post
import com.example.androidhilt.model.User
import com.example.androidhilt.utils.Resource
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}