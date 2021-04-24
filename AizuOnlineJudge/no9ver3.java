/*
    エラストテネスのふるいで先に最大値(999999)までの素数を全て計算する
    -> あとは配列の中身を見てカウントするだけ
*/

package AizuOnlineJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

// ふるうぞ！
// Time	00:08 Memory 28396 KB Accepted
public class no9ver3{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        final int MAX_INPUT = 999999;
        // 初期値は0
        byte[] primeList = new byte[MAX_INPUT];
        // もし素数じゃなければ1を入れる
        primeList[0] = 1;
        for (int i = 2; i <= Math.sqrt(MAX_INPUT); i++) {
            for (int j = 2; j*i <= MAX_INPUT; j++) {
                primeList[j*i-1] = 1;
            }
        }
        // 今までの結果をTreeMapに溜める
        TreeMap<Integer,Integer> tm= new TreeMap<>();
        while ((line = br.readLine()) != null){
            int n = Integer.valueOf(line);
            Integer primeCount = 0;
            // 既にTreeMapが答えを知っていたらその答えを返す
            if ((primeCount = tm.get(n))== null){
                // nullが入っているので0に戻す
                primeCount = 0;
                // TreeMapから入力値に一番近い値を引っ張り出して途中からカウントする
                Map.Entry<Integer,Integer> maxEntry = null;
                int start = 1;
                if ((maxEntry = tm.lowerEntry(n))!= null){
                    primeCount += maxEntry.getValue();
                    start = maxEntry.getKey() + 1;
                }
                for (int i = start; i<=n; i++){
                    if (primeList[i-1]  == 0)
                        primeCount += 1;
                }
                // 計算結果をTreeMapに記憶させる
                tm.put(n,primeCount);
            } 
            System.out.println(String.valueOf(primeCount));
        }
    }
}