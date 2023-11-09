import processing.core.PApplet;

public class DebugSpinningSquare extends GameObject {
    DebugSpinningSquare(PApplet main, Vec2 _pos, float _rot, Vec2 _scale) {
        this.position = _pos;
        this.rotation = _rot;
        this.scale = _scale;
    }

    public void Start(PApplet main) {

    }

    public void Update(PApplet main, float deltaTime) {
        rotation += deltaTime / 10;
        System.out.println(rotation);
    }

    public void Draw(PApplet main, GameObject cameraAnchor) {
        main.applyMatrix(this.getMatrix());
        main.fill(255, 0, 0, 255);
        main.rect(main.displayWidth / 2.0f, main.displayHeight / 2.0f, 50, 50);
    }
}
