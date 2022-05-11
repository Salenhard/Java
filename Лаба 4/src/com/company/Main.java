// Райков ИВТ-20
// Вариянт 8
// Дифференцирование

package com.company;

public class Main {

    public static double f(double x) {              // заданная функция (для первой части)
        return Math.cos(2*x);
    }


    public static double f1(double x, double h) {   // по 1 формуле
        return (f(x + h) - f(x - h)) / (2 * h);
    }


    public static double f2(double x, double h) {
        return (f(x - 2*h) - 8 * f(x - h) + 8 * f(x + h) - f(x + 2*h)) / (12 * h);
    }


    public static void first() {
        double m1 = 8;
        double m2 = 32;

        double x0 = Math.PI / 4;

        double e = 0.001;

        double h = Math.sqrt(e * 6 / m1);
        h = Math.floor(h * 100) / 100;
        System.out.println("h = " + h);

        double y = 0;

        y = f1(x0, h);
        System.out.println("По первой формуле: " + y);

        h = Math.sqrt(Math.sqrt(e * 30 / m2));
        h = Math.floor(h * 100) / 100;
        System.out.println("h = " + h);

        y = f2(x0, h);
        System.out.println("По второй формуле: " + y + "\n");
    }


    public static void show(double[] x, double[][] y, int n, int m) {
                                                    // вывод в консоль
        for (int i = 0; i < n; i++) {
            System.out.printf(String.format("X[%d] = %+.4f\n",i, x[i]));
        }

        System.out.println("\nY = ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf(String.format("%+.4f\t\t", y[i][j]));
            }
            System.out.println();
        }

    }


    public static void zap(double[] x, double[][] y, int n, int m, double h) {


        for (int i = 1; i < n; i++) {
            x[i] = Math.round(x[0] + i * h * 1000);
            x[i] /= 1000;
        }

        for (int j = 1; j < m; j++) {
            for (int  i= 0; i < n-j; i++) {
                y[i][j] = y[i+1][j-1] - y[i][j-1];
            }
        }

    }


    public static void dif(double[] x, double[][] y, int n, int m, double h) {

        /**-------то, что в комментариях - то из примера-------*/

        // int i = 1;
        int i = 0;
        int z = -1;
        double p = 0;
        double d = 0;
        double s = 0;

        for (int j = 1; j < 4; j++) {
            z *= -1;
            s += (y[i][j] / j ) * z;
            d = 1 / h * s;

            System.out.printf(String.format("\nM[%d] = %+.4f\n", j, d));

            p = 1 / h * (Math.abs(y[i][j+1]) / (j + 1));

            System.out.printf(String.format("Погрешность не более %+.4f\n", p));

        }

    }


    public static void second() {




        int n = 7;
        int m = 5;

        double h = 0.5;

        double[] x = new double[n];

        x[0] = -1;

        double[][] y = new double[n][m];

        y[0][0] = -7.05552;
        y[1][0] = -6.96658;
        y[2][0] = -6.89279;
        y[3][0] = -6.82974;
        y[4][0] = -6.77469;
        y[5][0] = -6.72584;
        y[6][0] = -6.68194;

        zap(x, y, n, m, h);
        show(x, y, n, m);

        dif(x, y, n, m, h);

    }


    public static void main(String[] args) {
        first();

        second();

    }


}
