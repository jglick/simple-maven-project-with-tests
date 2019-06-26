podTemplate(label: BUILD_TAG, containers: [containerTemplate(name: 'maven', image: 'maven:3.6.1-jdk-8', command: 'sleep', args: 'infinity')]) {
  node(BUILD_TAG) {
    checkout scm
    container('maven') {
      sh 'mvn -B -ntp -Dmaven.test.failure.ignore verify && sleep 30'
    }
    junit '**/target/surefire-reports/TEST-*.xml'
  }
}
