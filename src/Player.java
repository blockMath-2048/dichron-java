import processing.core.PApplet;

public class Player extends GameObject {
    Player(PApplet main, Vec2 _pos, float _rot, Vec2 _scale) {
        this.position = _pos;
        this.rotation = _rot;
        this.scale = _scale;
    }

    public void Start(PApplet main) {

    }

    public void Update(PApplet main, float deltaTime) {

    }

    public void Draw(PApplet main, GameObject cameraAnchor) {
        main.applyMatrix(this.getMatrix());
        main.fill(255.0f, 0.0f, 0.0f, 255.0f);
        main.stroke(0.0f, 0.0f, 0.0f, 255.0f);
        main.strokeWeight(10.0f);
        main.rect(-25, -25, 50, 50);
    }
}
