package print;


import design.console.Design;
import interfaces.Printable;


import java.util.List;

public class Print {

    public static <T extends Printable>void printer(List<T> objects, String ...headers)
    {
        printRow(objects, printHeader(headers));
    }

    public static StringBuilder printHeader(String ... headers)
    {
        int index = 0;
        String []colors = { Design.RED, Design.PURPLE, Design.YELLOW, Design.GREEN, Design.BLUE, Design.CYAN };
        StringBuilder headerFields = new StringBuilder();
        StringBuilder headerRow = new StringBuilder();
        for (String header : headers)
        {
            headerRow.append(Design.BOLD + Design.LIGHT_WHITE + "+").append("-".repeat(header.length() + 2));
        }
        headerRow.append(Design.BOLD + Design.LIGHT_WHITE + "+\n");
        for (String header : headers)
        {
            if (index > colors.length - 1)
            {
                index = 0;
            }
            headerFields.append(Design.BOLD).append(Design.LIGHT_WHITE).append("| ").append(colors[index]).append(header).append(Design.BOLD).append(Design.LIGHT_WHITE).append(" ");
            index += 1;
        }
        headerFields.append(Design.BOLD + Design.LIGHT_WHITE + "|\n");
        System.out.print(headerRow);
        System.out.print(headerFields);
        System.out.print(headerRow);
        return headerRow;
    }
    public static <T extends Printable>void printRow(List<T> objects, StringBuilder row)
    {
        for (T obj : objects)
        {
            obj.printer();
            System.out.print(row);
        }
    }
}

