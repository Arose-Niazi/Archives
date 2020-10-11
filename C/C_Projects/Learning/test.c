#include <stdio.h>

void StartScript();
void Testing(const char * params);
void main(void)
{
	StartScript();
	return 0;
}

void StartScript()
{
	char params[250];
	printf("Enter Anything\n");
	if(scanf("%249s",&params)) Testing(params);
	else Testing(" ");
}

void Testing(const char * params)
{
	printf("\n The Result is %s.\n",params);
	StartScript();
}