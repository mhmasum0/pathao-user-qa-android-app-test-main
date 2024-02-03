Table of Contents
=================

* [Run the automation tests](#run-the-automation-tests)
    * [Requirements](#requirements)
    * [install Appium](#install-appium)
    * [install and update driver](#install-and-update-driver)
    * [Setup Android environment](#setup-android-environment)
    * [Setup JAVA_HOME](#setup-java_home)
    * [Check requirements with a package](#check-requirements-with-a-package)
    * [Open Emulator from command](#open-emulator-from-command)
    * [Helper tools](#helper-tools)

# Run the automation tests

Documentation: [pathao-user-qa-android-automation](start-appium-project.md)

## Requirements
- **OS:** macOS/ Linux/Windows
- **Node.js version:** >= 16
- **NPM version:** >= 8
- **Appium driver:** uiautomator2
- **Android Environment**
- **JAVA version:** 11
- **Real Device:** Real device connected woth developer options enabled

## install Appium
`npm i -g appium@next`

## install and update driver
**_Article on appium commands_**: https://www.lambdatest.com/learning-hub/appium-commands-cheat-sheet
```bash
appium driver list
appium driver install uiautomator2
appium driver update uiautomator2
appium driver install xcuitest
```

## Setup Android environment
Set environment variable with your bash profile
```bash
export ANDROID_HOME=$HOME/Library/Android/sdk
export PATH=$ANDROID_HOME/platform-tools.$PATH
export PATH=$ANDROID_HOME/tools:$PATH
export PATH=$ANDROID_HOME/tools/bin:$PATH
export PATH=$ANDROID_HOME/emulator:$PATH
```

## Setup JAVA_HOME
```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 11)
```

## Check requirements with a package
```bash
npm install -g appium-doctor
appium-doctor --android
```

## Open Emulator from command
```bash
emulator -list-avds
emulator -avd avd-name
```

## Install Allure for test report generation
```bash
 brew install allure
```

## Helper tools
```bash
npm install -g appium-installer
```
