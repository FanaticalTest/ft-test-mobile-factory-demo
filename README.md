# ft-test-mobile-factory-demo

## Requirements
* Java 8.121
* Mac (Sierra 10.12)
* Xcode 8.3.2 and iOS Simulator 10.3
* Appium Desktop 1.0.1 using Appium Server 1.6.4

## Networking
`docker.sak` is a domain configure in hosts file and response as the ip of the developing and Appium Server (via Appium Desktop)

## Start to test
* Ensure your Appium Desktop is running.
* Ensure the version of Appium Server Version in Appium Desktop is aligned with the one in Desired Capabilities "appiumVersion"
* Type the following command:
```
mvn clean verify -Dtest=CukesRunner > log.txt
mvn clean verify -Dtest=CukesRunner -Dcucumber.options="-t @Project=MobileApp" > log.txt
mvn clean verify -Dtest=CukesRunner -Dcucumber.options="-t @Feature=CalculateSum" > log.txt
mvn clean verify -Dtest=CukesRunner -Dcucumber.options="-t @Id=B.1.1" > log.txt
```

## Reference
* https://github.com/appium/sample-code/tree/master/sample-code/examples/java/generic