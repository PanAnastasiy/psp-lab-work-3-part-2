package sandal.type;

import design.console.Design;

public class FlipFlops extends Sandals
{
    private final int totalCost;
    public FlipFlops(int size, String color, String producer, boolean openness, int totalCost) {
        super(size, color, producer, openness);
        this.totalCost = totalCost;
    }
    @Override
    public void printer()
    {
        System.out.printf(this.toString(), ++sandalsId,
                "Сандали", this.getTypeOfSandals(),this.producer(), this.size(), this.color(),
                this.getOpenness(), this.getCost());
    }
    @Override
    public String toString()
    {
        return Design.LIGHT_WHITE + Design.BOLD + "|" + Design.RED + Design.BOLD +
                " %-3d " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.PURPLE + Design.BOLD +
                " %-9s " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.YELLOW + Design.BOLD +
                " %-11s " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.GREEN + Design.BOLD +
                " %-13s " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.BLUE + Design.BOLD +
                " %-6d " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.CYAN + Design.BOLD +
                " %-12s " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.RED + Design.BOLD +
                " %-10s " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.PURPLE + Design.BOLD +
                " %-9d " + Design.LIGHT_WHITE + Design.BOLD +
                "|\n";
    }
    @Override
    public String getTypeOfSandals()
    {
        return "Вьетнамки";
    }

    @Override
    public int getCost() {
        return this.totalCost;
    }
}
