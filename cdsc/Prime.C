#include <stdio.h>
#include <math.h>
int prime(int num){
    if (num == 0 || num == 1)
        return -1;
    for (int i = 2; i<=sqrt(num); i++) {
        if (num%i==0) {
            return -1;
        }
    return 1;
    }
 return 0;
}

int main(int argc, const char *argv[]){
    int number = 17;
    int result = prime(number);
    if(result==1){
        printf("The number is prime\n");
    }
    else {
        printf("Number is not prime\n");
    }
    return 0;
}
