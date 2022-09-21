import java.util.*;
public class FractionalKnapsack {

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Size :");
        int size = scan.nextInt();
        System.out.println("");
        int [] profit = new int[size];
        int [] weight = new int[size];
        float [] ratio = new float [size];
        String [] name = new String[size];
        int sort [] = new int [size];

        for(int i =0 ; i<size;i++){
            System.out.print("Enter the profit of Item "+(i+1)+" : ");
            profit[i] = scan.nextInt();
            System.out.println("");
            System.out.print("Enter the weight of Item "+(i+1)+" : ");
            weight[i] = scan.nextInt();
            System.out.println("");
            name[i] = "Item "+(i+1);
            ratio[i] = (float)profit[i]/weight[i];
        }

        System.out.print("Enter KnapSack Capacity :");
        int a = scan.nextInt();

        System.out.println("Item\t\tProfit\t\tWeight \n-------------------------------");
        for(int i =0;i<size;i++){

            System.out.println(name[i]+"\t\t"+profit[i]+"\t\t\t"+weight[i]);
        }

        System.out.println("");
        for(int i =0;i< size;i++){
            for (int j = i+1; j < size; j++) {
                if(ratio[i]<ratio[j]){
                    float temp = ratio[i];
                    ratio[i]=ratio[j];
                    ratio[j]=temp;

                    int temp2 = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp2;

                    int temp3 = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp3;

                    String temp4 = name[i];
                    name[i] = name[j];
                    name[j] = temp4;
                }
            }
        }
        GFK( profit,weight,name,size,a);
    }

    public static void GFK(int [] p , int [] w,String [] name,int size, int m){
        float [] x =new float[size];
        float weight=0;
        float maxProfit = 0;
        for(int i=0;i<size;i++){
            if(weight+w[i]<=m){
                x[i]= 1;
                weight=weight+w[i];
            }else{
                x[i] = (m-weight)/w[i];
                weight = weight+x[i];
                maxProfit = maxProfit+(p[i]*x[i]);
                break;
            }
            maxProfit = maxProfit+(p[i]*x[i]);

        }
        System.out.println("Item Used :");
        for(int i =0;i<size;i++){
            System.out.println(name[i]+" : "+x[i]);
        }
        System.out.println("");
        System.out.println("Max Profit = "+maxProfit);
    }
}
