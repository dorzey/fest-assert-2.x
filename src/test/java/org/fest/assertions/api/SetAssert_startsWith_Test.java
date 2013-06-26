/*
 * Created on Mar 29, 2009
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
 * Copyright @2013 the original author or authors.
 */

package org.fest.assertions.api;

import static org.fest.test.ExpectedException.none;

import java.util.Set;

import org.fest.test.ExpectedException;
import org.fest.util.Sets;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link SetAssert#startsWith(Object...)}.
 *
 * @author Yvonne Wang
 */
public class SetAssert_startsWith_Test {
  @Rule
  public ExpectedException thrown = none();
  private final Set<String> actual = Sets.newLinkedHashSet("one", "two", "three", "four");
  private Object[] sequence = { "one", "two" };
  private SetAssert assertions;

  @Before
  public void setUp() {
    assertions = new SetAssert(actual);
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    thrown.expect(AssertionError.class);
    assertions = new SetAssert(null);
    assertions.startsWith(sequence);
  }

  @Test
  public void should_throw_error_if_sequence_is_null() {
    sequence = null;
    thrown.expect(NullPointerException.class);
    assertions.startsWith(sequence);
  }

  @Test
  public void should_throw_error_if_sequence_is_empty() {
    Object[] sequence = new Object[0];
    thrown.expect(IllegalArgumentException.class);
    assertions.startsWith(sequence);
  }

  @Test
  public void should_throw_error_if_parameter_sequence_is_missing() {
    thrown.expect(IllegalArgumentException.class);
    assertions.startsWith();
  }

  @Test
  public void should_fail_if_actual_does_not_start_with_sequence() {
    Object[] sequence = { "one", "five" };
    thrown.expect(AssertionError.class);
    assertions.startsWith(sequence);
  }

  @Test
  public void should_fail_if_sequence_size_is_larger_than_actual_size() {
    Object[] sequence = { "one", "two", "one", "two", "three", "four" };
    thrown.expect(AssertionError.class);
    assertions.startsWith(sequence);
  }

  @Test
  public void should_pass_if_actual_starts_with_sequence() {
    assertions.startsWith(sequence);
  }

  @Test
  public void should_pass_if_actual_starts_with_itself() {
    assertions.startsWith(actual.toArray());
  }
}