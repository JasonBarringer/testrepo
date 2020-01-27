public class Grades {
    public static void main(String[] args) {
        int a1 = 17;
        int a2 = 14;
        int a3 = 18;
        int a1p = 20;
        int a2p = 20;
        int a3p = 20;

        int midterm = 88;
        int fin = 82;

        double assignAvg = calculateAverage(a1, a2, a3, a1p, a2p, a3p);

        double overall = calculateGrade(assignAvg, midterm, fin);

        printResults(assignAvg, midterm, fin, overall);
    }

    public static double calculateAverage(int a1, int a2, int a3, int a1p, int a2p, int a3p){
        int assigntotal = a1 + a2 + a3;
        int assignposs = a1p + a2p + a3p;
        return (double) assigntotal / assignposs;
    }

    public static double calculateGrade(double assignAvg, int midterm, int fin) {
        double overall = (0.45 * assignAvg) + (0.20 * (midterm / 100.0)) + (0.35 * (fin / 100.0));
        return(overall);
    }

    public static void printResults(double assignAvg, int midterm, int fin, double overall) {
        System.out.println("Assign. Average: " + assignAvg);
        System.out.println("Midterm: " + midterm);
        System.out.println("Final: " + fin);
        System.out.println("Overall grade: " + overall);
    }
}