
import java.util.Scanner
import java.util.Random


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

