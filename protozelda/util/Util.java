package protozelda.util;

public class Util {

    public static int positiveMin(int n1, int n2) {
        if(n1 <= 0 && n2 <= 0) {
            return 0;
        }
        if(n1 > 0 && n2 > 0) {
            return Math.min(n1, n2);
        }

        return n1 > 0 ? n1 : n2;
    }

    public static int sign(int n) {
        if(n < 0) {
            return -1;
        }
        if(n > 0) {
            return 1;
        }
        
        return 0;
    }
    
}