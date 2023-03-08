package com.thkjava.secabase.C04CtrlExec;
/* 
吸血鬼数字是指位数为偶数的数字，可以由一对数字相乘而得到，而这对数字各包含乘积的一半位数的数字，
其中从最初的数字中选取的数字可以任意排序。以两个0结尾的数字是不允许的，例如，下列数字都是“吸血鬼”数字:
1260 = 21 * 60
1827 =21 *87
2187 =27*81
写一个程序，找出4位数的所有吸血鬼数字 (Dan Forhan推荐)
*/
public class C04P04bloodNum {
    public static void main(String[] args) {
        // 吸血鬼数字
        // 思路1是遍历所有4位数, 将其 拆为两个两位数 进行乘法, 然后比较
        // 拆分的过程较麻烦, 因为数字任意选取, 顺序不唯一
        // 思路2是两层循环遍历所有的两位数组合, 得到乘积, 然后拆分为数组, 排序后比较各位是否相等
        composeTwo();
    }

    static void composeTwo(){
        for(int i=10; i<100; i++){
            for(int j=i+1; j<100; j++){
                if(i*j<100 || i*j>9999)
                    continue;
                if(i%10==0 && j%10==0)
                    continue;    // 两个0结尾的数字舍弃
                if(ifnumOK(i, j))
                    System.out.println(i+" * "+j+" = "+(i*j));
            }
        }
    }

    static boolean ifnumOK(int a, int b){
        int p = a * b;
        int la[] = {a/10, a%10, b/10, b%10};
        int lp[] = {p/1000, (p/100)%10, (p/10)%10, p%10};
        qsort(la, 0, 3);
        qsort(lp, 0, 3);
        return ifEqual(la, lp, 4);
    }

    static void qsort(int arr[], int i, int j){
        if (i < j){
            int x = arr[i], low=i, high=j;  // 快排
            while(i < j){
                while(j>i && arr[j]>=x) --j;    // 找到第一个比x小的
                arr[i] = arr[j];    // 将它放到前面
                while(i<j && arr[i]<=x) ++i;    // 找到第一个比x大的
                arr[j] = arr[i];    // 将它放到后面
            }
            arr[i] = x;
            qsort(arr, low, i-1);
            qsort(arr, i+1, high);
        }
    }

    static boolean ifEqual(int[] a, int[] b, int n){
        for(int i=0; i<n; i++){
            if(a[i] != b[i])
            return false;
        }
        return true;
    }

    static void prtInfo(int[] a, int n){
        for(int i=0; i<n; i++){
            System.out.print(a[i]);
            if(i<n-1)System.out.print(" ");
            else System.out.print("\n");
        }
    }
}
/*
 * refer programe
public static void main(String[] args) {
    for (int i = 10; i < 100; i++) {
        for (int j = i + 1; j < 100; j++) {
            int result = i * j;
            //两个数相乘结果若小于4位数或者大于4位数的直接舍去
            if (result < 1000 || result > 9999)
                continue;

            //若成绩刚好为4位数，将结果数字转换为字符，并存入字符数组中
            char[] targetNum = (result + "").toCharArray();
            //将两个乘数也存入字符数组中
            char[] gunNum = ("" + i + j).toCharArray();

            //将两个字符数组排序，以方便对比
            Arrays.sort(targetNum);
            Arrays.sort(gunNum);

            //将两个字符数组进行对比，若一致，即乘数与乘积的数字相同，即满足吸血鬼数字，进行打印输出
            if (Arrays.equals(targetNum, gunNum))
                System.out.println(result + " = " + i + " * " + j);
        }
    }
}
 */