// repository/AuthRepository.kt
package com.example.vetcare.repository

import com.example.vetcare.model.LoginRequest
import com.example.vetcare.model.LoginResponse
import com.example.vetcare.utils.HttpClientProvider
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

object AuthRepository {
    suspend fun login(email: String, password: String): Result<LoginResponse> {
        return try {
            val response: HttpResponse = HttpClientProvider.client.post("http://10.116.39.126:8080/auth/login") {
                contentType(ContentType.Application.Json)
                setBody(LoginRequest(email, password))
            }

            if (response.status == HttpStatusCode.OK) {
                val data: LoginResponse = response.body()
                Result.success(data)
            } else {
                Result.failure(Exception("Error ${response.status.value}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
