package com.mrright.users.viewmodels

import androidx.lifecycle.ViewModel
import com.mrright.users.models.User
import com.mrright.users.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val users = userRepository.getUsers()

    suspend fun insert(user: User) = userRepository.insert(user)

    suspend fun update(user: User) = userRepository.update(user)

    suspend fun delete(user: User) = userRepository.delete(user)

}