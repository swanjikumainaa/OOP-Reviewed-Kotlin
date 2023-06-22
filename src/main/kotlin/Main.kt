fun main() {
    val story = Story("Medium", listOf("Unity", "Respect"), "Children")
    val storyteller = StoryTeller("John Doe", "Engaging")
    val translator = Translator(listOf("English", "French", "Spanish"))


    story.read()
    story.translate("French")
    storyteller.tellStory(story)
    translator.translateStory(story, "French")



    // Create recipe objects
    val recipe1 = MoroccanRecipe(
        "Moroccan Tajine",
        listOf("Chicken", "Onions", "Tomatoes", "Spices"),
        30,
        "Slow cooking",
        mapOf("Calories" to "350", "Protein" to "25"),
        "Medium"
    )

    val recipe2 = EthiopianRecipe(
        "Ethiopian Doro Wat",
        listOf("Chicken", "Onions", "Berbere Spice Mix", "Injera"),
        45,
        "Stewing",
        mapOf("Calories" to "400", "Protein" to "30"),
        true
    )

    val recipe3 = NigerianRecipe(
        "Nigerian Jollof Rice",
        listOf("Rice", "Tomatoes", "Pepper", "Onions"),
        40,
        "One-pot cooking",
        mapOf("Calories" to "300", "Protein" to "20"),
        "Very Spicy"
    )


    recipe1.displayRecipe()

    recipe2.displayRecipe()

    recipe3.displayRecipe()


    // Create species objects
    val species1 = Predator("Lion", "Carnivore", 15, "Ambush hunting")
    val species2 = Prey("Wildebeest", "Herbivore", 20, "Seasonal migration")

// Display species information
    species1.displayInfo()

    species2.displayInfo()


    // Create artist objects
    val artist1 = Artist("Femi Kuti", "Nigeria", "Afrobeat")
    val artist2 = Artist("Salif Keita", "Mali", "Mande music")

// Create performance objects
    val performance1 = Performance(artist1, "18:00", "20:00")
    val performance2 = Performance(artist2, "20:30", "22:30")

// Create stage object
    val stage = Stage("Main Stage", 5000)

// Add performances to the stage
    stage.addPerformance(performance1)
    stage.addPerformance(performance2)

// Display the schedule of the stage
    stage.displaySchedule()



// Create Product objects
    val product1 = Product("Item 1", 10.99, 5)
    val product2 = Product("Item 2", 5.99, 10)
    val product3 = Product("Item 3", 8.50, 2)

// Calculate the total value of each product
    val totalValue1 = product1.calculateTotalValue()
    val totalValue2 = product2.calculateTotalValue()
    val totalValue3 = product3.calculateTotalValue()

// Print the total values
    println("Total value of ${product1.name}: $totalValue1")
    println("Total value of ${product2.name}: $totalValue2")
    println("Total value of ${product3.name}: $totalValue3")


    // Create a Student object
    val student = Student("John Doe", 18, listOf(80, 75, 90, 65, 70))

// Display student information
    student.displayStudentInfo()

// Calculate and display the average grade
    val averageGrade = student.calculateAverageGrade()
    println("Average Grade: $averageGrade")

// Determine if the student has passed
    if (student.hasPassed()) {
        println("Status: Passed")
    } else {
        println("Status: Failed")
    }



        // Create a FlightBooking object
        val bookingSystem = FlightBooking()

        // Create some Flight objects
        val flight1 = Flight("F001", "New York", "2023-07-15", 100)
        val flight2 = Flight("F002", "London", "2023-07-20", 150)
        val flight3 = Flight("F003", "Paris", "2023-07-25", 200)

        // Add the flights to the booking system
        bookingSystem.addFlight(flight1)
        bookingSystem.addFlight(flight2)
        bookingSystem.addFlight(flight3)

        // Search for available flights
        val availableFlights = bookingSystem.searchFlights("London", "2023-07-20")
        println("Available Flights:")
        availableFlights.forEach { flight ->
            println("${flight.flightNumber} ${flight.destination} ${flight.date}")
        }

        // Reserve a seat for a passenger
        val passenger1 = "John Doe"
        val reserved = bookingSystem.reserveSeat(flight2, passenger1)
        if (reserved) {
            println("Seat reserved for $passenger1 on Flight ${flight2.flightNumber}")
        }

        // Generate booking confirmation
        val confirmation = bookingSystem.generateBookingConfirmation(flight2, passenger1)
        if (confirmation != null) {
            println(confirmation)
        }



        // Create a LibraryCatalog object
        val catalog = LibraryCatalog()

        // Add books to the catalog
        val book1 = Book("Python Crash Course", "Eric Matthes", 3)
        val book2 = Book("Clean Code", "Robert C. Martin", 5)
        val book3 = Book("The Great Gatsby", "F. Scott Fitzgerald", 2)
        catalog.addBook(book1)
        catalog.addBook(book2)
        catalog.addBook(book3)

        // Search for books by title or author
        val titleSearchResults = catalog.searchByTitle("python crash course")
        val authorSearchResults = catalog.searchByAuthor("Robert C. Martin")

        println("Search Results by Title:")
        titleSearchResults.forEach { book ->
            catalog.displayBookDetails(book)
        }

        println("\nSearch Results by Author:")
        authorSearchResults.forEach { book ->
            catalog.displayBookDetails(book)
        }

        // Borrow a book
        val borrowed = catalog.borrowBook(book1)
        if (borrowed) {
            println("\nBook ${book1.title} borrowed successfully.")
        }

        // Return a book
        catalog.returnBook(book1)
        println("\nBook ${book1.title} returned.")

        // Display updated book details
        println("\nUpdated Book Details:")
        catalog.displayBookDetails(book1)


}

