import java.lang.Math.abs

class CollectionExamples : ExampleCodeInterface {

    fun listExample() {
        val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)
        val sudoers: List<Int> = systemUsers

        fun addSudoer(newUser: Int) {
            systemUsers.add(newUser)
        }

        fun getSysSudoers(): List<Int> {
            return sudoers
        }

        addSudoer(4)
        println("Total sudoers: ${getSysSudoers().size}")
        getSysSudoers().forEach { i ->
            println("Some useful info on user $i")
        }
    }

    fun setExample() {
        val adjectives: MutableSet<String> = mutableSetOf("cool", "awesome", "radical")

        fun addIssue(uniqueAdjectives: String): Boolean {
            return adjectives.add(uniqueAdjectives)
        }

        fun getStatusLog(isAdded: Boolean): String {
            return if (isAdded) "registered correctly!" else "marked as duplicate and rejected :|"
        }

        val newAdjectives: String = "nice"
        val collidingAdj = "cool"

        println("Adj $newAdjectives ${getStatusLog(addIssue(newAdjectives))}")
        println("Adj collision $collidingAdj ${getStatusLog(addIssue(collidingAdj))}")
    }

    fun mapExample() {
        val POINTS_X_PASS: Int = 15

        val EZPassAccounts: MutableMap<Int, Int> = mutableMapOf(1 to 100, 2 to 100, 3 to 100)
        val EZPassReport: Map<Int, Int> = EZPassAccounts

        fun updatePointsCredit(accountId: Int) {
            if (EZPassAccounts.containsKey(accountId)) {
                println("Updating $accountId")
                EZPassAccounts[accountId] = EZPassAccounts.getValue(accountId) + POINTS_X_PASS
            } else {
                println("Error: Trying to update a non-existing account (id: $accountId)")
            }
        }

        fun accountsReport() {
            println("Ez-Pass report:")
            EZPassReport.forEach { key, value -> println("ID $key: credit $value") }
        }

        accountsReport()
        updatePointsCredit(1)
        updatePointsCredit(1)
        updatePointsCredit(5)
        accountsReport()
    }

    fun filterExample() {
        val numbers = listOf(1, -2, 3, -4, 5, -6)
        val positives = numbers.filter { x -> x > 0 }
        val negatives = numbers.filter { x -> x < 0 }
        println("Positive numbers $positives")
        println("Negative numbers $negatives")
    }

    fun functionalMapExample() {
        val numbers = listOf(1, -2, 3, -4, 5, -6)
        val doubled = numbers.map { x -> x * 2 }
        val tripled = numbers.map { x -> x * 3 }

        println("Numbers: $numbers")
        println("Doubled: $doubled")
        println("Tripled: $tripled")
    }

    fun allAnyNoneExample() {
        val numbers = listOf(1, -2, 3, -4, 5, -6)
        val anyNegative = numbers.any { it < 0 }
        val anyGT6 = numbers.any { it > 6 }

        println("Any negative numbers: $anyNegative")
        println("Any numbers greater than six: $anyGT6")

        val allEven = numbers.all { it % 2 == 0 }
        val allLessThanSix = numbers.all { it < 6 }

        println("All even numbers: $allEven")
        println("All numbers less than six: $allLessThanSix")

        val areNoneEven = numbers.none { it % 2 == 1 }
        val areNoneGreaterThanSix = numbers.none { it > 6 }

        println("Numbers : $numbers")
        println("Are none of the numbers even?: $areNoneEven")
        println("Are none of the numbers greater than six?: $areNoneGreaterThanSix")
    }

    fun findAndFindLastExample() {
        val words = listOf("Let's", "find", "something", "in", "collection", "somehow")

        val first = words.find { it.startsWith("some") }
        val last = words.findLast { it.startsWith("some") }
        val notFound = words.find { it.contains("nothing") }

        println("For words: $words")
        println("Find first `some*`: $first")
        println("Find last `some*`: $last")
        println("Try to find something not there: $notFound")
    }

    fun firstAndLastExample() {
        val numbers = listOf(1, -2, 3, -4, 5, -6)

        val first = numbers.first()
        val last = numbers.last()

        val firstEven = numbers.first { it % 2 == 0 }
        val lastOdd = numbers.last { it % 2 != 0 }

        println("For numbers: $numbers")
        println("First number: $first")
        println("Last number: $last")
        println("First even: $firstEven")
        println("Last odd: $lastOdd")
    }

    fun firstNullAndLastNullExample() {
        val words = listOf("foo", "bar", "baz", "faz")
        val empty = emptyList<String>()

        val first = empty.firstOrNull()
        val last = empty.lastOrNull()

        val firstF = words.firstOrNull { it.startsWith("f") }
        val firstZ = words.firstOrNull { it.startsWith("z") }

        val lastF = words.lastOrNull { it.endsWith("f") }
        val lastZ = words.lastOrNull { it.endsWith("z") }

        println("For words: $words")
        println("firstOrNull on an empty list: $first")
        println("lastOrNull on an empty list: $last")
        println("First word that starts with an f: $firstF")
        println("First word that starts with a z (does not exist): $firstZ")
        println("last word that ends with an f (does not exist): $lastF")
        println("last word that ends with a z: $lastZ")
    }

    fun countExample() {
        val numbers = listOf(1, -2, 3, -4, 5, -6)

        val totalCount = numbers.count()
        val evenCount = numbers.count { it % 2 == 0 }

        println("For numbers: $numbers")
        println("Total count: $totalCount")
        println("Count of even numbers: $evenCount")
    }

    fun associateByAndGroupByExample() {
        data class Person(val name: String, val city: String, val phone: String)

        val people = listOf<Person>(
            Person("Chris", "St. Louis", "666.555.4444"),
            Person("Zoe", "San Diego", "555.444.3333"),
            Person("Petey", "Chicago", "111.222.3333"),
            Person("Madori", "Chicago", "666.777.8888"),
            Person("Lily", "St. Louis", "666.555.4444"),
        )

        // * Note that you can use either a lambda or a parameter for this.
        // * The big difference is the way you specify the parameter.
        val phoneBook = people.associateBy { it.phone }
        // val phoneBook = people.associateBy(Person::phone)
        val cityBook = people.associateBy(Person::phone, Person::city)
        val peopleCities = people.groupBy(Person::city, Person::name)

        println("For people:")
        people.forEach { println(it) }
        println()

        println("Phone book:")
        phoneBook.forEach { println(it) }
        println()

        println("City book:")
        cityBook.forEach { println(it) }
        println()

        println("People/city grouping:")
        peopleCities.forEach { println(it) }
    }

    fun partitionExample() {
        val numbers = listOf(1, -2, 3, -4, 5, -6)

        val evenOdd = numbers.partition { it % 2 == 0 }
        val (positives, negatives) = numbers.partition { it > 0 }

        println("For numbers: $numbers")
        println()
        println("Even and Odd lists: $evenOdd")
        println("Positives: $positives")
        println("Negatives: $negatives")
    }

    fun flatMapExample() {
        val numbers = listOf(1, 2, 3)

        val tripled = numbers.flatMap { listOf(it, it, it) }

        println("For numbers: $numbers")
        println("Triple repeat: $tripled")
    }

    fun minMaxExample() {
        val numbers = listOf(1, 2, 3)
        val emptyList = emptyList<Int>()

        println("Numbers: $numbers, min: ${numbers.minOrNull()}, max: ${numbers.maxOrNull()}")
        println("Empty: $emptyList, min = ${emptyList.minOrNull()}, max = ${emptyList.maxOrNull()}")
    }

    fun sortedExample() {
        val shuffled = listOf(5, 4, 2, 1, 3, -10)

        val natural = shuffled.sorted()
        val inverted = shuffled.sortedBy { -it }
        val descending = shuffled.sortedDescending()
        val descBy = shuffled.sortedByDescending { abs(it) }

        println("For list: $shuffled")
        println("Sorted naturally: $natural")
        println("Sorted inversely: $inverted")
        println("Sorted descending: $descending")
        println("Sorted descending by absolute value: $descBy")
    }

    fun mapElementAccessExample() {
        val map = mapOf("key" to 42)

        val value1 = map["key"]
        val value2 = map["key2"]

        val value3: Int = map.getValue("key")

        val mapWithDefault = map.withDefault { searchKey -> searchKey.length }

        val value4 = mapWithDefault.getValue("keyTwo")

        println("For map: $map")
        println("Value for `map['key']`: $value1")
        println("Value for `map.getValue('key')`: $value3")

        println("Value for `map['key2']` (i.e. non-existing key): $value2")
        println("Value for non existent `key2` with a default value: $value4")

        try {
            map.getValue("anotherKey") // ! note this will def throw an exception
        } catch (e: NoSuchElementException) {
            println("message: $e")
        }
    }

    fun zipExample() {
        val A = listOf("a", "b", "c")
        val B = listOf(1, 2, 3, 4)

        val resultPairs = A zip B
        val resultReduce = A.zip(B)
        val resultReduceWithDefinedStructure = A.zip(B) { a, b -> "$a$b" }

        println("For lists")
        println("A: $A")
        println("B: $B")

        println("Result pairs: $resultPairs")
        println("Result reduced: $resultReduce")
        println("Result reduced with defined structure: $resultReduceWithDefinedStructure")
    }

    fun getOrElseExample() {
        val list = listOf(0, 10, 20)
        println(list.getOrElse(1) { 42 })
        println(list.getOrElse(10) { 42 })
    }

    override fun runExamples() {
        println("===> Collection Examples <==")
        println()

        println("---> List example")
        listExample()
        println()

        println("---> Set example")
        setExample()
        println()

        println("---> Map example")
        mapExample()
        println()

        println("---> Filter example")
        filterExample()
        println()

        println("---> Functional map example")
        functionalMapExample()
        println()

        println("---> All, any, none example")
        allAnyNoneExample()
        println()

        println("---> Find and FindLast example")
        findAndFindLastExample()
        println()

        println("---> First and last example")
        firstAndLastExample()
        println()

        println("---> firstOrNull and lastOrNull example")
        firstNullAndLastNullExample()
        println()

        println("---> Count example")
        countExample()
        println()

        println("---> AssociateBy and groupBy example")
        associateByAndGroupByExample()
        println()

        println("---> Partition example")
        partitionExample()
        println()

        println("---> Flatmap example")
        flatMapExample()
        println()

        println("---> Min and Max example")
        minMaxExample()
        println()

        println("---> Sorted example")
        sortedExample()
        println()

        println("---> Map Element example")
        mapElementAccessExample()
        println()

        println("---> Zip example")
        zipExample()
        println()

        println("---> GetOrElse example")
        getOrElseExample()
        println()
    }
}
