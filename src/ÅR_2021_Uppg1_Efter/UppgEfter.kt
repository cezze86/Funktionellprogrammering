package ÅR_2021_Uppg1_Efter

import java.io.File

/*Mestadels inspirerad av Ginsberg. zipWithNext är
en av hans favoritfunktioner i Kotlins bibliotek.

https://todd.ginsberg.com/post/advent-of-code/2021/day1/

I A- uppgiften gör Kotlin snygga par av integers (element) med zipWithNext.
Detta göra att man slipper loopa igenom varje enskilt nummer och kontrollera
storleken i förhållande till numret innan.

I hans B- lösning ordnar Kotlin en lista med fönster av elementen direkt i B-uppgiften enligt nedan:
Från:
(1, 2, 3, 4, 5, 6, 7, 8, 9)
Till:
([1, 2, 3](ett fönster), [2, 3, 4](ett fönster till), [3, 4, 5](osv)
Med detta sätt är det mycket lättare att jämföra och beräkna dessa fönster


I min lösning:
Från (1, 2, 3, 4, 5, 6, 7, 8, 9)
Första tre elementen [1,2,3] 1+2+3
(1)+2+3+4-(1)= nytt fönster [2,3,4]
 Till
*/


/*Tar in en lista av heltal och räknar antalet par
av intilliggande element (ex.[1,2] och [3,4]) där det första elementet är mindre än det andra.*/
fun assignmentA(input: List<Int>): Int = input.zipWithNext().count { it.first < it.second }

/*Tar in en lista av heltal, grupperar dem i tre fönster och lägger ihop varje fönster.
Sedan räknar den antalet par av fönster och kollar
summan av det första fönstret och om det i sådana fall är mindre än summan av det andra fönstret.*/
fun assignmentB(input: List<Int>): Int = input.windowed(3, 1) { it.sum() }.zipWithNext().count { it.first < it.second }

fun main() {
//Läser in data
    val inputFile = File("src/ÅR_2021_Uppg1_Efter/DataEfter")

//Läser varje rad till integers
    val inputData: List<Int> = try {
        inputFile.readLines().map { it.toInt() }
    } catch (e: Exception) {
        println("Error reading input file: ${e.message}")
        emptyList()
    }

    if (inputData.isNotEmpty()) {
        println("Uppgift A: ${assignmentA(inputData)}")
        println("Uppgift B: ${assignmentB(inputData)}")
    }
}


