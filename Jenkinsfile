node ('master') {
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
  stage('Results') {
    junit '**/target/surefire-reports/TEST-*.xml'
    archiveArtifacts 'target/*.jar'
  }
  
  stage('SSH transfer') {
   script {
    sshPublisher(
     continueOnError: false, failOnError: true,
     publishers: [
      sshPublisherDesc(
       configName: "${env.SSH_CONFIG_NAME}",
       verbose: true,
       transfers: [
        sshTransfer(
			execCommand: "Run commands before copy?"
		),
		sshTransfer(
			sourceFiles:"${path_to_file}/${file_name}, ${path_to_file}/${file_name}",
			removePrefix: "${path_to_file}",
			remoteDirectory: "${remote_dir_path}",
			execCommand: "run commands after copy?"
		)
       ])
     ])
   }
  }
  
  
  stage (‘Deploy’) {
	sh ‘ssh root@172.17.201.150 rm -rf /root/nems2/jenkins_deploy_test/dist/’
	sh ‘ssh root@172.17.201.150 mkdir -p /root/nems2/jenkins_deploy_test/’
	sh ‘scp -r dist root@172.17.201.150:/root/nems2/jenkins_deploy_test/disk/’
	//sh ‘ssh root@172.17.201.150 “rm -rf /var/www/example.com/dist/ && mv /var/www/temp_deploy/dist/ /var/www/example.com/”’
  }
}
