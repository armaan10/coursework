#include<iostream>
#include<fstream>
using namespace std;
int main()
{

  
    string line,a,n;
    ofstream alpha;
    ofstream num;
    alpha.open("alpha.txt",ios_base::app);
    num.open("num.txt",ios_base::app);
    ifstream fin;
    fin.open("reader.txt");
    while(fin)
    {

        getline(fin,line);
        for (int i = 0; i < line.length(); i++)
        {
            /* code */
            if (line[i]>='0' && line[i]<='9')
            {
                num<<line[i];
            }
            else
            {
                alpha<<line[i];
            }
            
        }
        

    }
    alpha.close();
    num.close();
    fin.close();
    


}