# ft-cucumber-skeleton

## Pre-requirement
* Java 8.121
* Xcode 8.3.2 and iOS Simulator 10.3
* Appium-Desktop : 1.2.7 (http://www.fanaticaltest.com/appium-desktop-tutorial-and-setup/)
* Appium-Server : 1.7.1 (embeded in Appium-Desktop 1.2.7)
* com.fanaticaltest:ft-appium:0.1.1
* io.cucumber:cucumber-java:2.1.0 and io.cucumber:cucumber-junit:2.1.0


## Getting started
* Update the build.gradle by changing the glue 
`com.fanaticaltest.fttestmobilefactorydemo.cucumber` => with your package name where the cucumber are implemented.
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
					//'--tags', '@Id=002',
					'--glue', 'com.fanaticaltest.fttestmobilefactorydemo.cucumber', 'src/test/resources']
		}
	}
}
```

## Running
```
gradle cucumber
```

To run specific tag just uncomment the tags line in the cucumber task in `build.gradle` : `'--tags', '@Id=002'`.

