package org.test.sample;

import org.junit.Test;

public class VersionTest {

    @Test(expected = Version.InvalidVersionException.class)
    public void testOnlyDigits() throws Version.InvalidVersionException {
        new Version("12");
    }

    @Test
    public void testDigitsWithDotsCorrect() throws Version.InvalidVersionException {
        new Version("1.2.3");
    }

    @Test(expected = Version.InvalidVersionException.class)
    public void testDigitsWithDotsNotCorrect() throws Version.InvalidVersionException {
        new Version("1.2.3.4");
    }

    @Test
    public void testDigitsWithDotsWithSnapshotCorrect() throws Version.InvalidVersionException {
        new Version("1.2.3-SNAPSHOT");
    }

    @Test(expected = Version.InvalidVersionException.class)
    public void testDigitsWithDotsWithSnapshotNotCorrect() throws Version.InvalidVersionException {
        new Version("1.2.3.4-SNAPSHOT");
    }

    @Test(expected = Version.InvalidVersionException.class)
    public void testIllegalSymbolsLetters() throws Version.InvalidVersionException {
        new Version("test");
    }

    @Test
    public void testSnapshot() throws Version.InvalidVersionException {
        assert new Version("1-SNAPSHOT").isSnapshot();
    }

}
