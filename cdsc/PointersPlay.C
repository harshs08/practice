#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void swap(int*, int*);

int main(int argc, const char *argv[]){
	int *p;
	int a = 5;
	//*p = 5;
	p = &a;

	printf("%d\n", *p);
	printf("%p\n", p);
	printf("%p\n", &a);

	*p = 10;
	printf("%d\n", *p);
	printf("%p\n", p);
	printf("%p\n", &a);

	printf("%p\n", p+1);
	printf("%d\n", *(p+1));

	int x = 11;
	int y = 33;
	printf("Values of x: %d and y: %d\n", x, y);
	swap(&x,&y);
	printf("After swap Values of x: %d and y: %d\n", x, y);
	// char* c_ptr;
	// c_ptr=(char*)malloc(sizeof(char));
	// *c_ptr='A';
	// printf("c_ptr: %p\t*c_ptr: %c\t and also address c_ptr: %d\n",c_ptr,*c_ptr,c_ptr);

	// char str[] = "hello";
	// char* s_ptr = str;
	// //c_ptr=(char*)malloc(sizeof(str));
	// //*c_ptr="Hello";
	// printf("c_ptr: %p\t*c_ptr: %s\t and also address c_ptr: %d\n",s_ptr,*s_ptr,s_ptr);

	// char* c_ptr;
	// c_ptr=(char*)calloc(4,sizeof(char));
	// *c_ptr="Hii";
	// printf("c_ptr: %p\t*c_ptr: %c\t and also address c_ptr: %d\n",c_ptr,*c_ptr,c_ptr);
}

void swap(int* x, int* y){
	int temp;
	temp = *x;
	*x = *y;
	*y = temp;
}
