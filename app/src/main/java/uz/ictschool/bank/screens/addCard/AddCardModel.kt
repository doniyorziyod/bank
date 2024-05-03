package uz.ictschool.bank.screens.addCard

import uz.ictschool.bank.models.CheckCode
import uz.ictschool.bank.models.Response
import uz.ictschool.bank.models.SendCode
import uz.ictschool.bank.networking.ApiService
import javax.inject.Inject

class AddCardModel @Inject constructor(val apiService: ApiService) {
    suspend fun sendCode(sendCode: SendCode): Response {
        return apiService.sendCode(sendCode)
    }

    suspend fun checkCode(checkCode: CheckCode): Response {
        return apiService.checkCode(checkCode)
    }
}