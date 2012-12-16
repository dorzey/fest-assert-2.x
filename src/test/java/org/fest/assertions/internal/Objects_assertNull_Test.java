/*
 * Created on Sep 16, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010-2012 the original author or authors.
 */
package org.fest.assertions.internal;

import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.fest.assertions.description.Description;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link Objects#assertNull(Description, Object)}.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class Objects_assertNull_Test {
  private Objects objects;

  @Before
  public void setUp() {
    objects = new Objects();
  }

  @Test
  public void should_pass_if_object_is_null() {
    objects.assertNull(mock(Description.class), null);
  }

  @Test
  public void should_fail_if_object_is_not_null() {
    Description description = new TestDescription("Testing");
    try {
      objects.assertNull(description, "Luke");
    } catch (AssertionError e) {
      String message = "[Testing] expected:<null> but was:<'Luke'>";
      assertEquals(message, e.getMessage());
      return;
    }
    throw expectedAssertionErrorNotThrown();
  }
}
