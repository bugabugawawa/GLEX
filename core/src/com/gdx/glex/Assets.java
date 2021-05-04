package com.gdx.glex;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.gdx.glex.Jogo.GameScreen;
import com.gdx.glex.Menu.MenuPrincipal.Menu;
import com.gdx.glex.Menu.Rankings.Rankings;

// Classe que carrega e gerencia as imagens carregadas na memoria
public class Assets {
    public AssetManager manager;

    public void load(Object type){
        if(manager==null)
            manager = new AssetManager();
        else
            manager.clear();
        if(type.equals(Menu.class))
            loadMenu();
        if(type.equals(Rankings.class))
            loadRankings();
        if(type instanceof GameScreen) {
            loadBackgroundGameplay();
            loadGameplay();
        }
    }

    private void loadMenu()
    {
        manager.load("Imagens/Menu/menuTitle.png", Texture.class);
        manager.load("Imagens/Menu/startText.png", Texture.class);
        manager.load("Imagens/Menu/rankingsText.png", Texture.class);
        manager.load("Imagens/Menu/exitText.png", Texture.class);

        manager.load("Imagens/Menu/startBlue.png", Texture.class);
        manager.load("Imagens/Menu/rankingsBlue.png", Texture.class);
        manager.load("Imagens/Menu/exitBlue.png", Texture.class);

        manager.load("Sounds/menuMusic.mp3", Music.class);
    }

    private void loadRankings()
    {
        manager.load("Imagens/Rankings/cursor.png", Texture.class);
        manager.load("Imagens/Rankings/selectedRanking.png", Texture.class);
        manager.load("Imagens/Rankings/rankingsFinal.png", Texture.class);
        manager.load("Sounds/menuMusic.mp3", Music.class);
    }

    private void loadBackgroundGameplay()
    {
        manager.load("Imagens/Gameplay/Corridors1.png", Texture.class);
        manager.load("Imagens/Gameplay/Corridors2.png", Texture.class);
        manager.load("Imagens/Gameplay/Corridors3.png", Texture.class);
        manager.load("Imagens/Gameplay/Corridors4.png", Texture.class);
        manager.load("Imagens/Gameplay/wof.png", Texture.class);
    }

    private void loadGameplay()
    {
        manager.load("Animations/playerAttack.png", Texture.class);
        manager.load("Animations/playerRun.png", Texture.class);
        manager.load("Animations/monstro.png", Texture.class);
        manager.load("Animations/ghost.png", Texture.class);
        manager.load("Animations/demon.png", Texture.class);
        manager.load("Imagens/Gameplay/deathMessage.png", Texture.class);
        manager.load("Imagens/Gameplay/popup.png", Texture.class);
        manager.load("Fonts/OldFont.fnt", BitmapFont.class); //or use alex answer to use custom font
        manager.load("Sounds/gameplayMusic.mp3", Music.class);
    }
}
