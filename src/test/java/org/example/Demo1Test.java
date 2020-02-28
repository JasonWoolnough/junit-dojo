package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class Demo1Test {
    // This annotation creates an actual (not mocked) instance of Demo.
    // It calls an actual constructor, injecting any required mocks in there.
    // Because there are no mocked dependencies, it's just calling the default empty constructor.
    @InjectMocks
    Demo1 demo1;

    @Test
    public void append_shouldAppendStringsAndSeparateWithSpace() {
        String result = demo1.append("hello", "world");

        assertThat(result, equalTo("hello world"));
    }

    @Test
    public void append_shouldTrimString1() {
        String result = demo1.append(" hello  ", "world");

        assertThat(result, equalTo("hello world"));
    }

    @Test
    public void append_shouldTrimString2() {
        String result = demo1.append(" hello  ", "  world");

        assertThat(result, equalTo("hello world"));
    }
}
