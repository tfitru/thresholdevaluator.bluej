import org.junit.Test;
import org.junit.Assert;

public class InstancedThresholdEvaluatorTest {
    // given
    @Test
    public void testSetThreshold() {
        for (Integer thresholdToBeSet : new Integer[]{0, 5, 10, Integer.MAX_VALUE, Integer.MIN_VALUE}) {
            int expected = thresholdToBeSet;
            InstancedThresholdEvaluator thresholdEvaluator = new InstancedThresholdEvaluator();

            // when
            thresholdEvaluator.setThreshold(thresholdToBeSet);
            int actual = thresholdEvaluator.getThreshold();

            // then
            Assert.assertEquals(expected, actual);
        }
    }

    // given
    @Test
    public void testIsThresholdExceedingTrue(int thresholdToBeSet) {
        for (Integer thresholdTobeSet : new Integer[]{0, 5, 10, Integer.MIN_VALUE}) {
            testIsThresholdExceeding(thresholdToBeSet, 1, false);
        }
    }

    // given
    @Test
    public void testIsThresholdExceedingFalse() {
        for (Integer thresholdToBeSet : new Integer[]{0, 5, 10, Integer.MAX_VALUE}) {
            testIsThresholdExceeding(thresholdToBeSet, -1, true);
        }
    }

    // given
    private void testIsThresholdExceeding(int thresholdToBeSet, int thresholdOffset, boolean expected) {
        Integer valueToCompareAgainstThreshold = thresholdToBeSet + thresholdOffset;
        InstancedThresholdEvaluator thresholdEvaluator = new InstancedThresholdEvaluator();
        thresholdEvaluator.setThreshold(thresholdToBeSet);

        // when
        boolean actual = thresholdEvaluator.isThresholdExceeding(valueToCompareAgainstThreshold);

        // then
        Assert.assertEquals(expected, actual);
    }
}
