import java.util.ArrayList;

public class Input {
    public static boolean[] keys = new boolean[256];

    public static float getKey(char key) {
        return keys[key]?1.0f:0.0f;
    }

    public static float getAxis(String axis) {
        switch (axis) {
            case "Axis X":
                return getKey('D') - getKey('A');
            case "Axis Y":
                return getKey('S') - getKey('W');
            case "Axis Z":
                return getKey('E') - getKey('Q');
            case "Axis x":
                return getKey('d') - getKey('a');
            case "Axis y":
                return getKey('s') - getKey('w');
            case "Axis z":
                return getKey('e') - getKey('q');
            default:
                return 0.0f;
        }
    }
}
