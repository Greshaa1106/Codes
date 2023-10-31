import java.util.Scanner
import java.util.Random

class Cancellation(val booking: Booking) {
    // Cancellation properties and methods
    fun cancelBooking() {
        // Implement the cancellation logic here (e.g., refund, release seats, etc.)
        booking.tickets.clear()
        println("Booking ${booking.customer.name} cancelled.")
    }
}
