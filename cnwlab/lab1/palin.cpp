#include<iostream>
#include<string.h>
using namespace std;
int palin(char cheese[100])
{
int i=0;
     int len=strlen(cheese);
    for(int i=0;i<len;i++)
    {
        if (cheese[i]!=cheese[len-i-1])
        {
            return 0;
        }
    }
    return 1;
}

main()
{

    char straw[100]="sauce";
    cout<<palin(straw);

}