package lintcode;

import java.util.Scanner;

public class MainALi {

    //判断上家的牌
    public static int judgePre(String s){
        if(s.length()==1){
            return 0; // 单
        }else if(s.length()==2){
            return 1; //对
        }else if(s.length() == 5){
            return 2; // 顺子
        }else if(s.length() ==4){
            if(s.charAt(0) == s.charAt(s.length()-1)){
                return 4; //炸
            }else {
                return 3; //连对
            }
        }else if(s.length() > 4 && s.length() %2 ==0){
            return 3; //连对
        }else {
            return -1;
        }
    }

    public static String getOutput(String mycard,int type,String pre){

        String res = "0";

        if(judgePre(pre) == -1){
            res = "0";
        }
        char[] s = mycard.toCharArray();

        if(type == 0){
            if(pre.charAt(0) >= '2' && pre.charAt(0) <= '8'){
                int pre_int = Integer.valueOf(pre);
                for(int i=0;i<s.length;i++){
                    if(Integer.valueOf(""+s[i]) > pre_int){
                        res = ""+s[i];
                        return res;
                    }
                }
            }else if(pre.charAt(0) >= '9'){
                for(int i=0;i<s.length;i++){
                    if(s[i] == 'I' || s[i] == 'J' || s[i] == 'Q' || s[i] == 'K' || s[i] == 'A'){
                        res = ""+s[i];
                        return res;
                    }
                }
            }else if(pre.charAt(0) >= 'I'){
                for(int i=0;i<s.length;i++){
                    if( s[i] == 'J' || s[i] == 'Q' || s[i] == 'K' || s[i] == 'A'){
                        res = ""+s[i];
                        return res;
                    }
                }
            }else if(pre.charAt(0) >= 'J'){
                for(int i=0;i<s.length;i++){
                    if( s[i] == 'Q' || s[i] == 'K' || s[i] == 'A'){
                        res = ""+s[i];
                        return res;
                    }
                }
            }else if(pre.charAt(0) >= 'Q'){
                for(int i=0;i<s.length;i++){
                    if(s[i] == 'K' || s[i] == 'A'){
                        res = ""+s[i];
                        return res;
                    }
                }
            }else if(pre.charAt(0) >= 'K'){
                for(int i=0;i<s.length;i++){
                    if(s[i] == 'A'){
                        res = ""+s[i];
                        return res;
                    }
                }
            }
        }else if(type == 1){
            int pre_int = Integer.valueOf(pre.charAt(0));
            for(int i=0;i<s.length;i++){
                if(Integer.valueOf(s[i]) > pre_int){
                    for(int j=0;j<s.length;j++){
                        if(j!=i && s[j]==s[i]){
                            res = ""+s[i] +""+s[j];
                            return res;
                        }
                    }
                }
            }
        }else if(type==2){
            // 顺子

        }else if(type==3){
            //连对
        }else if(type == 4){
            //炸弹


        }




        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String mycard = sc.next();
        String pre = sc.next();

        int type = judgePre(pre);

        System.out.println(mycard);

        System.out.println(getOutput(mycard,type,pre));
    }


}
