# Coding Exercises
This repository contains solutions to the CERN-provided coding exercises. Each solution has been implemented with readability, maintainability, and real-world applicability in mind.

## Table of Contents

- [Introduction](#introduction)
- [Exercise 1: Detecting Duplicates](#exercise-1-detecting-duplicates)
- [Exercise 2: Spreadsheet Engine](#exercise-2-spreadsheet-engine)
- [Exercise 3: Dependency Graph](#exercise-3-dependency-graph)


## Introduction
This project includes solutions for the three exercises provided by CERN:
1. Detecting duplicates in a list.
2. Implementing a simple spreadsheet engine.
3. Building a Java library to process JSON-based dependency graphs.

The exercises have been split up in their own packages, resulting in the following code folder structure:
```text
- src.main.java
    - exercise1
        - main
        - tests
    - exercise2
        - main
        - tests
    - exercise3
        - main
        - tests
```
Each `tests` package contains unit tests regarding the implemented code in the related `main` package. 
No other test types have introduced, e.g. Cucumber tests.

Regarding code style/documentation:
- Normally I would follow the style of the project, 
e.g. because the `QuestionTest` contains JUnit4, this is what I have continued using i.o. 
switching to JUnit5 (which might be interesting for a separate task/story).
- Since there was not a lot of style to follow, 
I only added comments on selected pieces of code, 
where I deemed additional context valuable.
- I see now my commit messages are rather poor. Ideally they would have been more clear and prefixed with `exercise 2:` or similar.

## Exercise 1: Detecting Duplicates
The `getDuplicatesInOriginalOrder` method identifies duplicate elements in a list and returns them in the order they first appeared.

#### Key Features:
- Returns duplicates in their first appearance order.
- No third-party libraries used except for testing.

#### How To Run
The  `getDuplicatesInOriginalOrder` method is tested in the `DeduplicatorTest.java`.
More tests can easily be added, to further test the method.

#### Example Input:
```python
["b", "a", "c", "c", "e", "a", "c", "d", "c", "d"]
```

#### Expected Output:
```python
["a", "c", "d"]
```

## Exercise 2: Spreadsheet Engine
A simple spreadsheet engine, implemented with a Test-Driven Development (TDD) approach.

#### Features:
- The exporter has been implemented using the Strategy Pattern. Allowing for easy extension of SpreadSheetExporters

### Missing Features
- Tests on `office.java`

#### How to Run
Compile and execute the `QuestionTest.java` tests to validate the solution.

To showcase the TDD approach, each test function has its own commit in this PR https://github.com/nenanen/coding_exercises/pull/1.
In follow-up commits to the main branch, some additional tests/comments where places.

## Exercise 3: Dependency Graph
A Java library for processing JSON-based package dependencies and constructing a full dependency graph.

### Features
- Reads a JSON file containing package dependencies.
- Constructs a tree structure of dependencies using our custom `PackageNode`.
- Exposes methods for:
    - Returning a graph object
    - Producing a "pretty" string representation of the graph

### Missing Features
- Cycle detection in dependencies.

### How to Run
The `PackageReader` can be tested through the `PackageReaderTest.java` file.
Please add a test as well as the related json file.

#### Example Input:
```json
{
    "pkg1": ["pkg2", "pkg3"],
    "pkg2": ["pkg3"],
    "pkg3": []
}
```

#### Example Output:
```
- pkg1
    - pkg2
        - pkg3
    - pkg3
- pkg2
    - pkg3
- pkg3
```


