package design.console;

import java.util.Scanner;

public class Message
{
    public static void printMessage(String line, String coverColor, String textColor)
    {
        String lines = Design.BOLD + coverColor + "+" + "-".repeat(line.length() + 2) + "+" + Design.RESET;
        System.out.println(lines);
        System.out.println(
                Design.BOLD + coverColor + "| " + textColor + Design.BOLD + line + Design.RESET + coverColor + " |" + Design.RESET);
        System.out.println(lines);
    }
    public static void waitForEnter()
    {
        Message.printMessage("Нажмите Enter, чтобы продолжить...", Design.BLUE, Design.CYAN);
        new Scanner(System.in).nextLine();
    }
}
