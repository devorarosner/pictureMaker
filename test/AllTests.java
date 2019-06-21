//Devora Rosner 206672545 
//Hanna Weissberg 318796398
package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testCircle.class, testPlain.class, testPoint3D.class, testTriangle.class, testVector.class, testCamera.class,testLight.class})
public class AllTests {

}
