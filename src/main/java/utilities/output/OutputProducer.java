package utilities.output;

public class OutputProducer {

    public void produce(String output) {
        System.out.println(output);
    }

    public void produce(String output, Object... args) {
        System.out.printf(output, args);
    }

    public void produceErr(String output) {
        System.err.println(output);
    }
}
