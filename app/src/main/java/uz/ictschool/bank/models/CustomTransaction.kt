package uz.ictschool.bank.models

data class CustomTransaction(
    var icon: Int,
    var type: String,
    var state: Boolean = false
)
