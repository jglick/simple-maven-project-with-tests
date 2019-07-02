node('master') {
  checkout scm
  stage('Build') {
    withMaven(maven: 'M3') {
      if(isUnix()) {
        sh 'mvn -Dmaven.test.failure.ignore clean package'
      }
      else {
        bat 'mvn -Dmaven.test.failure.ignore clean package'
      }
    }
  }
  stage('Result') {
    junit '**/target/surefire-report/TEST-*.xml'
    archive 'target/*.jar'
  }
}       
