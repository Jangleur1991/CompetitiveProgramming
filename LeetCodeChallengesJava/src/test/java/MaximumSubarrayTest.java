import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MaximumSubarrayTest {

    private MaximumSubarray testCandidate;

    @Before
    public void setUp() {
        testCandidate = new MaximumSubarray();
    }

    @Test
    public void testExample1() {
        //given
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        //when
        int result = testCandidate.maxSubArray(nums);

        //then
        assertThat(result).isEqualTo(6);

    }

    @Test
    public void testExample2() {
        //given
        int[] nums = new int[]{1};

        //when
        int result = testCandidate.maxSubArray(nums);

        //then
        assertThat(result).isEqualTo(1);

    }

    @Test
    public void testExample3() {
        //given
        int[] nums = new int[]{5,4,-1,7,8};

        //when
        int result = testCandidate.maxSubArray(nums);

        //then
        assertThat(result).isEqualTo(23);

    }
}