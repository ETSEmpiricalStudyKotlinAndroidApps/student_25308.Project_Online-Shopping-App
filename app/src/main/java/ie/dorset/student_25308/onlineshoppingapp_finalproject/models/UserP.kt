package ie.dorset.student_25308.onlineshoppingapp_finalproject.models

class UserP(var address: Address,
               var id : Int,
               var email :String,
               var username: String,
               var password: String,
               var name: Name,
               var phone :String, )

class Address ( var geolocation : Geolocation,var city :String , var street :String, var number :Int , var zipcode:String)
class Geolocation( var lat : String , var long :String)

class Name ( var firstname : String , var lastname : String )
