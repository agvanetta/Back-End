import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

    static Empleado agustin = new Empleado(1, "Agustin", 3, "Digital House", "06-06-1993");
    static Empleado otronom = new Empleado(2, "Vanetta", 3, "Google", "18-02-1993");
    static Empleado agustin3 = new Empleado(3, "Ag_Vanetta", 3, "Facebook", "01-04-1993");

    public static void main(String[] args) throws Exception {
        //Class.forName("org.h2.Driver").newInstance();
        //Connection con = DriverManager.getConnection("jdbc:h2:"+
        //        "./Database/my", "root", "myPassword");

        Class.forName("org.h2.Driver").newInstance();
        //jdbc:h2:~/test
        Connection con = DriverManager.getConnection("jdbc:h2:" +
                "~/test", "sa", "");


        Statement stmt = con.createStatement();

        //Código para crear una tabla. Elimina la tabla si esta ya existe y la
        //vuelve a crear
        String createSql = "DROP TABLE IF EXISTS TEST;\n" +
                "CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255), EDAD INT, EMPRESA VARCHAR(255), FECHA_INGRESO VARCHAR(255));\n" +
                "INSERT INTO TEST VALUES(" + agustin.getID() + ", '" + agustin.getNombre() + "', " + agustin.getEdad() + ", '" + agustin.getEmpresa() + "', '" + agustin.getFechaIngreso() + "');\n" +
                "INSERT INTO TEST VALUES(" + otronom.getID() + ", '" + otronom.getNombre() + "', " + otronom.getEdad() + ", '" + otronom.getEmpresa() + "', '" + otronom.getFechaIngreso() + "');\n" +
                "INSERT INTO TEST VALUES(" + agustin3.getID() + ", '" + agustin3.getNombre() + "', " + agustin3.getEdad() + ", '" + agustin3.getEmpresa() + "', '" + agustin3.getFechaIngreso() + "')\n";

        stmt.execute(createSql);

        //Codigo para consultar todos los registros de la tabla TEST
        String sql = "select * from TEST";
        ResultSet rd = stmt.executeQuery(sql);

        //Código para recorrer el resultado de la consulta
        while (rd.next()) {
            System.out.println(rd.getInt(1) + rd.getString(2) + rd.getInt(3) + rd.getString(4) + rd.getString(5));
        }
    }
}
