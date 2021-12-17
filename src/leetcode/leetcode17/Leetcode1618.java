package leetcode.leetcode17;

public class Leetcode1618 {

    interface FontInfo {
        // Return the width of char ch when fontSize is used.
        public int getWidth(int fontSize, char ch);
        // Return Height of any char when fontSize is used.
        public int getHeight(int fontSize);
    }

    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int[] num=new int[26];
        for(char c:text.toCharArray())
            num[c-'a']++;

        if(!isMatch(fontInfo,fonts[0],w,h,num))
            return -1;
        int l=0,r=fonts.length-1;
        while(l<r){
            int mid=(l+r+1)/2;
            if(isMatch(fontInfo,fonts[mid],w,h,num))
                l=mid;
            else
                r=mid-1;
        }
        return fonts[l];
    }

    private boolean isMatch(FontInfo fontInfo,int fontSize,int w,int h,int[] num){
        if(fontInfo.getHeight(fontSize)>h)
            return false;

        int width=0;
        for(int i=0;i<26;i++){
            char cur=(char)(i+'a');
            width+=fontInfo.getWidth(fontSize,cur)*num[i];
        }

        return width<=w;
    }


}
