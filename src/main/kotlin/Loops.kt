fun findLargestDigit() {
    /* Napišite program koji od korisnika traži unos broja unutar granica zadanih također
    korisničkim unosom. Unos se ponavlja sve dok se ne unese broj unutar željenih granica.
Kada je unesen broj, potrebno je pronaći njegovu najveću znamenku.
 */
    var lowerBound = readln().toInt()
    var upperBound = readln().toInt()
    var number: Int
    do {
        println("Enter number: ")
        number = readln().toInt()
    } while(number < lowerBound || number > upperBound)

    var largestDigit = 0
    var currentDigit: Int
    while(number > 0) {
        currentDigit = number % 10
        if(largestDigit < currentDigit)
            largestDigit = currentDigit
        number /= 10
    }
    println("Largest digit is $largestDigit")
}

fun calculateSum() {
    /* Napišite program koji uz pomoć for petlje računa i na ekran ispisuje sumu prvih n
    prirodnih brojeva, gdje se n zadaje s tipkovnice. */
    var n = readln().toInt()
    var sum = 0
    for(i in (1..n))
        sum += i
    println("Sum of first n natural numbers is $sum")
}

fun main(args: Array<String>) {
    calculateSum()
    findLargestDigit()
}