import java.util.Scanner;

public class InsertionSortP2 {

    private int theSize;
    private int theArray[];

    private void inputArray(){

        Scanner input = new Scanner(System.in);
        int mySize = input.nextInt();//enter the array size
        int myArray[] = new int[mySize];//provision for an array of a given size
        theSize = mySize;
        theArray = myArray;

        for(int i=0; i<mySize; i++){
            myArray[i] = input.nextInt();
        }
    }

    private void printArray(){

        for(int i=0;i<theSize;i++){
            System.out.print(theArray[i]+" ");
        }
        System.out.println();
    }

    private void sortLast(int index){

        int last = theArray[index-1];//keeps last array element
        boolean end = false;

        for(int j=1;j<index&&!end;j++){

            if(last < theArray[index-j-1]){//shift right if the next is less than last
                theArray[index-j] = theArray[index-j-1];
            }else{//if not, copy last at next position
                theArray[index-j] = last;
                end = true;
            }

            //if the first is reached, I have to copy the
            //last into the first position and end
            if(j==index-1&&!end){//but don't do this if end is previously reached
                theArray[index-j-1] = last;
                end = true;
            }
        }
    }

    private void sortAll(){

        for(int i=2;i<=theSize;i++){//initial size is 2, last is theSize
            sortLast(i);
            printArray();
        }
    }

    public static void main(String[] args) {

        InsertionSortP2 mySolution = new InsertionSortP2();
        mySolution.inputArray();
        mySolution.sortAll();
    }
}