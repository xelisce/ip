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

    public static void hello() {
        printBanner();
        printMessage("Hello! I'm ESPRESSO", "What can I do for you today?");
    }

    public static void bye() {
        printMessage("Bye. Hope to see you again soon!");
    }

    public static void printMessage(String... message) {
        System.out.println(DIVIDER);
        for (String s : message) {
            System.out.println("\t" + s);
        }
        System.out.println(DIVIDER);
    }
}
