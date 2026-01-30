# 🚀 Java Test Automation Framework

A **Java-based UI Test Automation Framework** built for **scalability, maintainability, and parallel execution**.  
The framework supports both **local execution** and **cloud-based execution using LambdaTest**, and follows industry best practices such as **Page Object Model (POM)**, **data-driven testing**, and **thread-safe WebDriver management**.

![Java](https://img.shields.io/badge/Java-11-orange)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![TestNG](https://img.shields.io/badge/TestNG-Framework-red)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-brightgreen)
![LambdaTest](https://img.shields.io/badge/LambdaTest-Cloud%20Testing-purple)
![CI/CD](https://img.shields.io/badge/CI%2FCD-Ready-success)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

## 📌 Table of Contents

1. Overview  
2. Features  
3. Technologies Used  
4. Prerequisites  
5. Project Structure  
6. Framework Architecture  
7. Setup Instructions  
8. Running Tests  
9. Parallel Execution  
10. Data-Driven Testing  
11. WebDriver Management  
12. Screenshots & Logging  
13. Reports  
14. CI/CD Integration  

---

## 📖 Overview

This framework is designed to automate **web UI test cases** using **Selenium WebDriver** and **TestNG**.  
It is optimized for:

- Parallel execution  
- Cross-browser testing  
- CI/CD pipeline integration  
- Cloud execution via LambdaTest  

The architecture ensures **clean separation of concerns**, **reusability**, and **ease of maintenance**.

---

## ✨ Features

- Java 11 based automation framework  
- Selenium WebDriver for UI automation  
- TestNG for test orchestration  
- Page Object Model (POM) design pattern  
- Thread-safe WebDriver using ThreadLocal  
- Parallel execution using TestNG  
- Data-driven testing using DataProviders  
- Cross-browser support  
- LambdaTest cloud execution  
- Screenshot capture on test failures  
- Logging using Log4j2  
- Maven Surefire Plugin for execution control  
- CI/CD ready design  

---

## 🛠 Technologies Used

- Java 11  
- Selenium WebDriver  
- TestNG  
- Maven  
- LambdaTest  
- Log4j2  
- Page Object Model (POM)  

---

## ⚙️ Prerequisites

Ensure the following are installed:

- **Java 11**  
  `JAVA_HOME` must be configured

- **Maven**  
  Download: https://maven.apache.org/download.cgi

- **Browsers (Local Execution)**  
  Chrome / Edge / Firefox

- **LambdaTest Account** (For cloud execution)

---

## 📁 Project Structure

```
├── src/main/java
├── src/test/java
│   ├── com.constants          # Enums and constants (Browser, Environment)
│   ├── com.ui.pages           # Page Object classes
│   ├── com.utility            # Utilities (Driver, Logger, Config, LambdaTest)
│   ├── com.ui.tests           # Test classes
│   ├── com.ui.listeners       # TestNG listeners (Retry, Screenshot, Reporting)
│   ├── com.ui.dataproviders   # Data providers
│
├── testData                   # External test data
├── testng.xml                 # TestNG suite configuration
├── pom.xml                    # Maven configuration
└── README.md                  # Documentation
```

---

## 🏗 Framework Architecture

```
Test Classes
     ↓
TestNG
     ↓
Driver Factory (ThreadLocal)
     ↓
Browser (Local / LambdaTest)
     ↓
Page Objects
     ↓
Utilities (Logger, Config, Screenshots)
```

---

## 🔧 Setup Instructions

### Clone the Repository

```bash
git clone <your-repository-url>
cd Test-Automation-Framework
```

---

### 🔐 LambdaTest Configuration

Set LambdaTest credentials as environment variables:

```bash
export LT_USERNAME=your_username
export LT_ACCESS_KEY=your_access_key
```

---

## ▶️ Running Tests

### Run Tests Locally

```bash
mvn test
```

### Run Tests with Parameters

```bash
mvn test -Dbrowser=chrome -Denvironment=qa -DisLambdaTest=false
```

### Run Tests on LambdaTest (Cloud)

```bash
mvn test -Dbrowser=chrome -DisLambdaTest=true
```

---

## ⚡ Parallel Execution

Parallel execution is configured using **TestNG** in `testng.xml`:

```xml
<suite name="UI Automation Suite" parallel="methods" thread-count="3">
    <test name="Regression Tests">
        <classes>
            <class name="com.ui.tests.LoginTest"/>
        </classes>
    </test>
</suite>
```

✔ Each test runs in an isolated browser instance  
✔ Thread safety ensured using `ThreadLocal<WebDriver>`

---

## 📊 Data-Driven Testing

Implemented using **TestNG DataProviders**:

```java
@Test(
    dataProvider = "LoginTestDataProvider",
    dataProviderClass = LoginDataProvider.class
)
public void loginTest(User user) {
    // test logic
}
```

---

## 🧵 WebDriver Management

- WebDriver instances are managed using `ThreadLocal<WebDriver>`
- Each test thread receives a dedicated browser instance
- Prevents driver collisions during parallel execution
- Supports both local and LambdaTest remote drivers

---

## 📸 Screenshots & Logging

### Screenshots

- Captured automatically on test failure  
- Stored under `/screenshots`

### Logging

- Implemented using **Log4j2**  
- Logs generated during test execution  
- Stored under `/logs`

---

## 📈 Reports

The framework is easily extensible to support:

- Extent Reports  
- Allure Reports  

---

## 🔄 CI/CD Integration

This framework is **CI/CD ready** and integrates seamlessly with:

- Jenkins  
- GitHub Actions  
- GitLab CI  

Execution behavior is controlled via **Maven Surefire Plugin** and system properties.

## 👤 Author

Keerthana Telaprolu 
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Profile-blue?logo=linkedin)](https://www.linkedin.com/in/keerthanatelaprolu/)
