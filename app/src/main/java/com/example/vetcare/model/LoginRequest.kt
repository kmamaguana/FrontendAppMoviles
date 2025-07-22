// model/LoginRequest.kt
package com.example.vetcare.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val email: String,
    val password: String
)

// model/LoginResponse.kt
@Serializable
data class LoginResponse(
    val token: String,
    val usuarioId: String,
    val nombre: String,
    val rol: String
)
