package Airline

import java.util.Scanner
import java.util.Random

class Customer(val name: String, val email: String) {
    // Customer properties and methods
    override fun toString(): String {
        return "Customer: $name ($email)"
    }
}

class Ticket(val ticketNumber: String, val price: Double) {
    // Ticket properties and methods
    override fun toString(): String {
        return "Ticket $ticketNumber - Price: $price"
    }
}


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

class Booking(val customer: Customer, val tickets: MutableList<Ticket> = mutableListOf()) {
    // Booking properties and methods
    fun addTicket(ticket: Ticket) {
        tickets.add(ticket)
    }

    fun calculateTotalPrice(): Double {
        val priceCalculator = Price("economy", 0.0) // Default to economy
        return priceCalculator.calculatePrice() * tickets.size
    }

    override fun toString(): String {
        return "Booking for ${customer.name} (${customer.email}) - Tickets: $tickets"
    }
}

class Cancellation(val booking: Booking) {
    // Cancellation properties and methods
    fun cancelBooking() {
        // Implement the cancellation logic here (e.g., refund, release seats, etc.)
        booking.tickets.clear()
        println("Booking ${booking.customer.name} cancelled.")
    }
}

class TransactionManagement {
    // Transaction management properties and methods
    fun processPayment(booking: Booking, amount: Double) {
        // Implement payment processing logic here (e.g., payment gateway integration)
        println("Payment processed for booking ${booking.customer.name}. Amount: $amount")
    }
}

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

fun generateRandomTicketNumber(): String {
    val random = Random()
    val prefix = "T" // You can customize the prefix as needed
    val randomDigits = random.nextInt(1000)
    return "$prefix$randomDigits"
}

fun main() {

    val scanner = Scanner(System.`in`)
    val customerService = CustomerService()

    println("List of Queries:")
    val queries = customerService.listQueries()
    queries.forEach { query ->
        println(query)
    }

    print("Enter your query: ")
    val userQuery = scanner.nextLine()
    val response = customerService.respondToQuery(userQuery)
    println(response)


    print("Enter your name: ")
    val name = scanner.nextLine()
    print("Enter your email: ")
    val email = scanner.nextLine()

    val customer = Customer(name, email)

    val booking = Booking(customer)
    while (true) {
        print("Enter the ticket type (business or economy, or type 'done' to finish): ")
        val ticketType = scanner.nextLine()
        if (ticketType.equals("done", ignoreCase = true)) {
            break
        }

        val priceCalculator = Price(ticketType, 0.0)
        val total = priceCalculator.calculatePrice()
        booking.addTicket(Ticket("T123", total)) // Generate a random ticket number or use an actual ticket number
        println("Ticket added to the booking. Total Price for Booking: $total")
    }

    val transactionManager = TransactionManagement()
    val totalAmount = booking.calculateTotalPrice()
    transactionManager.processPayment(booking, totalAmount)

    println(booking)

    print("Do you want to cancel the booking? (yes/no): ")
    val cancelChoice = scanner.nextLine()
    if (cancelChoice.equals("yes", ignoreCase = true)) {
        val cancellation = Cancellation(booking)
        cancellation.cancelBooking()
    }

}

