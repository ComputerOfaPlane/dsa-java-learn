class Solution
{
    
    int count=0;

    public void printNos(int N) // recursive function
    {
        if(count==N) return; // base condition

        System.out.print(++count+" ");
        printNos(N); // calling itself
        
    }
}
