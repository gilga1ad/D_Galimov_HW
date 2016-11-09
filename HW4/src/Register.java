import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Register {

    private Connection connection;

    private JdbcRowSet jdbcRs;

    private List<String> tableNames;

    public Register(final String URL, final String USERNAME, final String PASSWORD) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            jdbcRs = new JdbcRowSetImpl(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableNames = new ArrayList<>();
    }

    public void addStorage(final String nameStorage) throws SQLException {
        try (Statement createStorage = connection.createStatement()) {
            String createString = "CREATE TABLE " + nameStorage +
                    " (" +
                    "name text PRIMARY KEY , " +
                    "description  text, " +
                    "price numeric" +
                    ");";
            createStorage.executeUpdate(createString);
        }
        tableNames.add(nameStorage);
    }

    public void removeStorage(final String nameStorage) throws SQLException {
        try (Statement deleteStorage = connection.createStatement()) {
            deleteStorage.executeUpdate("DROP TABLE " + nameStorage + ";");
        }
        tableNames.remove(nameStorage);
    }

    public void addProductToStorage(final Product product, final String nameStorage) throws SQLException {
        jdbcRs.setCommand("SELECT * FROM " + nameStorage + ";");
        jdbcRs.execute();
        jdbcRs.moveToInsertRow();
        jdbcRs.updateString("name", product.getName());
        jdbcRs.updateString("description", product.getDescription());
        jdbcRs.updateDouble("price", product.getPrice());
        jdbcRs.insertRow();
    }

    private void showTable() throws SQLException {
        while (jdbcRs.next()) {
            String name = jdbcRs.getString(1);
            String description = jdbcRs.getString(2);
            double price = jdbcRs.getDouble(3);
            System.out.println(name + ", " + description + ", " + price);
        }
    }

    public void listProductsFromStorage(final String nameStorage) throws SQLException {
        jdbcRs.setCommand("SELECT * FROM " + nameStorage + ";");
        jdbcRs.execute();
        showTable();
    }

    private void searchProductByNameInStorage(final String nameProduct, final String nameStorage) throws SQLException {
        jdbcRs.setCommand("SELECT * FROM " + nameStorage + " WHERE name = '" + nameProduct + "';");
        jdbcRs.execute();
        showTable();
    }

    public void searchProductByName(final String nameProduct) throws SQLException {
        for(String tableName: tableNames) {
            searchProductByNameInStorage(nameProduct, tableName);
        }
    }

    public static void main(String[] args) {
        Register register = new Register("jdbc:postgresql://localhost:5432/mydb",
                "postgres",
                "root");
        try {
            register.removeStorage("myStorage");
            register.addStorage("myStorage");
            register.addProductToStorage(new Product("Samsung Galaxy S3", "smartphone", 10000.0), "myStorage");
            register.addProductToStorage(new Product("Iphone 5s", "smartphone", 20000.0), "myStorage");

            register.removeStorage("yourStorage");
            register.addStorage("yourStorage");
            register.addProductToStorage(new Product("Nokia", "smartphone", 5000.0), "yourStorage");
            register.addProductToStorage(new Product("Sony Erricson", "smartphone", 5000.0), "yourStorage");

            register.searchProductByName("Nokia");
            register.searchProductByName("Sony Erricson");
            register.searchProductByName("Samsung Galaxy S3");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
