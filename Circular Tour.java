//Day 42 of #CrackYourInternship

class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	// Your code here	
	    int deficit = 0;
	    int balance = 0;
	    int start = 0;
	    int n = distance.length;
	    for(int i = 0;i < n;i++){
	        balance += petrol[i] - distance[i];
	        if(balance < 0){
	            deficit += balance;
	            start = i + 1;
	            balance = 0;
	        }
	    }
	    if(deficit + balance >= 0){
	        return start;
	    }
	    return -1;
    }
}
