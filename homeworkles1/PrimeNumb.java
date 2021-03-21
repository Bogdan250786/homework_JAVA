package com.paramud.homeworkles1;

public class PrimeNumb {
    public String primeCount(int a, int b) {
        String str = "";
        String rev = "";
        nextNumb:
        for (int i = a; i <= b; i++) {
            for (int j = 2; j < i; j++){
                if (i % j == 0) continue nextNumb;
            }
            str = (str=="") ? str+i : str+","+i;
        }
        String[] arr1 = str.split(",");
        for (int i=0; i<arr1.length-1; i++){
            for (int j = i+1; j < arr1.length; j++){
                StringBuilder build = new StringBuilder(arr1[j]);
                if (Integer.parseInt(arr1[i]) == (Integer.parseInt(build.reverse()+"")))
                    rev+= (rev=="") ? arr1[i]+","+arr1[j] : ","+arr1[i]+","+arr1[j];
            }
        }
        System.out.println("Prime numbers are "+str+"\n"+"Reversed numbers are "+rev);
        return "Prime numbers are "+str+"\n"+"Reversed are "+rev;
    }
}

