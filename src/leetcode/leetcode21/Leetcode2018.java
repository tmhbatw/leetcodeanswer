package leetcode.leetcode21;

public class Leetcode2018 {

    public boolean placeWordInCrossword(char[][] board, String word) {
        char[] w=word.toCharArray();
        for(char[] c:board){
            int j=0;
            for(int i=0;i<c.length;i++){
                if(c[i]==' '||c[i]==w[j]){
                    j++;
                    if(j==w.length) {
                        if(i==c.length-1||c[i+1]=='#')
                            return true;
                        else{
                            while(i<c.length-1&&c[i+1]!='#')
                                i++;
                            j=0;
                        }
                    }
                }else {
                    j = 0;


                    if(c[i]=='#')
                        continue;
                    while (i < c.length - 1 && c[i + 1] != '#')
                        i++;
                }
            }
        }

        for(char[] c:board){
            int j=0;
            for(int i=c.length-1;i>=0;i--){
                if(c[i]==' '||c[i]==w[j]){
                    j++;
                    if(j==w.length) {
                        if(i==0||c[i-1]=='#')
                            return true;
                        else{
                            while(i>=1&&c[i-1]!='#')
                                i--;
                            j=0;
                        }
                    }
                }else {
                    j = 0;


                    if(c[i]=='#')
                        continue;
                    while (i >=1  && c[i - 1] != '#')
                        i--;
                }
            }
        }

        for(int jj=0;jj<board[0].length;jj++){
            int j=0;
            for(int i=0;i<board.length;i++){
                //System.out.println(i+" "+board[i][jj]+" "+j+" "+word);
                if(board[i][jj]==' '||board[i][jj]==w[j]){
                    j++;
                    if(j==w.length) {
                        if(i==board.length-1||board[i+1][jj]=='#')
                            return true;
                        else{
                            while(i<board.length-1&&board[i+1][jj]!='#')
                                i++;
                            j=0;
                        }
                    }
                }else {
                    j = 0;

                    if(board[i][jj]=='#'){
                        continue;
                    }
                    while (i < board.length - 1 && board[i+1][jj] != '#')
                        i++;
                }
            }
        }

        for(int jj=0;jj<board[0].length;jj++){
            int j=0;
            for(int i=board.length-1;i>=0;i--){
                //System.out.println(i+" "+board[i][jj]+" "+j+" "+word);
                if(board[i][jj]==' '||board[i][jj]==w[j]){
                    j++;
                    if(j==w.length) {
                        if(i==0||board[i-1][jj]=='#')
                            return true;
                        else{
                            while(i>=1&&board[i-1][jj]!='#')
                                i--;
                            j=0;
                        }
                    }
                }else {
                    j = 0;

                    if(board[i][jj]=='#'){
                        continue;
                    }
                    while(i>=1&&board[i-1][jj]!='#')
                        i--;
                }
            }
        }

        return false;
    }

}
