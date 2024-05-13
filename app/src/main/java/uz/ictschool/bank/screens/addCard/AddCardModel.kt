package uz.ictschool.bank.screens.addCard

import uz.ictschool.bank.models.AddCard
import uz.ictschool.bank.models.CardResponse
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

    suspend fun addCard(addCard: AddCard):Response{
        return apiService.addCard(addCard)
    }

    suspend fun getCardsByNUmber(cardNum:String): CardResponse {
        return apiService.getCardByNumber(cardNum)
    }
}