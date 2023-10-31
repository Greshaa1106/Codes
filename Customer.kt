import java.util.Scanner


class Customer(val name: String, val email: String) {
    // Customer properties and methods
    override fun toString(): String {
        return "Customer: $name ($email)"
    }
}
