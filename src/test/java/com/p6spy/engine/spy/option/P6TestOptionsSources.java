
package com.p6spy.engine.spy.option;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.management.JMException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.p6spy.engine.logging.P6LogOptions;
import com.p6spy.engine.test.BaseTestCase;
import com.p6spy.engine.test.P6TestFramework;

public class P6TestOptionsSources extends BaseTestCase {

	@Before
	public void setUp() throws JMException, SQLException, IOException,
			InterruptedException {
		// make sure to reinit properly
		new P6TestFramework("blank") {
		};
	}

	@After
	public void tearDown() {
		// cleanup to make sure other tests work as expected
		System.getProperties().remove(
				SystemProperties.P6SPY_PREFIX + P6LogOptions.EXCLUDECATEGORIES);
	}

	@Test
	public void testSpyDotPropetiesNoKeyValueDoesntModifySetOption()
			throws SQLException, IOException {
		new P6TestFramework("blank") {
		};

		Assert.assertTrue(P6LogOptions
				.getActiveInstance()
				.getExcludeCategoriesSet()
				.containsAll(
						Arrays.asList(P6TestOptionDefaults.DEFAULT_CATEGORIES)));
	}

	@Test
	public void testSpyDotPropetiesEmptyStringValueClearsSetOption()
			throws SQLException, IOException {
		new P6TestFramework("override_clear") {
		};

		Assert.assertNull(P6LogOptions.getActiveInstance()
				.getExcludeCategoriesSet());
	}

	@Test
	public void testSysPropertyNoKeyValueDoesntModifySetOption()
			throws SQLException, IOException {
		new P6TestFramework("blank") {
		};

		Assert.assertTrue(P6LogOptions
				.getActiveInstance()
				.getExcludeCategoriesSet()
				.containsAll(
						Arrays.asList(P6TestOptionDefaults.DEFAULT_CATEGORIES)));
	}

	@Test
	public void testSysPropertyEmptyStringValueClearsSetOption() throws SQLException,
			IOException {
		System.getProperties().setProperty(
				SystemProperties.P6SPY_PREFIX + P6LogOptions.EXCLUDECATEGORIES,
				"");

		new P6TestFramework("blank") {
		};

		Assert.assertNull(P6LogOptions.getActiveInstance()
				.getExcludeCategoriesSet());
	}
	
	@Test
	public void testPojoSetterNullValueDoesntModifySetOption()
			throws SQLException, IOException {

		P6LogOptions.getActiveInstance().setExcludecategories(null);
		
		Assert.assertTrue(P6LogOptions
				.getActiveInstance()
				.getExcludeCategoriesSet()
				.containsAll(
						Arrays.asList(P6TestOptionDefaults.DEFAULT_CATEGORIES)));
	}

	@Test
	public void testPojoSetterEmptyStringValueClearsSetOption() throws SQLException,
			IOException {
		
		P6LogOptions.getActiveInstance().setExcludecategories("");

		Assert.assertNull(P6LogOptions.getActiveInstance()
				.getExcludeCategoriesSet());
	}
}
