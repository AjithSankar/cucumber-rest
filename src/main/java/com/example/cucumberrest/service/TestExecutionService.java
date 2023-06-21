package com.example.cucumberrest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
@Slf4j
public class TestExecutionService {

    public String executeTests() {
        try {
            log.info("calling TestExecutionService.executeTests()");
            // If running on Windows, use `cmd.exe /c mvn test` command
            // If running on Linux, use `mvn test` command
            String cmd = "cmd.exe /c mvn test";  // Windows
            // Execute the `mvn test` command programmatically using ProcessBuilder
            log.info("executing command: " + cmd);
            Process process = Runtime.getRuntime().exec(cmd);

            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the process to finish and get the exit code
            int exitCode = process.waitFor();

            // Handle the test execution results based on the exit code
            if (exitCode == 0) {
                log.info("Test execution completed successfully");
                log.info("Printing output ********************************************\n");
                log.info(output.toString());
                log.info("End of output ***********************************************\n");
                // Tests passed
                return "Tests executed successfully";
            } else {
                // Tests failed or encountered errors
                String errorMessage = "Test execution failed. Exit code: " + exitCode + "\n";
                errorMessage += "Output:\n" + output.toString();
                log.error(errorMessage);
                return "Test execution failed. Please check the logs for more details";
            }
        } catch (IOException | InterruptedException e) {
            // Handle exceptions if the command execution fails
            log.error("Test execution failed due to an exception: " , e);
            return "Test execution failed due to an exception , Please check the logs for more details ";
        }
    }
}
