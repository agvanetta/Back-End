package daos;

import entidades.Paciente;

import java.sql.*;
import java.util.List;

public class PacienteDAOH2 implements InterfaceDAO<Paciente>{

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
    public Paciente guardar(Paciente paciente) {
        // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO paciente VALUES (?,?,?,?,?,?)");
            preparedStatement.setLong(1,paciente.getId());
            preparedStatement.setString(2,paciente.getApellido());
            preparedStatement.setString(3,paciente.getNombre());
            preparedStatement.setInt(4,paciente.getDni());
            //Hay que convertir el Date en sql.Date ya que son dos clases diferentes en Java
            // preparedStatement.setDate(4, Util.utilDateToSqlDate(paciente.getFechaIngreso()));
            preparedStatement.setDate(5, Util.Util.utilDateToSqlDate(paciente.getFechaDeIngreso()));
            preparedStatement.setLong(6, paciente.getDomicilio().getId());

            // 4- Ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return paciente;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public Paciente buscar(Long id) {
        return null;
    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }
}
