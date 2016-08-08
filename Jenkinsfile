

stage 'build'
	node('docker-cloud') {
	checkout scm
	docker.image('kmadel/maven:3.3.3-jdk-8').inside('-v /data:/data') {
			sh 'mvn -Dmaven.repo.local=/data/mvn/repo clean package'
	}
	stash name: 'pom', includes: 'pom.xml, src, target'
}


checkpoint 'Build Complete'
stage 'Quality Analysis'
	node('docker-cloud') {
		try {
			unstash 'pom'

			docker.image('kmadel/maven:3.3.3-jdk-8').inside('-v /data:/data') {
			              sh 'mvn -Dmaven.repo.local=/data/mvn/repo verify'
			          }
			//step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml', healthScaleFactor: 1.0])
		} catch (x) {
		  currentBuild.result = "failed"
		  throw x
		}
	}



checkpoint 'Quality Analysis Complete'


docker.withServer('tcp://52.27.249.236:3376', 'beedemo-swarm-cert'){
	stage 'Build Docker Image'
		node('docker-cloud') {
			unstash 'pom'
			def sampleWebAppImage
			dir('target') {
					sampleWebAppImage = docker.build "issc29/sampleWebApp:1.0"
			}
		}

	stage 'Deploy'
	      try{
	        sh "docker stop beedemo-swarm-master/sampleWebApp"
	        sh "docker rm beedemo-swarm-master/sampleWebApp"
	      } catch (Exception _) {
	         echo "no container to stop"
	      }

				container = sampleWebAppImage.run("--name sampleWebApp -p 1234:1234")

}


stage 'approval'
	input 'Do you approve deployment to production?'
	echo 'modified'

stage 'production'
	echo 'mvn cargo:deploy'
