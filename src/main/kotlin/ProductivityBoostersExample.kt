import java.time.LocalDate
import java.time.chrono.ChronoLocalDate

class ProductivityBoostersExample : ExampleCodeInterface {

    fun namedArgumentsExample() {
        fun format(userName: String, domain: String) = "$userName@$domain"

        print("unnamed and in the correct order: "); println(format("mario", "example.com"))
        print("unnamed and in the wrong order: "); println(format("domain.com", "username"))
        print("named and in the default order: "); println(format(userName = "cschmitz", domain = "labelinsight.com"))
        print("named and in a different order: "); println(format(domain = "mycoolsite.biz", userName = "me"))
    }

    fun stringTemplatesExample() {
        val greeting = "Kotliner"
        println("Hello $greeting")
        println("Hello ${greeting.toUpperCase()}")
    }

    fun destructuringDeclarations() {
        fun findMinMax(list: List<Int>): Pair<Int, Int> {
            return Pair(50, 100)
        }

        val testArray = arrayOf(5, 10, 15)
        val (x, y, z) = testArray
        println("For array: $testArray")

        println("x: $x")
        println("y: $y")
        println("z: $z")

        val map = mapOf("Alice" to 21, "Bob" to 25)
        println("For array: $map")
        for ((name, age) in map) {
            println("$name is $age years old.")
        }

        val range = listOf(100, 90, 50, 98, 76, 83)
        val (min, max) = findMinMax(range)
        println("For range: $range")
        println("Min: $min")
        println("Max: $max")

        data class User(val username: String, val email: String)

        fun getUser() = User("me", "me@mycoolcompany.biz")

        val user = getUser()
        val (username, email) = user
        println(username == user.component1())

        val (_, emailAddress) = getUser()

        println("Email address: $emailAddress")


        class Pair<K, V>(val first: K, val second: V) {
            operator fun component1(): K {
                return first
            }

            operator fun component2(): V {
                return second
            }
        }

        val (num, name) = Pair(1, "one")
        println("num = $num, name = $name")
    }

    fun smartCastsExample() {
        val date: ChronoLocalDate? = LocalDate.now()

        if (date != null) {
            println(date.isLeapYear)
        }

        if (date != null && date.isLeapYear) {
            println("it's a leap year!")
        }

        if (date == null || !date.isLeapYear) {
            println("There is no Feb 29th this year...")
        }
        if (date is LocalDate) {
            val month = date.monthValue
            println(month)
        }
    }

    override fun runExamples() {
        println("===> Productivity Booster Examples <===")
        println()

        println("---> Named arguments example")
        namedArgumentsExample()
        println()

        println("---> String templates example")
        stringTemplatesExample()
        println()

        println("---> Destructuring declarations example")
        destructuringDeclarations()
        println()

        println("---> Smart casts example")
        smartCastsExample()
        println()
    }
}
