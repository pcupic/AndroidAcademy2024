import kotlin.random.Random

/* Napišite program za igranje kartaške igre War. Kreirajte klasu koja predstavlja kartu. Za
boje i vrijednosti možete rabiti takozvane enum klase. Kreirajte klasu koja predstavlja
špil i omogućuje miješanje i dijeljenje po jedne karte. S obzirom da postoje 52 karte,
možete rabiti polje (engl. array – pogledati dokumentaciju). Svaki igrač u svakoj rundi
dobije po 1 kartu. Rundu dobiva igrač s jačom kartom (veći broj, as je najjači). Napišite
funkciju koja omogućuje igranje ove igre za dva igrača. */

enum class Suit {
    HEARTS, DIAMONDS, CLUBS, SPADES
}

enum class Rank(val value: Int) {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(11), QUEEN(12), KING(13), ACE(14)
}

data class Card(val suit: Suit, val rank: Rank) {
    override fun toString(): String {
        return "${rank.name} of ${suit.name}"
    }
}

class Deck {
    private val cards: MutableList<Card> = mutableListOf()

    init {
        for (suit in Suit.values()) {
            for (rank in Rank.values()) {
                cards.add(Card(suit, rank))
            }
        }
        shuffle()
    }

    fun shuffle() {
        cards.shuffle(Random)
    }

    fun draw(): Card? {
        return if (cards.isNotEmpty()) cards.removeAt(cards.size - 1) else null
    }
}

fun playWar() {
    val deck = Deck()

    // Players' hands
    val player1Hand = mutableListOf<Card>()
    val player2Hand = mutableListOf<Card>()

    while (true) {
        val card1 = deck.draw()
        val card2 = deck.draw()

        if (card1 == null || card2 == null) break

        player1Hand.add(card1)
        player2Hand.add(card2)

        println("Player 1 drew: $card1")
        println("Player 2 drew: $card2")

        when {
            card1.rank.value > card2.rank.value -> println("Player 1 wins this round!\n")
            card1.rank.value < card2.rank.value -> println("Player 2 wins this round!\n")
            else -> println("It's a tie!\n")
        }
    }

    println("Game Over!")
    println("Player 1 has ${player1Hand.size} cards left.")
    println("Player 2 has ${player2Hand.size} cards left.")

    when {
        player1Hand.size > player2Hand.size -> println("Player 1 wins the game!")
        player1Hand.size < player2Hand.size -> println("Player 2 wins the game!")
        else -> println("It's a tie overall!")
    }
}

fun main() {
    playWar()
}