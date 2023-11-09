package fr.dd.biere2000;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class DAO <T> {
    public Connection getConnexion(){
        return SqlServerConnect.getInstance();
    }
    public abstract boolean create(T object);
    public abstract T read(Long id);
    public abstract ArrayList<T> readAll();
    public abstract boolean update(T object);
    public abstract boolean delete(T object);
}
