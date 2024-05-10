package mangosNaranjas;

import java.util.Scanner;

public class MangosNaranjas {
    private int mangos;
    private int naranjas;

    public MangosNaranjas (int mangos, int naranjas) {
        this.mangos = mangos;
        this.naranjas = naranjas;
    }

    // Método para calcular el máximo común divisor 
    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void imprimir() {
        int mcd = calcularMCD(mangos, naranjas);
        int cajas = mcd;
        int mangosPorCaja = mangos / mcd;
        int naranjasPorCaja = naranjas / mcd;

        System.out.println("El número de cajas es: " + cajas);
        System.out.println("El número de mangos en una caja es: " + mangosPorCaja);
        System.out.println("El número de naranjas en una caja es: " + naranjasPorCaja);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el número de mangos y el número de naranjas separados por un espacio: ");
        int mangos = scanner.nextInt();
        int naranjas = scanner.nextInt();

        MangosNaranjas mn = new MangosNaranjas(mangos, naranjas);
        mn.imprimir();

        scanner.close();
    }
}