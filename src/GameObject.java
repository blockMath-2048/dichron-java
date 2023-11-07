import com.sun.istack.internal.NotNull;
import processing.core.PApplet;
import processing.core.PMatrix2D;

public class GameObject {

    @NotNull
    public Vec2 position;

    @NotNull
    public float rotation;

    @NotNull
    public Vec2 scale;

    GameObject(PApplet main, Vec2 _pos, float _rot, Vec2 _scale) {
        this.position = _pos;
        this.rotation = _rot;
        this.scale = _scale;
    }

    public void Start(PApplet main) {

    }

    public void Update(PApplet main, float deltaTime) {

    }

    public void Draw(PApplet main, GameObject cameraAnchor) {

    }

    public PMatrix2D getMatrix() {
        PMatrix2D mat = new PMatrix2D();
        mat.m00 = (float)Math.cosh(rotation) * scale.x;
        mat.m01 = (float)Math.sinh(rotation) * scale.x;
        mat.m02 = position.x;
        mat.m10 = (float)Math.sinh(rotation) * scale.y;
        mat.m11 = (float)Math.cosh(rotation) * scale.y;
        mat.m12 = position.y;
        return mat;
    }

}
