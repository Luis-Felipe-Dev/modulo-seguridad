package pe.isil.moduloseguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SpringApplication.run(Application.class, args);

        //Load driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Crear conexion
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/moduloseg",
                "root", "123456");

        //Crear Statement
//        Statement st = conexion.createStatement();
//        PreparedStatement pt = conexion.prepareStatement("SELECT * FROM USERS WHERE id = ?");
//        pt.setInt(1, 2);
        CallableStatement callSp = conexion.prepareCall("{call validarLogin(?,?,?)}");
        callSp.setString(1, "DNI73267572");
        callSp.setString(2, "123456");
        callSp.registerOutParameter(3, Types.INTEGER);

        //Ejecutar sentencia
//        ResultSet resultado = st.executeQuery("SELECT * FROM USERS");
//        ResultSet resultado = pt.executeQuery();
//        ResultSet resultado = callSp.executeQuery();

        callSp.executeQuery();

        int resultado = callSp.getInt(3);

        if(resultado == 1){
            System.out.println("Login exitoso!!!");
        }else{
            System.out.println("Usuario o contraseña incorrecta!!!");
        }

        CallableStatement callSp2 = conexion.prepareCall("{call listaAllUsers()}");
        ResultSet resultadoSP2 = callSp2.executeQuery();

        //Recorrer
        while (resultadoSP2.next()) {
            System.out.println(resultadoSP2.getString("username"));
        }

        CallableStatement callSp3 = conexion.prepareCall("{call listaUserPerId(?)}");
        callSp3.setInt(1,2);
        ResultSet resultadoSP3 = callSp3.executeQuery();

        //Recorrer
        while (resultadoSP3.next()) {
            System.out.println(resultadoSP3.getString("name"));
        }

    }
}
