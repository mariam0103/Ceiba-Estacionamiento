pipeline {
	agent {
		label 'Slave_Induccion'
	
	}
	
	options {
		buildDiscarder(logRotator(numToKeepStr: '3'))
		disableConcurrentBuilds()
	
	}
	
	tools {
		jdk 'JDK8_Centos'
		gradle 'Gradle4.5_Centos'
	
	}
	
	stages {
		stage('Checkout Code') {
			steps {
				echo "------------>Checkout<------------"
				checkout([$class: 'GitSCM', branches: [[name: '*/master']],
				doGenerateSubmoduleConfigurations: false, extensions: [], gitTool:
				'Git_Centos', submoduleCfg: [], userRemoteConfigs: [[credentialsId:
				'GitHub_vquintec', url:
				'https://github.com/mariam0103/Ceiba-Estacionamiento']]])
			}
		
		}
		
		stage('Unit Tests') {
			steps {
				echo "------------>Unit Tests<------------"
				sh 'gradle --b ./build.gradle test'

			}
		
		}
		
		stage('Integration Tests') {
			steps {
				echo "INTEGRATION TESTS"
			
			}
		}
		
		stage('Static Code Analysis') {
			steps {
				echo "STATIC CODE ANALYSIS"
				
				withSonarQubeEnv('Sonar') {
					sh "${tool name: 'SonarScanner',type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
				
				}
			}
		
		}
		
		stage('Build') {
			steps {
				echo "------------>Build<------------"
				//Construir sin tarea test que se ejecut� previamente
				sh 'gradle --b ./build.gradle build -x test'

			}
		
		}
	
	
	}
	
	post {
		always {
			echo "This will always run"
		
		}
		
		success {
			echo 'This will run only if successful'
		}
		
		failure {
			echo 'This will run only if failed'
			mail (to: 'maria.molina@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")

		}
		
		unstable {
			echo "run unstable"
		
		}
		
		changed {
			echo "Pipeline state has changed"
		
		}

		
	
	}


}