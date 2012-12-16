/*
 * Created on Jun 4, 2012
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2010-2012 the original author or authors.
 */
package org.fest.assertions.internal.maps;

import static org.fest.assertions.data.MapEntry.entry;
import static org.fest.assertions.error.ShouldHaveSameSizeAs.shouldHaveSameSizeAs;
import static org.fest.assertions.test.FailureMessages.actualIsNull;
import static org.fest.assertions.test.Maps.newMap;
import static org.fest.assertions.test.TestData.someInfo;
import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.fest.util.Lists.newArrayList;

import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import org.fest.assertions.core.AssertionInfo;
import org.fest.assertions.internal.Maps;
import org.fest.assertions.internal.MapsBaseTest;

/**
 * Tests for <code>{@link Maps#assertHasSameSizeAs(AssertionInfo, boolean[], Iterable)}</code>.
 * 
 * @author Nicolas François
 */
public class Maps_assertHasSameSizeAs_with_Iterable_Test extends MapsBaseTest {

  @SuppressWarnings("unchecked")
  @Override
  @Before
  public void setUp() {
    super.setUp();
    actual = (Map<String, String>) newMap(entry("name", "Yoda"), entry("job", "Yedi Master"));
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    maps.assertHasSameSizeAs(someInfo(), null, newArrayList("Solo", "Leia"));
  }

  @Test
  public void should_fail_if_size_of_actual_is_not_equal_to_expected_size() {
    AssertionInfo info = someInfo();
    List<String> other = newArrayList("Solo", "Leia", "Yoda");
    try {
      maps.assertHasSameSizeAs(info, actual, other);
    } catch (AssertionError e) {
      verify(failures).failure(info, shouldHaveSameSizeAs(actual, actual.size(), other.size()));
      return;
    }
    expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_pass_if_size_of_actual_is_equal_to_expected_size() {
    maps.assertHasSameSizeAs(someInfo(), actual, newArrayList("Solo", "Leia"));
  }

}
