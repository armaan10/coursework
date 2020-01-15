#include<iostream>
using namespace std;
int linsearch(int a[],int n,int k)
{
	for ( int i=0;i<n;i++)
		{

			if (a[i]==k)
				return i;

		}

return -1;
}
int main()
{
int n;
cout<<"enter number of elements\n";
cin>>n;
int arr[n];
cout<<"Enter elements\n";
for(int i=0;i<n;i++)
{
	cin>>arr[i];

}
int k,pos;
cout<<"Enter element to be searched for\n";
cin>>k;
pos=linsearch(arr,n,k);
if(pos==-1) cout<<"not found";
else cout<<"element at:"<<pos;


}
