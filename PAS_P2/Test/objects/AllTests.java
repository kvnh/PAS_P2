package objects;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDoctor.class, TestNurse.class, TestPatient.class,
		TestReceptionist.class })
public class AllTests {

}
