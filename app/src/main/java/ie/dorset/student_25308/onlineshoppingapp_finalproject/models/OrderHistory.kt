package ie.dorset.student_25308.onlineshoppingapp_finalproject.models

class OrderHistory ( val orderH : Array<OrderH>)


    class OrderH(

    var id : Int ,
    var userId : Int,
    var date :String,
    var products : Productos

        )

class Productos(var productId : Int , var quantity : Int)
