
import java.util.Scanner


class Ticket(val ticketNumber: String, val price: Double) {
    // Ticket properties and methods
    override fun toString(): String {
        return "Ticket $ticketNumber - Price: $price"
    }
}
