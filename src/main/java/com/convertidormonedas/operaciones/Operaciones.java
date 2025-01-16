package com.convertidormonedas.operaciones;

import com.convertidormonedas.modelo.TipoCambio;

import java.util.Locale;
import java.util.Scanner;

public class Operaciones {
    public static void convertCurrency(TipoCambio rates) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        boolean continuar = true;
        while (continuar) {
            System.out.println("Seleccione una opción:");
            System.out.println("1) Dólar -> Peso argentino");
            System.out.println("2) Peso argentino -> Dólar");
            System.out.println("3) Dólar -> Real Brasileño");
            System.out.println("4) Real brasileño -> Dólar");
            System.out.println("5) Dólar -> Peso Colombiano");
            System.out.println("6) Peso colombiano -> Dólar");
            System.out.println("7) Dólar -> Sol Peruano");
            System.out.println("8) Sol Peruano -> Dólar");
            System.out.println("9) Salir");
            System.out.println("---------------------------------");

            try {
                int option = scanner.nextInt(); // Leer la opción seleccionada.
                double amount;

                switch (option) {
                    case 1:
                        System.out.print("Ingrese la cantidad en USD: ");
                        amount = scanner.nextDouble();
                        System.out.println("Pesos argentinos: " + redondear(amount * rates.getConversionRates().get("ARS")));
                        break;
                    case 2:
                        System.out.print("Ingrese la cantidad en ARS: ");
                        amount = scanner.nextDouble();
                        System.out.println("USD: " + redondear(amount / rates.getConversionRates().get("ARS")));
                        break;
                    case 3:
                        System.out.print("Ingrese la cantidad en USD: ");
                        amount = scanner.nextDouble();
                        System.out.println("Reales: " + redondear(amount * rates.getConversionRates().get("BRL")));
                        break;
                    case 4:
                        System.out.print("Ingrese la cantidad en BRL: ");
                        amount = scanner.nextDouble();
                        System.out.println("USD: " + redondear(amount / rates.getConversionRates().get("BRL")));
                        break;
                    case 5:
                        System.out.print("Ingrese la cantidad en USD: ");
                        amount = scanner.nextDouble();
                        System.out.println("Pesos colombianos: " + redondear(amount * rates.getConversionRates().get("COP")));
                        break;
                    case 6:
                        System.out.print("Ingrese la cantidad en COP: ");
                        amount = scanner.nextDouble();
                        System.out.println("USD: " + redondear(amount / rates.getConversionRates().get("COP")));
                        break;
                    case 7:
                        System.out.print("Ingrese la cantidad en USD: ");
                        amount = scanner.nextDouble();
                        System.out.println("Soles peruanos: " + redondear(amount * rates.getConversionRates().get("PEN")));
                        break;
                    case 8:
                        System.out.print("Ingrese la cantidad en PEN: ");
                        amount = scanner.nextDouble();
                        System.out.println("USD: " + redondear(amount / rates.getConversionRates().get("PEN")));
                        break;
                    case 9:
                        System.out.println("¡Gracias por usar el conversor!");
                        continuar = false; // Cambia la variable para salir del bucle
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, ingrese números en el formato correcto (ejemplo: 79.47).");
                scanner.nextLine();
            }
            System.out.println("--------------------------------------");
        }
    }

    public static String redondear(double valor) {
        return String.format("%.2f", valor);
    }
}
