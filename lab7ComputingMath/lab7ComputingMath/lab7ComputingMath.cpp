#include <iostream>
#include "matr.h"
#include "inv.h"
int main()
{
	double** a = new double* [5];
	for (int i = 0; i < 5; i++)
		a[i] = new double[5];
	double** e = matr::E(5);
	a[0][0] = 4;
	a[0][1] = -2;
	a[0][2] = 3;
	a[0][3] = 1;
	a[0][4] = -4;
	a[1][0] = 2;
	a[1][1] = 1;
	a[1][2] = -5;
	a[1][3] = -5;
	a[1][4] = -2;
	a[2][0] = 1;
	a[2][1] = 5;
	a[2][2] = -1;
	a[2][3] = 5;
	a[2][4] = 1;
	a[3][0] = -2;
	a[3][1] = 1; 
	a[3][2] = 0;
	a[3][3] =1;
	a[3][4] = -1;
	a[4][0] = -4;
	a[4][1] = 5;
	a[4][2] = -2;
	a[4][3] = 3;
	a[4][4] = -5;


	matr::show(matr::forbenius(a));







	for (int i = 0; i < 5; i++)
		delete[] a[i];
	delete[] a;

	for (int i = 0; i < 5; i++)
		delete[] e[i];
	delete[] e;
}

