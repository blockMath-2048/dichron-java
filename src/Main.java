import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {

    public ArrayList<GameObject> gameObjects;


    public void settings(){
        size(600,600);
    }
    public void setup(){



        for (GameObject o : gameObjects) {
            o.Start(this);
        }
    }
    public void draw(){
        float deltaTime = 1 / frameRate;

        for (GameObject o : gameObjects) {
            o.Update(this, deltaTime);
        }

        for (GameObject o : gameObjects) {
            o.Draw(this, gameObjects.get(0));
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}

