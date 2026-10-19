import java.util.HashMap;
import java.util.Map;
public class Problem4SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Long,Integer> frequency = new HashMap<>();
        frequency.put(0L, 1);
        long prefix = 0;
        int count = 0;
        for (int num : nums) {
            prefix += num;
            count += frequency.getOrDefault(prefix - k, 0);
            frequency.put(prefix, frequency.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
        System.out.println(subarraySum(new int[]{1,-1,0}, 0));
    }
}
