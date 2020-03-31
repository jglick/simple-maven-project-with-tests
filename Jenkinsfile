pipeline {
  agent any
  stages {
    stage('Windows Testing') {
      steps {
        bat 'mvn -B clean verify'
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