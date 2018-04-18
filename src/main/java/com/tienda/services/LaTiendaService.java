package com.tienda.services;

import java.util.List;

import com.tienda.dao.ProductoExtended;

import static com.tienda.constants.Constants.*;

public class LaTiendaService {

	public void updateDailyProducts(List<ProductoExtended> productos) {
		for (ProductoExtended producto : productos) {
			switch (producto.getNombre()) {
			case ACCESO_VIP_ERIC_MAULLER:
				updateProductERIC_MAULLER(producto);
				break;
			case BOTELLA_VINO_TINTO:
				updateVinoTinto(producto);
				break;
			case QUESO_AZUL:
				// No hacer nada
				break;
			case TARTA_DE_MANZANA:
				updateTartaManzana(producto);
				break;
			default:
				updateProductoNormal(producto);
				break;

			}
		}

	}

	private void updateTartaManzana(ProductoExtended producto) {
		producto.decrementarCaducidad();
		producto.decrementarValor();
		producto.decrementarValor();

	}

	private void updateVinoTinto(ProductoExtended producto) {
		producto.decrementarCaducidad();
		producto.incrementarValor();

	}

	private void updateProductERIC_MAULLER(ProductoExtended producto) {


		

		if (producto.getCaducidad() < 11) {
			producto.incrementarValor();

		}
		if (producto.getCaducidad() < 6) {
			producto.incrementarValor();
		}

		producto.incrementarValor();
		producto.decrementarCaducidad();
	
		if (producto.getCaducidad() < 0) {
			producto.setValor(0);
			return;
		}
	}

	private void updateProductoNormal(ProductoExtended producto) {
		producto.decrementarCaducidad();
		producto.decrementarValor();
	}

}
