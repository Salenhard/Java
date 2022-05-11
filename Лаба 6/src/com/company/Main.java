// Райков ИВТ-20
// Вариант 11

package com.company;

public class Main {

    public static double f(double x, double y) {
        return (2 * x*x - 5) * Math.sin(y);
    }


    public static void out(double[] x, int n) {
        for(int i = 0; i < n; i++) {
            System.out.println("[" + i + "]= " + x[i]);
        }
    }


    public static void clean(double[] x, int n) {
        for(int i = 1; i < n; i++) {
            x[i] = 0;
        }
    }


    public static void main(String[] args) {

        double h = 0.1;
        int k = 6;

        double[] y = new double[k];
        y[0] = 1;
        double[] x = new double[k];
        x[0] = 1;

        // заполнение X
        for(int i = 1; i < k; i++) {
            x[i] = x[0] + i * h;
        }

        // вывод X
        System.out.println("X");
        out(x, k);

        /**----------вычисление Y методом Эйлера----------*/
        for(int i = 1; i < k; i++) {
            y[i] = y[i-1] + h * f(x[i-1], y[i-1]);
        }

        System.out.println("\tМетод Эйлера");
        System.out.println("Y");
        out(y, k);

        clean(y, k);

        /**----------вычисление Y мод. методом Эйлера----------*/
        for(int i = 1; i < k; i++) {
            y[i] = y[i-1] + h * f(x[i-1] + h/2, y[i-1] + h/2 * f(x[i-1], y[i-1]));
        }

        System.out.println("\tМод. метод Эйлера");
        System.out.println("Y");
        out(y, k);

        clean(y, k);

        double[][] z = new double[3][4];

        /**----------метод Рунге-Кутта (Y[0]-Y[3])----------*/
        for(int i = 0; i < 3; i++) {
            z[i][0] = h * f(x[i], y[i]);
            z[i][1] = h * f(x[i] + h/2, y[i] + z[i][0]/2);
            z[i][2] = h * f(x[i] + h/2, y[i] + z[i][1]/2);
            z[i][3] = h * f(x[i] + h, y[i] + z[i][2]);

            y[i+1] = y[i] + (z[i][0] + 2*z[i][1] + 2*z[i][2] + z[i][3]) / 6;
        }

        double[] t = new double[k-1];

        /**----------метод Адамса----------*/
        for(int i = 3; i < k-1; i++) {
            t[i] = 55*f(x[i], y[i]) - 59*f(x[i-1], y[i-1]) + 37*f(x[i-2], y[i-2]) - 9*f(x[i-3], y[i-3]);
            y[i+1] = y[i] + h/24 * t[i];
        }

        System.out.println("\tМетод Адамса");
        System.out.println("Y");
        out(y, k);

    }


}
