pipeline {
	agent any

	tools {
		maven "maven_354"
		jdk "java_8"
	}

	stages {
		stage("Checkout") {
			steps {
                git url: 'https://github.com/obendi/jenkins.git'
            }
		}
		stage("Maven Compile") {
			steps {
                sh 'mvn compile -DskipTests'
            }
		}
		stage("SonarQube Analysis") {
			steps {
				withSonarQubeEnv('Sonar') {
					sh 'mvn clean package sonar:sonar'
				}
			}
		}
	}
}
