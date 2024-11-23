import java.util.Locale

fun findMax() {
    /*Napišite kod koji od korisnika zahtjeva unos 3 broja, a zatim nađite i ispišite najveći
    među njima. */
    var firstNumber = readln().toInt()
    var secondNumber = readln().toInt()
    var thirdNumber = readln().toInt()
    var max = Int.MIN_VALUE
    if(max < firstNumber) max = firstNumber
    if(max < secondNumber) max = secondNumber
    if(max < thirdNumber) max = thirdNumber
    println("Largest number is $max")
}

fun isVowel() {
    /* Napišite kod koji od korisnika zahtjeva unos znaka, a zatim korištenjem naredbe when
    određuje i na ekran ispisuje je li riječ o samoglasniku. */
    var character = readln().lowercase(Locale.getDefault())
    var isVowel = when(character) {
        "a" -> true
        "e" -> true
        "i" -> true
        "o" -> true
        "u" -> true
        else -> false
    }
    if(isVowel)
        println("Character is a vowel")
    else
        println("Character is not a vowel")
}

fun main(args: Array<String>) {
    findMax()
    isVowel()
}