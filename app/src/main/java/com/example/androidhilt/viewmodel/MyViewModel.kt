package com.example.androidhilt.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import com.example.androidhilt.repository.Repository
import androidx.lifecycle.*
import com.example.androidhilt.model.Post
import com.example.androidhilt.utils.Resource
import kotlinx.coroutines.launch

class MyViewModel @ViewModelInject constructor(private val repository: Repository): ViewModel() {

    val posts = MutableLiveData<Resource<List<Post>>>()
    val users: LiveData<Resource<List<Post>>>
        get() = posts
    init {
        fetchPosts()
    }
    private fun fetchPosts(){
        viewModelScope.launch {
            posts.postValue(Resource.loading(null))
            repository.getPosts().let {
                if (it.isSuccessful){
                    posts.postValue(Resource.success(it.body()))
                }
            }
        }
    }
}