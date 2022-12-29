package Servicios;

import Excepciones.ArmaduraExcepcion;

public interface IArmadura {

    public void caminar(double tiempo) throws ArmaduraExcepcion;

    public void correr(double tiempo) throws ArmaduraExcepcion;

    public void propulsar(double tiempo) throws ArmaduraExcepcion;

    public void volar(double tiempo) throws ArmaduraExcepcion;

    public void disparar(double tiempo) throws ArmaduraExcepcion;

    public void escribir();
    public void leer(int accion) throws ArmaduraExcepcion;


}
