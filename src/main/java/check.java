// to do discount and to reverse it

public class check {
    public static void main(String[] args) {
        double a = 1000;
        double dis = 10;

        double sum = a * (dis / 100);
        double ans = a - sum;
        System.out.println(ans);

        double dis2 = 10;
        double sum2 = ans * (dis2 / 100);
        double ans2 = ans - sum2;
        System.out.println(ans2);

        double dis3 = 20;
        double sum3 = ans2 * (dis3 / 100);
        double ans3 = ans2 - sum3;
        System.out.println(ans3);

        double minus = ans3 / ((100 - dis3)/100);
        System.out.println(minus);
    }
}
