package com.zhandos.unitconverter

class Time {
    companion object{
        val types = listOf("Seconds", "Minutes", "Hours", "Day", "Week", "Month", "Year", "Century")

        fun convert(value: Int, firstMeasure: String, secondMeasure: String): String{
            var result = ""

            when(firstMeasure){
                types[0] -> {
                    when(secondMeasure){
                        types[0] ->{
                            result = value.toString()
                        }
                        types[1] -> {
                            result = secondsToMinutes(value).toString()
                        }
                        types[2] -> {
                            result = secondsToHours(value).toString()
                        }
                        types[3] -> {
                            result = secondsToDay(value).toString()
                        }
                        types[4] -> {
                            result = secondsToWeek(value).toString()
                        }
                        types[5] -> {
                            result = secondsToMonth(value).toString()
                        }
                        types[6] -> {
                            result = secondsToYear(value).toString()
                        }
                        types[7] -> {
                            result = secondsToCentury(value).toString()
                        }
                    }
                }
                types[1] -> {
                    when(secondMeasure){
                        types[0] -> {
                            result = minutesToSeconds(value).toString()
                        }
                        types[1] ->{
                            result = value.toString()
                        }
                        types[2] -> {
                            result = minutesToHours(value).toString()
                        }
                        types[3] -> {
                            result = minutesToDay(value).toString()
                        }
                        types[4] -> {
                            result = minutesToWeek(value).toString()
                        }
                        types[5] -> {
                            result = minutesToMonth(value).toString()
                        }
                        types[6] -> {
                            result = minutesToYear(value).toString()
                        }
                        types[7] -> {
                            result = minutesToCentury(value).toString()
                        }
                    }
                }
                types[2] -> {
                    when(secondMeasure){
                        types[0] -> {
                            result = hoursToSeconds(value).toString()
                        }
                        types[1] -> {
                            result = hoursToMinutes(value).toString()
                        }
                        types[2] ->{
                            result = value.toString()
                        }
                        types[3] -> {
                            result = hoursToDay(value).toString()
                        }
                        types[4] -> {
                            result = hoursToWeek(value).toString()
                        }
                        types[5] -> {
                            result = hoursToMonth(value).toString()
                        }
                        types[6] -> {
                            result = hoursToYear(value).toString()
                        }
                        types[7] -> {
                            result = hoursToCentury(value).toString()
                        }
                    }
                }
                types[3] -> {
                    when(secondMeasure){
                        types[0] -> {
                            result = dayToSeconds(value).toString()
                        }
                        types[1] -> {
                            result = dayToMinutes(value).toString()
                        }
                        types[2] -> {
                            result = dayToHours(value).toString()
                        }
                        types[3] ->{
                            result = value.toString()
                        }
                        types[4] -> {
                            result = dayToWeek(value).toString()
                        }
                        types[5] -> {
                            result = dayToMonth(value).toString()
                        }
                        types[6] -> {
                            result = dayToYear(value).toString()
                        }
                        types[7] -> {
                            result = dayToCentury(value).toString()
                        }
                    }
                }
                types[4] -> {
                    when(secondMeasure){
                        types[0] -> {
                            result = weekToSeconds(value).toString()
                        }
                        types[1] -> {
                            result = weekToMinutes(value).toString()
                        }
                        types[2] -> {
                            result = weekToHours(value).toString()
                        }
                        types[3] -> {
                            result = weekToDay(value).toString()
                        }
                        types[4] ->{
                            result = value.toString()
                        }
                        types[5] -> {
                            result = weekToMonth(value).toString()
                        }
                        types[6] -> {
                            result = weekToYear(value).toString()
                        }
                        types[7] -> {
                            result = weekToCentury(value).toString()
                        }
                    }
                }
                types[5] -> {
                    when(secondMeasure){
                        types[0] -> {
                            result = monthToSeconds(value).toString()
                        }
                        types[1] -> {
                            result = monthToMinutes(value).toString()
                        }
                        types[2] -> {
                            result = monthToHours(value).toString()
                        }
                        types[3] -> {
                            result = monthToDay(value).toString()
                        }
                        types[4] -> {
                            result = monthToWeek(value).toString()
                        }
                        types[5] ->{
                            result = value.toString()
                        }
                        types[6] -> {
                            result = monthToYear(value).toString()
                        }
                        types[7] -> {
                            result = monthToCentury(value).toString()
                        }
                    }
                }
                types[6] -> {
                    when(secondMeasure){
                        types[0] -> {
                            result = yearToSeconds(value).toString()
                        }
                        types[1] -> {
                            result = yearToMinutes(value).toString()
                        }
                        types[2] -> {
                            result = yearToHours(value).toString()
                        }
                        types[3] -> {
                            result = yearToDay(value).toString()
                        }
                        types[4] -> {
                            result = yearToWeek(value).toString()
                        }
                        types[5] -> {
                            result = yearToMonth(value).toString()
                        }
                        types[6] ->{
                            result = value.toString()
                        }
                        types[7] -> {
                            result = yearToCentury(value).toString()
                        }
                    }
                }
                types[7] -> {
                    when(secondMeasure){
                        types[0] -> {
                            result = centuryToSeconds(value).toString()
                        }
                        types[1] -> {
                            result = centuryToMinutes(value).toString()
                        }
                        types[3] -> {
                            result = centuryToHours(value).toString()
                        }
                        types[3] -> {
                            result = centuryToDay(value).toString()
                        }
                        types[4] -> {
                            result = centuryToWeek(value).toString()
                        }
                        types[5] -> {
                            result = centuryToMonth(value).toString()
                        }
                        types[6] -> {
                            result = centuryToYear(value).toString()
                        }
                        types[7] ->{
                            result = value.toString()
                        }
                    }
                }
            }

            return result
        }

        private fun secondsToMinutes(seconds: Int) = seconds / 60
        private fun secondsToHours(seconds: Int) = seconds / (60*60)
        private fun secondsToDay(seconds: Int) = seconds / ((60*60)*24)
        private fun secondsToWeek(seconds: Int) = seconds / (((60*60) * 24) * 7)
        private fun secondsToMonth(seconds: Int) = seconds / (((60*60) * 24) * 30)
        private fun secondsToYear(seconds: Int) = seconds / (((60*60) * 24) * 365)
        private fun secondsToCentury(seconds: Int) = seconds / ((((60*60) * 24) * 365) * 100)


        private fun minutesToSeconds(minutes: Int) = minutes * 60
        private fun minutesToHours(minutes: Int) = minutes / 60
        private fun minutesToDay(minutes: Int) = minutes / (60 * 24)
        private fun minutesToWeek(minutes: Int) = minutes / (60 * 24 * 7)
        private fun minutesToMonth(minutes: Int) = minutes / (60 * 24 * 30)
        private fun minutesToYear(minutes: Int) = minutes / (60 * 24 * 365)
        private fun minutesToCentury(minutes: Int) = minutes / (60 * 24 * 365 * 100)

        private fun hoursToSeconds(hours: Int) = hours * 60 * 60
        private fun hoursToMinutes(hours: Int) = hours * 60
        private fun hoursToDay(hours: Int) = hours / 24
        private fun hoursToWeek(hours: Int) = hours / (24 * 7)
        private fun hoursToMonth(hours: Int) = hours / (24 * 30)
        private fun hoursToYear(hours: Int) = hours / (24 * 365)
        private fun hoursToCentury(hours: Int) = hours / (24 * 365 * 100)

        private fun dayToSeconds(day: Int) = day * 60 * 60 * 24
        private fun dayToMinutes(day: Int) = day * 60 * 24
        private fun dayToHours(day: Int) = day * 24
        private fun dayToWeek(day: Int) = day / 7
        private fun dayToMonth(day: Int) = day / 30
        private fun dayToYear(day: Int) = day / 365
        private fun dayToCentury(day: Int) = day / (365 * 100)

        private fun weekToSeconds(week: Int) = week * 7 * 24 * 60 * 60
        private fun weekToMinutes(week: Int) = week * 7 * 24 * 60
        private fun weekToHours(week: Int) = week * 7 * 24
        private fun weekToDay(week: Int) = week * 7
        private fun weekToMonth(week: Int) = week / 30
        private fun weekToYear(week: Int) = week / 365
        private fun weekToCentury(week: Int) = week / (365 * 100)

        private fun monthToSeconds(month: Int) = month * 30 * 24 * 60 * 60
        private fun monthToMinutes(month: Int) = month * 30 * 24 * 60
        private fun monthToHours(month: Int) = month * 30 * 24
        private fun monthToDay(month: Int) = month * 30
        private fun monthToWeek(month: Int) = (month * 30) / 7
        private fun monthToYear(month: Int) = month / 12
        private fun monthToCentury(month: Int) = month / (12 * 100)

        private fun yearToSeconds(year: Int) = year * 365 * 24 * 60 * 60
        private fun yearToMinutes(year: Int) = year * 365 * 24 * 60
        private fun yearToHours(year: Int) = year * 365 * 24
        private fun yearToDay(year: Int) = year * 365
        private fun yearToWeek(year: Int) = (year * 365) / 7
        private fun yearToMonth(year: Int) = (year * 365) / 30
        private fun yearToCentury(year: Int) = year / 100

        private fun centuryToSeconds(century: Int) = century * 100 * 365 * 24 * 60 * 60
        private fun centuryToMinutes(century: Int) = century * 100 * 365 * 24 * 60
        private fun centuryToHours(century: Int) = century * 100 * 365 * 24
        private fun centuryToDay(century: Int) = century * 100 * 365
        private fun centuryToWeek(century: Int) = (century * 100 * 365) / 7
        private fun centuryToMonth(century: Int) = (century * 100 * 365) / 30
        private fun centuryToYear(century: Int) = century * 100
    }
}