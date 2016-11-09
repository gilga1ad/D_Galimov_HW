import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Register {

    private Connection connection;
    private JdbcRowSet jdbcRs;

    public Register(final String URL, final String USERNAME, final String PASSWORD) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            jdbcRs = new JdbcRowSetImpl(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStorage(final String nameStorage) throws SQLException {
        try (Statement createStorage = connection.createStatement()) {
            String createString = "CREATE TABLE " + nameStorage +
                    " (" +
                    "product_no integer PRIMARY KEY, " +
                    "name text, " +
                    "description  text, " +
                    "price numeric" +
                    ");";
            createStorage.executeUpdate(createString);
        }
    }

    public void removeStorage(final String nameStorage) throws SQLException {
        try (Statement deleteStorage = connection.createStatement()) {
            deleteStorage.executeUpdate("DROP TABLE " + nameStorage + ";");
        }
    }

    public void addProductToStorage(final Product product, final String nameStorage) throws SQLException {
        jdbcRs.setCommand("SELECT * FROM " + nameStorage + ";");
        jdbcRs.execute();
        jdbcRs.moveToInsertRow();
        jdbcRs.updateInt("product_no", product.getProduct_no());
        jdbcRs.updateString("name", product.getName());
        jdbcRs.updateString("description", product.getDescription());
        jdbcRs.updateDouble("price", product.getPrice());
        jdbcRs.insertRow();
    }

    public void listProductsFromStorage(final String nameStorage) throws SQLException {
        jdbcRs.setCommand("SELECT * FROM " + nameStorage + ";");
        jdbcRs.execute();
        while (jdbcRs.next()) {
            int product_no = jdbcRs.getInt(1);
            String name = jdbcRs.getString(2);
            String description = jdbcRs.getString(3);
            double price = jdbcRs.getDouble(4);
            System.out.println(product_no + ", " + name + ", " + description + ", " + price);
        }
    }

    public static void main(String[] args) {
        Register register = new Register("jdbc:postgresql://localhost:5432/mydb",
                "postgres",
                "root");
        try {
            register.removeStorage("myStorage");
            register.addStorage("myStorage");
            register.addProductToStorage(new Product(1, "Samsung Galaxy S3", "smartphone", 10000.0), "myStorage");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
