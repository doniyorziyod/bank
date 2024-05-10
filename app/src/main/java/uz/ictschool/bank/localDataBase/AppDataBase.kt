package uz.ictschool.bank.localDataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.ictschool.bank.models.Card

@Database(entities = [UserEntity::class, Card::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getCardDao(): CardDao

    companion object{
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase{
            if (instance==null){
                instance = Room.databaseBuilder(context,
                    AppDataBase::class.java, "app_db")
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}