package campus;

import java.util.*;

public class MainALL2 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] map_in = new String[n];

        for(int i = 0;i<n;i++){
            map_in[i] = scanner.next();
        }

        String[][] map = new String[n][n];
        List<String> isUsed = new LinkedList<>();

        for(int i=0;i<n;i++){
            char[] item = map_in[i].toCharArray();
            for(int j = 0;j<n;j++){
                map[i][j] = ""+item[j];
                if(item[j] == '*'){
                    isUsed.add(i+" "+j);
                }
            }
        }

        HashMap<String,Integer> all_res = new HashMap<>();
        int count = 0;

        for(String key : isUsed){
            int[] index = {Integer.valueOf(key.split(" ")[0]),
                            Integer.valueOf(key.split(" ")[1])};

            int left_x = index[0] - 1;
            int right_x = index[0] + 1;
            int left_y = index[1] - 1;
            int right_y = index[1] + 1;

            String[] arround_keys = {
                    left_x+" "+left_y,
                    left_x+" "+index[1],
                    left_x+" "+right_y,
                    index[0] + " " + left_y,
                    index[0] + " " + right_y,
                    right_x+" " +left_y,
                    right_x+" " + index[1],
                    right_x+" " + right_y
            };

            boolean has_nei_in_all_res = false;
            int last_index = -1;

            for(String s : arround_keys){
                if(all_res.containsKey(s)){
                    if(!has_nei_in_all_res) {
                        has_nei_in_all_res = true;
                        int which = all_res.get(s);
                        all_res.put(key, which);
                        last_index = which;
                    }else {
                        if(last_index != all_res.get(s) && last_index != -1){
                            count--;
                            last_index = all_res.get(s);
                        }
                    }
                }
            }

            if(!has_nei_in_all_res){
                count++;
                all_res.put(key,count);
            }
        }


        System.out.println(count);
    }
}
