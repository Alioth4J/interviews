public class Result {

    private String code;
    private String method;
    private Object data;

    // getter and setter omitted

    public static Result success() {
        // TODO Flyweight
        return new Result("200", "OK", null);
    }

    // similar methods omitted

    // TODO Builder pattern

}
