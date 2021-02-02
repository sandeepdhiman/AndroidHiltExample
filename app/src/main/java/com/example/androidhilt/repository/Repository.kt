package com.example.androidhilt.repository

import com.example.androidhilt.model.Post
import com.example.androidhilt.model.User
import com.example.androidhilt.request.ApiInterface
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val apiInterface:ApiInterface) {
    suspend fun getPosts(): Response<List<Post>> = apiInterface.getPosts()
}