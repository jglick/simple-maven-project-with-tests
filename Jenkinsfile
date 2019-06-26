podTemplate(label: BUILD_TAG, containers: [containerTemplate(name: 'maven', image: 'maven', command: 'sleep', args: 'infinity')]) {
  node(BUILD_TAG) {
    checkout scm
    container('maven') {
      sh 'mvn -B -ntp -Dmaven.test.failure.ignore verify'
    }
    junit '**/target/surefire-reports/TEST-*.xml'
  }
}
