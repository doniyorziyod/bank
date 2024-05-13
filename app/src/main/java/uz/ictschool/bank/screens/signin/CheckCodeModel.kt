package uz.ictschool.bank.screens.signin

import uz.ictschool.bank.models.CheckCode
import uz.ictschool.bank.models.Response
import uz.ictschool.bank.networking.ApiService
import javax.inject.Inject

class CheckCodeModel @Inject constructor(private val apiService: ApiService){
    suspend fun checkCode(checkCode: CheckCode): Response {
        return apiService.checkCode(checkCode)
    }
}