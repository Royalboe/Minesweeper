class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field = when {
                name == "Dubai" && value > 57 || name == "Dubai" && value < -92 -> 30
                name == "Moscow" && value > 57 || name == "Moscow" &&  value < -92 -> 5
                name == "Hanoi" && value > 57 || name == "Hanoi" &&  value < -92 -> 20
                else -> value
            }
        }
}

fun printColdestCity(list: MutableMap<Int, String>) {
    val tempsAsKeys = list.keys.toList().sorted()
    val isTempTheSame = tempsAsKeys[0] == tempsAsKeys[1]
    if (isTempTheSame) {
        print("neither")
    } else {
        print(list[tempsAsKeys[0]])
    }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    //implement comparing here
    val cities= mutableMapOf(
        secondCity.degrees to secondCity.name,
        firstCity.degrees to firstCity.name,
        thirdCity.degrees to thirdCity.name
    )
    printColdestCity(cities)
}