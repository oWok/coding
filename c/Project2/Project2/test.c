#include<stdio.h>

main() {
	int* a;
	int b;

	b = 100;

	a = &b;


	printf("%d\n", *a);

	printf("%d", &b);

	return 0;

}