package com.saucelabs.junit;

import com.saucelabs.saucebindings.SauceSession;
import com.saucelabs.saucebindings.options.SauceOptions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

public class SauceBaseTest {
    protected WebDriver driver;
    protected SauceSession session;

    @Rule
    public SauceTestWatcher watcher = new SauceTestWatcher();

    @Rule
    public TestName testName = new TestName();

    public SauceOptions createSauceOptions() {
        return new SauceOptions();
    }

    @Before
    public void setup() {
        SauceOptions sauceOptions = createSauceOptions();
        sauceOptions.sauce().setName(testName.getMethodName());
        session = new SauceSession(sauceOptions);
        driver = session.start();
    }

    public class SauceTestWatcher extends TestWatcher {
        @Override
        protected void succeeded(Description description) {
            session.stop(true);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            session.stop(false);
        }
    }
}
