package uz.ictschool.bank.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.ictschool.bank.models.Card

class SharedPrefHelper(context: Context){

    private val shared: SharedPreferences =
        context.getSharedPreferences("shared", Context.MODE_PRIVATE)

    private val edit = shared.edit()
    private val gson = Gson()
    private val cardListType = object : TypeToken<MutableList<Card>>(){}.type

    private val USER_NUMBER_KEY = "user_number_key"
    private val CARD_NUMBER_KEY = "card_number_key"

    private val IS_FIRST_TIME = "is_first_time"
    private val PIN_CODE_KEY = "pin_code_key"
    private val CARD_LIST_KEY = "card_number_list_key"

    companion object{
        private var instance: SharedPrefHelper? = null
        fun getInstance(context: Context):SharedPrefHelper{
            if (instance == null){
                instance = SharedPrefHelper(context)
            }
            return instance!!
        }
    }

    fun setUserNumber(number: String){
        edit.putString(USER_NUMBER_KEY, number).commit()
    }
    fun getUserNumber(): String{
        return shared.getString(USER_NUMBER_KEY, "")!!
    }


    fun setIsFirstTime(isFirstTime: Boolean){
        edit.putBoolean(IS_FIRST_TIME, isFirstTime).commit()
    }
    fun getIsFirstTime():Boolean{
        return shared.getBoolean(IS_FIRST_TIME, false)
    }

    fun setPinCode(pinCode: String){
        edit.putString(PIN_CODE_KEY, pinCode)
    }
    fun getPinCode(): String{
        return shared.getString(PIN_CODE_KEY, "")!!
    }

    fun setCardNumber(card_number: String){
        edit.putString(CARD_NUMBER_KEY, card_number).commit()
    }
    fun getCardNumber(): String {
        return shared.getString(CARD_NUMBER_KEY, "")!!
    }

    fun addCardToList(card:Card){
        val card_List = getCardNumberList()
        card_List.add(card)
        val str = gson.toJson(card_List, cardListType)
        edit.putString(CARD_LIST_KEY, str)
        edit.commit()
    }
    fun getCardNumberList():MutableList<Card>{
        val str = shared.getString(CARD_LIST_KEY, "")
        val list = gson.fromJson<MutableList<Card>>(str, cardListType)
        return list
    }
}