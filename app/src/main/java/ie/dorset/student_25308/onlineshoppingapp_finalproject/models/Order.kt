package ie.dorset.student_25308.onlineshoppingapp_finalproject.models

class Order {
    var id : Int = 0
    var userId : Int = 0
    var date :String = ""
    var products : ProductsOrder = ProductsOrder()


}
class ProductsOrder{
   var  productId : Int  =0
    var quantity : Int= 0

    override fun toString(): String {
        return "Order $productId: $quantity"
    }

}

