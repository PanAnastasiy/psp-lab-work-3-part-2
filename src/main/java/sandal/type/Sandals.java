package sandal.type;

import design.console.Design;
import interfaces.Shoes;
import interfaces.Printable;

public abstract class Sandals implements Shoes, Printable
{
    protected static int sandalsId = 0;
    private final boolean openness;
    private final int size;
    private final String color;
    private final String producer;
    public Sandals()
    {
        this.openness = false;
        this.size = 0;
        this.color = "???";
        this.producer = "???";
    }
    public Sandals(int size, String color, String producer, boolean openness)
    {
        this.size = size;
        this.color = color;
        this.producer = producer;
        this.openness = openness;
    }
    public String getOpenness()
    {
        if (this.openness)
        {
            return "СИЛЬНО";
        }
        else {
            return "НЕТ";
        }
    }

    @Override
    public String producer()
    {
        return this.producer;
    }
    @Override
    public int size()
    {
        return this.size;
    }
    @Override
    public String color()
    {
        return this.color;
    }
    abstract String getTypeOfSandals();
    public abstract int getCost();
}
