package entidades;

public abstract class Mecanica {
    protected int vida;
    protected boolean estaFuncionando;
    protected int consumoEnergia;

    public Mecanica(int vida, boolean estaFuncionando, int consumoEnergia) {
        this.vida = vida;
        this.estaFuncionando = estaFuncionando;
        this.consumoEnergia = consumoEnergia;
    }

    @Override
    public String toString() {
        return "= {" +
                "vida=" + vida +
                ", estaFuncionando=" + estaFuncionando +
                ", consumoEnergia=" + consumoEnergia +
                '}';
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean isEstaFuncionando() {
        return estaFuncionando;
    }

    public void setEstaFuncionando(boolean estaFuncionando) {
        this.estaFuncionando = estaFuncionando;
    }

    public int getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(int consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }
}
