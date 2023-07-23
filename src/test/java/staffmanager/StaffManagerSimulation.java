package staffmanager;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;


public class StaffManagerSimulation extends Simulation {


    ChainBuilder getAllMissions = repeat(1).on(exec(http("Récupération des missions").get("/api/v1/mission"))
            .pause(2));


    HttpProtocolBuilder httpProtocol = http.baseUrl("http://check-consulting.net:8080");

    ScenarioBuilder getMissions = scenario("Scenario : Tests de performances des Endpoints de Staff-Manager-API").exec(getAllMissions);

    {
        setUp(getMissions.injectOpen(rampUsers(50).during(5))).protocols(httpProtocol);
    }
}
