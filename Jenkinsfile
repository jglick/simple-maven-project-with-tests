node {
  tools {
    // Install the Maven version configured as "M3" and add it to the path.
    maven "M3"
  }
  checkout scm
  sh 'mvn -B -ntp -Dmaven.test.failure.ignore verify'
  junit '**/target/surefire-reports/TEST-*.xml'
}


