package ÅR_2021_Uppg1_Före

import java.io.File

val dataF: List<String> = File("src/ÅR_2021_Uppg1_Före/data").readLines()

//Gör om lista av stringar till integer
val dataList=dataF.map {it.toInt()}.toIntArray()


fun main() {

//Räkna antalet mätningar (measurements)
    var count = 0
/*Börjar räkna från 1 då 0 (118, ingen tidigare mätning) i min lista inte räknas och
loopar igenom listans storlek*/
    for (measurements in 1 until dataList.size) {
//Kollar om mätningen är större än den förra mätningen
        if (dataList[measurements] > dataList[measurements - 1]) {

//om större, räkna 1
            count++
        }
    }

    println("Antal mätningar som är större än mätningen innan: $count")
}