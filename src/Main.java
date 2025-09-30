public class Main {
    public static void main(String[] args) {
        Vehiculo auto = new Automovil("Toyota", "Corolla", 2020, 40.0);
        Vehiculo bici = new Bicicleta("Trek", "Mountain", 2022, 21);
        Vehiculo moto = new Motocicleta("Honda", "CBR", 2021, 250, 10.0);

        System.out.println("=== Automóvil ===");
        auto.mover();
        System.out.println(auto.obtenerDetalles());
        ((Combustible) auto).recargarCombustible();
        System.out.println("Nivel de combustible: " + ((Combustible) auto).obtenerNivelCombustible());

        System.out.println("\n=== Bicicleta ===");
        bici.mover();
        System.out.println(bici.obtenerDetalles());

        System.out.println("\n=== Motocicleta ===");
        moto.mover();
        System.out.println(moto.obtenerDetalles());
        ((Combustible) moto).recargarCombustible();
        System.out.println("Nivel de combustible: " + ((Combustible) moto).obtenerNivelCombustible());
    }
}


