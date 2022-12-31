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

    println("Write how many ml of water the coffee machine has: ")
    val availableWater = readln().toInt()

    println("Write how many ml of milk the coffee machine has: ")
    val availableMilk = readln().toInt()

    println("Write how many grams of coffee beans the coffee machine has: ")
    val availableBeans = readln().toInt()

    println("Write how many cups of coffee you will need: ")
    val cups = readln().toInt()
    requirements(cups)

    val waterCups = howManyCupsIngredientsCanMake(availableWater, ONE_CUP_WATER)
    val milkCups = howManyCupsIngredientsCanMake(availableMilk, ONE_CUP_MILK)
    val beanCups = howManyCupsIngredientsCanMake(availableBeans, ONE_CUP_BEANS)

    val numOfCups = mutableListOf(waterCups, milkCups, beanCups)
    var numOfCupsPossible = numOfCups.minOrNull()
    if (numOfCupsPossible == null) numOfCupsPossible = 0

    if (numOfCupsPossible == cups) {
        println("Yes, I can make that amount of coffee")
    } else if (numOfCupsPossible > cups) {
        val rem = numOfCupsPossible - cups
        println("Yes, I can make that amount of coffee (and even $rem more than that)")
    } else {
        println("No, I can make only $numOfCupsPossible cups of coffee")
    }
}

fun howManyCupsIngredientsCanMake(numerator: Int, denominator: Int): Int {
    return numerator / denominator
}

fun requirements(cups: Int) {
    val water = cups * ONE_CUP_WATER
    val milk = cups * ONE_CUP_MILK
    val beans = cups * ONE_CUP_BEANS
}
