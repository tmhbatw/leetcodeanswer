package leetcode.leetcode9;

public class Leetcode838 {

    public String pushDominoes(String dominoes) {
        char pre='L';
        int index=-1;

        char[] res=dominoes.toCharArray();
        for(int i=0;i<res.length;i++){
            switch (res[i]){
                case '.':
                    break;
                case 'L':
                    if(pre=='L'){
                        for(int j=index+1;j<i;j++)
                            res[j]='L';
                    }else{
                        int l=index+1,r=i-1;
                        while(l<r){
                            res[l++]='R';
                            res[r--]='L';
                        }
                    }
                    pre='L';
                    index=i;
                    break;
                default:
                    if(pre=='R'){
                        for(int j=index+1;j<i;j++)
                            res[j]='R';
                    }
                    pre='R';
                    index=i;
            }
        }

        if(pre=='R'){
            for(int j=index+1;j<res.length;j++)
                res[j]='R';
        }

        return new String(res);

    }


}
