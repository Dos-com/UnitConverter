package com.zhandos.unitconverter

class NumberSystems {
    companion object{
        val types = listOf("HEX", "OCT", "BIN", "DEC")

        fun convert(value: String, firstMeasure: String, secondMeasure: String): String{
            var result = ""
            when(firstMeasure){
                types[0] ->{
                    when(secondMeasure){
                        types[0] ->{
                            result = value
                        }
                        types[1] ->{
                            result = hexToOct(value).toString()
                        }
                        types[2] ->{
                            result = hexToBin(value)
                        }
                        types[3] ->{
                            result = hexToDec(value).toString()
                        }
                    }
                }
                types[1] ->{
                    when(secondMeasure){
                        types[0] ->{
                            result = octToHex(value.toInt())
                        }
                        types[1] ->{
                            result = value
                        }
                        types[2] ->{
                            result = octToBin(value.toInt())
                        }
                        types[3] ->{
                            result = octToDec(value.toInt()).toString()
                        }
                    }
                }
                types[2] ->{
                    when(secondMeasure){
                        types[0] ->{
                            result = binToHex(value.toLong())
                        }
                        types[1] ->{
                            result = binToOct(value.toLong()).toString()
                        }
                        types[2] ->{
                            result = value
                        }
                        types[3] ->{
                            result = binToDec(value.toLong()).toString()
                        }
                    }
                }
                types[3] ->{
                    when(secondMeasure){
                        types[0] ->{
                            result = decToHex(value.toInt())
                        }
                        types[1] ->{
                            result = decToOct(value.toInt()).toString()
                        }
                        types[2] ->{
                            result = decToBin(value.toInt())
                        }
                        types[3] ->{
                            result = value
                        }
                    }
                }
            }
            return result
        }

        private fun hexToOct(hex: String) : Int{
            val dec = hexToDec(hex) as Int
            return decToOct(dec)
        }
        private fun hexToBin(hex: String) : String{
            val dec = hexToDec(hex) as Int
            return decToBin(dec)
        }
        private fun hexToDec(hex: String) = hex.toLong(radix = 16)

        private fun octToHex(octal: Int) : String{
            val dec = octToDec(octal)
            return decToHex(dec)
        }
        private fun octToBin(octal: Int):String {
            val dec = octToDec(octal)
            return decToBin(dec)
        }
        private fun octToDec(octal: Int): Int {
            var octal = octal
            var decimalNumber = 0
            var i = 0

            while (octal != 0) {
                decimalNumber += (octal % 10 * Math.pow(8.0, i.toDouble())).toInt()
                ++i
                octal /= 10
            }

            return decimalNumber
        }

        private fun binToHex(bin: Long): String{
            val dec = binToDec(bin)
            return decToHex(dec)
        }
        private fun binToOct(bin: Long): Int {
            val dec = binToDec(bin)
            return decToOct(dec)
        }
        private fun binToDec(num: Long): Int {
            var num = num
            var decimalNumber = 0
            var i = 0
            var remainder: Long

            while (num.toInt() != 0) {
                remainder = num % 10
                num /= 10
                decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
                ++i
            }
            return decimalNumber
        }

        private fun decToHex(dec: Int) = java.lang.Integer.toHexString(dec)
        private fun decToBin(bin: Int) = java.lang.Integer.toBinaryString(bin)
        private fun decToOct(decimal: Int): Int {
            var decimal = decimal
            var octalNumber = 0
            var i = 1

            while (decimal != 0) {
                octalNumber += decimal % 8 * i
                decimal /= 8
                i *= 10
            }

            return octalNumber
        }
    }
}