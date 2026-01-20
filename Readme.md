# Test Automation Framework

A scalable **Test Automation Framework** built using **Java 11**, **TestNG**, and **Selenium WebDriver**, with seamless integration to **LambdaTest** for executing tests on the cloud. The framework supports **parallel execution**, follows the **Page Object Model (POM)** design pattern, and is designed to be **CI/CD friendly**.

---

## 🚀 Key Features

* Java 11 based automation framework
* TestNG for test orchestration and execution
* Selenium WebDriver for UI automation
* LambdaTest integration for cloud-based cross-browser testing
* Parallel execution support using TestNG
* Page Object Model (POM) architecture
* Data-driven testing using TestNG DataProviders
* Thread-safe WebDriver management using ThreadLocal
* Screenshot capture on test failures
* Robust logging using Log4j2
* Maven Surefire Plugin for execution control
* Supports local and cloud execution modes

---

## 🛠️ Tech Stack

* **Language:** Java 11
* **Test Framework:** TestNG
* **Automation Tool:** Selenium WebDriver
* **Build Tool:** Maven
* **Cloud Testing:** LambdaTest
* **Logging:** Log4j2
* **Design Pattern:** Page Object Model (POM)

---

## 📁 Project Structure

```
├── src/main/java
├── src/test/java
|   ├── com.constants        # Enums and constants (Browser, Environment)
│   ├── com.ui.pages         # Page Object classes
│   ├── com.utility          # Utilities (Browser, Logger, JSON, LambdaTest)
│   ├── com.ui.tests         # Test classes
│   ├── com.ui.listeners     # TestNG listeners (Retry, Screenshot, Reporting)
│   ├── com.ui.dataproviders # Data providers for tests
│
├── testng.xml               # TestNG suite configuration
├── pom.xml                  # Maven dependencies and plugins
└── README.md                # Project documentation
```

---

## ⚙️ Setup & Prerequisites

### Prerequisites

* Java 11 installed
* Maven installed
* Chrome / Edge / Firefox browsers (for local execution)
* LambdaTest account (for cloud execution)

---

## 🔧 Configuration

### LambdaTest Configuration

Set your LambdaTest credentials as environment variables:

```bash
export LT_USERNAME=your_username
export LT_ACCESS_KEY=your_access_key
```

(or set them in your system / CI environment)

---

## ▶️ Running Tests

### 1️⃣ Run tests locally

```bash
mvn test
```

### 2️⃣ Run tests with parameters from the terminal

```bash
mvn test -Dbrowser=chrome -Denvironment=qa -DisLambdaTest=false
```

### 3️⃣ Run tests on LambdaTest (Cloud)

```bash
mvn test -Dbrowser=chrome -DisLambdaTest=true
```

---

## 🔁 Parallel Execution

Parallel execution is enabled using TestNG. You can control parallelism from `testng.xml`:

```xml
<suite name="UI Automation Suite" parallel="methods" thread-count="3">
    <test name="Regression Tests">
        <classes>
            <class name="com.ui.tests.LoginTest" />
        </classes>
    </test>
</suite>
```

The framework uses **ThreadLocal WebDriver** to ensure thread safety during parallel runs.

---

## 📊 Data-Driven Testing

Data-driven tests are implemented using **TestNG DataProviders**.

Example:

```java
@Test(dataProvider = "LoginTestDataProvider",
      dataProviderClass = LoginDataProvider.class)
public void loginTest(User user) {
    // test logic
}
```

---

## 📸 Screenshots on Failure

Screenshots are automatically captured on test failure using a TestNG listener. Screenshots are stored under:

```
/screenshots
```

---

## 🧪 Reporting & Logging

* **Log4j2** is used for logging
* Logs include browser actions, test lifecycle events, and failures
* Designed to be easily extendable to reporting tools like ExtentReports or Allure

---

## 🔄 CI/CD Integration

The framework is CI/CD-ready and can be easily integrated with:

* Jenkins
* GitHub Actions
* GitLab CI

Use Maven Surefire Plugin with system properties to control execution behavior.

---

## 🧠 Best Practices Followed

* Clean separation of test logic and page logic
* No WebDriver initialization inside test classes
* Centralized driver lifecycle management
* Thread-safe execution
* Configurable execution via Maven

---

## 📌 Future Enhancements

* Extent / Allure report integration
* Docker support
* API automation module
* Visual regression testing

---

## 👤 Author

**Your Name**
Keerthana Telaprolu

---

## 📄 License

This project is licensed under the MIT License.