//1. **Ancestral Stories:** In many African cultures, the art of storytelling is passed
//down from generation to generation. Imagine you're creating an application that
//records these oral stories and translates them into different languages. The
//stories vary by length, moral lessons, and the age group they are intended for.
//Think about how you would model `Story`, `StoryTeller`, and `Translator`
//objects, and how inheritance might come into play if there are different types of
//stories or storytellers.
class Story(val length: String, val moralLessons: List<String>, val ageGroup: String) {
    fun read() {
        println("Reading the story")
    }

    fun translate(language: String) {
        println("Translating the story into $language")
    }
}

class StoryTeller(val name: String, val style: String) {
    fun tellStory(story: Story) {
        println("$name is telling a story")
    }
}

class Translator(val languages: List<String>) {
    fun translateStory(story: Story, language: String) {
        println("Translating the story into $language")
    }
}

//2. **African Cuisine:** You're creating a recipe app specifically for African cuisine.
//The app needs to handle recipes from different African countries, each with its
//unique ingredients, preparation time, cooking method, and nutritional
// information. Consider creating a `Recipe` class, and think about how you might
//create subclasses for different types of recipes (e.g., `MoroccanRecipe`,
//`EthiopianRecipe`, `NigerianRecipe`), each with their own unique properties and
//methods.
open class Recipe(
    val name: String,
    val ingredients: List<String>,
    val preparationTime: Int,
    val cookingMethod: String,
    val nutritionalInfo: Map<String, String>
) {
    open fun displayRecipe() {
        println("Recipe: $name")
        println("Ingredients:")
        ingredients.forEach { ingredient -> println("- $ingredient") }
        println("Preparation Time: $preparationTime minutes")
        println("Cooking Method: $cookingMethod")
        println("Nutritional Information:")
        nutritionalInfo.forEach { (key, value) -> println("- $key: $value") }
    }
}

class MoroccanRecipe(
    name: String,
    ingredients: List<String>,
    preparationTime: Int,
    cookingMethod: String,
    nutritionalInfo: Map<String, String>,
    val spiceLevel: String
) : Recipe(name, ingredients, preparationTime, cookingMethod, nutritionalInfo) {
    override fun displayRecipe() {
        super.displayRecipe()
        println("Spice Level: $spiceLevel")
    }
}

class EthiopianRecipe(
    name: String,
    ingredients: List<String>,
    preparationTime: Int,
    cookingMethod: String,
    nutritionalInfo: Map<String, String>,
    val injeraRequired: Boolean
) : Recipe(name, ingredients, preparationTime, cookingMethod, nutritionalInfo) {
    override fun displayRecipe() {
        super.displayRecipe()
        println("Injera Required: $injeraRequired")
    }
}

class NigerianRecipe(
    name: String,
    ingredients: List<String>,
    preparationTime: Int,
    cookingMethod: String,
    nutritionalInfo: Map<String, String>,
    val jollofRiceLevel: String
) : Recipe(name, ingredients, preparationTime, cookingMethod, nutritionalInfo) {
    override fun displayRecipe() {
        super.displayRecipe()
        println("Joll of Rice Level: $jollofRiceLevel")
    }
}




//3. **Wildlife Preservation:** You're a wildlife conservationist working on a
//program to track different species in a national park. Each species has its own
//characteristics and behaviors, such as its diet, typical lifespan, migration
//patterns, etc. Some species might be predators, others prey. You'll need to
//create classes to model `Species`, `Predator`, `Prey`, etc., and think about how
//these classes might relate to each other through inheritance.

open class Species(val name: String, val diet: String, val lifespan: Int) {
    open fun displayInfo() {
        println("Species: $name")
        println("Diet: $diet")
        println("Lifespan: $lifespan years")
    }
}

class Predator(name: String, diet: String, lifespan: Int, val huntingMethod: String) : Species(name, diet, lifespan) {
    override fun displayInfo() {
        super.displayInfo()
        println("Hunting Method: $huntingMethod")
    }
}

