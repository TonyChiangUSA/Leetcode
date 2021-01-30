package Pony;

public class isInTriangle {
    static class POINT {
        int x;
        int y;
        public POINT(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static boolean isInTriangle(POINT A, POINT B, POINT C, POINT P) {
        /*利用叉乘法进行判断,假设P点就是M点*/
        int a = 0, b = 0, c = 0;

        POINT PA = new POINT(P.x - A.x,P.y - A.y);
        POINT PB = new POINT(P.x - B.x,P.y - B.y);
        POINT PC = new POINT(P.x - C.x,P.y - C.y);

        /*向量叉乘，如果两个叉积的结果方向一致，那么两个点在同一测*/
        a = PA.x * PB.y - PA.y * PB.x;
        b = PB.x * PC.y - PB.y * PC.x;
        c = PC.x * PA.y - PC.y * PA.x;

        if((a <= 0 && b <= 0 && c <= 0)||
                (a > 0 && b > 0 && c > 0))
            return true;
        return false;
    }
    public static void main(String[] args) {
//        Point A =new Point(0,0);
//        Point B =new Point(20,0);
//        Point C =new Point(10,30);
//        Point P =new Point(10,15);
//
//        System.out.println(isInTriangle(A,B,C,P));

    }
}
