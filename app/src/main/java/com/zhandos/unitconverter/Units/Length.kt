package com.zhandos.unitconverter.Units

class Length {
    companion object{
        val types = listOf("inch","ft","yd","meter","dm","cm","mm","um","km","mile")
        fun convert(value: Int, firstMeasure: String, secondMeasure: String): String{
            when(firstMeasure){
                types[0] ->{
                    when(secondMeasure){
                        types[0] -> return value.toString()
                        types[1] -> return inchToFt(value).toString()
                        types[2] -> return inchToYd(value).toString()
                        types[3] -> return inchToMeter(value).toString()
                        types[4] -> return inchToDm(value).toString()
                        types[5] -> return inchToCm(value).toString()
                        types[6] -> return inchToMm(value).toString()
                        types[7] -> return inchToUm(value).toString()
                        types[8] -> return inchToKm(value).toString()
                        types[9] -> return inchToMile(value).toString()
                    }
                }
                types[1] ->{
                    when(secondMeasure){
                        types[0] -> return ftToInch(value).toString()
                        types[1] -> return value.toString()
                        types[2] -> return ftToYd(value).toString()
                        types[3] -> return ftToMeter(value).toString()
                        types[4] -> return ftToDm(value).toString()
                        types[5] -> return ftToCm(value).toString()
                        types[6] -> return ftToMm(value).toString()
                        types[7] -> return ftToUm(value).toString()
                        types[8] -> return ftToKm(value).toString()
                        types[9] -> return ftToMile(value).toString()
                    }
                }
                types[2] ->{
                    when(secondMeasure){
                        types[0] -> return ydToInch(value).toString()
                        types[1] -> return ydToFt(value).toString()
                        types[2] -> return value.toString()
                        types[3] -> return ydToMeter(value).toString()
                        types[4] -> return ydToDm(value).toString()
                        types[5] -> return ydToCm(value).toString()
                        types[6] -> return ydToMm(value).toString()
                        types[7] -> return ydToUm(value).toString()
                        types[8] -> return ydToKm(value).toString()
                        types[9] -> return ydToMile(value).toString()
                    }
                }
                types[3] ->{
                    when(secondMeasure){
                        types[0] -> return meterToInch(value).toString()
                        types[1] -> return meterToFt(value).toString()
                        types[2] -> return meterToYd(value).toString()
                        types[3] -> return value.toString()
                        types[4] -> return meterToDm(value).toString()
                        types[5] -> return meterToCm(value).toString()
                        types[6] -> return meterToMm(value).toString()
                        types[7] -> return meterToUm(value).toString()
                        types[8] -> return meterToKm(value).toString()
                        types[9] -> return meterToMile(value).toString()
                    }
                }
                types[4] ->{
                    when(secondMeasure){
                        types[0] -> return dmToInch(value).toString()
                        types[1] -> return dmToFt(value).toString()
                        types[2] -> return dmToYd(value).toString()
                        types[3] -> return dmToMeter(value).toString()
                        types[4] -> return value.toString()
                        types[5] -> return dmToCm(value).toString()
                        types[6] -> return dmToMm(value).toString()
                        types[7] -> return dmToUm(value).toString()
                        types[8] -> return dmToKm(value).toString()
                        types[9] -> return dmToKm(value).toString()
                    }
                }
                types[5] ->{
                    when(secondMeasure){
                        types[0] -> return cmToInch(value).toString()
                        types[1] -> return cmToFt(value).toString()
                        types[2] -> return cmToYd(value).toString()
                        types[3] -> return cmToMeter(value).toString()
                        types[4] -> return cmToDm(value).toString()
                        types[5] -> return value.toString()
                        types[6] -> return cmToMm(value).toString()
                        types[7] -> return cmToUm(value).toString()
                        types[8] -> return cmToKm(value).toString()
                        types[9] -> return cmToMile(value).toString()
                    }
                }
                types[6] ->{
                    when(secondMeasure){
                        types[0] -> return mmToInch(value).toString()
                        types[1] -> return mmToFt(value).toString()
                        types[2] -> return mmToYd(value).toString()
                        types[3] -> return mmToMeter(value).toString()
                        types[4] -> return mmToDm(value).toString()
                        types[5] -> return mmToCm(value).toString()
                        types[6] -> return value.toString()
                        types[7] -> return mmToUm(value).toString()
                        types[8] -> return mmToKm(value).toString()
                        types[9] -> return mmToMile(value).toString()
                    }
                }
                types[7] ->{
                    when(secondMeasure){
                        types[0] -> return umToInch(value).toString()
                        types[1] -> return umToFt(value).toString()
                        types[2] -> return umToYd(value).toString()
                        types[3] -> return umToMeter(value).toString()
                        types[4] -> return umToDm(value).toString()
                        types[5] -> return umToCm(value).toString()
                        types[6] -> return umToMm(value).toString()
                        types[7] -> return value.toString()
                        types[8] -> return umToKm(value).toString()
                        types[9] -> return umToMile(value).toString()
                    }
                }
                types[8] ->{
                    when(secondMeasure){
                        types[0] -> return kmToInch(value).toString()
                        types[1] -> return kmToFt(value).toString()
                        types[2] -> return kmToYd(value).toString()
                        types[3] -> return kmToMeter(value).toString()
                        types[4] -> return kmToDm(value).toString()
                        types[5] -> return kmToCm(value).toString()
                        types[6] -> return kmToMM(value).toString()
                        types[7] -> return kmToUm(value).toString()
                        types[8] -> return value.toString()
                        types[9] -> return kmToMile(value).toString()
                    }
                }
                types[9] ->{
                    when(secondMeasure){
                        types[0] -> return mileToInch(value).toString()
                        types[1] -> return mileToFt(value).toString()
                        types[2] -> return mileToYd(value).toString()
                        types[3] -> return mileToMeter(value).toString()
                        types[4] -> return mileToDm(value).toString()
                        types[5] -> return mileToCm(value).toString()
                        types[6] -> return mileToMm(value).toString()
                        types[7] -> return mileToUm(value).toString()
                        types[8] -> return mileToKm(value).toString()
                        types[9] -> return value.toString()
                    }
                }
            }
            return ""
        }


        private fun inchToFt(value: Int) = value.toDouble() / 12
        private fun inchToYd(value: Int) = value.toDouble() / 36
        private fun inchToMeter(value: Int) = value.toDouble() / 39.37
        private fun inchToDm(value: Int) = value.toDouble() / (39.37*10)
        private fun inchToCm(value: Int) = value.toDouble() * 2.54
        private fun inchToMm(value: Int) = value.toDouble() * 25.4
        private fun inchToUm(value: Int) = value.toDouble() * 25400
        private fun inchToKm(value: Int) = value.toDouble() / 39370
        private fun inchToMile(value: Int) = value.toDouble() / 63360


        private fun ftToInch(value: Int) = value*12
        private fun ftToYd(value: Int) = value.toDouble() / 3
        private fun ftToMeter(value: Int) = value / 3.281
        private fun ftToDm(value: Int) = value* 3.048
        private fun ftToCm(value: Int) = value* 30.48
        private fun ftToMm(value: Int) = value* 304.8
        private fun ftToUm(value: Int) = value* 304800
        private fun ftToKm(value: Int) = value / 3281
        private fun ftToMile(value: Int) = value / 5280


        private fun ydToInch(value: Int) = value * 36
        private fun ydToFt(value: Int) = value * 3
        private fun ydToMeter(value: Int) = value / 1.094
        private fun ydToDm(value: Int) = value * 9.144
        private fun ydToCm(value: Int) = value * 91.44
        private fun ydToMm(value: Int) = value * 914.4
        private fun ydToUm(value: Int) = value * 914400
        private fun ydToKm(value: Int) = value / 1094
        private fun ydToMile(value: Int) = value / 1760




        private fun meterToInch(value: Int) = value * 39.3701
        private fun meterToFt(value: Int) = value * 3.28084
        private fun meterToYd(value: Int) = value * 1.094
        private fun meterToDm(value: Int) = value * 10
        private fun meterToCm(value: Int) = value * 100
        private fun meterToMm(value: Int) = value * 1000
        private fun meterToUm(value: Int) = value * 1000_000
        private fun meterToKm(value: Int) = value / 1000
        private fun meterToMile(value: Int) = value / 1609

        private fun dmToInch(value: Int) = value * 3.93701
        private fun dmToFt(value: Int) = value / 3.0248
        private fun dmToYd(value: Int) = value / 9.144
        private fun dmToMeter(value: Int) = value / 10
        private fun dmToCm(value: Int) = value * 10
        private fun dmToMm(value: Int) = value * 100
        private fun dmToUm(value: Int) = value * 100_000
        private fun dmToKm(value: Int) = value / 10_000
        private fun dmToMile(value: Int) = value / 16093

        private fun cmToInch(value: Int) = value / 2.54
        private fun cmToFt(value: Int) = value / 30.48
        private fun cmToYd(value: Int) = value / 91.44
        private fun cmToMeter(value: Int) = value / 100
        private fun cmToDm(value: Int) = value / 10
        private fun cmToMm(value: Int) = value * 10
        private fun cmToUm(value: Int) = value * 1000
        private fun cmToKm(value: Int) = value / 100_000
        private fun cmToMile(value: Int) = value / 160934

        private fun mmToInch(value: Int) = value / 25.4
        private fun mmToFt(value: Int) = value / 305
        private fun mmToYd(value: Int) = value / 914
        private fun mmToMeter(value: Int) = value / 1000
        private fun mmToDm(value: Int) = value / 100
        private fun mmToCm(value: Int) = value / 10
        private fun mmToUm(value: Int) = value * 1000
        private fun mmToKm(value: Int) = value / 1000_000
        private fun mmToMile(value: Int) = value / 1609344

        private fun umToInch(value: Int) = value / 25400
        private fun umToFt(value: Int) = value / 304800
        private fun umToYd(value: Int) = value / 914400
        private fun umToMeter(value: Int) = value / 1000_000
        private fun umToDm(value: Int) = value / 1000_00
        private fun umToCm(value: Int) = value / 10000
        private fun umToMm(value: Int) = value / 1000
        private fun umToKm(value: Int) = value / 1000_000_000
        private fun umToMile(value: Int) = value / 1609344000

        private fun kmToInch(value: Int) = value / 39370
        private fun kmToFt(value: Int) = value / 3281
        private fun kmToYd(value: Int) = value / 1094
        private fun kmToMeter(value: Int) = value * 1000
        private fun kmToDm(value: Int) = value * 1000_0
        private fun kmToCm(value: Int) = value * 1000_00
        private fun kmToMM(value: Int) = value * 1000_000
        private fun kmToUm(value: Int) = value * 1000_000_000
        private fun kmToMile(value: Int) = value / 1.609

        private fun mileToInch(value: Int) = value * 63360
        private fun mileToFt(value: Int) = value * 5280
        private fun mileToYd(value: Int) = value * 1760
        private fun mileToMeter(value: Int) = value * 1609
        private fun mileToDm(value: Int) = value * 16093
        private fun mileToCm(value: Int) = value * 160934
        private fun mileToMm(value: Int) = value * 1609344
        private fun mileToUm(value: Int) = value * 1609344000
        private fun mileToKm(value: Int) = value * 1.609
    }
}