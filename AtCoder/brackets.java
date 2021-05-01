/* 
    解説 : https://github.com/E869120/kyopro_educational_90/blob/main/editorial/002.jpg
    計算量が 10^8 以下だったら全探索でヨシ
    今回は 2^20 (全ての組み合わせを作る) * N (正しいか確認) になる
*/

package AtCoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 実行時間制限: 2 sec / メモリ制限: 1024 MB
// 	Java (OpenJDK 1.8.0) では TLE が 発生 (実行時間　2185 ms メモリ 65384 KBS)
//	Java (OpenJDK 11.0.6) では　Pass (実行時間　1891 ms メモリ 105164 KBS)
public class brackets {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1 <= N <= 20
        int N = Integer.valueOf(br.readLine());
        // もし奇数ならさっさと正常終了
        if (N % 2 != 0) {
            System.out.println("");
            System.exit(0);   
        }
        
        // ゼロ埋めのためのフォーマット準備
        // %のエスケープは% %4d のようにしたい
        String zeroFmt = String.format("%%%ds", N);
        for (int i = 0; i < (int)Math.pow(2, N); i++) {
            // 2進数0埋め この方法でないとゼロ埋めできない(?)
            char [] brackets = String.format(zeroFmt, Integer.toBinaryString(i)).replace(' ', '0').toCharArray();
            int score = 0;
            for (int j = 0; j < N; j++) {
                // 辞書順に並べたいという要求がある
                // 0 -> ( 1 -> )
                if (brackets[j] == '0') {
                    brackets[j] = '(';
                    score ++;
                } else {
                    brackets[j] = ')';
                    score --;
                }
                if (score < 0) break;
            }
            if (score == 0) System.out.println(String.valueOf(brackets));
        } 
    }
}