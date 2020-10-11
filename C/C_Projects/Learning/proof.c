#include <stdio.h>

int main()
{
	printf("Please enter 3 numbers.");
	int a,b,c;
	scanf("%d%d%d",&a,&b,&c);
	int avg,product;
	avg=(a+b+c)/3;
	product=a*b*c;
	printf("Avg is %d and Product is %d",avg,product);
	getchar(); getchar(); getchar(); getchar(); //Added so the output cold be seen.
}