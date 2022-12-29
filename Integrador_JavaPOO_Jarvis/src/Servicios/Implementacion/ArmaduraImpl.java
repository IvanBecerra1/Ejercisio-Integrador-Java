package Servicios.Implementacion;

import Enumeradores.EColores;
import Excepciones.ArmaduraExcepcion;
import Servicios.IArmadura;
import Servicios.IEstadoArmadura;
import entidades.Armadura;
import entidades.Resistencia;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Function;

public final class ArmaduraImpl implements IArmadura {

    private Armadura armadura;
    private Scanner read = new Scanner(System.in);

    private BiConsumer<Armadura, Double> consumirEnergia =
            (paramArmadura, paramConsumo) -> {
                System.out.println("Se consumio: " + (paramConsumo * 0.01) + " por la accion.");
                paramArmadura.setBateria(paramArmadura.getBateria()-(paramConsumo * 0.01));
            };

    private final Function<Armadura, Integer> consumoBotas =
            (paramArmadura) -> {
                return (paramArmadura.getBotaIzquierdo().getConsumoEnergia() +
                        paramArmadura.getBotaDerecho().getConsumoEnergia());
            };

    private final Function<Armadura, Integer> consumoGuantes =
            (paramArmadura) -> {
                return (paramArmadura.getGuanteDerecho().getConsumoEnergia() +
                        paramArmadura.getGuanteIzquierdo().getConsumoEnergia());
            };


    private final static String CONST_ACCIONES[] = {
      "Caminar (#1)", "Correr (#2)", "Propulsar (#3)", "Volar (#4)",
      "Disparar (#5)",
            "Estado Dispositivos (#6)",
            "Estado Bateria (#7)",
            "Estado bateria en diferentes conversiones (#7)",
            "Apagar Jarvis (#0)",
    };

    public ArmaduraImpl(){
        this.armadura = new Armadura();
    }

    public ArmaduraImpl(EColores colorPrimario, EColores colorSecundario, Resistencia resistencia){
        this.armadura = new Armadura(colorPrimario, colorSecundario, resistencia);
    }

    /**
     * Al caminar la armadura hará un uso básico de las botas y se consumirá
     * la energía
     * establecida como consumo en la bota por el tiempo en el que se camine
     * @param tiempo
     * @throws Exception
     */
    @Override
    public void caminar(double tiempo) throws ArmaduraExcepcion {
        verificaciones();

        double consumo = consumoBotas.apply(armadura) * tiempo;
        consumirEnergia.accept(armadura,consumo);
    }

    /**
     * Al correr la armadura hará un uso normal de las botas y se consumirá
     * el doble de la energía establecida como consumo
     * en la bota por el tiempo en el que se corra.
     * @param tiempo
     * @throws Exception
     */
    @Override
    public void correr(double tiempo) throws ArmaduraExcepcion {
        verificaciones();

        double consumo = consumoBotas.apply(armadura) * tiempo;
        consumirEnergia.accept(armadura,consumo * 2);
    }

    /**
     * Al propulsarse la armadura hará un uso intensivo de
     * las botas utilizando el triple de la
     * energía por el tiempo que dure la propulsión.
     * @throws Exception
     */
    @Override
    public void propulsar(double tiempo) throws ArmaduraExcepcion {
        verificaciones();

        double consumo = consumoBotas.apply(armadura) * tiempo;
        consumirEnergia.accept(armadura,consumo * 3);
    }

    /**
     * Al volar la armadura hará un uso intensivo de las botas y
     * de los guantes un uso normal
     * consumiendo el triple de la energía establecida
     * para las botas y el doble para los guantes.
     * @return
     */
    @Override
    public void volar(double tiempo) throws ArmaduraExcepcion {
        verificaciones();

        double consumo = this.consumoBotas.apply(armadura) * 3 +
                                this.consumoGuantes.apply(armadura) * 2;
        consumirEnergia.accept(this.armadura, consumo * tiempo);
    }

    /**
     * Al utilizar los guantes como armas el consumo se triplica durante el tiempo del
     * disparo.
     * @return
     */
    @Override
    public void disparar(double tiempo) {

        double consumo = this.consumoGuantes.apply(this.armadura) * 3;

        this.consumirEnergia.accept(this.armadura, consumo);
    }

    /**
     * Cada vez que se escribe en la consola o se habla a través del sintetizador se consume
     * lo establecido en estos dispositivos. Solo se usa en nivel básico
     */
    @Override
    public void escribir() {
        int accion = 1;

        do {
            System.out.println("-----------Menu----------");
            Arrays.stream(CONST_ACCIONES).forEach(System.out::println);

            try {

                System.out.print("\nAccion: ");
                accion = Integer.parseInt(read.nextLine());

                this.leer(accion);
            } catch (ArmaduraExcepcion ex){
                System.out.printf("Sr.Stark Se informa: " + ex.getMessage());
            }
            catch (Exception ex) {
                System.out.println("Sr.Stark Tenemos grandes problemas no controlados: " + ex.getMessage());
            }
        } while (accion != 0);

    }

    /**
     * Cada vez que se efectúa una acción se llama a los métodos usar del dispositivo se le
     * pasa el nivel de intensidad y el tiempo. El dispositivo debe retornar la energía
     * consumida y la armadura deberá informar al generador se ha consumido esa
     * cantidad de energía.
     * @param accion
     * @return
     */
    @Override
    public void leer(int accion) throws ArmaduraExcepcion {
        double tiempo = 0;
        if (1 <= accion && accion <= 5) {

            System.out.print("\nTiempo: ");

            tiempo = Double.parseDouble(read.nextLine());
            System.out.println("Sr.Stark, se va a ejecutar la accion " + CONST_ACCIONES[accion] + " por " + tiempo + " seg/s");

        }

        switch (accion) {

            case 0: {
                System.out.println("Hasta luego SR. Stark....");
                break;
            }
            case 1: {
                this.caminar(tiempo);
                break;
            }
            case 2: {
                this.correr(tiempo);
                break;
            }
            case 3: {
                this.propulsar(tiempo);
                break;
            }
            case 4: {
                this.volar(tiempo);
                break;
            }
            case 5: {
                this.disparar(tiempo);
                break;
            }
            case 6: {
                IEstadoArmadura.estadoDispositivo(this.armadura);
                break;
            }
            case 7: {
                IEstadoArmadura.estadoBateria(this.armadura);
                break;
            }
            case 8: {
                IEstadoArmadura.informacionReactor(this.armadura);
                break;
            }
            default: {
                System.out.println("Esa opcion no esta registrado Sr Stack");
                break;
            }
        }
    }

    public void verificaciones() throws ArmaduraExcepcion {
        if (this.armadura.getBateria() <= 0) {
            throw new ArmaduraExcepcion("Sr.Stark, nos quedamos sin energia");
        }
    }

}
