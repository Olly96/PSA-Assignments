package edu.neu.coe.info6205.union_find;

public class Driver {


    public static int count(int n){
        int max = n-1;
        int min = 0;
        int connectionCount = 0;
        WQUDepth uf = new WQUDepth(n);
        while(uf.components() > 1){
            uf.show();
            int i = min + (int)(Math.random() * ((max - min) + 1));
            int j = min + (int)(Math.random() * ((max - min) + 1));
            if(!uf.connected(i,j)){
                uf.union(i,j);
                connectionCount++;
            }
        }

        return connectionCount;
    }

    public static void main(String[] args) {
        int i = 0;
        int n = 5;
        while(i <= 1){
            System.out.println("Total Sites: " + n + " Total Connections: " + count(n));
            n *= 2;
            i++;
        }
    }
}
