package leetcode.leetcode15;

public class Leetcode1410 {

    public String entityParser(String text) {
        text = text.replace("&quot;","\"");
        text = text.replace("&apos;","'");
        text = text.replace("&gt;",">");
        text = text.replace("&lt;","<");
        text = text.replace("&frasl;", "/");
        text = text.replace("&amp;","&");
        return text;
    }


}
