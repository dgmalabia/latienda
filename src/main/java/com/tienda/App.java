package com.tienda;

public class App {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Producto[] productos = new Producto[] {
                new Producto("+5 Macarrones", 10, 20), //
                new Producto("Botella Vino Tinto", 2, 0), //
                new Producto("Colonia", 5, 7), //
                new Producto("Queso Azul", 0, 80), //
                new Producto("Queso Azul", -1, 80),
                new Producto("Acceso VIP Eric Mauller", 15, 20),
                new Producto("Acceso VIP Eric Mauller", 10, 47),
                new Producto("Acceso VIP Eric Mauller", 5, 47),

                // TODO: La tarta de manzana no está implementada todavía.
                new Producto("Tarta de manzana", 3, 6) };

        LaTienda app = new LaTienda(productos);

        int days = 2;
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
            app.actualizarProductos();
        }
    }

}
