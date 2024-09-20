package boots;

import design.console.Design;
import interfaces.Shoes;
import interfaces.Printable;

public class Boots implements Shoes, Printable
{
    private final int heelSize;
    private final boolean soleType;
    private static int bootsId = 0;
    private final int size;
    private final String color;
    private final String producer;
    public Boots(String color, String producer, boolean soleType, int size, int heelSize)
    {
        this.heelSize = heelSize;
        this.soleType = soleType;
        this.color = color;
        this.producer = producer;
        this.size = size;
    }
    public int getHeelSize()
    {
        return this.heelSize;
    }
    public String getSoleType()
    {
        if (this.soleType)
        {
            return "Демисезон";
        }
        else {
            return "Зимние";
        }
    }
    @Override
    public String toString()
    {
        return Design.LIGHT_WHITE + Design.BOLD + "|" + Design.RED + Design.BOLD +
                " %-3d " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.PURPLE + Design.BOLD +
                " %-9s " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.YELLOW + Design.BOLD +
                " %-13s " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.GREEN + Design.BOLD +
                " %-6d " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.BLUE + Design.BOLD +
                " %-12s "  + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.PURPLE + Design.BOLD +
                " %-14s " + Design.LIGHT_WHITE + Design.BOLD +
                "|" + Design.YELLOW + Design.BOLD +
                " %-9s " + Design.LIGHT_WHITE + Design.BOLD +
                "|\n";
    }

    @Override
    public String producer() {
        return this.producer;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String color() {
        return this.color;
    }

    @Override
    public void printer() {
        System.out.printf(this.toString(), ++bootsId,
                "Сапоги", this.producer(), this.size(), this.color(),this.getHeelSize(), this.getSoleType());
    }
}
