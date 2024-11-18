import kotlin.collections.HashSet

fun countUniqueCharacters(word: String) : Int {
    /* Napišite funkciju koja za predani string broji koliko jedinstvenih znakova sadrži.
Testirajte funkciju s nekoliko različitih stringova. */
    var uniqueCharacters : HashSet<Char> = hashSetOf()
    for(letter in word)
        uniqueCharacters.add(letter)
    return uniqueCharacters.size
}

fun countVowels(word: String) : Int {
    /* Napišite funkciju koja za predani string broji koliko samoglasnika sadrži. Testirajte
funkciju s nekoliko različitih stringova.
 */
    var count = 0
    val vowels : Array<Char> = arrayOf('a', 'e', 'i', 'o', 'u')
    for(letter in word) {
            if(vowels.contains(letter.lowercaseChar()))
                count++
    }
    return count
}


fun isPasswordStrongEnough(passwordCandidate: String) : Boolean {
    /* Napišite funkciju koja za predani string provjerava bi li on činio dovoljno jaku lozinku.
    Da bi to činio, mora sadržavati barem jedno veliko slovo, jedan broj te biti dug barem 8
    znakova. Testirajte funkciju s nekoliko različitih stringova. */
    var hasDigit = false
    var hasUpperCase = false
    if(passwordCandidate.length < 8) return false
    for(character in passwordCandidate) {
        if(character.isDigit())
            hasDigit = true
        if(character.isUpperCase())
            hasUpperCase = true
    }
    return hasDigit && hasUpperCase
}

fun main() {
    println(isPasswordStrongEnough("Password123!")) // true
    println(isPasswordStrongEnough("pass123"))       // false
    println(isPasswordStrongEnough("PASSWORD"))      // false
    println(isPasswordStrongEnough("Pass!"))         // false
    println(isPasswordStrongEnough("Strong1!"))      // true

    println(countVowels("Hello"))      // 2
    println(countVowels("Kotlin"))     // 2
    println(countVowels("Programming")) // 3
    println(countVowels("AEIOU"))      // 5
    println(countVowels("xyz"))        // 0

    println(countUniqueCharacters("Hello"))          // 4 ('H', 'e', 'l', 'o')
    println(countUniqueCharacters("Kotlin"))         // 6 ('K', 'o', 't', 'l', 'i', 'n')
    println(countUniqueCharacters("Programming"))     // 8 ('P', 'r', 'o', 'g', 'a', 'm', 'i', 'n')
    println(countUniqueCharacters("AEIOU"))          // 5 ('A', 'E', 'I', 'O', 'U')
    println(countUniqueCharacters("aaa"))            // 1 ('a')
    println(countUniqueCharacters(""))                // 0 (prazan string)
}