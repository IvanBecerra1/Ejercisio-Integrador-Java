package entidades;

public class Generador implements Runnable {
    private double bateria;

    public Generador() {
        this.bateria = 80;
    }

    public double getBateria() {
        return bateria;
    }

    public void setBateria(double bateria){
        this.bateria = bateria;
    }

    @Override
    public String toString() {
        return "Bateria = " + this.bateria + "%";

    }

    /**
     * Se ejecuta una funcion en un hilo secundario
     * donde se determina por 5 segundos la carga de
     * bateria de JARVIS.
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(25000);

                if (this.bateria == 100) {
                    continue;
                }

                this.bateria++;
                System.out.println("// Bateria ++1 //");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
