#pragma once
#include <iostream>
#include "inv.h"
namespace matr {

	void show(double** a) {
		for (int i = 0; i < 5; i++)
		{
			for (int k = 0; k < 5; k++)
			{
				std::cout << a[i][k] << " ";
			}
			std::cout << std::endl;
		}
	}

	double** E(int n) {
		double** e = new double*[n];
		for (int i = 0; i < n; i++)
			e[i] = new double[n];

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				e[i][k] = 1;
			}
		}
		return e;
	}

	double** mMull(double** a, double** b) {
		double** c = new double* [5];
		for (int i = 0; i < 5; i++)
		{
			c[i] = new double[5];
			for (int j = 0; j < 5; j++)
			{
				c[i][j] = 0;
				for (int k = 0; k < 5; k++)
					c[i][j] += a[i][k] * b[k][j];
			}
		}
		return c;
	}

	double** forbenius(double** a) {
		int n = 5;
		double** e;
		for (int i = 0; i < n - 1; i++) {
			e = E(n);
			for (int j = 0; j < n; j++)
			{
				if (j == 4 - i)
					e[4 - i][j] = 1 / a[4 - (i - 1)][4 - i];
				else
					e[4 - i][j] = -a[4 - (i - 1)][j] / a[4 - (i - 1)][4 - i];
			}
			a = mMull(mMull(minV(e), a), e);
		}
		return a;
	}

}