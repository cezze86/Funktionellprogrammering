package ÅR_2018_Uppg1_Efter

import java.io.File

/*Efterlösningen till denna är huvudsakligen Todd Ginsberg. Han har så bra förklaringar
(även om hans 2018- lösning är svår) och de mest koncisa tycker jag, framför allt i AOC 2021.

Som jag förstår det loopar han igenom listan oändligt många gånger utan att starta om och sedan avslutas sökandet
efter att programmet uppnått den första hittade frekvensen två gånger.

I min lösning behöver programmet loopa genom HELA listan av frekvensförändringar och sedan börja om
tills vi hittar en upprepning av siffran igen vilket inte blir lika effektivt om vi har väldigt stor data.
Med detta sätt går det också att ändra vad vi vill leta efter på ett enklare och mer
överskådligt sätt.

I min lösning avslutas loopen med break när villkor uppnås till skillnad från Todds lösning som letar efter
upprepning av sekvens på egen hand.

https://todd.ginsberg.com/post/advent-of-code/2018/day1/

*/

//Interface för att skapa oändlig sekvens
fun <T> List<T>.infiniteSequence(): Sequence<T> = sequence {
//Kollar om listan är tom, om den inte är tom fortsätter listan att genereras
    if (this@infiniteSequence.isEmpty()) {
        return@sequence
    }

    while (true) {
//Hämta alla element i listan
        yieldAll(this@infiniteSequence)
    }
}


fun partB(input: List<Int>): Int {
//Mutable set för att lagra frekvenser
    val frequencies = mutableSetOf(0)

    var sum = 0
/*Uppdatera summan med det aktuella elementet,
Returnera den uppdaterade summan
Kontrollera om summan redan har setts*/
    return input.infiniteSequence().map {
        sum += it

        sum
    }.first {

        !frequencies.add(it)
    }
}

fun main() {

    val inputFileName = "src/ÅR_2018_Uppg1_Efter/Frequency"
//Läser raderna och gör om till integers.
    val data = File(inputFileName).readLines().map { it.toInt() }

    val firstDuplicateResult = partB(data)

    println("Första frekvens som man ser två gånger: $firstDuplicateResult")
}










