package Interview;

/**
 * 字符串处理
 * “ This   is a good  DAY”
 * “ This is A good Day   ”
 * Created by fengzhaoyang_i on 2017/6/1.
 */
public class _31_ {

    private static char toUp(char in){
        if(in >='a' && in <= 'z'){
            return (char)(in-32);
        }else {
            return in;
        }
    }

    private static char toLower(char in){
        if(in>='A' && in <= 'Z'){
            return (char)(in+32);
        }else {
            return in;
        }
    }

    private static char[] normalizedStr(char[] text){
        if(text==null || text.length==0)return text;

        int word_count = 1;
        char last_char = text[0];
        boolean isFirst = true;
        int index = 0;

        for(int i=0;i<text.length;i++){
            if(text[i] != ' ' && index==0){
                text[index++] = toUp(text[i]);
                isFirst = false;
            }else if(text[i] != ' ' && index !=0){
                if(last_char == ' '){
                    word_count++;
                }
                if(isFirst){
                    if(word_count%2==1){
                        text[index++] = ' ';
                        text[index++] = toUp(text[i]);
                    }else {
                        text[index++] = ' ';
                        text[index++] = toLower(text[i]);
                    }
                    isFirst = false;
                }else {
                    text[index++] = toLower(text[i]);
                }

            }else if(text[i] == ' ' && index !=0){
                isFirst = true;
            }

            last_char = text[i];
        }

        while (index<text.length){
            text[index++] = ' ';
        }

        return text;
    }

    public static void main(String[] args){
        String s = "     a     b     CCCC";
        System.out.println(s);
        System.out.println(normalizedStr(s.toCharArray()));
    }
}
