fun calculatePower(number: Int, exponent: Int) : Int {
    /* Napišite funkciju koja računa n-tu potenciju predanog joj broja. Rabiti for petlju,
potencija i broj su predstavljeni parametrima funkcije. Testirajte napisanu funkciju. */
    var powerOfNumber = 1
    for(i in (1..exponent)) {
        powerOfNumber *= number;
    }
    return powerOfNumber
}

fun isPrime(number: Int) : Boolean {
    /* Napišite funkciju koja za predan broj određuje je li on prost ili ne. Prost broj djeljiv
    je samo s brojem 1 i sa samim sobom. Broj predstavlja parametar funkcije. Koristiti neku
    od petlji obrađenih ranije. */
    if(number < 2) return false
    for(i in (2..number)) {
        if(number % i == 0)
            return false
    }
    return true
}

fun main() {
    var number = readln().toInt()
    var exponent = readln().toInt()
    var powerOfNumber = calculatePower(number, exponent)
    println("Power of number $number is $powerOfNumber")

    number = readln().toInt()
    if (isPrime(number))
        println("Number is prime")
    else
        println("Number is not prime")
}