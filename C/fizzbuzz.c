

#include<stdio.h>
#include<string.h>
#include<stdlib.h>


char * fizzbuzz(int n);
void testfizzbuzzhelper(int num, char * expected);


char * fizzbuzz(int n) {
    if (n % 15 == 0) {
        return "fizzbuzz";
    } else if (n % 3 == 0) {
        return "fizz";
    } else if (n % 5 == 0) {
        return "buzz";
    } else {
        char * result = (char *) malloc(10);
        if (result == NULL) {
            printf("Failed to malloc");
            exit(1);
        }
        sprintf(result, "%d", n);
        return result;
    }
}

void testfizzbuzzWith1Returns1(void) {
    testfizzbuzzhelper(1, "1");
}

void testfizzbuzzWith2Returns2(void) {
    testfizzbuzzhelper(2, "2");
}

void testfizzbuzzWith3ReturnsFizz(void) {
    testfizzbuzzhelper(3, "fizz");
}

void testfizzbuzzWith5ReturnsBuzz(void) {
    testfizzbuzzhelper(5, "buzz");
}

void testfizzbuzzWith9ReturnsFizz(void) {
    testfizzbuzzhelper(9, "fizz");
}

void testfizzbuzzWith10ReturnsBuzz(void) {
    testfizzbuzzhelper(10, "buzz");
}

void testfizzbuzzWith15ReturnsFizzbuzz(void) {
    testfizzbuzzhelper(15, "fizzbuzz");
}

void testfizzbuzzWith15x4ReturnsFizzbuzz(void) {
    testfizzbuzzhelper(15 * 4, "fizzbuzz");
}

void testfizzbuzzhelper(int num, char * expected) {
    if (strncmp(fizzbuzz(num), expected, strlen(expected)) != 0) {
        printf("fizzbuzz did not return %s\n", expected);
    }
}

int main(void) {
    testfizzbuzzWith1Returns1();
    testfizzbuzzWith2Returns2();
    testfizzbuzzWith3ReturnsFizz();
    testfizzbuzzWith5ReturnsBuzz();
    testfizzbuzzWith10ReturnsBuzz();
    testfizzbuzzWith15ReturnsFizzbuzz();
    testfizzbuzzWith15x4ReturnsFizzbuzz();
    return 0;
}
