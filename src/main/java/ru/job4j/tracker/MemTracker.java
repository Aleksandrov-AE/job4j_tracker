package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MemTracker implements Store {
    private static final String SQL_UPDATE_ITEM = "UPDATE items SET name = ?, create_date = ? WHERE id = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM items WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT id, name, create_date FROM items";
    private static final String SQL_SELECT_BY_NAME = "SELECT id, name, create_date FROM items WHERE name = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT id, name, create_date FROM items WHERE id = ?";

    private Connection connection;

    public MemTracker() {
        init();
    }

    public MemTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO items (name, create_date) values (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            Timestamp timestamp = Timestamp.valueOf(item.getDateTime());
            preparedStatement.setTimestamp(2, timestamp);
            preparedStatement.executeUpdate();
            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                if (keys.next()) {
                    item.setId(keys.getInt(1));
                }
            }
            return item;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean replace(int id, Item item) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_ITEM)) {
            preparedStatement.setString(1, item.getName());
            Timestamp timestamp = Timestamp.valueOf(item.getDateTime());
            preparedStatement.setTimestamp(2, timestamp);
            preparedStatement.setInt(3, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update item id=" + id + ", name='" + item.getName() + "'", e);
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID)) {
            preparedStatement.setInt(1, id);
            int affected = preparedStatement.executeUpdate();
            if (affected == 0) {
                throw new RuntimeException("Item id=" + id + " not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete item id=" + id, e);
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> results = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    results.add(getRow(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find All items", e);
        }
        return results;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> results = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_NAME)) {
            preparedStatement.setString(1, key);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    results.add(getRow(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find by names items", e);
        }
        return results;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    item = getRow(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find by id item", e);
        }
        return item;
    }

    private Item getRow(ResultSet rs) throws SQLException {
        Item item = new Item();
        item.setId(rs.getInt("id"));
        item.setName(rs.getString("name"));
        Timestamp ts = rs.getTimestamp("create_date");
        if (ts != null) {
            item.setCreater(ts.toLocalDateTime());
        }
        return item;
    }
}