package ru.eskendarov.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import ru.eskendarov.basic.Base2DScreen;


public class MenuScreen extends Base2DScreen {
    
    private Texture img;
    
    private Vector2 pos;
    private Vector2 v;
    
    private Vector2 touch;
    
    @Override
    public void show() {
        super.show();
        img = new Texture("ball.png");
        
        pos = new Vector2(0, 0);
        v = new Vector2(0.1f, 0.1f);
        touch = new Vector2();
        //        v = new Vector2(100f, 100f);
    }
    
    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.2f,3,3,3);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, touch.x - (float) img.getWidth() / 2,
                   Gdx.graphics.getHeight() - (float)img.getHeight() / 2 - touch.y);
        batch.end();
//        pos.add(v);
    }
    
    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }
    
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, screenY);
        return false;
    }
//    @Override
//    public boolean mouseMoved(int screenX, int screenY) {
//        touch.set(screenX, screenY);
//        return false;
//    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        touch.set(screenX, screenY);
        return false;
    }
}
