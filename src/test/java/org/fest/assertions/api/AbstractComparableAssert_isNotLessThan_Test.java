/*
 * Created on Oct 21, 2010
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
package org.fest.assertions.api;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.fest.assertions.internal.Comparables;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link AbstractComparableAssert#isNotLessThan(Comparable)}.
 *
 * @author Alex Ruiz
 */
public class AbstractComparableAssert_isNotLessThan_Test {
  private Comparables comparables;
  private ConcreteComparableAssert assertions;

  @Before
  public void setUp() {
    comparables = mock(Comparables.class);
    assertions = new ConcreteComparableAssert(8);
    assertions.comparables = comparables;
  }

  @Test
  public void should_verify_that_actual_is_not_less_than_other() {
    assertions.isNotLessThan(6);
    verify(comparables).assertNotLessThan(assertions.description, assertions.actual, 6);
  }

  @Test
  public void should_return_this() {
    ConcreteComparableAssert returned = assertions.isNotLessThan(6);
    assertSame(assertions, returned);
  }
}
