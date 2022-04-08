import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ContainsDuplicateTest {

    private ContainsDuplicate testCandidate;

    @Before
    public void setUp() {
        testCandidate = new ContainsDuplicate();
    }

    @Test
    public void testExample1() {
        //given
        int[] nums = new int[]{1,2,3,1};
        //when
        boolean result = testCandidate.containsDuplicate(nums);
        //then
        assertThat(result).isTrue();
    }

    @Test
    public void testExample2() {
        //given
        int[] nums = new int[]{1,2,3,4};
        //when
        boolean result = testCandidate.containsDuplicate(nums);
        //then
        assertThat(result).isFalse();
    }

    @Test
    public void testExample3() {
        //given
        int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        //when
        boolean result = testCandidate.containsDuplicate(nums);
        //then
        assertThat(result).isTrue();
    }

}