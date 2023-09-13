import java.sql.*;
import java.util.ArrayList;

public class Repository {
    private static Repository _instance;
    private final String url = "jdbc:mysql://localhost:3306/fiblioteca?serverTimezone=UTC";
    private final String user = "docker";
    private final String password = "docker";

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException err) {
            err.printStackTrace();
        }

        return null;
    }

    public void createRecord(String username, int points) {
        try {
            PreparedStatement statement = this
                    .getConnection()
                    .prepareStatement("INSERT INTO records (username, points) VALUES (?,?);");

            statement.setString(0, username);
            statement.setInt(1, points);

            statement.execute();
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }

    public ArrayList<Record> getBetterRecords() {
        ArrayList<Record> result = new ArrayList<Record>();

        try {
            ResultSet lines = this.getConnection()
                    .prepareStatement("SELECT username, points FROM records SORT BY points DESC LIMIT 5;")
                    .executeQuery();

            while (lines.next()) {
                String username = lines.getString("username");
                int points = lines.getInt("points");

                Record record = new Record(username, points);

                result.add(record);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }

        return result;
    }gam
}
