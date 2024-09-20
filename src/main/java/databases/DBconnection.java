package databases;

import boots.Boots;
import sandal.type.FlipFlops;
import sandal.type.Wedges;
import sneakers.Sneakers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBconnection
{
    public static <T>List<T> getCollection(Class<T> cl)
    {
        String selectSQL;
        List<T> objects = new ArrayList<>();
        if (cl == Wedges.class) {
            selectSQL = "SELECT s.sandalsId, s.openness, s.size, s.color, s.producer, " +
                    "w.costOfMaterial, w.costOfTransport " +
                    "FROM Sandals  s " +
                    "JOIN Wedges w ON s.sandalsId = w.sandalsId";
        } else if (cl == FlipFlops.class) {
            selectSQL = "SELECT s.sandalsId, s.openness, s.size, s.color, s.producer, " +
                    "f.totalCost " +
                    "FROM Sandals  s " +
                    "JOIN FlipFlops f ON s.sandalsId = f.sandalsId";
        }
        else {
             selectSQL = "SELECT * FROM " + cl.getSimpleName();
        }
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/user/Desktop/sqlite/psplab3.db");
             PreparedStatement pstmt = conn.prepareStatement(selectSQL);
             ResultSet rs = pstmt.executeQuery()) {
             while (rs.next())
             {
                String color = rs.getString("color");
                String producer = rs.getString("producer");
                int size = rs.getInt("size");
                if (cl == Boots.class) {
                    int heelSize = rs.getInt("heelSize");
                    String soleType = rs.getString("soleType");
                    boolean isDemiSeason = soleType.equals("Демисезон");
                    Boots boot = new Boots(color, producer, isDemiSeason, size, heelSize);
                    objects.add(cl.cast(boot));
                } else if (cl == Sneakers.class) {
                    String firmProducer = rs.getString("firmProducer");
                    Sneakers sneakers = new Sneakers(color, producer, firmProducer, size);
                    objects.add(cl.cast(sneakers));
                } else if (cl == FlipFlops.class) {
                    boolean openness = rs.getBoolean("openness");
                    int totalCost = rs.getInt("totalCost");
                    FlipFlops flipFlops = new FlipFlops(size, color, producer, openness, totalCost);
                    objects.add(cl.cast(flipFlops));
                }
                else {
                    boolean openness = rs.getBoolean("openness");
                    int costOfMaterial = rs.getInt("costOfMaterial");
                    int costOfTransport = rs.getInt("costOfTransport");
                    Wedges wedges = new Wedges(size, color, producer, openness,costOfMaterial , costOfTransport);
                    objects.add(cl.cast(wedges));
                }
             }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return objects;
    }
}
