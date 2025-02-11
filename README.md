# UI Automation Framework

This is a PicsArt UI Automation Framework.

## Features
- **Java 21** language
- **Selenium 4.28.1** for browser automation
- **TestNG 7.10.2** for test execution and parallel testing
- **Allure 2.29.0** test reporting
- **Owner 1.0.12** for managing configuration properties
- **Maven** for dependency management and build automation
- **Page Object Model (POM)** for maintainable and scalable test scripts

## Getting Started
1. Clone the repository
2. Run `mvn test` to execute tests (Running tests in parallel with the following resolutions: 1024 x 768, 1440 x 900, and 1366 x 768.)

## Usage
- Run specific suite: ` mvn test -Dsurefire.suiteXmlFiles=src/test/resources/xml/hd.xml`
- Run with specific resolution: `mvn test -Dsurefire.suiteXmlFiles=src/test/resources/xml/hd.xml -Dresolution='1920x1080'`
- Generate report: `mvn allure:serve`