package com.zhandos.unitconverter.Units

class Temperature {
    companion object{
        val types = listOf("Fahrenheit","Celsius","Kelvin")

        fun convert(value: Int, firstMeasure: String, secondMeasure: String): Double{
            var result = 0.0
            when(firstMeasure){
                types[0] ->{
                    when(secondMeasure){
                        types[0] -> {
                            result = value.toDouble()
                        }
                        types[1] -> {
                            result = fahrenheitToCelsius(value)
                        }
                        types[2] -> {
                            result = fahrenheitToKelvin(value)
                        }
                    }
                }
                types[1] ->{
                    when(secondMeasure){
                        types[0] -> {
                            result = celsiusToFahrenheit(value)
                        }
                        types[1] -> {
                            result = value.toDouble()
                        }
                        types[2] -> {
                            result = celsiusToKelvin(value)
                        }
                    }
                }
                types[2] ->{
                    when(secondMeasure){
                        types[0] -> {
                            result = kelvinToFahrenheit(value)
                        }
                        types[1] -> {
                            result = kelvinToCelsius(value)
                        }
                        types[2] -> {
                            result = value.toDouble()
                        }
                    }
                }
            }
            return result
        }

        private fun fahrenheitToCelsius(fahrenheit: Int)= (fahrenheit - 32.0) *5/9
        private fun fahrenheitToKelvin(fahrenheit: Int) = ((fahrenheit - 32) *5/9) + 273.15

        private fun kelvinToFahrenheit(kelvin: Int) = ((kelvin-273.15) * 9 / 5) + 32.0
        private fun kelvinToCelsius(kelvin: Int) = kelvin - 273.15

        private fun celsiusToFahrenheit(celsius: Int) = (celsius*9 / 5) + 32.0
        private fun celsiusToKelvin(celsius: Int) = celsius + 273.15
    }
}