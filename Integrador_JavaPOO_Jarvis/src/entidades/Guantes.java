package entidades;

public class Guantes extends Mecanica {

    public Guantes() {
        super(100, true, 5);
    }

    @Override
    public String toString() {
        return "Guantes" + super.toString();
    }
}
