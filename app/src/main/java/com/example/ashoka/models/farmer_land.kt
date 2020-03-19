package com.example.ashoka.models

class farmer_land {
//Define Classes for the land dat in the recycler view
    var name  : String = ""

    var profits  : String = ""

    var location  : String = ""

    //Primary Constructor
    constructor(){}

    //Secondary Constructor
    constructor(name : String, profits : String, location : String){
        this.name = name
        this.profits= profits
        this.location = location
    }

}