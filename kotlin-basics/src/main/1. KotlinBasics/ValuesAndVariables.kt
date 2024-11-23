fun calculateAge() {
    /* Napravite varijable za godinu vašeg rođenja i trenutnu godinu.
    Izračunajte koliko godina imate. Izračunajte koliko ćete godina imati 2048. */
    var yearOfBirth = 2002
    var currentYear = 2024
    var currentAge = currentYear - yearOfBirth
    println("You are $currentAge old")
    var ageIn2048 = 2048 - yearOfBirth
    println("You will be $ageIn2048 old in 2048")
}

fun printNeighbours() {
    /* Napravite tri vrijednosti, za Vaše i imena dvaju osoba pokraj Vas na akademiji. Ispišite
    poruke u kojoj napominjete tko sjedi lijevo, a tko desno od koga. */
    var myName = "Patrik"
    var leftNeighbour = "Matko"
    var rightNeighbour = "Ante"
    println("Patrik's left neighbour is $leftNeighbour and right neighbour is $rightNeighbour. \n" +
            "Matko's left neighbour is unknown, but his right neighbour is $myName. \n" +
            "Ante's right neighbour is unknown, but his left neighbour is $myName")
}

fun main(args: Array<String>) {
    calculateAge()
    printNeighbours()
}