import processing.core.PApplet;
import processing.core.PMatrix2D;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Main extends PApplet {

    public ArrayList<GameObject> gameObjects;

    public GameObject camera;


    public void settings(){
        size(800,800);
    }
    public void setup(){
        gameObjects = new ArrayList<>();

        camera = new GameObject(this, new Vec2(-width / 2.0f, -height / 2.0f), 0.0f, new Vec2(1.0f, 1.0f));
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

        gameObjects.add(new Player(this, new Vec2(0.0f, 0.0f), 0.0f, new Vec2(1.0f, 1.0f)));

        for (GameObject o : gameObjects) {
            o.Start(this);
        }
    }
    public void draw(){
        background(127.0f);
        float deltaTime = 1 / frameRate;

        //camera.rotation = sin(frameCount / 100.0f);
        for (GameObject o : gameObjects) {
            o.Update(this, deltaTime);
        }

        PMatrix2D p = new PMatrix2D();
        p.m02 = (width / 2.0f);
        p.m12 = (height / 2.0f);
        PMatrix2D m = camera.getMatrix();
        m.invert();
        applyMatrix(p);
        applyMatrix(m);
        p.invert();
        applyMatrix(p);
        for (GameObject o : gameObjects) {
            pushMatrix();
            o.Draw(this, camera);
            popMatrix();
        }
        resetMatrix();
        fill(0.0f, 255.0f);
        text("Rot: " + (int)(camera.rotation * 180 / 3.14159f) + "° (" + ((int)(camera.rotation * 10) / 10.0f) + " rad, factor " + camera.getMatrix().m00 + ")", 0, height - 10);
    }

    public void keyEvent(boolean pressed) {
        if (key == CODED) {
            switch (keyCode) {
                case UP:
                    Input.keys['W'] = pressed;
                    break;
                case DOWN:
                    Input.keys['S'] = pressed;
                    break;
                case LEFT:
                    Input.keys['A'] = pressed;
                    break;
                case RIGHT:
                    Input.keys['D'] = pressed;
                    break;
                case KeyEvent.VK_PAGE_UP:
                    Input.keys['Q'] = pressed;
                    break;
                case KeyEvent.VK_PAGE_DOWN:
                    Input.keys['E'] = pressed;
                    break;
            }
        } else {
            Input.keys[key] = pressed;
        }
        //System.out.println((char)key + " " + pressed);
    }

    public void keyPressed() {
        keyEvent(true);
    }

    public void keyReleased() {
        keyEvent(false);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}

