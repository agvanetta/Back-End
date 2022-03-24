package daos;

import entidades.Domicilio;
import entidades.Paciente;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    // Se crea un domicilio porque cada paciente llega un domicilio por foreing key
    private DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
    // Este lo utilizaremos para realizar consultas que requieran ingresar id_domicilio

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
        // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM paciente WHERE id=?");
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
    public Paciente buscar(Long id) {

        // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente paciente = null;

        // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM paciente WHERE id=?");
            preparedStatement.setLong(1,id);

            // 4- Ejecutar la sentencia, Query, porque es una CONSULTA
            ResultSet result = preparedStatement.executeQuery();

            // 5- Recorrer el resulset, evaluar resultados
            while(result.next()){
                // traemos los campos del registro
                Long idPaciente = result.getLong("id");
                String apellido = result.getString("apellido");
                String nombre = result.getString("nombre");
                int dni = result.getInt("dni");
                Date fecha_ingreso = result.getDate("fecha_ingreso");
                Long id_domicilio = result.getLong("id_domicilio");

                //Con el domicilio_id traemos el domicilio de la tabla domicilio a traves de DAO de Domicilios
                Domicilio domicilioQuery = domicilioDAOH2.buscar(id_domicilio);

                paciente = new Paciente(idPaciente,apellido,nombre,dni,fecha_ingreso,domicilioQuery);

                System.out.println((result.getLong(1))+result.getString(2) +result.getString(3)+
                        (result.getInt(4)) + (result.getDate(5))+(result.getLong(6)));
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() {
        // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Paciente> pacientes = new ArrayList();

        // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM paciente");

            // 4- Ejecutar la sentencia, Query, porque es una CONSULTA
            ResultSet result = preparedStatement.executeQuery();

            // 5- Recorrer el resulset, evaluar resultados
            while(result.next()){
                // traemos los campos del registro
                Long idPaciente = result.getLong("id");
                String apellido = result.getString("apellido");
                String nombre = result.getString("nombre");
                int dni = result.getInt("dni");
                Date fecha_ingreso = result.getDate("fecha_ingreso");
                Long id_domicilio = result.getLong("id_domicilio");

                //Con el domicilio_id traemos el domicilio de la tabla domicilio a traves de DAO de Domicilios UTILIZA EL METODO BUSCAR ANTERIOR, DE AHI SACA EL SOUT
                Domicilio domicilioQuery = domicilioDAOH2.buscar(id_domicilio);

                // Crea pacienteS con los campos que trae el select from *(all) paciente
                Paciente paciente = new Paciente(idPaciente,apellido,nombre,dni,fecha_ingreso,domicilioQuery);

                // p r i n t
                // Date a Str
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                // https://www.delftstack.com/es/howto/java/print-a-table-in-java/
                //String[][] table = new String[1][];
                //table[0] = new String[] { Long.toString(result.getLong(1)), result.getString(2), result.getString(3),
                //        Integer.toString(result.getInt(4)), dateFormat.format(result.getDate(5)), Long.toString(result.getLong(6))};
                //for (String[] row : table) {
                //    System.out.format("%5s %15s %15s %15s %15s %10s %n", row);
                    // %15s significa cadena justificada a la derecha con 15 anchos, y %n es un separador de línea específico de la plataforma.
                //}
                pacientes.add(paciente);
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pacientes;
    }
}

