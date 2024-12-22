package exercise3.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PackageNode {
    private final List<PackageNode> dependencies;
    public String name;

    PackageNode(String name) {
        this.name = name;
        dependencies = new ArrayList<>();
    }

    public void addDependencies(PackageNode packageNode) {
        dependencies.add(packageNode);
    }

    public String stringifyDependencies(int indent) {
        return dependencies.stream()
                .map(dependency -> " ".repeat(indent) + "- " + dependency.name + "\n" + dependency.stringifyDependencies(indent + 4))
                .collect(Collectors.joining());
    }
}