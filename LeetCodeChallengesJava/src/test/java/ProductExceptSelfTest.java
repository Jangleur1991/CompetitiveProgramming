import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ProductExceptSelfTest {

    private ProductExceptSelf testCandidate;


    @Before
    public void setUp() {
        testCandidate = new ProductExceptSelf();
    }

    @Test
    public void testCase1() {

        //given
        int[] nums = new int[]{1,2,3,4};

        //when
        int[] result = testCandidate.productExceptSelf(nums);

        //then
        assertThat(result).isEqualTo(new int[]{24,12,8,6});
    }

    @Test
    public void testCase2() {

        //given
        int[] nums = new int[]{-1,1,0,-3,3};

        //when
        int[] result = testCandidate.productExceptSelf(nums);

        //then
        assertThat(result).isEqualTo(new int[]{0,0,9,0,0});
    }

}