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
        this.rotation -= 0.01f * Input.getAxis("Axis Z");
        // TODO: Transform these
        Vec2 rdp = new Vec2(Input.getAxis("Axis X"), Input.getAxis("Axis Y"));
        Vec2 adp = new Vec2(0.0f, 0.0f);
        adp.x = rdp.x * (float)Math.cosh(rotation) * scale.x + rdp.y * (float)Math.sinh(rotation) * scale.y;
        // TODO: adp.y
        ((Main)main).camera.position = new Vec2(-main.width / 2.0f + this.position.x, -main.height / 2.0f + this.position.y);
        ((Main)main).camera.rotation = this.rotation;
        ((Main)main).camera.scale = this.scale;
    }

    public void Draw(PApplet main, GameObject cameraAnchor) {
        System.out.println(this.rotation);
        this.getMatrix().print();
        main.applyMatrix(this.getMatrix());
        main.fill(255.0f, 0.0f, 0.0f, 255.0f);
        main.stroke(0.0f, 0.0f, 0.0f, 255.0f);
        main.strokeWeight(10.0f);
        main.rect(-25, -25, 50, 50);
    }
}
