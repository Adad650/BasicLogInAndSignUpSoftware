data class User(val username: String, val password: String)

fun main() {
    val users = mutableListOf<User>()

    println("Welcome to the Basic Login System!")

    while (true) {
        print("Choose an option (1: Sign Up, 2: Login, 3: Exit): ")
        when (readLine()?.toIntOrNull()) {
            1 -> signUp(users)
            2 -> login(users)
            3 -> {
                println("Goodbye!")
                return
            }
            else -> println("Invalid option. Please try again.")
        }
    }
}

fun signUp(users: MutableList<User>) {
    print("Enter your desired username: ")
    val username = readLine()?.trim()

    if (username.isNullOrEmpty()) {
        println("Username cannot be empty. Please try again.")
        return
    }

    if (users.any { it.username == username }) {
        println("Username already taken. Please choose a different username.")
        return
    }

    print("Enter your desired password: ")
    val password = readLine()?.trim()

    if (password.isNullOrEmpty()) {
        println("Password cannot be empty. Please try again.")
        return
    }

    users.add(User(username, password))
    println("Account created successfully! You can now log in.")
}

fun login(users: MutableList<User>) {
    if (users.isEmpty()) {
        println("No user accounts found. Please sign up first.")
        return
    }

    print("Enter your username: ")
    val username = readLine()?.trim()

    if (username.isNullOrEmpty()) {
        println("Username cannot be empty. Please try again.")
        return
    }

    print("Enter your password: ")
    val password = readLine()?.trim()

    if (password.isNullOrEmpty()) {
        println("Password cannot be empty. Please try again.")
        return
    }

    val user = users.find { it.username == username }

    if (user != null && user.password == password) {
        println("Login successful! Welcome, ${user.username}.")
    } else {
        println("Invalid username or password. Please try again.")
    }
}








