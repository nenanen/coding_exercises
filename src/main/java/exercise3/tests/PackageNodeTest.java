package exercise3.tests;

import exercise3.main.PackageNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PackageNodeTest {

    @Test
    public void handlesNodeWithoutDependencies() {
        PackageNode node = new PackageNode("root");
        String actual = node.stringifyDependencies(0);
        String expected = "";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handlesSingleDependency() {
        PackageNode root = new PackageNode("root");
        PackageNode dependency = new PackageNode("dependency1");

        root.addDependencies(dependency);

        String actual = root.stringifyDependencies(0);
        String expected = """
                - dependency1
                """;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handlesMultipleDependencies() {
        PackageNode root = new PackageNode("root");
        PackageNode dependency1 = new PackageNode("dependency1");
        PackageNode dependency2 = new PackageNode("dependency2");

        root.addDependencies(dependency1);
        root.addDependencies(dependency2);

        String actual = root.stringifyDependencies(0);
        String expected = """
                - dependency1
                - dependency2
                """;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handlesNestedDependencies() {
        PackageNode root = new PackageNode("root");
        PackageNode dependency1 = new PackageNode("dependency1");
        PackageNode dependency2 = new PackageNode("dependency2");
        PackageNode subDependency3 = new PackageNode("subDependency3");

        root.addDependencies(dependency1);
        dependency1.addDependencies(subDependency3);
        root.addDependencies(dependency2);

        String actual = root.stringifyDependencies(0);
        String expected = """
                - dependency1
                    - subDependency3
                - dependency2
                """;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handlesDeeplyNestedDependencies() {
        PackageNode root = new PackageNode("root");
        PackageNode dependency1 = new PackageNode("dependency1");
        PackageNode dependency2 = new PackageNode("dependency2");
        PackageNode dependency3 = new PackageNode("dependency3");

        root.addDependencies(dependency1);
        dependency1.addDependencies(dependency2);
        dependency2.addDependencies(dependency3);

        String actual = root.stringifyDependencies(0);
        String expected = """
                - dependency1
                    - dependency2
                        - dependency3
                """;
        Assert.assertEquals(expected, actual);
    }
}
