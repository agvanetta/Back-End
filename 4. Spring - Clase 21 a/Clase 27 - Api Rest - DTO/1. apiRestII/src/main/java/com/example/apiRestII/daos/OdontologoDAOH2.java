package com.example.apiRestII.daos;

import com.example.apiRestII.entidades.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements InterfaceDAO<Odontologo>{

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_domicilios;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Iniciando guardado");
        // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO odontologos VALUES (?,?,?,?)");
            preparedStatement.setLong(1,odontologo.getId());
            preparedStatement.setInt(2,odontologo.getNumero_matricula());
            preparedStatement.setString(3,odontologo.getNombre());
            preparedStatement.setString(4,odontologo.getApellido());

            // 4- Ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();
            logger.info("El metodo guardar se ejecuto con exito");

        } catch (ClassNotFoundException e) {
            logger.error("Ocurrio un error en "+e);
            e.printStackTrace();
        } catch (SQLException throwables) {
            logger.error("Ocurrio un error en "+throwables);
            throwables.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public void eliminar(Long id) {
        logger.info("Ejecutando metodo eliminar");
        // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM odontologos WHERE id=?");
            preparedStatement.setLong(1,id);

            // 4- Ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();
            logger.info("La operacion se realizo con exito");

        } catch (ClassNotFoundException e) {
            logger.error("Ocurrio un error en "+e);
            e.printStackTrace();
        } catch (SQLException throwables) {
            logger.error("Ocurrio un error en "+throwables);
            throwables.printStackTrace();
        }
    }

    @Override
    public Odontologo buscar(Long id) {
        logger.info("Ejecutando metodo buscar");
        // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;

        // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM odontologos WHERE id=?");
            preparedStatement.setLong(1,id);

            // 4- Ejecutar la sentencia, Query, porque es una CONSULTA
            ResultSet result = preparedStatement.executeQuery();

            // 5- Recorrer el resulset, evaluar resultados
            while(result.next()){
                // traemos los campos del registro
                Long idod = result.getLong("id");
                int numero_matricula = result.getInt("numero_matricula");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");

                odontologo = new Odontologo(idod,numero_matricula,nombre,apellido);
                logger.info("Id : "+(result.getLong(1))+" | Numero de matricula : "+(result.getInt(2)
                        +" | Nombre : "+result.getString(3)+" | Apellido : "+result.getString(4)));
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            logger.error("Ocurrio un error en "+e);
            e.printStackTrace();
        } catch (SQLException throwables) {
            logger.error("Ocurrio un error en "+throwables);
            throwables.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public List buscarTodos() {
        logger.info("Ejecutando metodo buscaTodos");
        // 1-Crear la conexion y preparedStatement
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList();

        // 2- Levantar el driver, y conectarnos
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3- Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM odontologos");

            // 4- Ejecutar la sentencia, Query, porque es una CONSULTA
            ResultSet result = preparedStatement.executeQuery();

            // 5- Recorrer el resulset, evaluar resultados
            while(result.next()){
                // traemos los campos del registro
                Long idod = result.getLong("id");
                int numero_matricula = result.getInt("numero_matricula");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");

                // Crea domicilios con los campos que trae el select from *(all)
                Odontologo odontologo = new Odontologo(idod,numero_matricula,nombre,apellido);

                odontologos.add(odontologo);
                logger.info("Id : "+(result.getLong(1))+" | Numero de matricula : "+(result.getInt(2)
                        +" | Nombre : "+result.getString(3)+" | Apellido : "+result.getString(4)));
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            logger.error("Ocurrio un error en "+e);
            e.printStackTrace();
        } catch (SQLException throwables) {
            logger.error("Ocurrio un error en "+throwables);
            throwables.printStackTrace();
        }
        return odontologos;
    }
}
