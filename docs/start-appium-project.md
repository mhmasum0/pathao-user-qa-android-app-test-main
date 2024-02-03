Table of Contents
=================

* [Start the android app automation project](#start-the-android-app-automation-project)
* [Testing Data](#testing-data)
    * [Configuration](#configuration)
    * [Start the appium server](#start-the-appium-server)
    * [Connect real device](#connect-real-device)
    * [Run the test suite](#run-the-test-suite)
    * [Test report](#test-report)


# Start the android app automation project
Do the followings to start the test project
# Testing Data
- Registered account
- Previous ride history
- Reportable ride history
- Open Restaurants with available food.

## Configuration
Configuration file: [config.properties](../src/test/resources/config.properties)

Please Update following configuration as your need
- **deviceName**
- **mobileNumber**
- **destinationLocation**

## Start the appium server
```bash
appium
```
## Connect real device
Connect the real device to the computer.
To check the device, run the following command.
```bash
adb devices -l
```
## Run the test suite
To run the test suite, Go to the project directory from terminal and execute the following command.
```bash
 mvn clean && mvn test
```

## Test report
Allure report is added to the project
```bash
allure serve allure-results
```