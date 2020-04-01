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
        bat 'mvn verify'
      }
    }

    stage('create package') {
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
            bat 'mvn package'
          }
        }

        stage('Record Jacoco') {
          steps {
            jacoco()
          }
        }

      }
    }

  }
  post {
    always {
      junit 'target/surefire-reports/*.xml'
    }

  }
}