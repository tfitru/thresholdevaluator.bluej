import org.junit.Assert;
import org.junit.Test;

public class StaticThresholdEvaluatorTest {
    // given
    @Test
    public void testIsThresholdExceedingTrue() {
        for (Integer thresholdToBeSet : new Integer[]{0, 5, 10, Integer.MIN_VALUE}) {

            Integer valueToCompareAgainstThreshold = thresholdToBeSet + 1;

            // when
            boolean actual = StaticThresholdEvaluator.isThresholdExceeding(thresholdToBeSet, valueToCompareAgainstThreshold);

            // then
            Assert.assertTrue(actual);
        }
    }

    // given
    @Test
    public void testIsThresholdExceedingFalse() {
        for (Integer thresholdToBeSet : new Integer[]{0, 5, 10, Integer.MAX_VALUE}) {
            Integer valueToCompareAgainstThreshold = thresholdToBeSet - 1;

            // when
            boolean actual = StaticThresholdEvaluator.isThresholdExceeding(thresholdToBeSet, valueToCompareAgainstThreshold);

            // then
            Assert.assertFalse(actual);
        }
    }
}