public class CodingBat {
    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation)
            return true;
        return false;
    }

    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if ((aSmile && bSmile) || (!aSmile && !bSmile))
            return true;
        return false;
    }

    public String helloName(String name) {
        return "Hello " + name + "!";
    }

    public int countEvens(int[] nums) {
        int counter = 0;
        for (int i=0; i<nums.length; i++)
            if (nums[i] % 2 == 0)
                counter++;
        return counter;
    }
}
