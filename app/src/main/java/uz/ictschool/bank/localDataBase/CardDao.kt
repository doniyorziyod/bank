package uz.ictschool.bank.localDataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import uz.ictschool.bank.models.Card

@Dao
interface CardDao {

    @Insert
    fun addCard(card: Card)

    @Query("select * from Card ")
    fun getMyCards(): MutableList<Card>

    @Delete
    fun deleteCard(card: Card)

}