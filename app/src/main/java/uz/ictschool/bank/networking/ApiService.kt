package uz.ictschool.bank.networking

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import uz.ictschool.bank.models.AddCard
import uz.ictschool.bank.models.CardResponse
import uz.ictschool.bank.models.CheckCode
import uz.ictschool.bank.models.Response
import uz.ictschool.bank.models.SendCode
import uz.ictschool.bank.models.Transaction
import uz.ictschool.bank.models.User

interface ApiService {

    @GET("/cards")
    suspend fun getCards(): List<User>

    @GET("/card/{card}")
    suspend fun getCardByNumber(@Path("card") card:String): CardResponse

    @POST("/add_card/")
    suspend fun addCard(@Body addCard: AddCard):Response

    @GET("/transactions")
    suspend fun getTransactions(): List<Transaction>


    @GET("/transactions?card={card}")
    suspend fun getTransactions(@Path("card") card:String): List<Transaction>

    @POST("/send_code/")
    suspend fun sendCode(@Body sendCode: SendCode):Response

    @POST("/check_code/")
    suspend fun checkCode(@Body checkCode: CheckCode):Response

    @POST("/transaction/")
    suspend fun transaction(@Body transaction: Transaction):Response

}