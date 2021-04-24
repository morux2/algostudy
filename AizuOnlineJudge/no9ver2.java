/*
    lowerEntry
        public Map.Entry<K,V> lowerEntry(K key)
        インタフェースからコピーされた説明: NavigableMap
        指定されたキーよりも確実に小さい、最大のキーに関連付けられたキーと値のマッピングを返します。そのようなキーが存在しない場合は、nullを返します。
        定義:
          lowerEntry、インタフェース: NavigableMap<K,V>
        パラメータ:
          key - キー戻り値:
          keyよりも小さいキーの中で最大のものを持つエントリ。そのようなキーが存在しない場合はnull
*/

package AizuOnlineJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

// メモ化するぞ！
// Time	00:30 Memory 27572 KB Accepted
public class no9ver2{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
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
                    if (isPrime(i)) primeCount++;   
                }
                // 計算結果をTreeMapに記憶させる
                tm.put(n,primeCount);
            } 
            System.out.println(String.valueOf(primeCount));
        }
    }

    public static boolean isPrime(int n) {
        if (n==1) return false;
        //偶数は省く
         if (n > 2 && n%2==0) return false;
        for  (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
 }