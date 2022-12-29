import Servicios.IArmadura;
import Servicios.Implementacion.ArmaduraImpl;
import entidades.Armadura;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        IArmadura armaduraServicio = new ArmaduraImpl();
        armaduraServicio.escribir();
    }
}