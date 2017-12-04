# ft-cucumber-skeleton

## Getting started
* Update the build.gradle by changing the glue 
`com.fanaticaltest.ftcucumberskeleton.cucumber` => with your package name where the cucumber are implemented.
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
					'--glue', 'com.fanaticaltest.ftcucumberskeleton.cucumber', 'src/test/resources']
		}
	}
}
```

## Running
```
gradle cucumber
```