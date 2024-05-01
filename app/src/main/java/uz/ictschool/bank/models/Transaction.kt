package uz.ictschool.bank.models

data class Transaction(
    val amount: Int,
    val datetime: String,
    val id: Int,
    val `receiver`: Receiver,
    val sender: Sender
)