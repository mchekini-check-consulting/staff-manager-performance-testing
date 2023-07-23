node("ci-node") {

    stage("checkout") {
        checkout scmGit(branches: [[name: '*/develop']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mchekini-check-consulting/staff-manager-performance-testing.git']])
    }


    stage("Performance Testing") {
        sh "chmod 777 mvnw"
        sh "./mvnw gatling:test"
    }

    stage("Archive Report") {
        gatlingArchive()
    }


}