package Servicios;

import entidades.Armadura;

public interface IEstadoArmadura {

    /**
     * Hacer un método que JARVIS muestre el estado de todos los dispositivos y toda la
     * información de la Armadura.
     */
    public static void estadoDispositivo(Armadura armadura) {
        System.out.println("-------------Informacion de armadura------------");
        System.out.println(armadura.toString());
    }

    /**
     * Hacer un método para que JARVIS informe el estado de la batería en porcentaje a través
     * de la consola. Poner como carga máxima del reactor el mayor float posible. Ejecutar
     * varias acciones y mostrar el estado de la misma.
     */
    public static void estadoBateria(Armadura armadura) {
        System.out.println("--------------Informacion Bateria---------------");
        System.out.println(armadura.getBateria());
    }

    /**
     * Hacer un método para que JARVIS informe el estado del reactor en otras dos unidades
     * de medida. Hay veces en las que Tony tiene pretensiones extrañas. Buscar en Wikipedia
     * la tabla de transformaciones.
     */
    public static void informacionReactor(Armadura armadura) {

        double reactor = armadura.getBateria();

        double megajulios = reactor / 1000000;
        double megaergios = reactor / 1.055e+8;
        System.out.println("* El reactor tiene una energía de " + megajulios + " megajulios y " + megaergios + " megaergios.");

        double vatios = reactor;
        double calorias = reactor / 4.184;
        System.out.println("* El reactor tiene una energía de " + vatios + " vatios y " + calorias + " calorías.");
    }

}
