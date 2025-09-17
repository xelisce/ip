package espresso.ui;

public class Display {
    private static final String DIVIDER = "\t____________________________________________________________";
    private static final String LOGO = """
            .·:''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''':·.
            : : ███████╗███████╗██████╗ ██████╗ ███████╗███████╗███████╗ ██████╗  : :
            : : ██╔════╝██╔════╝██╔══██╗██╔══██╗██╔════╝██╔════╝██╔════╝██╔═══██╗ : :
            : : █████╗  ███████╗██████╔╝██████╔╝█████╗  ███████╗███████╗██║   ██║ : :
            : : ██╔══╝  ╚════██║██╔═══╝ ██╔══██╗██╔══╝  ╚════██║╚════██║██║   ██║ : :
            : : ███████╗███████║██║     ██║  ██║███████╗███████║███████║╚██████╔╝ : :
            : : ╚══════╝╚══════╝╚═╝     ╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝ ╚═════╝  : :
            '·:...................................................................:·'
            """;

    private static void printBanner() {
        System.out.println("\n" + LOGO);
    }

    public static void printHelloMessage(String[] loadTaskMessage) {
        printBanner();
        printMessage("Hello! I'm ESPRESSO",
                "What can I do for you today?",
                loadTaskMessage[0],
                loadTaskMessage[1]);
    }

    public static void printByeMessage() {
        printMessage("Bye. Hope to see you again soon!");
    }

    public static void printInvalidCommand(String specificErrorMessage) {
        printMessage("Invalid command",
                "Please use todo, deadline or event to add a task",
                "Example: todo borrow book",
                specificErrorMessage);
    }

    public static void printMessage(String... message) {
        System.out.println(DIVIDER);
        for (String s : message) {
            System.out.println("\t" + s);
        }
        System.out.println(DIVIDER);
    }
}
