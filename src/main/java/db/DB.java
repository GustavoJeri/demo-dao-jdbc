package db;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection() {
        if(conn == null){
            try{
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    private static Properties loadProperties(){
        try(var ps = DB.class.getClassLoader().getResourceAsStream("db.properties")){
            if(ps == null){
                throw new DbException("Erro: arquivo db.properties não encontrado no classpath");
            }
            Properties props = new Properties();
            props.load(ps);
            return props;
        }
        catch (IOException e){
            throw new DbException(e.getMessage());
        }
    }

    public static void closeConnection(){
        if(conn != null){
            try{
                conn.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st){
        if(st != null){
            try{
                st.close();
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

}
