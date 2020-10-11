#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

int isNumeric(int str);

int main(void)
{
	char a[30],string[30];
	int i;
	i=0;
	do
	{
		a[i]=getch();
		printf("\nYour character is %c - %d\n",a[i],a[i]);
		if(isNumeric(a[i]) == 0) printf("Is Not Numeric.\n",a[i],a[i]);
		if(a[i] == 13)  printf("Enter is pressed.\n");
		if(i == 0) sprintf(string, "%d",a[i]-48);
		else  sprintf(string, "%s%d",string,a[i]-48);
		printf(string);
		printf("\n The number is: %d",atoi(string));
		i++;
	} while(a[i] != 'l');
	return 1;
}

int isNumeric(int str) 
{
    if(str < 48 || str > 57)
            return 0;
    return 1;
}