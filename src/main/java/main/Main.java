package main;


/*

Лабораторная работа № 3 (часть 2) выполняется на основе лабораторной работы №3 (часть 1).

Родительский класс требуется заменить одноимённым интерфейсом.

Метод, ранее определённый в супер-классе, записать в интерфейс в качестве абстрактного.
Добавить интерфейс Object, в котором объявить абстрактный метод print().
Далее создать 3 класса, реализующих оба интерфейса.
Один из этих классов нужно представить как абстрактный (не реализовать абстрактные методы).
Нереализованные методы реализуются в двух классах-наследниках абстрактного класса.
Задание выполняется в соответствие со схемой,
вместо букв латинского алфавита студент подставляет данные,
согласно своему варианту индивидуального задания.

*/

import boots.Boots;
import databases.DBconnection;
import design.console.Console;
import design.console.Design;
import design.console.Developer;
import design.console.Message;
import menu.MenuMain;
import print.Print;
import sandal.type.FlipFlops;
import sandal.type.Wedges;
import sneakers.Sneakers;

import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        List<Sneakers> sneakers = DBconnection.getCollection(Sneakers.class);
        List<Boots> boots = DBconnection.getCollection(Boots.class);
        List <Wedges> wedges = DBconnection.getCollection(Wedges.class);
        List<FlipFlops> flipFlops = DBconnection.getCollection(FlipFlops.class);
        MenuMain menu = new MenuMain();
        while (true)
        {
            menu.menuOfMain();
            switch(menu.getChoice())
            {
                case '1':
                    Console.clear();
                    Print.printer(sneakers, " N ", "ТИП ОБУВИ", "ПРОИЗВОДИТЕЛЬ", "РАЗМЕР", "    ЦВЕТ    ", "  ФИРМА  ");
                    Message.waitForEnter();
                    break;
                case '2':
                    Console.clear();
                    Print.printer(boots, " N ", "ТИП ОБУВИ", "ПРОИЗВОДИТЕЛЬ", "РАЗМЕР", "    ЦВЕТ    ", "РАЗМЕР КАБЛУКА", "  СЕЗОН  ");
                    Message.waitForEnter();
                    break;
                case '3':
                    Console.clear();
                    Print.printer(wedges, " N ", "ТИП ОБУВИ", "    ВИД    ", "ПРОИЗВОДИТЕЛЬ", "РАЗМЕР", "    ЦВЕТ    ","ОТКРЫТОСТЬ", "СТОИМОСТЬ");
                    Message.waitForEnter();
                    break;
                case '4':
                    Console.clear();
                    Print.printer(flipFlops, " N ", "ТИП ОБУВИ", "    ВИД    ", "ПРОИЗВОДИТЕЛЬ", "РАЗМЕР", "    ЦВЕТ    ","ОТКРЫТОСТЬ", "СТОИМОСТЬ");
                    Message.waitForEnter();
                    break;
                case '5':
                    Console.clear();
                    Developer.printInfoOfDeveloper();
                    Message.waitForEnter();
                    break;
                case '6':
                    Console.clear();
                    Message.printMessage("Осуществляем выход из программы...", Design.PURPLE, Design.RED);
                    System.exit(0);
                default:
                    Console.clear();
                    Message.printMessage("Выбран некорректный номер задачи...", Design.PURPLE, Design.RED);
                    Message.waitForEnter();
            }
        }
    }
}