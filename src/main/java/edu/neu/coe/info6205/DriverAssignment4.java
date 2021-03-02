package edu.neu.coe.info6205;

import edu.neu.coe.info6205.union_find.Driver;
import edu.neu.coe.info6205.union_find.UF_HWQUPC;
import edu.neu.coe.info6205.union_find.UF_HWQUPC_TwoPass;
import edu.neu.coe.info6205.union_find.WQUDepth;
import edu.neu.coe.info6205.util.Timer;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class DriverAssignment4 {

    public void benchmarkWQUDepth(int n){

//        int connectionCount = 0;
        final UnaryOperator<Integer> prefunc = (sites) -> {
            int max = sites-1;
            int min = 0;
            WQUDepth uf = new WQUDepth(n, false);
            while(uf.components() > 1){
//                uf.show();
                int i = min + (int)(Math.random() * ((max - min) + 1));
                int j = min + (int)(Math.random() * ((max - min) + 1));
                if(!uf.connected(i,j)){
                    uf.union(i,j);
//                    connectionCount++;
                }
            }
            return null;
        };

        final Function<Integer, Integer> targetfunc = (sites) -> {
            int max = sites-1;
            int min = 0;
            WQUDepth uf = new WQUDepth(n, false);
            while(uf.components() > 1){
                int i = min + (int)(Math.random() * ((max - min) + 1));
                int j = min + (int)(Math.random() * ((max - min) + 1));
                if(!uf.connected(i,j)){

                    uf.union(i,j);
//                    connectionCount++;
                }
            }
            return null;
        };
        Supplier<Integer> argsSupplier = getSupplierFunc(n);
        double mlt = new Timer().repeat(100, argsSupplier, targetfunc, prefunc, null);
        System.out.println("benchmarkWQUDepth mlt:"+ mlt);
    }

    public void benchmarkWQUSize(int n){

//        int connectionCount = 0;
        final UnaryOperator<Integer> prefunc = (sites) -> {
            int max = sites-1;
            int min = 0;
            UF_HWQUPC uf = new UF_HWQUPC(n, false);
            while(uf.components() > 1){
//                uf.show();
                int i = min + (int)(Math.random() * ((max - min) + 1));
                int j = min + (int)(Math.random() * ((max - min) + 1));
                if(!uf.connected(i,j)){
                    uf.union(i,j);
//                    connectionCount++;
                }
            }
            return null;
        };

        final Function<Integer, Integer> targetfunc = (sites) -> {
            int max = sites-1;
            int min = 0;
            UF_HWQUPC uf = new UF_HWQUPC(n, false);
            while(uf.components() > 1){
                int i = min + (int)(Math.random() * ((max - min) + 1));
                int j = min + (int)(Math.random() * ((max - min) + 1));
                if(!uf.connected(i,j)){

                    uf.union(i,j);
//                    connectionCount++;
                }
            }
            return null;
        };
        Supplier<Integer> argsSupplier = getSupplierFunc(n);
        double mlt = new Timer().repeat(100, argsSupplier, targetfunc, prefunc, null);
        System.out.println("benchmarkWQUSize mlt:"+ mlt);
    }
    public void benchmarkHWQUPC_SinglePass(int n){

//        int connectionCount = 0;
        final UnaryOperator<Integer> prefunc = (sites) -> {
            int max = sites-1;
            int min = 0;
            UF_HWQUPC uf = new UF_HWQUPC(n, true);
            while(uf.components() > 1){
                int i = min + (int)(Math.random() * ((max - min) + 1));
                int j = min + (int)(Math.random() * ((max - min) + 1));
                if(!uf.connected(i,j)){
                    uf.union(i,j);
                }
            }
            return null;
        };

        final Function<Integer, Integer> targetfunc = (sites) -> {
            int max = sites-1;
            int min = 0;
            UF_HWQUPC uf = new UF_HWQUPC(n, true);
            while(uf.components() > 1){
                int i = min + (int)(Math.random() * ((max - min) + 1));
                int j = min + (int)(Math.random() * ((max - min) + 1));
                if(!uf.connected(i,j)){

                    uf.union(i,j);
//                    connectionCount++;
                }
            }
            return null;
        };
        Supplier<Integer> argsSupplier = getSupplierFunc(n);
        double mlt = new Timer().repeat(100, argsSupplier, targetfunc, prefunc, null);
        System.out.println("benchmarkHWQUPC_SinglePass mlt:"+ mlt);
    }

    public void benchmarkHWQUPC_TwoPass(int n){

//        int connectionCount = 0;
        final UnaryOperator<Integer> prefunc = (sites) -> {
            int max = sites-1;
            int min = 0;
            UF_HWQUPC_TwoPass uf = new UF_HWQUPC_TwoPass(n);
            while(uf.components() > 1){
                int i = min + (int)(Math.random() * ((max - min) + 1));
                int j = min + (int)(Math.random() * ((max - min) + 1));
                if(!uf.connected(i,j)){
                    uf.union(i,j);
                }
            }
            return null;
        };

        final Function<Integer, Integer> targetfunc = (sites) -> {
            int max = sites-1;
            int min = 0;
            UF_HWQUPC_TwoPass uf = new UF_HWQUPC_TwoPass(n);
            while(uf.components() > 1){
                int i = min + (int)(Math.random() * ((max - min) + 1));
                int j = min + (int)(Math.random() * ((max - min) + 1));
                if(!uf.connected(i,j)){

                    uf.union(i,j);
//                    connectionCount++;
                }
            }
            return null;
        };
        Supplier<Integer> argsSupplier = getSupplierFunc(n);
        double mlt = new Timer().repeat(100, argsSupplier, targetfunc, prefunc, null);
        System.out.println("benchmarkHWQUPC_TwoPass mlt:"+ mlt);
    }

    public Supplier<Integer> getSupplierFunc(Integer  n){
        return ()->{
            return  n;
        };
    }


    public static void main(String[] args) {
        int i = 0;
        int n = 12000;
        DriverAssignment4 driverObj = new DriverAssignment4();
        while(i < 6){
            System.out.println("Total Sites: " + n );
            driverObj.benchmarkWQUDepth(n);
            driverObj.benchmarkWQUSize(n);
            driverObj.benchmarkHWQUPC_TwoPass(n);
            driverObj.benchmarkHWQUPC_SinglePass(n);
            System.out.println("************************************************************");
            n *= 2;
            i++;
        }
    }
}
