package ÅR_2018_Uppg1_Före

import java.io.File

fun main() {

    val data: List<String> = File("src/ÅR_2018_Uppg1_Före/Frequency").readLines()

//Gör om element i listan till Integer.
    val frequencies = data.map { it.toInt() }

//En mängd som kommer att hålla koll på de frekvenser som redan har setts.
    val seenFrequencies = mutableSetOf<Int>()

//Variabel för att hålla den aktuella frekvensen när vi summerar listan.
    var currentFrequency = 0

//Lagrar den första frekvensen som upprepas.
    var firstDuplicate: Int? = null

//Loopar tills vi hittar den första frekvensen som upprepas.
    while (firstDuplicate == null) {
        for (i in frequencies) {
            //Lägger till den aktuella frekvensen till den totala frekvensen.
            currentFrequency += i
//Om aktuell frekvensen redan finns i mutableSet har vi hittat den första frekvensen som upprepas.
            if (seenFrequencies.contains(currentFrequency)) {
                firstDuplicate = currentFrequency
//Avslutar loopen då villkor uppnåtts
                break
            } else {
                seenFrequencies.add(currentFrequency)
            }
        }
    }

//Skriver ut den första frekvensen som upprepas.
    println("Första frekvens som man ser två gånger : $firstDuplicate")
}