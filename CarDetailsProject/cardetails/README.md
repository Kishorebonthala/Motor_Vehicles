# Motor vehicles is a project that retrieves car details stored in files and compares them against vechicle registration website using Selenium, Cucumber and Spring framework

## Clone the following repository from git
`git clone https://github.com/Kishorebonthala/Motor_Vehicles.git Motor_Vehicles
`

## Pre-Requisites to run tests, following tools needs to be installed
`Maven
Jdk8
Firefox (v59.0.2)
`

# Change dependencies
`update the csv files location based on the folder strucutre on the machine you are running in feature and service file
update the driver location based on the machine you are running
`

## To run tests, execute the following commands
`cd cardetails
mvn clean install
`

## To enable full debug logging, execute the following commands
`cd cardetails
mvn clean install -X
`

## If any problems, correct them and resume the build with following command
`cd cardetails
 mvn <goals> -rf :scenarios
 `
