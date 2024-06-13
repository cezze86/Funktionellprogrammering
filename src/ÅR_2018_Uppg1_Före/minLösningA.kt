import java.io.File

val data: List<String> = File("src/ÅR_2018_Uppg1_Före/Frequency").readLines()

val dataList=data.map {it.toInt()}.toIntArray()



fun main() {
//Jag krånglade ganska länge i mitt huvud med att tänka något i stil med:
    //Addera alla positiva nummer sedan subtrahera alla negativa (11+14+8 osv -11+2+13 osv).
    // Sum() var ju självfallet den bästa lösningen
    //+11
    //+14
    //+10
    //-8
    //-13
    //-2
    //+8
    //+14
    //-11
    println(dataList.sum())

}

