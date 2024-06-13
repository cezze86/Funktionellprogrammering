package Dag1.AOC.`2020`

import java.io.File

val datat: List<String> = File("src/ÅR_2020_Uppg1_Före/Data").readLines()

//Gör om strängarna till array av heltal
val datatList=datat.map {it.toInt()}.toIntArray()

//Funktion för att hitta två tal från listan vars summa är 2020 och skriva ut dem samt deras produkt
fun sumOfTwo(){

    for (num1 in datatList){
        for (num2 in datatList) {
            if (num1 + num2 == 2020) {

                println("Två nummer som tillsammans är 2020: $num1 och $num2. De två multiplicerat blir ${num1*num2}")

                return

            }
        }
    }
}

//Funktion för att hitta tre tal från listan vars summa är 2020 och skriva ut dem samt deras produkt
fun sumOfThree(){

    for (num1 in datatList){
        for (num2 in datatList) {
            for (num3 in datatList)
                if (num1 + num2 + num3== 2020) {

                    println("Tre nummer som tillsammans är 2020: $num1, $num2 och $num3. De tre multiplicerat blir ${num1 * num2 * num3}")

                    return

                }
        }
    }
}


fun main() {

    sumOfTwo()

    sumOfThree()


}
