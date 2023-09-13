import java.sql.*;
import java.util.ArrayList;

public class Repository {
    private final String url = "jdbc:mysql://localhost:3306/gamemath";
    private final String username = "root";
    private final String password = "docker";

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(this.url, this.username, this.password);

            return connection;
        } catch (SQLException | ClassNotFoundException err) {
            err.printStackTrace();
        }

        return null;
    }

    public void createRecord(String username, int points) {
        try {
            PreparedStatement statement = this
                    .getConnection()
                    .prepareStatement("INSERT INTO records (username, points) VALUES (?,?);");

            statement.setString(1, username);
            statement.setInt(2, points);

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
    }
}
