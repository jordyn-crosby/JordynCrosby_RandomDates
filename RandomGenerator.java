public class RandomGenerator {
    public static int getYear() {return(int)(Math.random() * 2022 + 1);}
    public static int getMonth() {return (int)(Math.random() * 12 + 1);}
    public static int getDay(int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> (int)(Math.random() * 31);
            case 4, 6, 11 -> (int)(Math.random() * 30);
            default -> (int)(Math.random() * 28);
        };
    }
}