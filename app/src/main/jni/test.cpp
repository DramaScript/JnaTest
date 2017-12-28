#include "test.h"

/**
 *  int 类型
 * @param a
 * @param b
 * @return
 */
int test(int a,int b){
    return a+b;
}

/**
 * int * 类型
 * @param a
 */
void getInt(int *a){
    *a = 1024;
}

/**
 *char * 类型
 * @param name
 * @param s
 */
void getChar(char *name, char *s){
    if(name==NULL||s==NULL){
        return;
    }
    int result=strcmp(name, "我很帅");
    char  dabaozi[40] ="DramaScipt最帅！";
    char other [40] = "天王盖地虎，小鸡炖萝卜";
    if (result == 0) {
        memcpy(s, dabaozi, strlen(dabaozi));
    }else {
        memcpy(s, other, strlen(other));
    }
}

/**
 * 结构体
 * @param user
 */
void getStruct(struct User* user){
    user->age=18;
    char name[20] ="DramaScript";
    memcpy(user->name, name, strlen(name));
}

void getArray(char *ch){
    char arr[10] = "abcd";
    for (int i = 0; i < 4; ++i) {
        ch[i] = arr[i];
    }
}