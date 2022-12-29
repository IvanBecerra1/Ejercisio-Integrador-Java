package entidades;

public class Repulsores extends Mecanica {
    public Repulsores() {
        super(100, true, 10);
    }

    @Override
    public String toString() {
        return "Repulsores" + super.toString();
    }
}
