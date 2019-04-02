package caffeine;

/**
 * @author Starstar Sun
 * @date 2018/10/8
 * @Description:
 **/
public class DataObject {

    private String data;

    private static int objectCounter = 0;

    public static DataObject get(String data) {
        objectCounter++;
        return new DataObject(data);
    }

    public DataObject() {
    }

    public DataObject(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public static int getObjectCounter() {
        return objectCounter;
    }

    public static void setObjectCounter(int objectCounter) {
        DataObject.objectCounter = objectCounter;
    }
}
