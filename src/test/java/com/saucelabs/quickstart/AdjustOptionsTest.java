package com.saucelabs.quickstart;

import com.saucelabs.saucebindings.JobVisibility;
import com.saucelabs.saucebindings.SaucePlatform;
import com.saucelabs.saucebindings.options.SauceOptions;
import com.saucelabs.junit.SauceBaseTest;
import org.junit.Test;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AdjustOptionsTest extends SauceBaseTest {

    public SauceOptions createSauceOptions() {
        return SauceOptions.firefox()
                .setMaxDuration(Duration.ofMinutes(30))
                .setJobVisibility(JobVisibility.TEAM)
                .setPlatformName(SaucePlatform.MAC_CATALINA)
                .build();
    }

    @Test
    public void useCustomOptions() throws AssertionError {
        driver.navigate().to("https://www.saucedemo.com");
        assertEquals(driver.getTitle(), "Swag Labs");
    }
}
