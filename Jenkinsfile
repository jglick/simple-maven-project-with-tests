pipeline {
  agent any
  stages {
    stage('clean and build') {
      steps {
        bat 'mvn -B clean'
      }
    }

    stage('Windows Testing') {
      steps {
        bat 'mvn test'
      }
    }

    stage('deploy package & generate reports') {
      parallel {
        stage('create package') {
          when {
            branch 'master'
          }
          post {
            success {
              echo 'Now Archiving...'
              archiveArtifacts 'target/*.jar'
            }

          }
          steps {
            bat 'mvn package verify'
          }
        }

        stage('Record Jacoco') {
          steps {
            jacoco()
          }
        }
        stage('Record Junit') {
          steps {
            junit 'target/surefire-reports/*.xml'
          }
        }

      }
    }
    stage('Clean environment') {
        steps {
            bat 'mvn clean'
        }
    }
  }

}