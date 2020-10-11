#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

int isNumeric(int str);

int main(void)
{
	char a[3],b[3],f[5],g[5];
	int c,d,i,PressedEnter,PressedEnter2;
	printf("\n\t\t***\tProgram to get table.\t***");
	PressedEnter=PressedEnter2=i=0;
	printf("\nPlease enter a number (Limit: 0-9);\t");
	do
	{
		a[i]=getch();
		if(isNumeric(a[i]) == 1)
		{
			printf("%c",a[i]);
			if(i == 0) sprintf(f, "%d",a[i]-48);
			else  sprintf(f, "%s%d",f,a[i]-48);
			i++;
		}
		else if(a[i] == 13 && i != 0)
		{
			a[i] = '\0';
			PressedEnter=i;
			break;
		}
	} while (isNumeric(a[i]) == 0 && PressedEnter == 0 && i != 3);
	
	printf("\nPlease enter a limit number (Limit: 0-9);\t");
	i=0;
	do
	{
		b[i]=getch();
		if(isNumeric(b[i]) == 1)
		{
			printf("%c",b[i]);
			if(i == 0) sprintf(g, "%d",b[i]-48);
			else  sprintf(g, "%s%d",g,b[i]-48);
			i++;
		}
		if(b[i] == 13 && i != 0)
		{
			b[i] = '\0';
			PressedEnter2=i;
			break;
		}
	} while (isNumeric(b[i]) == 0 && PressedEnter2 == 0 && i != 3);
	i=0;
	c=atoi(f);
	d=atoi(g);
	printf("\n**\tTable of %d\t**\n",c);
	for(i=0; i<=d; i++) printf("%dx%02d=%02d\n",c,i,c*i);
	a[i]=getc(stdin);
	return 1;
}

int isNumeric(int str) 
{
    if(str < 48 || str > 57)
            return 0;
    return 1;
}