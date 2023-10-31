
import java.util.Scanner
import java.util.Random

class CustomerService {
    // Customer service properties and methods
    fun respondToQuery(query: String): String {
        return when (query.toLowerCase()) {
            "how to book a ticket" -> "You can book a ticket by providing your details and selecting the desired tickets."
            "how to cancel a booking" -> "You can cancel a booking by contacting our customer service or using our website."
            "how to get a refund" -> "To get a refund, please contact our customer service and provide your booking details."
            else -> "Sorry, we couldn't understand your query. Please contact our customer service for assistance."
        }
    }
    fun listQueries(): List<String> {
        return listOf(
            "1. How to book a ticket",
            "2. How to cancel a booking",
            "3. How to get a refund",
            "4. How to change booking details",
            "5. How to contact customer service"
        )
    }
}
