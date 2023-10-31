import java.util.Scanner
import java.util.Random

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
