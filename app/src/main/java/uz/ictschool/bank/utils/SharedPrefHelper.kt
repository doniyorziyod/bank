package uz.ictschool.bank.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPrefHelper(context: Context){

    private val shared: SharedPreferences =
        context.getSharedPreferences("shared", Context.MODE_PRIVATE)

    private val edit = shared.edit()

    private val USER_NUMBER_KEY = "user_number_key"

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
}