#include<iostream>
using namespace std;
int binsearch(int a[],int l,int r,int k)
{
	if(l<=r)
	{
		int mid=(l+r)/2;
		if(a[mid]==k) return mid;
		
		else if(a[mid]<k) return binsearch(a,mid+1,r,k);
		
		else
			return binsearch(a,l,mid-1,k); 

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
pos=binsearch(arr,0,n,k);
if(pos==-1) cout<<"not found";
else cout<<"element at:"<<pos;


}
