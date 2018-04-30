package com.qa.test.Guru99Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({ TestFeatureLogin.class, TestFeatureLogout.class, TestFeatureNavigate.class,
		TestFeatureUpdate.class })

public class TestSuite {
}
