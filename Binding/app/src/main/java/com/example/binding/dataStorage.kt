package com.example.binding

class Name(var nameHeading: String = "", var userName: String = "")
class Age(var ageHeading: String = "", var userAge: String = "")
class Address(var addressHeading: String = "", var userAddress: String = "")
class PhoneNumber(var phoneNumberHeading: String = "", var userPhoneNumber: String = "")
class Text(
    var heading: String = "",
    var buttonName: String = "",
    var editNameHint: String = "",
    var editAgeHint: String = "",
    var editAddressHint: String = "Enter your address",
    var editNumberHint: String = ""
)