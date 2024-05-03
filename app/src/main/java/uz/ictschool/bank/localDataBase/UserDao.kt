package uz.ictschool.bank.localDataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Insert
    fun addUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

    @Update
    fun updateUser(user: UserEntity)

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM users WHERE id=:id")
    fun getUserById(id: Int): UserEntity
}