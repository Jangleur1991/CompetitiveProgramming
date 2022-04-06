import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumTest {

    private TwoSum testCandidate;

    @Before
    public void setUp() {
        testCandidate = new TwoSum();
    }

    @Test
    public void testThatTwoSumsWithBinaryArrayReturns01() throws Exception {
        //given
        int[] nums = new int[]{3,3};
        int target = 6;

        //when
        int[] result = testCandidate.twoSum(nums, target);

        //then
        assertThat(result).isEqualTo(new int[]{0,1});
    }

    @Test
    public void testThatTwoSumsWithBinaryArrayReturnsEmptyArray() throws Exception {
        //given
        int[] nums = new int[]{2,3};
        int target = 6;

        //when
        int[] result = testCandidate.twoSum(nums, target);

        //then
        assertThat(result).isEqualTo(new int[]{0,0});
    }

    @Test
    public void testTwoSumsExample1() throws Exception {
        //given
        int[] nums = new int[]{2,7,11,15};
        int target = 9;

        //when
        int[] result = testCandidate.twoSum(nums, target);

        //then
        assertThat(result).isEqualTo(new int[]{0,1});
    }

    @Test
    public void testTwoSumsExample2() throws Exception {
        //given
        int[] nums = new int[]{3,2,4};
        int target = 6;

        //when
        int[] result = testCandidate.twoSum(nums, target);

        //then
        assertThat(result).isEqualTo(new int[]{1,2});
    }

    @Test
    public void testTwoSumsExample3() throws Exception {
        //given
        int[] nums = new int[]{3,3};
        int target = 6;

        //when
        int[] result = testCandidate.twoSum(nums, target);

        //then
        assertThat(result).isEqualTo(new int[]{0,1});
    }
}