package com.zhandos.unitconverter

class Distance {
    companion object{
        val types = listOf("Meter","Millimeter","Centimeter","Kilometer")

        fun convert(value: Int, firstMeasure: String, secondMeasure: String): String{
            var result = ""

            when(firstMeasure){
                types[0] ->{
                    when(secondMeasure){
                        types[0] -> {
                            result = value.toString()
                        }
                        types[1] -> {
                            result = meterToMillimeter(value).toString()
                        }
                        types[2] -> {
                            result = meterToCentimeter(value).toString()
                        }
                        types[3] -> {
                            result = meterToKilometer(value).toString()
                        }
                    }
                }
                types[1] ->{
                    when(secondMeasure){
                        types[0] -> {
                            result = millimeterToMeter(value).toString()
                        }
                        types[1] -> {
                            result = value.toString()
                        }
                        types[2] -> {
                            result = millimeterToCentimeter(value).toString()
                        }
                        types[3] -> {
                            result = millimeterToKilometer(value).toString()
                        }
                    }
                }
                types[2] ->{
                    when(secondMeasure){
                        types[0] -> {
                            result = centimeterToMeter(value).toString()
                        }
                        types[1] -> {
                            result = centimeterToMillimeter(value).toString()
                        }
                        types[2] -> {
                            result = value.toString()
                        }
                        types[3] -> {
                            result = centimeterToKilometer(value).toString()
                        }
                    }
                }
                types[3] ->{
                    when(secondMeasure){
                        types[0] -> {
                            result = kilometerToMeter(value).toString()
                        }
                        types[1] -> {
                            result = kilometerToMillimeter(value).toString()
                        }
                        types[2] -> {
                            result = kilometerToCentimeter(value).toString()
                        }
                        types[3] -> {
                            result = value.toString()
                        }
                    }
                }
            }

            return result
        }

        private fun meterToMillimeter(meter:Int)  = meter*1000
        private fun meterToCentimeter(meter:Int)  = meter*100
        private fun meterToKilometer(meter:Int)  = meter*0.001


        private fun millimeterToMeter(millimeter:Int) = millimeter * 0.001
        private fun millimeterToCentimeter(millimeter:Int)  = millimeter * 0.1
        private fun millimeterToKilometer(millimeter:Int)  = millimeter * 0.000_000_1

        private fun centimeterToMeter(centimeter: Int) = centimeter*0.01
        private fun centimeterToMillimeter(centimeter: Int) = centimeter*0.1
        private fun centimeterToKilometer(centimeter: Int) = centimeter*0.000_001

        private fun kilometerToMeter(kilometer: Int) = kilometer*1000
        private fun kilometerToMillimeter(kilometer: Int) = kilometer*100_000_0
        private fun kilometerToCentimeter(kilometer: Int) = kilometer*100_000
    }
}