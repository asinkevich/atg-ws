package tools;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ClassToolsTest {
    @Test
    public void shouldFindClassBySimpleName() throws Exception {
        /*final Package[] packages = Package.getPackages();
        final String className = "SampleClass";

        for (final Package p : packages) {
            final String pack = p.getName();
            final String tentative = pack + "." + className;
            try {
                Class.forName(tentative);
            } catch (final ClassNotFoundException e) {
                continue;
            }
            System.out.println("addsda");
            System.out.println(pack);
            break;
        }*/
        System.out.println(this.getClass().getClassLoader().getParent());
//        assertNotNull("Class wasn't found", ClassTools.findClass("SampleClass"));
    }
}
