import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ExactStopsTripCounterTest.class, GraphNodeTest.class, MaximumStopsTripCounterTest.class,
		RouteDistanceHelperTest.class, TripDistanceCalculatorTest.class, TripHelperTest.class,
		UniqueTripsCalculatorTest.class })
public class AllTests {

}
