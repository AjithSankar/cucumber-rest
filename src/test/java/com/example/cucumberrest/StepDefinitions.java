package com.example.cucumberrest;

import com.example.cucumberrest.test.Belly;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StepDefinitions {
    @Given("I have {int} cukes in my belly")
    public void I_have_cukes_in_my_belly(int cukes) {
        Belly belly = new Belly();
        belly.eat(cukes);
    }

    @When("I wait {int} hour")
    public void wait( int hour) {
        log.info("I wait " + hour + " hour");
    }

    @Then("my belly should growl")
    public void growl() {
        log.info("belly growl");
    }
}