class Prey(name: String, diet: String, lifespan: Int, val migrationPattern: String) : Species(name, diet, lifespan) {
    override fun displayInfo() {
        super.displayInfo()
        println("Migration Pattern: $migrationPattern")
    }
}





//4. **African Music Festival:** You're in charge of organizing a Pan-African music
//festival. Many artists from different countries, each with their own musical style
//and instruments, are scheduled to perform. You need to write a program to
//manage the festival lineup, schedule, and stage arrangements. Think about how
//you might model the `Artist`, `Performance`, and `Stage` classes, and consider
//how you might use inheritance if there are different types of performances or
//stages.

class Artist(val name: String, val country: String, val musicalStyle: String) {
    fun displayInfo() {
        println("Artist: $name")
        println("Country: $country")
        println("Musical Style: $musicalStyle")
    }
}

class Performance(val artist: Artist, val startTime: String, val endTime: String) {
    fun displayInfo() {
        println("Performance Details:")
        artist.displayInfo()
        println("Start Time: $startTime")
        println("End Time: $endTime")
    }
}

class Stage(val name: String, val capacity: Int) {
    private val performances: MutableList<Performance> = mutableListOf()

    fun addPerformance(performance: Performance) {
        performances.add(performance)
    }

    fun displaySchedule() {
        println("Stage: $name")
        println("Capacity: $capacity")
        println("Scheduled Performances:")
        performances.forEach { performance ->
            performance.displayInfo()
            println()
        }
    }
}





//5. Create a class called Product with attributes for name, price, and quantity.
//Implement a method to calculate the total value of the product (price * quantity).
//Create multiple objects of the Product class and calculate their total values.

class Product(val name: String, val price: Double, val quantity: Int) {
    fun calculateTotalValue(): Double {
        return price * quantity
    }
}



//6. Implement a class called Student with attributes for name, age, and grades (a
//list of integers). Include methods to calculate the average grade, display the
//student information, and determine if the student has passed (average grade >=
//60). Create objects for the Student class and demonstrate the usage of these
//methods.

class Student(val name: String, val age: Int, val grades: List<Int>) {
    fun calculateAverageGrade(): Double {
        val totalGrades = grades.sum()
        val averageGrade = totalGrades.toDouble() / grades.size
        return averageGrade
    }

    fun displayStudentInfo() {
        println("Student Information:")
        println("Name: $name")
        println("Age: $age")
        println("Grades: $grades")
    }

    fun hasPassed(): Boolean {
        val averageGrade = calculateAverageGrade()
        return averageGrade >= 60
    }
}



//7. Create a FlightBooking class that represents a flight booking system. Implement
//methods to search for available flights based on destination and date, reserve
//seats for customers, manage passenger information, and generate booking
//confirmations.


class FlightBooking {
    private val flights = mutableListOf<Flight>()

    fun addFlight(flight: Flight) {
        flights.add(flight)
    }

    fun searchFlights(destination: String, date: String): List<Flight> {
        return flights.filter {
            it.destination == destination && it.date == date && it.isAvailable()
        }
    }

    fun reserveSeat(flight: Flight, passenger: String): Boolean {
        return if (flight.isAvailable() && flight.hasAvailableSeats()) {
            flight.reserveSeat(passenger)
            true
        } else {
            false
        }
    }

    fun generateBookingConfirmation(flight: Flight, passenger: String): String? {
        return if (flight.isPassengerReserved(passenger)) {
            "Booking Confirmation:\nFlight: $flight\nPassenger: $passenger"
        } else {
            null
        }
    }
}

class Flight(
    val flightNumber: String,
    val destination: String,
    val date: String,
    val seats: Int
) {
    private val passengerList = mutableListOf<String>()

    fun isAvailable(): Boolean {
        return passengerList.size < seats
    }

    fun hasAvailableSeats(): Boolean {
        return passengerList.size < seats
    }

    fun reserveSeat(passenger: String) {
        passengerList.add(passenger)
    }

    fun isPassengerReserved(passenger: String): Boolean {
        return passengerList.contains(passenger)
    }
}




//8. Create a LibraryCatalog class that handles the cataloging and management of
//books in a library. Implement methods to add new books, search for books by
//title or author, keep track of available copies, and display book details.


class Book(val title: String, val author: String, var numCopies: Int) {
    override fun toString(): String {
        return "$title by $author"
    }
}

class LibraryCatalog {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter { it.title.equals(title, ignoreCase = true) }
    }

    fun searchByAuthor(author: String): List<Book> {
        return books.filter { it.author.equals(author, ignoreCase = true) }
    }

    fun displayBookDetails(book: Book) {
        println("Title: ${book.title}")
        println("Author: ${book.author}")
        println("Available Copies: ${book.numCopies}")
    }

    fun borrowBook(book: Book): Boolean {
        if (book.numCopies > 0) {
            book.numCopies--
            return true
        }
        return false
    }

    fun returnBook(book: Book) {
        book.numCopies++
    }
}

