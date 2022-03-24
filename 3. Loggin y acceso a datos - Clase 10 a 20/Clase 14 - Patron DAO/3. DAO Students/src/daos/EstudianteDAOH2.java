package daos;

import entidades.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOH2 implements IDAO<Estudiante> {

    // Que necesitamos para conectarnos a una BD
    // R: 1- Saber el driver de conexion, => DB_JDBC_DRIVER = "org.h2.Driver";
    //    2- la url (donde esta la BD) => DB_URL = "jdbc:h2:~/db_estudiante";
    //    3- El usuario y el password => sa y ""

    // Creamos variables estaticas porque no van a cambiar
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_estudiante";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";


    @Override
    public Estudiante guardar(Estudiante estudiante) {
            // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;

            // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO estudiantes VALUES (?,?,?)");
            preparedStatement.setLong(1,estudiante.getId());
            preparedStatement.setString(2,estudiante.getNombre());
            preparedStatement.setString(3,estudiante.getApellido());

            // 4- Ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiante;
    }

    @Override
    public void eliminar(Long id) {
        // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM estudiantes WHERE id=?");
            preparedStatement.setLong(1,id);

            // 4- Ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Estudiante buscar(Long id) {
            // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Estudiante estudiante = null;

            // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes WHERE id=?");
            preparedStatement.setLong(1,id);

            // 4- Ejecutar la sentencia, Query, porque es una CONSULTA
            ResultSet result = preparedStatement.executeQuery();

            // 5- Recorrer el resulset, evaluar resultados
            while(result.next()){
                // traemos los campos del registro
                Long idEstudiante = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                estudiante = new Estudiante();
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiante;
    }

    @Override
    public List<Estudiante> buscarTodos() {
        // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Estudiante> estudiantes = new ArrayList();

        // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes");

            // 4- Ejecutar la sentencia, Query, porque es una CONSULTA
            ResultSet result = preparedStatement.executeQuery();

            // 5- Recorrer el resulset, evaluar resultados
            while(result.next()){
                // traemos los campos del registro
                Long idEstudiante = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                Estudiante estudiante = new Estudiante();
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);

                estudiantes.add(estudiante);
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiantes;
    }
}
