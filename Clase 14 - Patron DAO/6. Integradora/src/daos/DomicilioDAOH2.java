package daos;

import entidades.Domicilio;
import entidades.Paciente;

import java.sql.*;
import java.util.List;

public class DomicilioDAOH2 implements InterfaceDAO<Domicilio> {

    // Que necesitamos para conectarnos a una BD
    // R: 1- Saber el driver de conexion, => DB_JDBC_DRIVER = "org.h2.Driver";
    //    2- la url (donde esta la BD) => DB_URL = "jdbc:h2:~/db_estudiante";
    //    3- El usuario y el password => sa y ""

    // Creamos variables estaticas porque no van a cambiar
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_consultorio";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO domicilio VALUES (?,?,?,?,?)");
            preparedStatement.setLong(1,domicilio.getId());
            preparedStatement.setString(2,domicilio.getCalle());
            preparedStatement.setInt(3,domicilio.getNumero());
            preparedStatement.setString(4,domicilio.getLocalidad());
            preparedStatement.setString(5, domicilio.getProvincia());

            // 4- Ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return domicilio;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public Domicilio buscar(Long id) {
        return null;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return null;
    }
}
