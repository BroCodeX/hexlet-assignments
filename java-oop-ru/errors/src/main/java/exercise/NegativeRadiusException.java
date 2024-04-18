package exercise;

// BEGIN
class NegativeRadiusException extends Exception {
    String message;
    {
        message = "NegativeRadiusException";
    }
    NegativeRadiusException(String message) {
        this.message = message;
    }
    NegativeRadiusException() {
    }
    public String getMessage() {
        return this.message;
    }
}
// END
