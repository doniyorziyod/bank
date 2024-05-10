package uz.ictschool.bank.models

data class Card(
    val balance: Int,
    val id: Int,
    val name: String,
    val number: String,
    val phone_number: String,
    val photo: String
)