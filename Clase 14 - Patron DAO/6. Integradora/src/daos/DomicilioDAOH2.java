package daos;

import entidades.Domicilio;
import entidades.Paciente;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM domicilio WHERE id=?");
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
    public Domicilio buscar(Long id) {
        // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Domicilio domicilio = null;

        // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM domicilio WHERE id=?");
            preparedStatement.setLong(1,id);

            // 4- Ejecutar la sentencia, Query, porque es una CONSULTA
            ResultSet result = preparedStatement.executeQuery();

            // 5- Recorrer el resulset, evaluar resultados
            while(result.next()){
                // traemos los campos del registro
                Long idPaciente = result.getLong("id");
                String calle = result.getString("calle");
                int numero = result.getInt("numero");
                String localidad = result.getString("localidad");
                String provincia = result.getString("provincia");

                domicilio = new Domicilio(id,calle,numero,localidad,provincia);

                System.out.println("ID: "+Long.toString(result.getLong(1)) +" - Calle: "+result.getString(2)+" - Numero: "+Integer.toString(result.getInt(3))
                        +" - Localidad: "+result.getString(4)+" - Provincia: "+result.getString(5));
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return domicilio;
    }

    @Override
    public List<Domicilio> buscarTodos() {

        // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Domicilio> domicilios = new ArrayList();

        // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM domicilio");

            // 4- Ejecutar la sentencia, Query, porque es una CONSULTA
            ResultSet result = preparedStatement.executeQuery();

            // 5- Recorrer el resulset, evaluar resultados
            while(result.next()){
                // traemos los campos del registro
                Long id = result.getLong("id");
                String calle = result.getString("calle");
                int numero = result.getInt("numero");
                String localidad = result.getString("localidad");
                String provincia = result.getString("provincia");

                // Crea domicilioS con los campos que trae el select from *(all) domicilio
                Domicilio domicilio = new Domicilio(id,calle,numero,localidad,provincia);

                // p r i n t
                // Date a Str
                //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                // https://www.delftstack.com/es/howto/java/print-a-table-in-java/
                String[][] table = new String[1][];
                table[0] = new String[] { Long.toString(result.getLong(1)), result.getString(2), Integer.toString(result.getInt(3)),
                        result.getString(4), result.getString(5)};
                for (String[] row : table) {
                    System.out.format("%5s %15s %15s %15s %15s %n", row);
                    // %15s significa cadena justificada a la derecha con 15 anchos, y %n es un separador de línea específico de la plataforma.
                }

                domicilios.add(domicilio);
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return domicilios;
    }
}
