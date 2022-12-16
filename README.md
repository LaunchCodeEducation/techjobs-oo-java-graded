# TechJobs, OO Edition Autograded Rubric

For [this assignment](https://education.launchcode.org/java-web-development/assignments/tech-jobs-oo.html), students are asked to refactor a version of the TechJobs Console assignment to make the code object-oriented and to add some unit testing.

## Assignment Requirements

1. Explore the `Employer` Class
2. Complete the `Support` Classes
3. Complete the `Job` Class
4. Use Unit Testing to Verify Parts of the `Job` Class
5. Use TDD to Build the `toString` Method
6. Refactor to `DRY` ("Don't Repeat Yourself") the Support Classes

## Unit Tests
 
The starter code contains 6 unit test classes.  Each class contains tests for each main task of the assignment. This allows students to run tests upon completion of a task before moving on to the next one.
 
`TestTaskTwo` verifies that students completed the `Location`, `CoreCompetency`, and `PositionType` classes.

`TestTaskThree` verifies that students created the `jobClass` and that it uses the other classes correctly to create `job` objects.  

`TestTaskFour` verifies students' unit tests exist within the application.  

`TestTaskFive` tests the unit tests the students created for their custom `ToString` method.  

`TestTaskSix` verifies that students used proper inheritance between `Location`, `Employer`, `CoreCompetency`, `PositionType` and `JobField`.  For example, `Employer` should extend `JobField`.  These tests focus on the existance of the extension rather than the behavior of the extension. 

`AbstractTest` verifies the behavior of the DRY code.  

Submission cannot be graded on unit tests alone.  The tests will provide answers to the code checks below, but should not replace a live demo.  Use the section below as a guide for what to look for before submitting your assignment.
  
### Appearance and Output:
 
Expected output from hardcoded job data:
 
```
ID: 1
Name: Product tester
Employer: ACME
Location: Desert
Position Type: Quality control
Core Competency: Persistence
 
 
ID: 2
Name: Web Developer
Employer: LaunchCode
Location: St. Louis
Position Type: Front-end developer
Core Competency: JavaScript
 
 
ID: 3
Name: Ice cream tester
Employer: Data not available
Location: Home
Position Type: UX
Core Competency: Tasting ability
```
 
Does the hardcoded job data in `Main` print when the application is run?
 
Will an additional job be printed with a unique ID? Create a new
`Job` object in Main. Verify that it gets printed with a unique ID.

## Submitting Your Work

To submit your work please following the [Submission Instructions](https://education.launchcode.org/java-web-development/assignments/hello-world.html#submitting-your-work)
