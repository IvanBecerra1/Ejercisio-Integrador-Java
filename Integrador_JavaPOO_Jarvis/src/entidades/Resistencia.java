package entidades;

import Enumeradores.EMaterial;

public class Resistencia {
    private EMaterial material;

    public Resistencia() {
        this.material = EMaterial.BRIVANIO;
    }

    public EMaterial getMaterial() {
        return material;
    }

    public void setMaterial(EMaterial material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Resistencia{" +
                "material=" + material +
                '}';
    }
}
