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
        //rotation += deltaTime / 20;
    }

    public void Draw(PApplet main, GameObject cameraAnchor) {
        main.applyMatrix(this.getMatrix());
        main.fill(255, 0, 0, 255);
        main.stroke(0.0f, 0.0f, 0.0f, 255.0f);
        main.strokeWeight(1.0f);
        main.rect(-50, -50, 100, 100);
        main.fill(0, 0, 0, 255);
        main.ellipse(0, 0, 10, 10);
    }
}
