import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int spawnDelay = 90; 
    private int spawnCounter = 0;
    public MyWorld()
    {    
        super(600, 400, 1); 
        prepare();
    }
    
    private void prepare() {
        // Tambahkan karakter ke dunia.
        Character character = new Character();
        addObject(character, 100, 200); // Letakkan karakter di posisi yang Anda inginkan.
    }
    
    public void act() {
        if (spawnCounter == spawnDelay) {
            spawnObject();
            spawnCounter = 0;
        } else {
            spawnCounter++;
        }
    }
    
    public void spawnObject() {
        int randomY = Greenfoot.getRandomNumber(getHeight());
        int randomSpawn = Greenfoot.getRandomNumber(3); // Menghasilkan angka acak 0 atau 1
        Actor object;

        if (randomSpawn == 0) {
            object = new ObjectSpecial();
        } else {
            object = new enemy();
        }

        addObject(object, getWidth(), randomY);
    }
}