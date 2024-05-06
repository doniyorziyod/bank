package uz.ictschool.bank.screens.signin

import uz.ictschool.bank.models.Response
import uz.ictschool.bank.models.SendCode
import uz.ictschool.bank.networking.ApiService
import javax.inject.Inject

class SignInModel @Inject constructor(private val apiService: ApiService){
    suspend fun sendCode(sendCode: SendCode): Response {
        return apiService.sendCode(sendCode)
    }
}