package sneakers;

import design.console.Design;
import interfaces.Shoes;
import interfaces.Printable;

public record Sneakers(String color, String producer, String firmProducer, int size) implements Shoes, Printable {
    public static int sneakersId = 0;

    @Override
    public String toString() {
        return Design.LIGHT_WHITE + Design.BOLD + "|" + Design.RED + Design.BOLD +
                " %-3d " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.PURPLE + Design.BOLD +
                " %-9s " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.YELLOW + Design.BOLD +
                " %-13s " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.GREEN + Design.BOLD +
                " %-6d " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.BLUE + Design.BOLD +
                " %-12s " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.CYAN + Design.BOLD +
                " %-9s " + Design.LIGHT_WHITE + Design.BOLD +
                "|\n";
    }

    @Override
    public void printer() {
        System.out.printf(this.toString(), ++sneakersId,
                "Кроссовки", this.producer(), this.size(), this.color(),
                this.firmProducer());
    }
}
