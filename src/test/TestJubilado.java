package test;

import dominio.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestJubilado {

    static Scanner entada = new Scanner(System.in);

    static ArrayList<Jubilado> jubilados = new ArrayList<>();

    public static void main(String[] args) {
        int op = 0;
        String cedula, nombre;
        int anios;

        do {
            op = menu(op);
            if (op != 5 && op != 4) {
                entada.nextLine();
                System.out.print("Cedula: ");
                cedula = entada.nextLine();
                System.out.print("Nombre: ");
                nombre = entada.nextLine();
                System.out.print("Anios Aporte :");
                anios = entada.nextInt();
                datos(op, cedula, nombre, anios);
            }
            if (op == 4) {
                
                for (Jubilado jub : jubilados) {
                    jub.calculaPensioni();
                    jub.calcularPension();
                    if (jub instanceof JubiladoPatronal) {
                        ((JubiladoPatronal) jub).bonoSueldo();
                        System.out.println(jub);
                    }
                }
                for (Jubilado jub : jubilados) {
                    jub.calculaPensioni();
                    jub.calcularPension();
                    if (jub instanceof JubiladoVejez) {
                        System.out.println(jub);
                    }
                }
                for (Jubilado jub : jubilados) {
                    jub.calculaPensioni();
                    jub.calcularPension();
                    if (jub instanceof JubiladoDiscapacidad) {
                        System.out.println(jub);
                    }
                }
            }
        } while (op != 5);

    }

    public static int menu(int op) {
        System.out.println("\tMENU JUBILADO");
        System.out.println("1.Vejez");
        System.out.println("2.Invalidez");
        System.out.println("3.Patronal");
        System.out.println("4.Reporte");
        System.out.println("5.Salir");
        System.out.print("Ingrese una opcion : ");
        op = entada.nextInt();

        return op;
    }

    public static void datos(int op, String nombre, String cedula, int anios) {
        double porcentaje;
        int tipoE = 0;
        switch (op) {
            case 1:
                jubilados.add(new JubiladoVejez(cedula, nombre, anios));
                break;
            case 2:
                System.out.print("Porcentaje de discapacidad: ");
                porcentaje = entada.nextDouble();
                jubilados.add(new JubiladoDiscapacidad(porcentaje, cedula, nombre, anios));
                break;
            case 3:
                System.out.print("Podentaje de Inflacion :");
                porcentaje = entada.nextDouble();
                System.out.print("Tipo empresa Publica <<1>> Pirvada <<2>>: ");
                tipoE = entada.nextInt();
                jubilados.add(new JubiladoPatronal(porcentaje, tipoE, cedula, nombre, anios));
                break;
        }
    }
}