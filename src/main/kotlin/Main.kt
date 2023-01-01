enum class Espresso(val quantity: Int) {
    WATER(250),
    BEANS(16),
    PRICE(4),
}

enum class Latte(val quantity: Int) {
    WATER(350),
    MILK(75),
    BEANS(20),
    PRICE(7),
}

enum class Cappuccino(val quantity: Int) {
    WATER(200),
    MILK(100),
    BEANS(12),
    PRICE(6),
}

enum class InitialState(val quantity: Int) {
    WATER(400),
    MILK(540),
    BEANS(120),
    CUPS(9),
    AMOUNT(550)
}

fun main() {
    val coffeeMachine = CoffeeMachine(
        initialAvailableWater = InitialState.WATER.quantity,
        initialAvailableMilk = InitialState.MILK.quantity,
        initialAvailableBeans = InitialState.BEANS.quantity,
        initialDisposableCups = InitialState.CUPS.quantity,
        initialAmountLeft = InitialState.AMOUNT.quantity
    )

    var exit = false
    do {
        println("Write action (buy, fill, take, remaining, exit): ")
        when(readln()) {
            "buy" -> {
                println()
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
                val action = readln()
                coffeeMachine.buy(action)
            }
            "fill" ->  {
                println()

                println("Write how many ml of water you want to add: ")
                coffeeMachine.availableWater += readln().toInt()

                println("Write how many ml of milk you want to add: ")
                coffeeMachine.availableMilk += readln().toInt()

                println("Write how many grams of coffee beans you want to add: ")
                coffeeMachine.availableBeans += readln().toInt()

                println("Write how many disposable cups you want to add: ")
                coffeeMachine.disposableCups += readln().toInt()

                println()
            }
            "take" -> coffeeMachine.take()
            "remaining" -> coffeeMachine.showState()
            "exit" -> exit = true
        }
    } while (!exit)
}

class CoffeeMachine(
    val initialAvailableWater: Int,
    val initialAvailableMilk: Int,
    val initialAvailableBeans: Int,
    val initialDisposableCups: Int,
    val initialAmountLeft: Int
) {
    var availableWater: Int = initialAvailableWater
    var availableMilk: Int = initialAvailableMilk
    var availableBeans: Int = initialAvailableBeans
    var disposableCups: Int = initialDisposableCups
    private var amountLeft: Int = initialAmountLeft

    fun showState() {
        println()
        println("The coffee machine has:")
        println("$availableWater ml of water")
        println("$availableMilk ml of milk")
        println("$availableBeans g of coffee beans")
        println("$disposableCups disposable cups")
        println("$$amountLeft of money")
        println()
    }

    fun buy(action: String) {
        when(action) {
            "1" -> {
                val waterCups = howManyCupsIngredientsCanMake(availableWater, Espresso.WATER.quantity)
                val beanCups = howManyCupsIngredientsCanMake(availableBeans, Espresso.BEANS.quantity)

                val numOfCups = mutableListOf(waterCups, beanCups)
                var numOfCupsPossible = numOfCups.minOrNull()
                if (numOfCupsPossible == null) numOfCupsPossible = 0

                if (numOfCupsPossible > 0) {
                    println("I have enough resources, making you a coffee!")

                    availableWater -= Espresso.WATER.quantity
                    availableBeans -= Espresso.BEANS.quantity
                    amountLeft += Espresso.PRICE.quantity
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
                val waterCups = howManyCupsIngredientsCanMake(availableWater, Latte.WATER.quantity)
                val beanCups = howManyCupsIngredientsCanMake(availableBeans, Latte.BEANS.quantity)
                val milkCups = howManyCupsIngredientsCanMake(availableMilk, Latte.MILK.quantity)

                val numOfCups = mutableListOf(waterCups, beanCups, milkCups)
                var numOfCupsPossible = numOfCups.minOrNull()
                if (numOfCupsPossible == null) numOfCupsPossible = 0

                if (numOfCupsPossible > 0) {
                    println("I have enough resources, making you a coffee!")

                    availableWater -= Latte.WATER.quantity
                    availableBeans -= Latte.BEANS.quantity
                    availableMilk -= Latte.MILK.quantity
                    amountLeft += Latte.PRICE.quantity
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
                val waterCups = howManyCupsIngredientsCanMake(availableWater, Cappuccino.WATER.quantity)
                val beanCups = howManyCupsIngredientsCanMake(availableBeans, Cappuccino.BEANS.quantity)
                val milkCups = howManyCupsIngredientsCanMake(availableMilk, Cappuccino.MILK.quantity)

                val numOfCups = mutableListOf(waterCups, beanCups, milkCups)
                var numOfCupsPossible = numOfCups.minOrNull()
                if (numOfCupsPossible == null) numOfCupsPossible = 0

                if (numOfCupsPossible > 0) {
                    println("I have enough resources, making you a coffee!")

                    availableWater -= Cappuccino.WATER.quantity
                    availableBeans -= Cappuccino.BEANS.quantity
                    availableMilk -= Cappuccino.MILK.quantity
                    amountLeft += Cappuccino.PRICE.quantity
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

    private fun howManyCupsIngredientsCanMake(numerator: Int, denominator: Int): Int {
        return numerator / denominator
    }

    fun take() {
        println()
        println("I gave you $$amountLeft")
        amountLeft = 0
        println()
    }
}
