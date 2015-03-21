#include <stdio.h>
#include <stdlib.h>
//const int x = 5;
#define A 10

// int main(int argc, char const *argv[])
// {
// 	//int a=5; float b=5/2; Is b=2 or 2.5? Why?
// 	int a = 5;
// 	//A =6;
// 	float b = 5/2;
// 	printf("%d\n", A);
// 	return 0;
// }
int sum(int a, int b){
    int *sum = (int*)malloc(16);
    sum = a + b;
    return sum;

}

int main(){
    int a;
    a = sum(1,2);
}


