package com.palii.test;

import org.junit.Assert;
import org.junit.Test;

public class NumberFormatterTest {

    @Test
    public void testSuccess() {
        Assert.assertEquals("2", NumberFormatter.format(2));
        Assert.assertEquals("2", NumberFormatter.format(22));
        Assert.assertEquals("5-6", NumberFormatter.format(56));
        Assert.assertEquals("5-6", NumberFormatter.format(5566));
        Assert.assertEquals("2,4", NumberFormatter.format(24));
        Assert.assertEquals("2,4", NumberFormatter.format(4242));
        Assert.assertEquals("1-3", NumberFormatter.format(123));
        Assert.assertEquals("1-3", NumberFormatter.format(132123));
        Assert.assertEquals("1,3,5", NumberFormatter.format(135));
        Assert.assertEquals("1,3,5", NumberFormatter.format(55531351));
        Assert.assertEquals("1-2,5", NumberFormatter.format(125));
        Assert.assertEquals("1-2,5", NumberFormatter.format(112255));
        Assert.assertEquals("1-3,6-7", NumberFormatter.format(12367));
        Assert.assertEquals("1-3,6-7", NumberFormatter.format(1236776126));
        Assert.assertEquals("1-3,6-7", NumberFormatter.format(12367));
        Assert.assertEquals("1-3,6-7", NumberFormatter.format(1237267));
        Assert.assertEquals("1,3-7", NumberFormatter.format(134567));
        Assert.assertEquals("1,3-7", NumberFormatter.format(674134567));
    }

    @Test(expected = NumberFormatException.class)
    public void testFailWrongFormat() {
        NumberFormatter.format(418);
    }

    @Test(expected = NumberFormatException.class)
    public void testFailWrongFormatContains0() {
        NumberFormatter.format(606);
    }

}
