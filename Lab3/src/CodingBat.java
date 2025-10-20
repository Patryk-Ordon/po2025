public class CodingBat {
    public static boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation)
            return true;
        return false;
    }

    public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if ((aSmile && bSmile) || (!aSmile && !bSmile))
            return true;
        return false;
    }

    public static String helloName(String name) {
        return "Hello " + name + "!";
    }

    public static int countEvens(int[] nums) {
        int counter = 0;
        for (int i=0; i<nums.length; i++)
            if (nums[i] % 2 == 0)
                counter++;
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(sleepIn(true,true));
        System.out.println(monkeyTrouble(true,true));
        System.out.println(helloName("Patryk"));
        int[] nums = new int[5];
        for (int i=0;i<5;i++)
            nums[i]=i;
        System.out.println(countEvens(nums));
    }
}
