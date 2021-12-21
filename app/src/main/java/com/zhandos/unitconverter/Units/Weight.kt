package com.zhandos.unitconverter.Units

class Weight {
    companion object{
        val types = listOf("Milligrams","Gram","Kilograms","Сentner","Ton")

        fun convert(value: Int, firstMeasure: String, secondMeasure: String): String{
            var result = ""
            when(firstMeasure){
                types[0] ->{
                    when(secondMeasure){
                        types[0] ->{
                            result = value.toString()
                        }
                        types[1] ->{
                            result = milligramsToGram(value).toString()
                        }
                        types[2] ->{
                            result = milligramsToKilograms(value).toString()
                        }
                        types[3] ->{
                            result = milligramsToСentner(value).toString()
                        }
                        types[4] ->{
                            result = milligramsToTon(value).toString()
                        }
                    }
                }
                types[1] ->{
                    when(secondMeasure){
                        types[0] ->{
                            result = gramToMilligrams(value).toString()
                        }
                        types[1] ->{
                            result = value.toString()
                        }
                        types[2] ->{
                            result = gramToKilograms(value).toString()
                        }
                        types[3] ->{
                            result = gramToСentner(value).toString()
                        }
                        types[4] ->{
                            result = gramToTon(value).toString()
                        }
                    }
                }
                types[2] ->{
                    when(secondMeasure){
                        types[0] ->{
                            result = kilogramsToMilligrams(value).toString()
                        }
                        types[1] ->{
                            result = kilogramsToGram(value).toString()
                        }
                        types[2] ->{
                            result = value.toString()
                        }
                        types[3] ->{
                            result = kilogramsToСentner(value).toString()
                        }
                        types[4] ->{
                            result = kilogramsToTon(value).toString()
                        }
                    }
                }
                types[3] ->{
                    when(secondMeasure){
                        types[0] ->{
                            result = centnerToMilligrams(value).toString()
                        }
                        types[1] ->{
                            result = centnerToGram(value).toString()
                        }
                        types[2] ->{
                            result = centnerToKilograms(value).toString()
                        }
                        types[3] ->{
                            result = value.toString()
                        }
                        types[4] ->{
                            result = centnerToTon(value).toString()
                        }
                    }
                }
                types[4] ->{
                    when(secondMeasure){
                        types[0] ->{
                            result = tonToMilligrams(value).toString()
                        }
                        types[1] ->{
                            result = tonToGram(value).toString()
                        }
                        types[2] ->{
                            result = tonToKilograms(value).toString()
                        }
                        types[3] ->{
                            result = tonToСentner(value).toString()
                        }
                        types[4] ->{
                            result = value.toString()
                        }
                    }
                }
            }

            return result
        }

        private fun milligramsToGram(milligrams : Int) = milligrams / 1000
        private fun milligramsToKilograms(milligrams : Int) = milligrams / (1000 * 1000)
        private fun milligramsToСentner(milligrams : Int) = milligrams / (1000 * 1000 * 100)
        private fun milligramsToTon(milligrams : Int) = milligrams / (1000 * 1000 * 1000)

        private fun gramToMilligrams(gram: Int) = gram * 1000
        private fun gramToKilograms(gram: Int) = gram / 1000
        private fun gramToСentner(gram: Int) = gram / (1000 * 100)
        private fun gramToTon(gram: Int) = gram / (1000 * 1000)

        private fun kilogramsToMilligrams(kilograms : Int) = kilograms * 1000 * 1000
        private fun kilogramsToGram(kilograms : Int) = kilograms * 1000
        private fun kilogramsToСentner(kilograms : Int) = kilograms / 100
        private fun kilogramsToTon(kilograms : Int) = kilograms / 1000

        private fun centnerToMilligrams(centner : Int) = centner * 100 * 1000 * 1000
        private fun centnerToGram(centner : Int) = centner * 100 * 1000
        private fun centnerToKilograms(centner : Int) = centner * 100
        private fun centnerToTon(centner : Int) = centner / 10

        private fun tonToMilligrams(ton : Int) = ton * 1000 * 1000 * 1000
        private fun tonToGram(ton : Int) = ton * 1000 * 1000
        private fun tonToKilograms(ton : Int) = ton * 1000
        private fun tonToСentner(ton : Int) = ton * 10
    }
}