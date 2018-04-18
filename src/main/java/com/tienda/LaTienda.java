package com.tienda;

class LaTienda {
    Producto[] productos;

    public LaTienda(Producto[] productos) {
        this.productos = productos;
    }

    public void actualizarProductos() {
        for (int i = 0; i < productos.length; i++) {
            if (!productos[i].nombre.equals("Botella Vino Tinto")
                    && !productos[i].nombre.equals("Acceso VIP Eric Mauller")) {
                if (productos[i].valor > 0) {
                    if (!productos[i].nombre.equals("Queso Azul")) {
                        productos[i].valor = productos[i].valor - 1;
                    }
                }
            } else {
                if (productos[i].valor < 50) {
                    productos[i].valor = productos[i].valor + 1;

                    if (productos[i].nombre.equals("Acceso VIP Eric Mauller")) {
                        if (productos[i].caducidad < 11) {
                            if (productos[i].valor < 50) {
                                productos[i].valor = productos[i].valor + 1;
                            }
                        }

                        if (productos[i].caducidad < 6) {
                            if (productos[i].valor < 50) {
                                productos[i].valor = productos[i].valor + 1;
                            }
                        }
                    }
                }
            }

            if (!productos[i].nombre.equals("Queso Azul")) {
                productos[i].caducidad = productos[i].caducidad - 1;
            }

            if (productos[i].caducidad < 0) {
                if (!productos[i].nombre.equals("Botella Vino Tinto")) {
                    if (!productos[i].nombre.equals("Acceso VIP Eric Mauller")) {
                        if (productos[i].valor > 0) {
                            if (!productos[i].nombre.equals("Queso Azul")) {
                                productos[i].valor = productos[i].valor - 1;
                            }
                        }
                    } else {
                        productos[i].valor = productos[i].valor - productos[i].valor;
                    }
                } else {
                    if (productos[i].valor < 50) {
                        productos[i].valor = productos[i].valor + 1;
                    }
                }
            }
        }
    }
}
