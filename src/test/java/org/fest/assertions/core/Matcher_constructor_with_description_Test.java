/*
 * Created on Aug 2, 2010
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
package org.fest.assertions.core;

import static junit.framework.Assert.assertSame;
import static org.fest.assertions.test.TestData.someDescription;
import static org.fest.test.ExpectedException.none;

import org.fest.assertions.description.Description;
import org.fest.test.ExpectedException;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link Matcher#Matcher(Description)}.
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class Matcher_constructor_with_description_Test {
  @Rule
  public ExpectedException thrown = none();

  @Test
  public void should_set_description() {
    Description description = someDescription();
    Matcher<Object> matcher = new Matcher<Object>(description) {
      @Override
      public boolean matches(Object value) {
        return false;
      }
    };
    assertSame(description, matcher.description);
  }

  @Test
  public void should_throw_error_if_description_is_null() {
    thrown.expect(NullPointerException.class);
    Description description = null;
    new Matcher<Object>(description) {
      @Override
      public boolean matches(Object value) {
        return false;
      }
    };
  }
}
