import kotlin.random.Random

/* Napišite program koji omogućuje igranje igre Jamb (engl. Yahtzee). Razdvojite
funkcionalnost u klase. Trebaju postojati klasa koja predstavlja kockicu, omogućuje
bacanje kockice i provjeru trenutnog stanja, klasa koja predstavlja ruku sa 6 kockica,
omogućije bacanje svih kockica, zaključavanje 0-6 kockica, bacanje samo otključanih
kockica, provjeru rezultata bacanja. Podržati barem 3 provjere za jamb (npr. jamb, poker,
skala). Napišite funkciju za provjeru napisane funkcionalnosti.
 */

class Die() {
    var value : Int = 1
        private set

    fun roll() {
        value = Random.nextInt(0, 7)
    }

    override fun toString(): String {
        return value.toString()
    }
}

class Hand() {
    private val dice : Array<Die> = Array(6) { Die() }
    private val isLocked: BooleanArray = BooleanArray(6) { false }

    fun rollAll() {
        for(i in dice.indices) {
            if(!isLocked[i])
                dice[i].roll()
        }
    }

    fun lockDice(index: Int) {
        if (index in 0 until 6) {
            isLocked[index] = true
        }
    }

    fun unlockDice(index: Int) {
        if (index in 0 until 6) {
            isLocked[index] = false
        }
    }

    fun getDiceValues() : List<Int> {
        return dice.map { it.value }
    }

    fun checkForJamb() : Boolean {
        return dice.groupBy { it.value }.any() {it.value.size == 5}
    }

    fun checkForPoker(): Boolean {
        return dice.groupBy { it.value }.any { it.value.size >= 4 } // Four of a kind
    }

    fun checkForScale(): Boolean {
        val sortedValues = getDiceValues().distinct().sorted()
        return sortedValues == listOf(1, 2, 3, 4, 5) || sortedValues == listOf(2, 3, 4, 5, 6)
    }
}

fun playYahtzee() {
    val hand = Hand()

    hand.rollAll()
    println("Rolled Dice: ${hand.getDiceValues()}")

    hand.lockDice(0)
    hand.lockDice(1)

    hand.rollAll()
    println("After re-rolling unlocked Dice: ${hand.getDiceValues()}")

    when {
        hand.checkForJamb() -> println("You have Jamb!")
        hand.checkForPoker() -> println("You have Poker!")
        hand.checkForScale() -> println("You have Scale!")
        else -> println("No special combinations.")
    }
}

fun main() {
    playYahtzee()
}