class ScopeFunctionExamples : ExampleCodeInterface {
    fun customPrint(s: String) {
        print(s.toUpperCase())
    }

    fun letExample() {
        val empty = "test".let {
            customPrint(it)
            it.isEmpty()
        }

        println(" is empty: $empty")

        fun printNonNull(str: String?) {
            println("Printing \"$str\":")
            str?.let {
                print("\t")
                customPrint(it)
                println()
            }
        }

        printNonNull(null)
        printNonNull("my string")
    }

    fun runExample() {
        fun getNullableLength(ns: String?) {
            println("form \"$ns\":")
            ns?.run {
                println("\tis empty? " + isEmpty())
                println("\tlength = $length")
                length
            }
        }

        getNullableLength(null)
        getNullableLength("")
        getNullableLength("some string with Kotlin")
    }

    fun withExample() {
        class Configuration(var host: String, var port: Int)

        // * example of named and non-named parameters
        val config = Configuration(host = "127.0.0.1", 9000)

        // ? we can use this:
        with(config) {
            println("$host:$port")
        }
        // ? instead of this:
        println("${config.host}:${config.port}")
    }

    fun applyExample() {
        data class Person(var name: String, var age: Int, var about: String) {
            constructor() : this("", 0, "")
        }

        val chris = Person()
        println("Chris pre-apply: $chris")

        val stringDescription = chris.apply {
            name = "Chris"
            age = 39
            about = "dev"
        }

        println(stringDescription)
        println("Chris post-apply: $chris")
    }

    fun alsoExample() {
        data class Person(var name: String, var age: Int, var about: String) {
            constructor() : this("", 0, "")
        }

        fun writeCreationLog(p: Person) {
            println("A new person ${p.name}, age ${p.age}, was created.")
        }

        val chris = Person("Chris", 39, "dev")
            .also {
                writeCreationLog(it)
            }
            .also {
                println("Incrementing age...")
                it.age = 40
            }
            .also {
                println("Happy ${it.age}th Birthday!")
            }
    }

    override fun runExamples() {
        println("===> Scope Function Examples <===")
        println()

        println("---> Let example")
        letExample()
        println()

        println("---> Run example")
        runExample()
        println()

        println("---> With example")
        withExample()
        println()

        println("---> Apply example")
        applyExample()
        println()

        println("---> Also example")
        alsoExample()
        println()
    }
}