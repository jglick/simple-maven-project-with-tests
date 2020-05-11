node ('master') {
  checkout scm
  stage ('Build') {
    withMaven(maven: 'M3') {
      if (usUnix()) {
        sh lavel: '', script: 'mvn -Dmaven.test.failure.ignore clean package'
      } else {
        bat label: '', script: 'mvn -Dmaven.test.failure.ignore clean package'
      }
    }
  }
  stage ('Results') {
    junit '**/target/surefire-reports/TEST-*.xml'
    archiveArtifacts 'target/*.jar'
  }
}
