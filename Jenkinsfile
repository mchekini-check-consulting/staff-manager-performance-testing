node("ci-node") {

    stage("checkout") {

    }


    stage("Test de performances") {
        sh "chmod 777 mvnw"
        sh "./mvnw gatling:test"
    }

    stage("Generate Report") {
        sh "echo generate report"
    }


}