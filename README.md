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
2. Run `mvn test` to execute tests

## Usage
- Run specific suite: ` mvn test -Dsurefire.suiteXmlFiles=src/test/resources/xml/hd.xml`
- Generate report: `mvn allure:serve`