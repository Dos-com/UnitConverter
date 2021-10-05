package com.zhandos.unitconverter

class Distance {
    companion object{
        val types = listOf("Meter","Millimeter","Centimeter","Kilometer")


        fun meterToMillimeter(meter:Int) : Int = meter*1000
        fun meterToCentimeter(meter:Int) : Int = meter*100
        fun meterToKilometer(meter:Int) : Double = meter*0.001


        fun millimeterToMeter(millimeter:Int) : Double = millimeter * 0.001
        fun millimeterToCentimeter(millimeter:Int) : Double = millimeter * 0.1
        fun millimeterToKilometer(millimeter:Int) : Double = millimeter * 0.000_000_1

        fun centimeterToMeter(centimeter: Int): Double = centimeter*0.01
        fun centimeterToMillimeter(centimeter: Int): Double = centimeter*0.1
        fun centimeterToKilometer(centimeter: Int): Double = centimeter*0.000_001

        fun kilometerToMeter(kilometer: Int): Int = kilometer*100
        fun kilometerToMillimeter(kilometer: Int): Int = kilometer*100_000_0
        fun kilometerToCentimeter(kilometer: Int): Int = kilometer*100_000
    }
}