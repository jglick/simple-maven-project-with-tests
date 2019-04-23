node ('master') {
	checkout scm
		stage('Build') {

				if (isUnix()) {
					sh 'echo "Building in shell"'
				}
				else {
					bat 'echo "Building in windows"'
				}

		}
		stage('Results') {
				if (isUnix()) {
					sh 'echo "Result in shell"'
				}
				else {
					bat 'echo "Result in windows"'
				}
		}
}
