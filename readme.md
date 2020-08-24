
7Shifts Calculator :
![badge](https://github.com/Allianzcortex/7shifts/workflows/7shifts%20CI/badge.svg)

---

Two ways to run the program :

The 1st way :

> 1. download 7ShiftsProject.jar from [release page](https://github.com/Allianzcortex/7shifts/releases)
> 2. run the following command  `java -cp 7ShiftsProject.jar Calculator`

The 2nd way :

> 1. clone the project from Github : 
`git clone https://github.com/Allianzcortex/7shifts.git`
> 2. import the project into any IDE/Editors or run the tests with Maven :
`mvn test`

Besides those two ways, you can also check the CI status in [action page](https://github.com/Allianzcortex/7shifts/actions)


---

Test Cases

|           | skip 1000(maximum) | throw exception when meeting negative input |
|-----------|--------------------|---------------------------------------------|
| addNumber | √                  | √                                           |


|      | null | "" | Input with new line | Input with extra spaces | Multiple Delimiters of arbitrary length |
|------|------|----|---------------------|------------------------|------|
| add1 | √    | √  |                     | √                      | √                                       |
| add2 | √    | √  | √                   | √                      | √                                       |
| add3 | √    | √  | √                   | √                      | √                                       |