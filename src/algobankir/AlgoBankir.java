/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algobankir;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author таня
 */
public class AlgoBankir {  


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 Relise jk = new Relise();
    }

}
class Relise{
    Scanner in = new Scanner(System.in);
       PrintWriter out = new PrintWriter(System.out);
       int n= in.nextInt();// количество процессов
       int m = in.nextInt();// количество ресурсов
       int Available[]= new int [m];// количество ресурсов доступных на данный момент
       int Max[][]= new int [n][m];// матрица ресурсов для каждого процесса
       int Allocation[][]= new int [n][m];// сколько ресурсов выделено процессу на данный момент
       int Need[][]= new int [n][m];//сколько еще нужно процессу

    public Relise() {
        for(int i=0;i<m;i++){
            Available[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
        Max[i][j]=in.nextInt();
        Need[i][j]=in.nextInt();
        }
        }
        int running[]= new int [n];
        for(int i=0;i<n;i++){
        running[i]=in.nextInt();
        }
        if(save(running)){
    out.print(" Можно ");
    }
    else{
    out.print(" Нельзя ");
    }
    }
    void Haupt(int j){
    int Requesti[]= new int [m];
    boolean fl=true;
    for(int i=0;i<m;i++){
    if(Requesti[i]>Available[i]){
        fl=false;
        break;
    }
    }
    if(fl==true){
    for(int i=0;i<m;i++){
    Available[i]-=Requesti[i];
    Allocation[j][i]+=Requesti[i];
    Need[j][i]=Need[j][i]-Requesti[i];
    if(save(Available)){
    out.print(" Можно ");
    }
    else{
    out.print(" Нельзя ");
    }
    }
    }
    }
       
   boolean save(int av[]){
int work[]=new int [m];
boolean finish[]= new boolean[n];
work=av;
for(int i=0;i<n;i++){
if(finish[i]==false){
    boolean ans=true;
for(int j=0;j<m;j++){
if(Need[i][j]>work[j]){
ans=false;
break;
}
}
if(ans==true){
for(int k=0;k<m;k++){
work[k]+=Allocation[i][k];
}
finish[i]=true;
}
}
}
       return equal(finish);
   }
   boolean equal(boolean array[]){
       for(int i=0;i<n;i++){
       if(array[i]==false){
       return false;
       }
       }
   return true;
   }
}


