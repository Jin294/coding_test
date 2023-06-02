public class Main {
    static int end = 10_000;
    public static void main(String[] args) {
        boolean[] nums = new boolean[end + 1];
        for (int i = 1; i < nums.length; i++) {
            nums[check(i)] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nums.length; i++) {
            if (!nums[i]) sb.append(i + "\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
    }

    private static int check(int num) {
        int sum = num;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum <= end) return sum;
        else return 0;
    }
}