pipeline {
  agent {
    kubernetes {
      label BUILD_TAG
      containerTemplate {
        name 'maven'
        image 'maven'
        command 'sleep'
        args 'infinity'
      }
    }
  }
  stages {
    stage('Run') {
      steps {
        container('maven') {
          sh 'mvn -B -ntp -Dmaven.test.failure.ignore verify'
        }
      }
    }
  }
  post {
    success {
      junit '**/target/surefire-reports/TEST-*.xml'
    }
  }
}
