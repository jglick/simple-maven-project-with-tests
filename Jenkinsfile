pipeline {
  agent any
  stages {
    stage('clean and build') {
      steps {
        bat 'mvn -B clean'
      }
    }

    stage('Windows Testing') {
      parallel {
        stage('Windows Testing') {
          steps {
            bat 'mvn verify'
          }
        }

        stage('') {
          steps {
            jacoco()
          }
        }

      }
    }

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

  }
  post {
    always {
      junit 'target/surefire-reports/*.xml'
    }

  }
}