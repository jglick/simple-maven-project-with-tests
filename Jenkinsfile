pipeline {
    agent any
    stages {
	    stage('Test') {
	        steps {
	            bat 'mvn -B clean verify'
	        }
	    }

        // Only build master branch
        stage('Build') {
            when {
                branch 'master'
            }
            steps {
                bat 'mvn -B clean verify package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: 'target/*.jar'
                }
            }

        }
    }
    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }

		
// 		stage('Deploy to Staging'){
// 			steps {
// 				build job: 'Deploy-to-staging'
// 			}
// 		}
//
// 		stage ('Deploy to Production'){
//             steps{
//                 timeout(time:5, unit:'DAYS'){
//                     input message:'Approve PRODUCTION Deployment?'
//                 }
//
//                 build job: 'Deploy-to-Prod'
//             }
//
//             post {
//                 success {
//                     echo 'Code deployed to Production.'
//                 }
//
//                 failure {
//                     echo ' Deployment failed.'
//                 }
//             }
//         }
		
}
