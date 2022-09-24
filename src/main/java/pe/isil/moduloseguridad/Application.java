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
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_phone_store",
                "root", "123456");

        //EJERCICIO 1 Statement para Listar celulares

        //Crear Statement
        String queryStatement = "SELECT * FROM CELULARES";
        Statement stmtListarCelulares = conexion.createStatement();
        ResultSet rsListarCelulares = stmtListarCelulares.executeQuery(queryStatement);

        //Recorrer Listar Celulares
        System.out.println("\n---Listar celulares---");
        while (rsListarCelulares.next()) {
            System.out.println(rsListarCelulares.getString("id")
                            + " " + rsListarCelulares.getString("marca")
                            + " " + rsListarCelulares.getString("modelo")
                            + " " + rsListarCelulares.getString("procesador")
                            + " " + rsListarCelulares.getString("memoria")
                            + " " + rsListarCelulares.getString("almacenamiento")
//                    + " " + rsListarCelulares.getString("descripcion")
                            + " " + rsListarCelulares.getString("precio")
            );
        }


        //EJERCICIO 2 PreparedStatement para actualizar precio de un celular

        //Dando valores a nuestras variables
        String precioActualizar = "5120.00";
        int IdActualizar = 2;

        //Crear PreparedStatement para mostrar celular antes de actualizar
        String queryMostrarCelularAntes = "SELECT * FROM CELULARES WHERE id = ?";
        PreparedStatement ptmtMostrarCelularAntes = conexion.prepareStatement(queryMostrarCelularAntes);
        ptmtMostrarCelularAntes.setInt(1, IdActualizar);
        ResultSet rsMostrarCelularAntes = ptmtMostrarCelularAntes.executeQuery();

        //Recorrer Registro antes de actualizar
        System.out.println("\n---Registro antes de actualizar---");
        while (rsMostrarCelularAntes.next()) {
            System.out.println(rsMostrarCelularAntes.getString("id")
                            + " " + rsMostrarCelularAntes.getString("marca")
                            + " " + rsMostrarCelularAntes.getString("modelo")
                            + " " + rsMostrarCelularAntes.getString("procesador")
                            + " " + rsMostrarCelularAntes.getString("memoria")
                            + " " + rsMostrarCelularAntes.getString("almacenamiento")
//                    + " " + rsMostrarCelularAntes.getString("descripcion")
                            + " " + rsMostrarCelularAntes.getString("precio")
            );
        }


        //Crear PreparedStatement para actualizar precio de celular
        String queryPreparedStatement = "UPDATE celulares SET precio = ? WHERE id = ?";
        PreparedStatement pstmt = conexion.prepareStatement(queryPreparedStatement);
        pstmt.setString(1, precioActualizar);
        pstmt.setInt(2, IdActualizar);
        int rsPreparedStatement = pstmt.executeUpdate();

        //Mostrar Resultado de actualizar
        System.out.println("\n---Resultado de actualizar--- (1 = Registro Actualizado, 0 = No se realizó la actualización)");
        System.out.println(rsPreparedStatement);


        //Crear PreparedStatement para mostrar celular despues de actualizar
        String queryMostrarCelularDespues = "SELECT * FROM CELULARES WHERE id = ?";
        PreparedStatement ptmtMostrarCelularDespues = conexion.prepareStatement(queryMostrarCelularDespues);
        ptmtMostrarCelularDespues.setInt(1, IdActualizar);
        ResultSet rsMostrarCelularDespues = ptmtMostrarCelularDespues.executeQuery();

        //Recorrer Registro despues de actualizar
        System.out.println("\n---Registro despues de actualizar---");
        while (rsMostrarCelularDespues.next()) {
            System.out.println(rsMostrarCelularDespues.getString("id")
                            + " " + rsMostrarCelularDespues.getString("marca")
                            + " " + rsMostrarCelularDespues.getString("modelo")
                            + " " + rsMostrarCelularDespues.getString("procesador")
                            + " " + rsMostrarCelularDespues.getString("memoria")
                            + " " + rsMostrarCelularDespues.getString("almacenamiento")
//                    + " " + rsMostrarCelularDespues.getString("descripcion")
                            + " " + rsMostrarCelularDespues.getString("precio")
            );
        }


        //EJERCICIO 3 CallableStatement para registrar un nuevo celular

        //Dando valores a nuestras variables
        String marcaCel = "Marca prueba";
        String modeloCel = "Modelo prueba";
        String procesadorCel = "Procesador prueba";
        String memoriaCel = "Memoria prueba";
        String almacenamientoCel = "Almacenamiento prueba";
        String descripcionCel = "Descripción prueba";
        String precioCel = "Precio prueba";
        int estadoCel = 1;

        //Crear CallableStatement para ingresar celular
        CallableStatement callSpIngresarCelular = conexion.prepareCall("{call ingresarCelular(?,?,?,?,?,?,?,?,?)}");
        callSpIngresarCelular.setString(1, marcaCel);
        callSpIngresarCelular.setString(2, modeloCel);
        callSpIngresarCelular.setString(3, procesadorCel);
        callSpIngresarCelular.setString(4, memoriaCel);
        callSpIngresarCelular.setString(5, almacenamientoCel);
        callSpIngresarCelular.setString(6, descripcionCel);
        callSpIngresarCelular.setString(7, precioCel);
        callSpIngresarCelular.setInt(8, estadoCel);
        callSpIngresarCelular.registerOutParameter(9, Types.INTEGER);
        callSpIngresarCelular.executeQuery();

        //Crear PreparedStatement para mostrar nuevo selular registrado
        String queryMostrarCelularNuevo = "SELECT * FROM CELULARES ORDER BY id DESC LIMIT 1";
        PreparedStatement ptmtMostrarCelularNuevo = conexion.prepareStatement(queryMostrarCelularNuevo);
        ResultSet rsMostrarCelularNuevo = ptmtMostrarCelularNuevo.executeQuery();

        //Mostrar nuevo registro
        System.out.println("\n---Nuevo celular registrado---");
        while (rsMostrarCelularNuevo.next()) {
            System.out.println(rsMostrarCelularNuevo.getString("id")
                            + " " + rsMostrarCelularNuevo.getString("marca")
                            + " " + rsMostrarCelularNuevo.getString("modelo")
                            + " " + rsMostrarCelularNuevo.getString("procesador")
                            + " " + rsMostrarCelularNuevo.getString("memoria")
                            + " " + rsMostrarCelularNuevo.getString("almacenamiento")
//                    + " " + rsMostrarCelularNuevo.getString("descripcion")
                            + " " + rsMostrarCelularNuevo.getString("precio")
            );
        }


        //EJERCICIO 4 CallableStatement para eliminar un celular

        //Dando valor a nuestra variable ID a eliminar
        int idCelularEliminar = 17;

        //Crear CallableStatement para eliminar un celular
        CallableStatement callSpEliminarCelular = conexion.prepareCall("{call eliminarCelular(?,?)}");
        callSpEliminarCelular.setInt(1, idCelularEliminar);
        callSpEliminarCelular.registerOutParameter(2, Types.INTEGER);
        callSpEliminarCelular.executeQuery();

        //Crear PreparedStatement para listar celulares sin el registro eliminado
        String queryrsListarCelularesSinIdEliminado = "SELECT * FROM CELULARES";
        PreparedStatement ptmtrsListarCelularesSinIdEliminado = conexion.prepareStatement(queryrsListarCelularesSinIdEliminado);
        ResultSet rsListarCelularesSinIdEliminado = ptmtrsListarCelularesSinIdEliminado.executeQuery();

        //Listar celulares sin el registro eliminado
        System.out.println("\n---Listar celulares sin el registro eliminado, el ID eliminado es: " + idCelularEliminar + "---");
        while (rsListarCelularesSinIdEliminado.next()) {
            System.out.println(rsListarCelularesSinIdEliminado.getString("id")
                            + " " + rsListarCelularesSinIdEliminado.getString("marca")
                            + " " + rsListarCelularesSinIdEliminado.getString("modelo")
                            + " " + rsListarCelularesSinIdEliminado.getString("procesador")
                            + " " + rsListarCelularesSinIdEliminado.getString("memoria")
                            + " " + rsListarCelularesSinIdEliminado.getString("almacenamiento")
//                    + " " + rsListarCelularesSinIdEliminado.getString("descripcion")
                            + " " + rsListarCelularesSinIdEliminado.getString("precio")
            );
        }
    }
}
