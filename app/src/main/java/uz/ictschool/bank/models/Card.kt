package uz.ictschool.bank.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Card(
    val balance: Int,
    @PrimaryKey
    val id: Int,
    val name: String,
    val number: String,
    val phone_number: String,
    val photo: String
)