package com.zhandos.unitconverter.Units

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
                            result = octToHex(value.toLong())
                        }
                        types[1] ->{
                            result = value
                        }
                        types[2] ->{
                            result = octToBin(value.toLong())
                        }
                        types[3] ->{
                            result = octToDec(value.toLong()).toString()
                        }
                    }
                }
                types[2] ->{
                    when(secondMeasure){
                        types[0] ->{
                            result = binToHex(value.toLong()).toString()
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
                            result = decToHex(value.toLong())
                        }
                        types[1] ->{
                            result = decToOct(value.toLong()).toString()
                        }
                        types[2] ->{
                            result = decToBin(value.toLong())
                        }
                        types[3] ->{
                            result = value
                        }
                    }
                }
            }
            return result
        }

        private fun hexToOct(hex: String) : Long{
            val dec = hexToDec(hex) as Long
            return decToOct(dec)
        }
        private fun hexToBin(hex: String) : String{
            val dec = hexToDec(hex) as Long
            return decToBin(dec)
        }
        private fun hexToDec(hex: String) = hex.toLong(radix = 16)

        private fun octToHex(octal: Long) : String{
            val dec = octToDec(octal)
            return decToHex(dec)
        }
        private fun octToBin(octal: Long):String {
            val dec = octToDec(octal)
            return decToBin(dec)
        }
        private fun octToDec(octal: Long): Long {
            var octal = octal
            var decimalNumber = 0L
            var i = 0L

            while (octal != 0L) {
                decimalNumber += (octal % 10 * Math.pow(8.0, i.toDouble())).toInt()
                ++i
                octal /= 10
            }

            return decimalNumber
        }

        private fun binToHex(bin: Long): Long{
            val dec = binToDec(bin)
            return decToHex(dec).toLong()
        }
        private fun binToOct(bin: Long): Long {
            val dec = binToDec(bin)
            return decToOct(dec)
        }
        private fun binToDec(num: Long): Long {
            var num = num
            var decimalNumber = 0
            var i = 0
            var remainder: Long

            while (num.toLong() != 0L) {
                remainder = num % 10
                num /= 10
                decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
                ++i
            }
            return decimalNumber.toLong()
        }

        private fun decToHex(dec: Long) = dec.toString(8)
        private fun decToBin(bin: Long) = bin.toString(2)
        private fun decToOct(decimal: Long): Long {
            var decimal = decimal
            var octalNumber = 0L
            var i = 1L

            while (decimal != 0L) {
                octalNumber += (decimal % 8L) * i
                decimal /= 8L
                i *= 10
            }

            return octalNumber.toLong()
        }
    }
}