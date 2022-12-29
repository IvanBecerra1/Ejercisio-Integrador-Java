package entidades;

public class Propulsor extends Mecanica {

    public Propulsor() {
        super(100, true, 20);
    }


    @Override
    public String toString() {
        return "Propulsor" + super.toString();
    }
}
