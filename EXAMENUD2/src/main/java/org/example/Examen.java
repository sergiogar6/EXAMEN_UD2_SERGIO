package org.example;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Examen {
    Random random = new Random();
    Scanner entry = new Scanner(System.in);
    public void ejercicio1() {
        //Defino los caracteres que puede seleccionar el ordenador
        //Y los marcadores del usuario y el ordenador
        String caracteres = "pat";
        int score = 0;
        int score_ia = 0;
        //Un bucle for que recorra hasta el numero de rondas posibles (al mejor de 3).
        for (int i = 1; i <= 3; i++) {
            boolean error = false;
            System.out.println("Ronda " + i);
            System.out.println("Piedra papel o tijera?(p/a/t)");
            String eleccion = entry.nextLine();

            //El numero del ordenador es una eleccion del 0 al 2 (3 numeros) que selecciona con charAt a la variable caracteres convertida en una String.
            int indice = random.nextInt(3);
            String eleccion_ia = String.valueOf(caracteres.charAt(indice));
            //Un switch donde con cada opcion del usuario, compara la eleccion de la maquina y dice si ha ganado, perdido o empatado
            //En caso de no ser valida la opción, salta un mensaje de error y se reinicia la ronda en la que estaban
            //En cada caso se muestra la eleccion del ordenador y el resultado que actualiza el marcador
            //En caso de ser empate el numero de ronda se reinicia
            switch (eleccion) {
                case "a":
                    if (eleccion_ia.equals("p")) {
                        System.out.println("El ordenador a elegido: Piedra");
                        System.out.println("Has ganado!");
                        score += 1;
                    } else if (eleccion_ia.equals("t")) {
                        System.out.println("El ordenador a elegido: Tijera");
                        System.out.println("Has perdido!");
                        score_ia += 1;
                    } else {
                        System.out.println("El ordenador a elegido: Papel");
                        System.out.println("Empate!");
                        i-=1;
                    }
                    break;
                case "p":
                    if (eleccion_ia.equals("t")) {
                        System.out.println("El ordenador a elegido: Tijera");
                        System.out.println("Has ganado!");
                        score += 1;

                    } else if (eleccion_ia.equals("a")) {
                        System.out.println("El ordenador a elegido: Papel");
                        System.out.println("Has perdido!");
                        score_ia += 1;
                    } else {
                        System.out.println("El ordenador a elegido: Piedra");
                        System.out.println("Empate!");
                        i-=1;
                    }
                    break;
                case "t":
                    if (eleccion_ia.equals("a")) {
                        System.out.println("El ordenador a elegido: Papel");
                        System.out.println("Has ganado!");
                        score += 1;

                    } else if (eleccion_ia.equals("p")) {
                        System.out.println("El ordenador a elegido: Piedra");
                        System.out.println("Has perdido!");
                        score_ia += 1;
                    } else {
                        System.out.println("El ordenador a elegido: Tijera");
                        System.out.println("Empate!");
                        i-=1;
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    i -= 1;
                    error = true;
                    break;
            }
            //En caso de que no sea una opcion valida, no se muestre el resultado.
            if (!error) {
                System.out.println("MARCADOR: " + score + "-" + score_ia);
            }
            //Cuando el resultado de los scores sume 3 acabe el bucle
            System.out.println(" ");
            if (score_ia+score == 3) {
                break;
            }

        }
        //La ultima comprobacion para ver quien ha ganado
        if (score > score_ia) {
            System.out.println("GANA EL USUARIO!");
        } else {
            System.out.println("GANA EL ORDENADOR");
        }
    }
    public void ejercicio2() {
        // Variables para indicar el año actual
        LocalDateTime time = LocalDateTime.now();
        int current_year = time.getYear();
        boolean error = true;

        int birth_year = 0;
        //Guardo variable del año de nacimiento y creo una variable de edad
        //Dentro de un while con un try catch por si se escribe un formato no valido vuelva a pedir el año
        while (error) {
            try {
                System.out.println("Introduce tu año de nacimiento:");
                birth_year = entry.nextInt();
                error = false;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Formato incorrecto");
                error = true;
                entry.nextLine();
            }

        }

        int age = current_year - birth_year;
        //Hago un for que recorra todos sus años cumplidos del 0 al 14
        for (int i = 0; i <= age; i++) {
            //En caso de haber nacido antes de 1900 o despues del año actual da error
            if (birth_year < 1900 || birth_year > current_year) {
                System.out.println("Año de nacimiento no valido");
                break;
            } else {
                //Muesta por pantalla el año de nacimiento y (i) que recorre su edad hasta la actual
                System.out.println(birth_year + " - edad: " + (i));
                //Sumo a su año de nacimiento para que coincida el año con la edad que tenia en ese año
                birth_year++;
            }
        }
    }
}
