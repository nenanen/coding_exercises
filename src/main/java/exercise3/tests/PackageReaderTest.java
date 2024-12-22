package exercise3.tests;

import exercise3.main.PackageReader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class PackageReaderTest {

    @Test
    public void stringifiesProvidedExample() throws IOException {
        String actual = PackageReader.stringifyPackageTree("src/main/java/exercise3/packagesProvidedExample.json");

        String expected = """
                - pkg1
                    - pkg2
                        - pkg3
                    - pkg3
                - pkg2
                    - pkg3
                - pkg3
                """;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stringifiesHighLevelPackages() throws IOException {
        String actual = PackageReader.stringifyPackageTree("src/main/java/exercise3/packagesOnlyHighLevel.json");

        String expected = """
                - pkg1
                - pkg2
                - pkg3
                """;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stringifiesSimpleOrdering() throws IOException {
        String actual = PackageReader.stringifyPackageTree("src/main/java/exercise3/packagesSimpleOrdering.json");

        String expected = """
                - pkg1
                - pkg2
                    - pkg1
                - pkg3
                    - pkg1
                    - pkg2
                        - pkg1
                - pkg4
                    - pkg1
                    - pkg2
                        - pkg1
                    - pkg3
                        - pkg1
                        - pkg2
                            - pkg1
                """;
        Assert.assertEquals(expected, actual);
    }
}