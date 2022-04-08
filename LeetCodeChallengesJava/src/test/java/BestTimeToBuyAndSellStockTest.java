import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BestTimeToBuyAndSellStockTest {

    private BestTimeToBuyAndSellStock testCandidate;

    @Before
    public void setUp() {
        testCandidate = new BestTimeToBuyAndSellStock();
    }


    @Test
    public void testExample1() {
        //given
        int[] prices = new int[]{7,1,5,3,6,4};

        //when
        int result = testCandidate.maxProfit(prices);

        //then

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void testExample2() {
        //given
        int[] prices = new int[]{7,6,4,3,1};

        //when
        int result = testCandidate.maxProfit(prices);

        //then

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testExample3() {
        //given
        int[] prices = new int[]{2,4,1,5};

        //when
        int result = testCandidate.maxProfit(prices);

        //then

        assertThat(result).isEqualTo(4);
    }
}