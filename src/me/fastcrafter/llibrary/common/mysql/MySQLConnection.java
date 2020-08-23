package me.fastcrafter.llibrary.common.mysql;

import me.fastcrafter.llibrary.bukkit.util.MSGUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private MySQLLogin login;
    private Connection connection;

    public MySQLConnection(MySQLLogin login) {
        this.login = login;
    }

    public MySQLLogin getLogin() {
        return login;
    }

    public void setLogin(MySQLLogin login) {
        this.login = login;
    }

    public void connect() {
        try {
            synchronized (this) {
                if (getConnection() != null && !getConnection().isClosed()) {
                    return;
                }
                Class.forName("com.mysql.jdbc.Driver");
                setConnection(DriverManager.getConnection("jdbc:mysql://" + login.getAddress(), login.getUser(), login.getPassword()));
            }
        } catch (SQLException | ClassNotFoundException e) {
            MSGUtils.sendError("LLibrary", "Could not create Connection to MySQL Database on: " + login.getAddress() +" with user: " + login.getUser());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
