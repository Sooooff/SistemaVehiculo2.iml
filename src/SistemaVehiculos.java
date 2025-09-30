// Interfaz que define el comportamiento común para vehículos con capacidad de combustible
interface Combustible {
    void recargarCombustible();
    double obtenerNivelCombustible();
}

// Clase abstracta que representa un vehículo genérico
abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int anio;

    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    // Método abstracto que debe ser implementado por las subclases
    public abstract void mover();

    // Método que puede ser sobrescrito
    public String obtenerDetalles() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Año: " + anio;
    }
}

// Clase que representa un Automóvil
class Automovil extends Vehiculo implements Combustible, Mantenimiento {
    private double nivelCombustible;

    public Automovil(String marca, String modelo, int anio, double nivelCombustible) {
        super(marca, modelo, anio);
        this.nivelCombustible = nivelCombustible;
    }

    @Override
    public void mover() {
        if (nivelCombustible > 0) {
            System.out.println("El automóvil " + marca + " " + modelo + " está conduciendo.");
            nivelCombustible -= 0.5;
        } else {
            System.out.println("El automóvil " + marca + " " + modelo + " no tiene combustible.");
        }
    }

    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + ", Combustible: " + nivelCombustible + " litros";
    }

    @Override
    public void recargarCombustible() {
        nivelCombustible = 50.0;
        System.out.println("El automóvil " + marca + " " + modelo + " ha sido recargado con combustible.");
    }

    @Override
    public double obtenerNivelCombustible() {
        return nivelCombustible;
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Revisando motor del automóvil " + marca + " " + modelo + ".");
    }
}


// Clase que representa una Bicicleta
class Bicicleta extends Vehiculo {
    private int numeroMarchas;

    public Bicicleta(String marca, String modelo, int anio, int numeroMarchas) {
        super(marca, modelo, anio);
        this.numeroMarchas = numeroMarchas;
    }

    @Override
    public void mover() {
        System.out.println("La bicicleta " + marca + " " + modelo + " está pedaleando con " + numeroMarchas + " marchas.");
    }

    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + ", Marchas: " + numeroMarchas;
    }
}

// Clase que representa una Motocicleta
class Motocicleta extends Vehiculo implements Combustible, Mantenimiento {
    private int cilindrada;
    private final double capacidadTanque = 20.0;
    private double nivelCombustible;

    public Motocicleta(String marca, String modelo, int anio, int cilindrada, double nivelCombustible) {
        super(marca, modelo, anio);
        this.cilindrada = cilindrada;
        this.nivelCombustible = Math.min(nivelCombustible, capacidadTanque);
    }

    @Override
    public void mover() {
        if (nivelCombustible > 0) {
            System.out.println("La motocicleta " + marca + " " + modelo +
                    " está acelerando con " + cilindrada + " cc.");
            nivelCombustible -= 0.3;
        } else {
            System.out.println("La motocicleta " + marca + " " + modelo + " no tiene combustible.");
        }
    }

    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() +
                ", Cilindrada: " + cilindrada + " cc, Combustible: " + nivelCombustible + " litros";
    }

    @Override
    public void recargarCombustible() {
        nivelCombustible = capacidadTanque;
        System.out.println("La motocicleta " + marca + " " + modelo + " ha sido recargada a " + capacidadTanque + " litros.");
    }

    @Override
    public double obtenerNivelCombustible() {
        return nivelCombustible;
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Cambiando aceite de la motocicleta " + marca + " " + modelo + ".");
    }
}


// Clase principal para probar el sistema
public class SistemaVehiculos {

    public static void procesarVehiculos(Vehiculo[] vehiculos) {
        for (Vehiculo v : vehiculos) {
            System.out.println("\n--- Procesando " + v.getClass().getSimpleName() + " ---");
            v.mover();
            System.out.println(v.obtenerDetalles());

            if (v instanceof Combustible combustible) {
                combustible.recargarCombustible();
                System.out.println("Nivel de combustible: " + combustible.obtenerNivelCombustible());
            }

            if (v instanceof Mantenimiento mantenimiento) {
                mantenimiento.realizarMantenimiento();
            }
        }
    }

    public static void main(String[] args) {
        Vehiculo[] flota = {
                new Automovil("Toyota", "Corolla", 2020, 40.0),
                new Bicicleta("Trek", "Mountain", 2022, 21),
                new Motocicleta("Honda", "CBR", 2021, 250, 10.0)
        };

        System.out.println("=== Procesamiento de Vehículos ===");
        procesarVehiculos(flota);
    }
}




