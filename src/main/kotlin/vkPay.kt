@file:Suppress("UNREACHABLE_CODE")

import java.util.*


fun main() {
    while (true) {
        println(
            """===================================
                |введите карту с которой планируете произвести перевод
        |1. Mastercard
        |2. Maestro
        |3. Visa
        |4. Мир
        |5. VK PAY
    """.trimMargin()
        )
        val typeCard = readLine()
        println("Введите сумму переводов за текущий месяц ")
        val nomber1 = Scanner(System.`in`)
        var amountThisMonth: Int = nomber1.nextInt()
        println("Введите сумму, которую хотите сейчас перевести ")
        val nomber2 = Scanner(System.`in`)
        var amountNow: Int = nomber2.nextInt()
        println("________________________________")
        println("вы выбрали карту " + typeCard)
        println("в этом месяце вы уже перевели " + amountThisMonth + " рублей")
        println("сумма для перевода сейчас " + amountNow + " рублей")
        println("________________________________")
        println(totalComision(typeCard.toString(), amountThisMonth, amountNow))

    }
}

fun totalComision(typeCard: String, amountThisMonth: Int, amountNow: Int) =
    when {
        typeCard == "Mastercard" && amountNow + amountThisMonth <= 75000 -> "комиссия не взимается "
        typeCard == "Mastercard" && amountNow + amountThisMonth >= 75000 && amountNow < 150000 && amountNow + amountThisMonth < 600000 -> "комиссия составляет " + (amountNow * 0.6 / 100 + 20) + "рублей"
        typeCard == "Maestro" && amountNow + amountThisMonth <= 75000 -> "комиссия не взимается "
        typeCard == "Maestro" && amountNow + amountThisMonth >= 75000 && amountNow < 150000 && amountNow + amountThisMonth < 600000 -> "комиссия составляет " + (amountNow * 0.6 / 100 + 20) + "рублей"
        typeCard == "Visa" && amountNow < 150000 && amountNow + amountThisMonth < 600000 && amountNow * 0.75 / 100 >= 35 -> "комиссия составляет " + (amountNow * 0.75 / 100) + "рублей"
        typeCard == "Visa" && amountNow < 150000 && amountNow + amountThisMonth < 600000 && amountNow * 0.75 / 100 <= 35 -> "комиссия составляет 35 рублей"
        typeCard == "Мир" && amountNow < 150000 && amountNow + amountThisMonth < 600000 && amountNow * 0.75 / 100 >= 35 -> "комиссия составляет " + (amountNow * 0.75 / 100) + "рублей"
        typeCard == "Мир" && amountNow < 150000 && amountNow + amountThisMonth < 600000 && amountNow * 0.75 / 100 <= 35 -> "комиссия составляет 35 рублей"
        typeCard == "VK PAY" && amountNow < 15000 && amountNow + amountThisMonth < 40000 -> "комиссия не взимается "
        else -> {
            "месячный лимит превышен, дождитесь следующего месяца!"
        }
    }







