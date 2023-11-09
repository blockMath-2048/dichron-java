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

    GameObject() {
        this(null, new Vec2(0, 0), 0.0f, new Vec2(1, 1));
    }

    GameObject(PApplet main, Vec2 _pos, float _rot, Vec2 _scale) {
        this.position = _pos;
        this.rotation = _rot;
        this.scale = _scale;
    }

    /// Start is called on first frame
    public void Start(PApplet main) {

    }

    /// Update is called on every frame
    /// DO NOT DRAW IN THIS FUNCTION. IT WILL BE OVERWRITTEN.
    public void Update(PApplet main, float deltaTime) {

    }

    /// Draw is called on every frame, after Update
    /// Matrix transform of the camera anchor will already be applied before this function is called.
    /// You do not need to ensure that the matrix is returned to its initial state.
    public void Draw(PApplet main, GameObject cameraAnchor) {

    }

    /// Returns the relative matrix of this object.
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
