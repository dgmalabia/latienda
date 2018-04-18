package com.tienda;

import static org.junit.Assert.*;

import org.junit.Test;

public class LaTiendaTest {

    @Test
    public void foo() {
    	//Arrange
        Producto[] productos = new Producto[] { new Producto("foo", 0, 0) };
        LaTienda app = new LaTienda(productos);
        
        //Act
        app.actualizarProductos();
        
        //Assert
        //DGM test actualizado para corregir fallo de comparación assertEquals
        assertEquals("foo", app.productos[0].nombre);
    }

}
