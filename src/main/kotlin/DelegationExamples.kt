import kotlin.reflect.KProperty

class DelegationExamples : ExampleCodeInterface {

    interface SoundBehavior {
        fun makeSound()
    }

    fun delegationPatternExample() {
        class ScreamBehavior(val n: String) : SoundBehavior {
            override fun makeSound() = println("${n.toUpperCase()} !!!")
        }

        class RockAndRollBehavior(val n: String) : SoundBehavior {
            override fun makeSound() = println("I'm the king of rock 'n roll: $n")
        }

        class TomAraya(n: String) : SoundBehavior by ScreamBehavior(n)
        class ChuckBerry(n: String) : SoundBehavior by RockAndRollBehavior(n)

        val tom = TomAraya("Trash metal")
        tom.makeSound()

        val chuck = ChuckBerry("Jonnie b. Goode")
        chuck.makeSound()
    }

    fun delegatePropertiesExample() {

        class Delegate() {
            operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
                return "$thisRef, thank you for delegating '${prop.name}' to me!"
            }

            operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
                println("$value has been assigned to ${prop.name} in $thisRef")
            }
        }

        /**
         * There are a couple of things worth noting here:
         * * The `toString` method override is, of course, overriding a `toString` method, specifically the
         *   method on the root class type in kotlin, so when we fire the `println(e.p) line below we're
         *   implicitly calling the `toString` since the property that we're trying to print is a string (right?)
         */
        class Example {
            var p: String by Delegate()
            override fun toString(): String {
                return "Example class"
            }
        }

        val e = Example()
        println(e.p)
        e.p = "New"
    }

    override fun runExamples() {
        println("===> Delegation Pattern Examples <===")
        println()

        println("---> Delegation example")
        delegationPatternExample()
        println()

        println("--->  Delegated Properties example")
        delegatePropertiesExample()
        println()
    }
}
