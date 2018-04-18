package com.tienda;

import java.util.ArrayList;
import java.util.List;

import static com.tienda.constants.Constants.*;
import com.tienda.dao.Producto;
import com.tienda.dao.ProductoExtended;
import com.tienda.services.LaTiendaService;

public class App {
	


	public static void main(String[] args) {
        System.out.println("OMGHAI!"); 

        List<ProductoExtended> productos = new ArrayList<ProductoExtended>();
        productos.add(new ProductoExtended(_5_MACARRONES, 10, 20));
        productos.add(new ProductoExtended(BOTELLA_VINO_TINTO, 2, 0));
        productos.add(new ProductoExtended(COLONIA, 5, 7));
        productos.add(new ProductoExtended(QUESO_AZUL, 0, 80));
        productos.add(new ProductoExtended(QUESO_AZUL, -1, 80));
        productos.add(new ProductoExtended(ACCESO_VIP_ERIC_MAULLER, 15, 20));
        productos.add(new ProductoExtended(ACCESO_VIP_ERIC_MAULLER, 10, 47));
        productos.add(new ProductoExtended(ACCESO_VIP_ERIC_MAULLER, 5, 47));
        productos.add(new ProductoExtended(TARTA_DE_MANZANA, 15, 40));
        
        //Aqui podriamos usar un framework de instanciación de servicios como Spring @Autowired LaTiendaService app;
        //Tambien podríamos haber definido una jerarquía interfaz - clase que implementa la interfaz de serivicios 
        LaTiendaService app = new LaTiendaService();

        int days = 60;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("nombre, caducidad, valor");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
            System.out.println();
            app.updateDailyProducts(productos);
        }
    }

}
