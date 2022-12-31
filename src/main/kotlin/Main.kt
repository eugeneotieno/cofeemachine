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

const val ONE_CUP_ESPRESSO_WATER = 250
const val ONE_CUP_ESPRESSO_BEANS = 16
const val ONE_CUP_ESPRESSO_PRICE = 4

const val ONE_CUP_LATTE_WATER = 350
const val ONE_CUP_LATTE_MILK = 75
const val ONE_CUP_LATTE_BEANS = 20
const val ONE_CUP_LATTE_PRICE = 7

const val ONE_CUP_CAPPUCCINO_WATER = 200
const val ONE_CUP_CAPPUCCINO_MILK = 100
const val ONE_CUP_CAPPUCCINO_BEANS = 12
const val ONE_CUP_CAPPUCCINO_PRICE = 6

var availableWater = 400
var availableMilk = 540
var availableBeans = 120
var disposableCups = 9
var amountLeft = 550

fun main() {
    actions()
}

fun showMachineState(){
    println()
    println("The coffee machine has:")
    println("$availableWater ml of water")
    println("$availableMilk ml of milk")
    println("$availableBeans g of coffee beans")
    println("$disposableCups disposable cups")
    println("$$amountLeft of money")
    println()
}

fun actions() {
    var exit = false
    do {
        println("Write action (buy, fill, take, remaining, exit): ")
        when(readln()) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> showMachineState()
            "exit" -> exit = true
        }
    } while (!exit)

}

fun buy(){
    println()
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    when(readln()) {
        "1" -> {
            val waterCups = howManyCupsIngredientsCanMake(availableWater, ONE_CUP_ESPRESSO_WATER)
            val beanCups = howManyCupsIngredientsCanMake(availableBeans, ONE_CUP_ESPRESSO_BEANS)

            val numOfCups = mutableListOf(waterCups, beanCups)
            var numOfCupsPossible = numOfCups.minOrNull()
            if (numOfCupsPossible == null) numOfCupsPossible = 0

            if (numOfCupsPossible > 0) {
                println("I have enough resources, making you a coffee!")

                availableWater -= ONE_CUP_ESPRESSO_WATER
                availableBeans -= ONE_CUP_ESPRESSO_BEANS
                amountLeft += ONE_CUP_ESPRESSO_PRICE
                disposableCups -= 1

                println()
            } else {
                when (numOfCups.indexOf(numOfCupsPossible)) {
                    0 -> {
                        println("Sorry, not enough water!")
                    }
                    1 -> {
                        println("Sorry, not enough coffee beans!")
                    }
                    else -> {
                        println("Sorry, not enough milk!")
                    }
                }

                println()
            }
        }
        "2" -> {
            val waterCups = howManyCupsIngredientsCanMake(availableWater, ONE_CUP_LATTE_WATER)
            val beanCups = howManyCupsIngredientsCanMake(availableBeans, ONE_CUP_LATTE_BEANS)
            val milkCups = howManyCupsIngredientsCanMake(availableMilk, ONE_CUP_LATTE_MILK)

            val numOfCups = mutableListOf(waterCups, beanCups, milkCups)
            var numOfCupsPossible = numOfCups.minOrNull()
            if (numOfCupsPossible == null) numOfCupsPossible = 0

            if (numOfCupsPossible > 0) {
                println("I have enough resources, making you a coffee!")

                availableWater -= ONE_CUP_LATTE_WATER
                availableBeans -= ONE_CUP_LATTE_BEANS
                availableMilk -= ONE_CUP_LATTE_MILK
                amountLeft += ONE_CUP_LATTE_PRICE
                disposableCups -= 1

                println()
            } else {
                when (numOfCups.indexOf(numOfCupsPossible)) {
                    0 -> {
                        println("Sorry, not enough water!")
                    }
                    1 -> {
                        println("Sorry, not enough coffee beans!")
                    }
                    else -> {
                        println("Sorry, not enough milk!")
                    }
                }

                println()
            }
        }
        "3" -> {
            val waterCups = howManyCupsIngredientsCanMake(availableWater, ONE_CUP_CAPPUCCINO_WATER)
            val beanCups = howManyCupsIngredientsCanMake(availableBeans, ONE_CUP_CAPPUCCINO_BEANS)
            val milkCups = howManyCupsIngredientsCanMake(availableMilk, ONE_CUP_CAPPUCCINO_MILK)

            val numOfCups = mutableListOf(waterCups, beanCups, milkCups)
            var numOfCupsPossible = numOfCups.minOrNull()
            if (numOfCupsPossible == null) numOfCupsPossible = 0

            if (numOfCupsPossible > 0) {
                println("I have enough resources, making you a coffee!")

                availableWater -= ONE_CUP_CAPPUCCINO_WATER
                availableBeans -= ONE_CUP_CAPPUCCINO_BEANS
                availableMilk -= ONE_CUP_CAPPUCCINO_MILK
                amountLeft += ONE_CUP_CAPPUCCINO_PRICE
                disposableCups -= 1

                println()
            } else {
                when (numOfCups.indexOf(numOfCupsPossible)) {
                    0 -> {
                        println("Sorry, not enough water!")
                    }
                    1 -> {
                        println("Sorry, not enough coffee beans!")
                    }
                    else -> {
                        println("Sorry, not enough milk!")
                    }
                }

                println()
            }
        }
        "back" -> {
            println()
        }
    }
}

fun howManyCupsIngredientsCanMake(numerator: Int, denominator: Int): Int {
    return numerator / denominator
}

fun fill() {
    println()
    println("Write how many ml of water the coffee machine has: ")
    availableWater += readln().toInt()

    println("Write how many ml of milk the coffee machine has: ")
    availableMilk += readln().toInt()

    println("Write how many grams of coffee beans the coffee machine has: ")
    availableBeans += readln().toInt()

    println("Write how many cups of coffee you will need: ")
    disposableCups += readln().toInt()
}

fun take() {
    println()
    println("I gave you $$amountLeft")
    amountLeft = 0
}

fun laterReferences(){
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

fun requirements(cups: Int) {
    val water = cups * ONE_CUP_WATER
    val milk = cups * ONE_CUP_MILK
    val beans = cups * ONE_CUP_BEANS
}
