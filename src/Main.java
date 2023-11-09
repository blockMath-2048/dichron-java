import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {

    public ArrayList<GameObject> gameObjects;

    public GameObject camera;


    public void settings(){
        size(600,600);
    }
    public void setup(){
        gameObjects = new ArrayList<>();

        camera = new GameObject(this, new Vec2(width / 2.0f, height / 2.0f), 0.0f, new Vec2(1.0f, 1.0f));
        gameObjects.add(camera);

        gameObjects.add(new DebugSquare(this, new Vec2(0.0f, 0.0f), 0.0f, new Vec2(1.0f, 1.0f)));
        gameObjects.add(new DebugSquare(this, new Vec2(100.0f, 0.0f), 0.0f, new Vec2(1.0f, 1.0f)));
        gameObjects.add(new DebugSquare(this, new Vec2(-100.0f, 0.0f), 0.0f, new Vec2(1.0f, 1.0f)));
        gameObjects.add(new DebugSquare(this, new Vec2(0.0f, 100.0f), 0.0f, new Vec2(1.0f, 1.0f)));
        gameObjects.add(new DebugSquare(this, new Vec2(100.0f, 100.0f), 0.0f, new Vec2(1.0f, 1.0f)));
        gameObjects.add(new DebugSquare(this, new Vec2(-100.0f, 100.0f), 0.0f, new Vec2(1.0f, 1.0f)));
        gameObjects.add(new DebugSquare(this, new Vec2(0.0f, -100.0f), 0.0f, new Vec2(1.0f, 1.0f)));
        gameObjects.add(new DebugSquare(this, new Vec2(100.0f, -100.0f), 0.0f, new Vec2(1.0f, 1.0f)));
        gameObjects.add(new DebugSquare(this, new Vec2(-100.0f, -100.0f), 0.0f, new Vec2(1.0f, 1.0f)));


        for (GameObject o : gameObjects) {
            o.Start(this);
        }
    }
    public void draw(){
        background(127.0f);
        float deltaTime = 1 / frameRate;

        camera.rotation = 2 * sin(frameCount / 100.0f);
        for (GameObject o : gameObjects) {
            o.Update(this, deltaTime);
        }

        applyMatrix(camera.getMatrix());
        for (GameObject o : gameObjects) {
            pushMatrix();
            o.Draw(this, camera);
            popMatrix();
        }
        resetMatrix();
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}

