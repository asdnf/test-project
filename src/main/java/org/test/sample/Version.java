package org.test.sample;

public class Version {

    private String ver;

    public Version(String version) throws InvalidVersionException {
        validate(version);
        ver = version;
    }

    protected void validate(String version) throws InvalidVersionException {
        if (version == null) {
            throw new InvalidVersionException("version number is null");
        }

        if (version.matches("\\d(\\.\\d){0,2}(-SNAPSHOT)?")) {

        } else {
            throw new InvalidVersionException("Unable to parse version");
        }
    }

    public boolean isSnapshot() {
        return ver.endsWith("-SNAPSHOT");
    }

    public static class InvalidVersionException extends Exception {

        public InvalidVersionException() {
        }

        public InvalidVersionException(String message) {
            super(message);
        }
    }

}
