package uz.ictschool.bank.screens.myCard

import uz.ictschool.bank.models.CardResponse
import uz.ictschool.bank.models.User
import uz.ictschool.bank.networking.ApiService
import javax.inject.Inject

class MyCardModel @Inject constructor(val apiService: ApiService) {
    suspend fun getCards(): List<User> {
        return apiService.getCards()
    }

    suspend fun getCardsByNUmber(cardNum:String): CardResponse {
        return apiService.getCardByNumber(cardNum)
    }
}