import com.sun.javafx.geom.Vec2f;

public class Vec2 extends Vec2f {
    Vec2(float _x, float _y) {
        x = _x;
        y = _y;
    }
    public float distanceSq(Vec2f a) {
        return (a.x - this.x)*(a.x - this.x) - (a.y - this.y)*(a.y - this.y);
    }
}
