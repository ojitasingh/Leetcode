class Solution 
{
    public int fib(int n) 
    {
        if(n==0)
        return 0;
        else if(n==1)
        return 1;
        else
        {
            int n0=0,n1=1;
            while(n-2>=0)
            {
                int temp=n0+n1;
                n0=n1;
                n1=temp;
                n--;
            }
            return n1;
        }
    }
}