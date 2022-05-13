import rsk.DisplayFunctions;

public class App {

    public static void main(String[] args) {
        DisplayFunctions.display("Hello, World from Java!"); // call Kotlin top-level function from Java

        DisplayFunctions.log("Hello, World from Java!", 3); // default param NOT used
        DisplayFunctions.log("Hello, World from Java!"); // default param used, works with @JvmOverloads
    }
}
