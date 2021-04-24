/*
    提出時はクラス名をMainに変更する
    Ctrl + DでEOFが入力されるので、この入力をしてプログラムが終了すればOKです
    https://koturn.hatenablog.com/entry/2016/02/04/050000
    最小値 / 最大値で動かしてみるとどれくらいかかる？
    Scannerは遅いらしい
    √n までループを回せば素数は判定できる
    例 36
        2 * 18
        3 * 12
        4 * 9
        6 * 6 (√n * √n)
        ここからは左側の数字のが大きくなるので確認する必要がなくなる
        9 * 4
        12 * 3
        18 * 2
    オーバーフローしないか確認する(しそうならLongにする)
*/

package AizuOnlineJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TIME 02:72 Memory 24968 KB TLE
public class no9{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null){
            int n = Integer.valueOf(line);
            int primeCount = 0;
            for (int i=1; i<=n; i++){
                if (isPrime(i)) primeCount++;
            }
            System.out.println(String.valueOf(primeCount));
        }
    }

    public static boolean isPrime(int n) {
        if (n==1) return false;
        // 偶数は先に返したい
        if (n > 2 && n % 2==0) return false;
        for  (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
 }