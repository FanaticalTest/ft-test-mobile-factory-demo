# ft-test-mobile-factory-demo

## Pre-requirement
* Java 8.121
* Xcode 9.2 with iOS 10.3.1 Simulator for TestApp8.0.app.zip (https://github.com/FanaticalTest/ft-appium#xcode)
* Appium-Desktop : 1.2.7 (http://www.fanaticaltest.com/appium-desktop-tutorial-and-setup/)
* Appium-Server : 1.7.1 (embeded in Appium-Desktop 1.2.7)
* com.fanaticaltest:ft-appium:0.1.5
* io.cucumber:cucumber-java:2.1.0 and io.cucumber:cucumber-junit:2.1.0
* Support Real device : iOS and Android


## Getting started
* Ensure to have Appium server running like using Appium Desktop.
* Ensure the `build.gradle` is properly set and the `application.properties` correctly set.
* If you are running iOS real device ensure to have porperly set `licences.properties`
* Update the build.gradle by changing the glue 
`com.fanaticaltest.fttestmobilefactorydemo.cucumber` => with your package name where the cucumber are implemented.
For convenience we move the device tag as a project property
```
task cucumber() {
	dependsOn assemble, compileTestJava
	doLast {
		javaexec {
			main = "cucumber.api.cli.Main"
			classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
			args = ['--plugin', 'pretty',
					'--plugin', 'html:build/cucumber-html-report',
					'--plugin', 'json:build/cucumber.json',
					'--tags', "@Device=${device}",
					'--glue', 'com.fanaticaltest.fttestmobilefactorydemo.cucumber', 'src/test/resources']
		}
	}
}
```


## Running
```
export APPIUM_SERVER_URL=http://127.0.0.1:4723/wd/hub
gradle cucumber -Pdevice=IosSimulator -PAPPIUM_SERVER_URL=http://127.0.0.1:4723/wd/hub
gradle cucumber -Pdevice=AndroidRealDevice -PAPPIUM_SERVER_URL=http://127.0.0.1:4723/wd/hub
gradle cucumber -Pdevice=IosRealDevice -PAPPIUM_SERVER_URL=http://127.0.0.1:4723/wd/hub
```

To run specific tag just uncomment the tags line in the cucumber task in `build.gradle` : `'--tags', '@Id=002'`.

### Running a subset of scenarios
```
cucumber --tags @billing            # Runs both scenarios
cucumber --tags @important          # Runs the first scenario
cucumber --tags ~@important         # Runs the second scenario (Scenarios without @important)

cucumber --tags @billing --tags @important    # Runs the first scenario (Scenarios with @important AND @billing)
cucumber --tags @billing,@important           # Runs both scenarios (Scenarios with @important OR @billing)
```

## Jenkins in Docker running Mac host
If you are running a Jenkins in a docker hosted in a mac, you need to be careful with some elements:
* When the jenkins container tries to connect to the docker host with the Appium-Desktop you should use `http://docker.for.mac.localhost:4723/wd/hub` as `appiumServer.appiumServerUrl` property
* In your Appium server you need to set `executeAsync Callback Host` with the value `docker.for.mac.localhost` otherwise it will use localhost and it won't work.
