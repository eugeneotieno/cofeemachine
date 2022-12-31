const val STEPS = """
Starting to make a coffee
Grinding coffee beans
Boiling water
Mixing boiled water with crushed coffee beans
Pouring coffee into the cup
Pouring some milk into the cup
Coffee is ready!
"""

const val ONE_CUP_WATER = 200
const val ONE_CUP_MILK = 50
const val ONE_CUP_BEANS = 15

fun main() {
    println("Write how many cups of coffee you will need: ")
    val cups = readln().toInt()
    val water = cups * ONE_CUP_WATER
    val milk = cups * ONE_CUP_MILK
    val beans = cups * ONE_CUP_BEANS

    println("For $cups cups of coffee you will need: ")
    println("$water ml of water")
    println("$milk ml of milk")
    println("$beans g of coffee beans")
}