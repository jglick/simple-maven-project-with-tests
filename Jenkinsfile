pipeline {
  agent any
  stages {
    stage('Test') {
      parallel {
        stage('Test') {
          steps {
            bat 'mvn -B clean verify'
          }
        }

        stage('') {
          steps {
            sh 'mvn -B clean verify'
          }
        }

      }
    }

    stage('Build') {
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
        bat 'mvn -B clean verify package'
      }
    }

  }
  post {
    always {
      junit 'target/surefire-reports/*.xml'
    }

  }
}