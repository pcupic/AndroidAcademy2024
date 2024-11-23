/* Definirajte klasu koja predstavlja krug, čije stanje čini polumjer kruga a ponašanje
uključuje izračun površine i opsega kruga. Omogućite stvaranje jediničnog kruga kao i
kruga sa zadanim polumjerom. Napišite testni program za klasu krug.
*/
class Circle(val radius: Double) {

    constructor() : this(1.0)
    fun calculateArea() : Double {
        return (radius * radius) * Math.PI
    }
    fun calculateCircumference() : Double {
        return 2 * radius * Math.PI
    }
}

/* Definirajte klasu koja predstavlja točku u 2D prostoru čije stanje čine x i y koordinata.
Omogućite stvaranje točaka podrazumijevanim konstruktorom, konstruktorom koji obje
koordinate postavlja na istu vrijednost kao i točke s proizvoljnim koordinatama.
Definirajte metodu za translaciju koja za predan pomak u x i y smjeru pomiče točku.
Definirajte metodu koja računa euklidsku udaljenost između trenutne i točke zadane
parametrom metode. Napišite testni program za klasu koja predstavlja točku. */

class Point(var x : Double, var y : Double) {
    constructor(value : Double) : this(value, value)
    constructor() : this(0.0, 0.0)

    fun translate(deltaX : Double, deltaY : Double) {
        x += deltaX
        y += deltaY
    }

    fun calculateDistance(other: Point): Double {
        return Math.sqrt(Math.pow(other.x - x, 2.0) + Math.pow(other.y - y, 2.0))
    }
}

class Tester() {
    fun testUnitCircle() {
        val unitCircle = Circle()
        println("Unit Circle:")
        println("Radius: ${unitCircle.radius}")
        println("Area: ${unitCircle.calculateArea()}")
        println("Circumference: ${unitCircle.calculateCircumference()}")
    }

    fun testCircleWithSpecifiedRadius() {
        val circleWithRadius = Circle(5.0)
        println("\nCircle with a radius of 5.0:")
        println("Radius: ${circleWithRadius.radius}")
        println("Area: ${circleWithRadius.calculateArea()}")
        println("Circumference: ${circleWithRadius.calculateCircumference()}")
    }

    fun testPointCreation() {
        // Test default constructor
        val point1 = Point()
        assert(point1.x == 0.0 && point1.y == 0.0) { "Default constructor failed" }

        // Test single value constructor
        val point2 = Point(5.0)
        assert(point2.x == 5.0 && point2.y == 5.0) { "Single value constructor failed" }

        // Test two value constructor
        val point3 = Point(3.0, 4.0)
        assert(point3.x == 3.0 && point3.y == 4.0) { "Two value constructor failed" }

        println("Point creation tests passed.")
    }

    fun testTranslate() {
        val point = Point(1.0, 2.0)
        point.translate(3.0, 4.0)

        assert(point.x == 4.0 && point.y == 6.0) { "Translate method failed" }

        println("Translate test passed.")
    }

    fun testCalculateDistance() {
        val pointA = Point(1.0, 2.0)
        val pointB = Point(4.0, 6.0)

        val distance = pointA.calculateDistance(pointB)

        // Expected distance calculated using the distance formula: sqrt((4-1)^2 + (6-2)^2) = sqrt(9 + 16) = sqrt(25) = 5
        assert(distance == 5.0) { "Calculate distance method failed" }

        println("Calculate distance test passed.")
    }
}

fun main() {
    val tester = Tester()
    tester.testUnitCircle()
    tester.testCircleWithSpecifiedRadius()
    tester.testPointCreation()
    tester.testTranslate()
    tester.testCalculateDistance()
}