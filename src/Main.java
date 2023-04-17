import java.math.BigInteger;
import java.util.Optional;

public class Main {
//36. Write a Java program to find all the unique triplets such that sum of all the three elements [x, y, z (x ≤ y ≤ z)] equal
// to a specified number.
//Sample array: [1, -2, 0, 5, -1, -4]
//Target value: 2.  Go to the editor

    public static BigInteger factorial(Integer n){
        if(n<0)
            throw new IllegalArgumentException("Liczba "+n+" jest spoza dziedziny funkcji silnia");
        else if(n>1)
        return factorial(n-1).multiply(BigInteger.valueOf(n));
        else
            return BigInteger.ONE;
    }

    public static Optional<int [][]> triplets(int [] inputArray, int targetValue){
        int n= inputArray.length;
        int outputLength=  factorial(n).divide(factorial(3).multiply(factorial(n-3))).intValueExact();
        System.out.println(outputLength);
        int [][] outputArray=new int[3][outputLength];

int i=0;
            for(int j=0;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int z=k+1;z<n;z++){

                        if(i<outputLength&&inputArray[j]+inputArray[k]+inputArray[z]==targetValue) {
                            outputArray[0][i] = inputArray[j];
                            outputArray[1][i] = inputArray[k];
                            outputArray[2][i] = inputArray[z];
                            i++;

                        }
                    }
                }
            }


        return Optional.ofNullable(outputArray);
    }
    public static void main(String[] args) {


    Optional<int[][]> array=triplets(new int[] {1, -2, 0, 5, -1, -4,0,2},6);
    if(array.isPresent()) {
        var tab = array.orElseThrow();
        for(int i=0;i< tab[1].length;i++) {

            for (int j = 0; j < tab.length; j++) {
                System.out.print(tab[j][i] + " ");
            }
            System.out.println();
        }

    }

    }
}
