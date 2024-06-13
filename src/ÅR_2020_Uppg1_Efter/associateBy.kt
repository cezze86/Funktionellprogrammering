package Dag1.AOC.`2020`

import java.io.File

/*Svetlana Isakova från JetBrains går igenom en version som förbättrar och förenklar, istället för forLoop associateBy som också verkar gå fortare att köra:
https://github.com/kotlin-hands-on/advent-of-code-2020/blob/master/src/day1/improvedPerformance.kt
Denna lösning hade jag lättare för att förstå.
Min lösning är väldigt basic men enkel att se och följa iterationen med forloopar.
I min lösning itererar jag igenom hela listan och för varje nummer tillsammans med annat nummer
kontrolleras de två (eller tre) mot summan som efterfrågas.

I Jetbrains lösning gör man en map med associateBy som
skapar nycklar av datat istället och beskriver det enligt nedan:

Exempeldata A- uppgift
numbers: [1721, 979, 366, 299, 675, 1456]
complements map: {299=1721, 1041=979, 1654=366, 1721=299, 1345=675, 564=1456}

Det första numret 1721 finns i map tillsammans med 299 vilket betyder att de två tillsammans är 2020.

Exempeldata B- uppgift
numbers: [1721, 979, 366, 299, 675, 1456]
complement pairs: {1721=null, 979=(366, 675), 366=(979, 675), 299=null, 675=(979, 366), 1456=null}

Det är bara nonNull nummer som tillsammans blir 2020 vilket associateBy räknar ut.
Det betyder att 1456,299 och 1721 inte kan paras med nummer som tillsammans blir 2020.

Jag hittade även en någon på Github som hade en lösnin med filter:
https://github.com/cluddles/aoc2020-kotlin/blob/master/src/main/kotlin/aoc2020/Day01.kt
Den är smart för att filter returnerar en lista med element som bara
matchar ett predikat, vilket jag tolkar som en typ av villkor. I GitHub-
användarens fall har hen valt "target".

*/


//Funktion för att hitta ett par av tal från listan som blir efterfrågad summa (2020)
fun List<Int>.twoOfSum(sum: Int): Pair<Int, Int>? {
//Skapa en karta av talen i listan
    val keySelects = associateBy { sum - it }
    //println(associateBy { sum - it})
//Iterera genom listan och leta efter ett tal vars komplement finns i kartan
    return firstNotNullOfOrNull { number ->
        val keySelect = keySelects[number]
        if (keySelect != null) Pair(number, keySelect) //Returnera paret om det hittas
        else null //Annars returnera null
    }
}

//Funktion som hittar tre summor som tillsammans blir 2020
fun List<Int>.threeOfSum(): Triple<Int, Int, Int>? =
    firstNotNullOfOrNull { x ->
/*Använder twoOfSum-funktionen för att hitta ett par av tal
som tillsammans är differensen mellan 2020 och x */
        twoOfSum(2020 - x)?.let { pair ->
            Triple(x, pair.first, pair.second)
        }
    }

fun main() {
//Läs in siffrorna från en fil och lägg dem till en lista av heltal
    val numbers = File("src/ÅR_2020_Uppg1_Efter/Data").readLines().map { it.toInt() }

//Hitta två tal där summan tillsammans är 2020, multiplicera dessa två
    val two = numbers.twoOfSum(2020)
    println(two)
    println(two?.let { (a, b) -> a * b })

//Hitta tre tal där summan tillsammans är 2020, multiplicera dessa tre
    val three = numbers.threeOfSum()
    println(three)
    println(three?.let { (x, y, z) -> x * y * z })
}
