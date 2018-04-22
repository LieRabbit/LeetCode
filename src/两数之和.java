import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        // 记录遍历过的数和索引
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 获取target-nums[i]，看是否存在，存在则表明可以相加为target
            Integer value = map.get(target - nums[i]);
            if (value != null) {
                res[0] = value;
                res[1] = i;
                break;
            }
            // 用键保存遍历过的数，用值保存遍历过的索引
            map.put(nums[i], i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        两数之和 test = new 两数之和();
        int[] res = test.twoSum(arr, 9);
        for (int a : res)
            System.out.print(a + " ");
    }
}
