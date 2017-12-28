#include<string.h>
#include <math.h>

#ifndef JNATEST_TEST_H
#define JNATEST_TEST_H


#ifdef __cplusplus
extern "C" {
#endif

struct  User
{
    int age;
    char name[11];
    char type[20];

}User;

int test(int a,int b);

void getInt(int *a);

void getChar(char *name, char *s);

void getStruct(struct User* user);

void getArray(char ch[]);

#ifdef __cplusplus
}
#endif
#endif


