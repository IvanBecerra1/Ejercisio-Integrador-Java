package entidades;

import Enumeradores.EColores;

public class Armadura {
    private EColores colorPrimario;
    private EColores colorSecundario;

    // bota
    private Propulsor botaIzquierdo;
    private Propulsor botaDerecho;

    // guante
    private Repulsores guanteIzquierdo;
    private Repulsores guanteDerecho;
    private Resistencia resistencia;

    private Generador generador;

    public Armadura() {
        this.botaDerecho = new Propulsor();
        this.botaIzquierdo = new Propulsor();
        this.guanteDerecho = new Repulsores();
        this.guanteIzquierdo = new Repulsores();
        this.generador = new Generador();
        this.resistencia = new Resistencia();

        this.colorPrimario = EColores.AMARILLO;
        this.colorSecundario = EColores.ROJO;


        // Segundo hilo encargado de la bateria.
        Thread hiloBateria = new Thread(this.generador);
        hiloBateria.start();

    }
    public Armadura(EColores colorPrimario, EColores colorSecundario, Resistencia resistencia) {
        this();

        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.resistencia = resistencia;

    }

    public EColores getColorPrimario() {
        return colorPrimario;
    }

    public void setColorPrimario(EColores colorPrimario) {
        this.colorPrimario = colorPrimario;
    }

    public EColores getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(EColores colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public Propulsor getBotaIzquierdo() {
        return botaIzquierdo;
    }

    public void setBotaIzquierdo(Propulsor botaIzquierdo) {
        this.botaIzquierdo = botaIzquierdo;
    }

    public Propulsor getBotaDerecho() {
        return botaDerecho;
    }

    public void setBotaDerecho(Propulsor botaDerecho) {
        this.botaDerecho = botaDerecho;
    }

    public Repulsores getGuanteIzquierdo() {
        return guanteIzquierdo;
    }

    public void setGuanteIzquierdo(Repulsores guanteIzquierdo) {
        this.guanteIzquierdo = guanteIzquierdo;
    }

    public Repulsores getGuanteDerecho() {
        return guanteDerecho;
    }

    public void setGuanteDerecho(Repulsores guanteDerecho) {
        this.guanteDerecho = guanteDerecho;
    }

    public Resistencia getResistencia() {
        return resistencia;
    }

    public void setResistencia(Resistencia resistencia) {
        this.resistencia = resistencia;
    }

    public double getBateria() {
        return this.generador.getBateria();
    }

    public void setBateria(double bateria) {
        this.generador.setBateria(bateria);
    }

    @Override
    public String toString() {
        return "Armadura{" +
                "\ncolorPrimario=" + colorPrimario +
                "\ncolorSecundario=" + colorSecundario +
                "\nbotaIzquierdo=" + botaIzquierdo +
                "\nbotaDerecho=" + botaDerecho +
                "\nguanteIzquierdo=" + guanteIzquierdo +
                "\nguanteDerecho=" + guanteDerecho +
                "\nresistencia=" + resistencia +
                "\nbateria=" + this.generador +
                '}';
    }
}
