import java.util.Scanner
import java.util.Random

class Price(private val ticketType: String, private val basePrice: Double) {
    // Price properties and methods
    private val businessPrice = 10000.0
    private val economyPrice = 3000.0

    fun calculatePrice(): Double {
        return when (ticketType.toLowerCase()) {
            "business" -> businessPrice
            "economy" -> economyPrice
            else -> {
                println("Invalid ticket type. Using economy as default.")
                economyPrice
            }
        }
    }
}
