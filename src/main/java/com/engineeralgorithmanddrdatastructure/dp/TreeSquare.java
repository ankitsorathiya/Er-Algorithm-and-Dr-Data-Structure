/**
 Bob and Forest
 You are given a 2D character array denoting forest of length N and breadth M . In the matrix, '.' denotes barren land and ' * ' denotes tree.
 You are given Q questions. In each question, you are given integer K and you have to determine the number of unique squares of side less than or equal to K which contain only trees.

 Input

 First line : N and M (N denoting number of rows and M denoting number of columns).

 Each of the next N lines contains string of M length containing '.' and '*' .

 Next line consists of an integer Q, denoting number of questions.

 Each of the next Q lines contains a single integer K.

 Input Constraints




 Output

 For each question, print the number of unique squares of side less than or equal to K which contain only trees. Answer for each question should come in a new line.

 Sample Input
 4 4
 *..*
 .***
 ****
 .***
 3
 1
 2
 3
 Sample Output
 12
 16
 17
 Explanation
 In the given sample , as we can see :-

 Squares of side 1 containing only trees :- 12.
 Squares of side 2 containing only trees :- 4.
 Squares of side 2 containing only trees :- 1.

 Thus answer for query 1 is 12.
 Answer for query 2 i.e squares of side less than or equal to 2 are 12+4 = 16.
 Answer for query 3 i.e squares of side less than or equal to 3 are 12+4+1=17.
 **/
package com.engineeralgorithmanddrdatastructure.dp;
import java.util.*;

class TreeSquare {
    public static void main(String args[] ){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        String[] forest= new String[n];
        for(int index=0;index<n;index++){
            forest[index]=scanner.next();
        }
        int memoLength= Math.min(n,m);
        long[] sideSquare= new long[memoLength+1];
        boolean[][][] memo= new boolean[n][m][memoLength+1];
        buildSolution(forest,sideSquare,memo,memoLength);
        for(int index=2;index<memoLength+1;index++){
            sideSquare[index]+=sideSquare[index-1];
        }
        int q=scanner.nextInt();
        for(int index=0;index<q;index++){
            int k=scanner.nextInt();
            if(k<=memoLength)
                System.out.println(sideSquare[k]);
            else
                System.out.println(0);
        }
    }
    private static void buildSolution(String[] forest,long[] sideSquare,boolean[][][] memo,int maxSquare){
        for(int row=0;row<forest.length;row++){
            for(int col=0;col<forest[row].length();col++){
                for(int square=1;square<=maxSquare;square++){
                    boolean canMoveForward=buildSquare(row,col,forest,square,memo,maxSquare,sideSquare);
                    if(!canMoveForward){
                        break;
                    }
                }
            }
        }
    }

    private static boolean buildSquare(int row,int col,String[] forest,int square,boolean[][][] memo,int maxSquare,long[] sideSquare){
        if(forest[row].charAt(col)=='.'){
            return false;
        }
        if(square==1){
            memo[row][col][square]=true;
            sideSquare[square]++;
            return true;
        }
        if(!memo[row][col][square-1]){
            return false;
        }
        int prevCol=col-1;
        if(prevCol>=0 && square+1<=maxSquare){
            if(memo[row][prevCol][square+1]){
                sideSquare[square]++;
                memo[row][col][square]=true;
                return true;
            }
        }

        int lastCol=col+square-1;
        int lastRow=row+square-1;
        if(lastCol>=forest[row].length() || lastRow>=forest.length){
            return false;
        }

        for(int checkCol=col;checkCol<col+square;checkCol++){
            if(forest[lastRow].charAt(checkCol)!='*'){
                return false;
            }
        }
        for(int checkRow=row;checkRow<row+square;checkRow++){
            if(forest[checkRow].charAt(lastCol)!='*'){
                return false;
            }
        }
        memo[row][col][square]=true;
        sideSquare[square]++;
        return true;

    }


}
