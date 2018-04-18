package com.tienda;

import static com.tienda.constants.Constants.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tienda.dao.ProductoExtended;
import com.tienda.services.LaTiendaService;;

public class LaTiendaTest {

	@Test
	public void foo() {
		// Arrange
		List<ProductoExtended> productos = new ArrayList<ProductoExtended>();
		productos.add(new ProductoExtended("foo", 0, 0));

		LaTiendaService app = new LaTiendaService();

		// Act
		app.updateDailyProducts(productos);

		// Assert
		// DGM test actualizado para corregir fallo de comparación assertEquals
		assertEquals("foo", productos.get(0).getNombre());
	}

	@Test
	public void testVino() {

		// Arrange
		List<ProductoExtended> productos = new ArrayList<ProductoExtended>();
		productos.add(new ProductoExtended(BOTELLA_VINO_TINTO, 2, 0));
		LaTiendaService app = new LaTiendaService();

		// Act
		app.updateDailyProducts(productos);

		// Assert
		// DGM test actualizado el valor del vino se incrementa
		assertEquals(1, productos.get(0).getValor());

		// Act
		// Pasan otros cien dias
		for (int i = 0; i < 100; i++) {
			app.updateDailyProducts(productos);
		}
		// Assert
		// DGM el valor de un item no puede superar la calidad 50
		assertEquals(50, productos.get(0).getValor());
		// Si el vino tiene una caducidad de 2 y pasan 101 dias deberá tener una
		// caducidad de -99
		assertEquals(-99, productos.get(0).getCaducidad());
	}

	@Test
	public void testQuesoAzul() {

		// Arrange
		List<ProductoExtended> productos = new ArrayList<ProductoExtended>();
		productos.add(new ProductoExtended(QUESO_AZUL, 20, 60));
		LaTiendaService app = new LaTiendaService();

		// Act 1 dias
		app.updateDailyProducts(productos);

		// Assert
		// DGM test actualizado el valor del queso azul permanece constante, la
		// fecha de caducidad también constante
		assertEquals(60, productos.get(0).getValor());
		assertEquals(20, productos.get(0).getCaducidad());

		// Act Pasan otros cien dias
		for (int i = 0; i < 100; i++) {
			app.updateDailyProducts(productos);
		}

		// Assert
		// DGM test actualizado el valor del queso azul permanece constante, la
		// fecha de caducidad también constante
		assertEquals(60, productos.get(0).getValor());
		assertEquals(20, productos.get(0).getCaducidad());
	}

	@Test
	public void testMauller() {

		// Arrange
		List<ProductoExtended> productos = new ArrayList<ProductoExtended>();
		productos.add(new ProductoExtended(ACCESO_VIP_ERIC_MAULLER, 11, 5));
		LaTiendaService app = new LaTiendaService();

		// Act quedan 11 días para concierto
		app.updateDailyProducts(productos);

		// Assert
		// DGM test actualizado el valor del ACCESO VIP ERIC MAULLER se
		// incrementa en uno
		assertEquals(6, productos.get(0).getValor());

		// Act quedan 10 dias para concierto
		app.updateDailyProducts(productos);

		// Assert
		// DGM test actualizado el valor del ACCESO VIP ERIC MAULLER se
		// incrementa en dos
		assertEquals(8, productos.get(0).getValor());

		// Act Pasan nueve dias, el valor del ACCESO VIP ERIC MAULLER se
		// incrementa en dos
		for (int i = 0; i < 9; i++) {
			app.updateDailyProducts(productos);
		}
		// Assert
		// DGM test el valor del ACCESO VIP ERIC MAULLER es el siguiente
		// empezamos día 11 valor 5 incrementamos en uno
		// día 10 llega valor 6, incrementamos en dos
		// dia 9 llega valor 8,, incrementamos en dos
		// dia 8 llega valor 10, incrementamos en dos
		// dia 7 llega valor 12, incrementamos en dos
		// dia 6 llega valor 14, incrementamos en dos
		// dia 5 llega valor 16, incrementamos en tres
		// dia 4 llega valor 19, incrementamos en tres
		// dia 3 llega valor 22, incrementamos en tres
		// dia 2 llega valor 25, incrementamos en tres
		// dia 1 llega valor 28, incrementamos en tres
		// dia 0 llega valor 31
		assertEquals(31, productos.get(0).getValor());
		assertEquals(0, productos.get(0).getCaducidad());

		// Act Siguiente día, despues del concierto, valor cero
		app.updateDailyProducts(productos);

		// Assert
		// DGM test el valor del ACCESO VIP ERIC MAULLER es cero una vez
		// ocurrido el concierto
		assertEquals(0, productos.get(0).getValor());
		assertEquals(-1, productos.get(0).getCaducidad());
	}

	@Test
	public void testTartaManzana() {

		// Arrange
		List<ProductoExtended> productos = new ArrayList<ProductoExtended>();
		productos.add(new ProductoExtended(TARTA_DE_MANZANA, 10, 40));
		LaTiendaService app = new LaTiendaService();

		// Act
		app.updateDailyProducts(productos);

		// Assert
		// DGM test actualizado la tarta de manzana decrementa el doble del valor normal (el doble de 1 = 2)
		assertEquals(38, productos.get(0).getValor());

		// Act
		// Pasan otros cien dias
		for (int i = 0; i < 100; i++) {
			app.updateDailyProducts(productos);
		}
		// Assert
		// DGM el valor de un item no puede ser  negativo
		assertEquals(0, productos.get(0).getValor());
		
	}

}
