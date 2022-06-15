package reversethestring;

import kthrowofpascalstriangle.KthRowOfPascalsTriangle;

public class ReverseTheString {

    public static void main(String[] args) {
        ReverseTheString obj = new ReverseTheString();
        String str = "qxkpvo  f   w vdg t wqxy ln mbqmtwwbaegx   mskgtlenfnipsl bddjk znhksoewu zwh bd fqecoskmo";
        System.out.println(obj.solve(str));
    }

    public String solve(String A) {
        A.trim();
        String[] strA = A.split(" ");
        StringBuilder strB = new StringBuilder();
        for(int i=strA.length-1;i>=0;i--){
            if(!strA[i].equals("")){
                strA[i] = strA[i].trim();
                strB.append(strA[i]);
                strB.append(" ");
            }
        }
        return strB.toString().trim();
    }
}
