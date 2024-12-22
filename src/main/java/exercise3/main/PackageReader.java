package exercise3.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class PackageReader {

    public static PackageNode getPackageTree(String filePath) throws IOException {
        Map<String, List<String>> packages = readPackageFile(filePath);
        return buildPackageTree(packages);
    }

    public static String stringifyPackageTree(String filePath) throws IOException {
        return getPackageTree(filePath).stringifyDependencies(0);
    }

    private static PackageNode buildPackageTree(Map<String, List<String>> packages) {
        Map<String, PackageNode> packageNodes = new HashMap<>();
        PackageNode root = new PackageNode("root");

        // Create nodes for all packages and add them as root dependency
        packages.keySet().forEach(
                key -> {
                    PackageNode node = new PackageNode(key);
                    packageNodes.put(key, node);
                    root.addDependencies(node);
                }
        );

        // Add dependencies for each package
        packages.forEach((key, dependencies) -> {
            PackageNode node = packageNodes.get(key);

            dependencies.forEach(dependency -> {
                PackageNode dependencyNode = packageNodes.get(dependency);
                node.addDependencies(dependencyNode);
            });
        });
        return root;
    }

    private static Map<String, List<String>> readPackageFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(filePath));


        Map<String, List<String>> packages = new HashMap<>();
        // Iterate over each package, aka 'key' in the json
        rootNode.fieldNames().forEachRemaining(key -> {
            JsonNode valuesNode = rootNode.get(key);
            List<String> dependencies = new ArrayList<>();

            if (valuesNode.isArray()) {
                valuesNode.forEach(value -> dependencies.add(value.asText()));
            }

            packages.put(key, dependencies);
        });
        return packages;
    }
}