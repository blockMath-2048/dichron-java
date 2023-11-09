import processing.core.PApplet;

public class DebugSquare extends GameObject {
    DebugSquare(PApplet main, Vec2 _pos, float _rot, Vec2 _scale) {
        this.position = _pos;
        this.rotation = _rot;
        this.scale = _scale;
    }

    public void Start(PApplet main) {

    }

    public void Update(PApplet main, float deltaTime) {
        //rotation += deltaTime / 10;
    }

    public void Draw(PApplet main, GameObject cameraAnchor) {
        main.applyMatrix(this.getMatrix());
        main.fill(255, 0, 0, 255);
        main.rect(-50, -50, 100, 100);
    }
}
