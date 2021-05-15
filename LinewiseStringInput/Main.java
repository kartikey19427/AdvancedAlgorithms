package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        read re=new read();
        re.init(System.in);
        int T=re.nextInt();
        for (int i=0;i<T;i++){
            int n=re.nextInt();
            int[][] arr=new int[n][n];
            int count=0;
            int[] inarr=new int[4];
            String[] stoarr=new String[n];
            for(int j=0;j<n;j++) {
                String st = re.readLine();
                stoarr[j] = st;
            }
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(stoarr[j].charAt(k)=='.'){
                        arr[j][k]=0;
                    }
                    else {
                        arr[j][k]=1;
                        inarr[count]=j;
                        count++;
                        inarr[count]=k;
                        count++;
                    }
                }
            }
            almostrect(arr,inarr);
        }
    }

        public static void almostrect(int[][] arr, int[] inarr){
            int inx1=inarr[0];
            int iny1=inarr[1];
            int inx2=inarr[2];
            int iny2=inarr[3];
            if(inx1==inx2){
                if(inx1==arr.length-1){
                    arr[inx1-1][iny1]=1;
                    arr[inx2-1][iny2]=1;

                }
                else {
                    arr[inx1+1][iny1]=1;
                    arr[inx2+1][iny2]=1;
                }
            }
            else if(iny1==iny2){
                if(iny1==arr.length-1){
                    arr[inx1][iny1-1]=1;
                    arr[inx2][iny2-1]=1;

                }
                else {
                    arr[inx1][iny1+1]=1;
                    arr[inx2][iny2+1]=1;
                }

            }
            else {
                arr[inx1][iny2]=1;
                arr[inx2][iny1]=1;
            }
            display2d(arr);


        }
        public static void display2d(int[][] arr){
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){
                    if(arr[i][j]==0){
                        System.out.print(".");

                    }
                    else{
                        System.out.print("*");
                    }

                }
                System.out.println("");
            }
        }

        static class read {
        BufferedReader reader;
        StringTokenizer tokenizer;

        void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input) );
            tokenizer = new StringTokenizer("");
        }

        String next() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) {
                tokenizer = new StringTokenizer(
                        reader.readLine() );
            }
            return tokenizer.nextToken();
        }

        String readLine() throws IOException {
            String s = reader.readLine();
            return s;
        }

        int nextInt() throws IOException {
            return Integer.parseInt( next() );
        }

        double nextDouble() throws IOException {
            return Double.parseDouble( next() );
        }

        long nextLong() throws  IOException{
            return Long.parseLong( next() );
        }
    }



}
