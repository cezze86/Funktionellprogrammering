import java.io.File

fun main() {
//Läser in data från en fil och konverterar varje rad till en heltal och lagrar dem i en lista
    val data: List<String> = File("src/ÅR_2021_Uppg1_Före/data").readLines()
    val dataList = data.map { it.toInt() }

//Antal element i map som ska mätas mot varandra
    val windowSize = 3
    var count = 0 // Räknare för att räkna antalet gånger summan ökar i fönstret

/*Kontrollerar om dataList har tillräckligt med
element för att bilda ett fönster och beräknar summan av första fönstret*/
    if (dataList.size >= windowSize) {
        var previousSum = dataList.take(windowSize).sum() // Beräknar summan för det första fönstret

        for (i in windowSize until dataList.size) {
//Räknar summan för det nuvarande fönstret genom att lägga till det nya värdet och subtrahera det äldsta värdet
            val currentWindowSum = previousSum + dataList[i] - dataList[i - windowSize]
//Om summan i det nuvarande fönstret är större än summan för det föregående fönstret, räkna 1
            if (currentWindowSum > previousSum) {
                count++
            }
//Uppdaterar summan för det föregående fönstret till summan för det nuvarande fönstret
            previousSum = currentWindowSum
        }
    }

    println("Antal gånger summan visar sig i fönstret: $count")
}
