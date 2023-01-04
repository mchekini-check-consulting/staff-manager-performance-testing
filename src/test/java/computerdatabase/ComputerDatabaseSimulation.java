package computerdatabase;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;


public class ComputerDatabaseSimulation extends Simulation {


    ChainBuilder getAllPepites = repeat(3).on(exec(http("Get All Pepites").get("/api/v1/get-all-pepites"))
            .pause(2));


    HttpProtocolBuilder httpProtocol = http.baseUrl("http://localhost:8080");

    ScenarioBuilder getPepites = scenario("Get Pepites").exec(getAllPepites);

    {
        setUp(getPepites.injectOpen(rampUsers(10).during(60))).protocols(httpProtocol);
    }
}
