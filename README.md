# Berlin Clock Kata in Java

Create a program for converting the time between a regular digital time and a textual representation of the Berlin Clock.

<u>Berlin Clock Representation</u>

The top lamp blinks to show seconds- it is illuminated on even seconds and off on odd seconds.

The next two rows represent hours. The upper row represents 5 hour blocks and is made up of 4 red lamps. The lower row represents 1 hour blocks and is also made up of 4 red lamps.

The final two rows represent the minutes. The upper row represents 5 minute blocks, and is made up of 11 lamps- every third lamp is red, the rest are yellow. The bottom row represents 1 minute blocks, and is made up of 4 yellow lamps.

### Prerequisite for this application
1. JDK 1.8\
2. Maven 3.x


#### Set up Application
1. Clone the repository https://github.com/rsgiridaran/MyKata.git
2. Add as maven project in your IDE
3. Select project sdk as JDK1.8
4. Add as maven project

#### Run Test cases
**Run from command prompt or Terminal**
1. Clone the project
2. Open the command prompt / terminal from project directory
3. Run `mvn clean test`

**Run from IDE**
1. Clone from Git repository and add as maven project
2. Run as Maven test

#### Code coverage and Mutation coverage Report
Application uses pitest dependency to check code coverage and mutation testing coverage. follow instruction below in order to generate report
1. Run `mvn pitest:mutationCoverage`
2. Go to target -> pit-reports -> directory in the name of YYYYMMddHHmm -> index.html
3. Code coverage and mutation coverage report will be displayed as summary and package wise report

### Run Application
From IDE, launch the Main class: BerlinClockApplication.java with arguments as digital time in 24 hour format ie 14:32:34. . It will accept time in the format of HH:mm:ss.

if your entered time is 18:43:56 then output will be YRRR0RRR0YYRYYRYY000YYY0
