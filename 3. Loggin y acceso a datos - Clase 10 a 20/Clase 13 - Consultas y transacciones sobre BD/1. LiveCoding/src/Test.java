import java.sql.*;
import java.util.PrimitiveIterator;

public class Test {

    private static final String SQL_TABLE_CREATE = "DROP TABLE IF EXISTS USUARIO; CREATE TABLE USUARIO"
           + "("
           + "ID INT PRIMARY KEY,"
           + "NOMBRE varchar(100) NOT NULL,"
           + "EMAIL varchar(100) NOT NULL,"
           + "SUELDO numeric(15, 2) NOT NULL"
           + ")";

    private static final String SQL_INSERT = "INSERT INTO USUARIO (ID, NOMBRE, EMAIL, SUELDO) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE USUARIO SET SUELDO=? WHERE EMAIL=?";

    public static void main(String[] args) throws Exception{
        Usuario usuario = new Usuario("Agustin", "agustin@dh.com", 10d);

        Connection connection = null;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_CREATE);

            // Empiezo a insertar en la BD 1

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);

            psInsert.setInt(1,1);
            psInsert.setString(2,usuario.getNombre());
            psInsert.setString(3,usuario.getEmail());
            psInsert.setDouble(4,usuario.getSueldo());
            psInsert.execute();

            //Empezar la transaccion
            connection.setAutoCommit(false);


            // Insertar en la BD 2

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);

            psUpdate.setDouble(1,usuario.subirSueldo(10d));
            psUpdate.setString(2,usuario.getEmail());
            psUpdate.execute();
            //int a = 4/0; // Da un error

            connection.commit();

            // Si ttodo cierra ok : buena practica autocommit en true

            connection.setAutoCommit(true);


            //Corremos una query
            String sql = "SELECT * FROM USUARIO";
            Statement stmt = connection.createStatement();
            // resulsert = manera de buscar en la base de datos
            ResultSet rd = stmt.executeQuery(sql);

            while(rd.next()){
                System.out.println(rd.getInt(1) + rd.getString(2) + rd.getString(3)
                + rd.getDouble(4));
            }

        }catch (Exception e){
            e.printStackTrace();
            connection.rollback();
            // Si falla, print error y hace un rollback, volver atras todos los cambios
        } finally {
            connection.close();
        }


    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:" +
                "~/test", "sa", "");
    }

}
