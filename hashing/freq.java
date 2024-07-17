import java.util.HashMap;
import java.util.Scanner;

class HelloWorld {
    static void frequency(int arr[]){
        
        HashMap<Integer, Integer> m = new HashMap<>();
        
        for(int i: arr){
            if(m.containsKey(i)) m.replace(i,m.get(i)+1);
            else m.put(i,1);
        }
        
        System.out.println(m);
        
        int highest=arr[0];
        int lowest=arr[0];
        
        
        for(int keys: m.keySet()){
            if(m.get(keys)>m.get(highest)){
                highest = keys;
            }
            if(m.get(keys)<m.get(lowest)){
                lowest = keys;
            }
        }
        
        System.out.println(highest + " is the highest occuring with frequency "+m.get(highest));
        System.out.println(lowest + " is the lowest occuring with frequency "+m.get(lowest));
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        frequency(arr);
    }
}