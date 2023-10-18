import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class enemy extends Actor
{
    public enemy() {
        GreenfootImage image = getImage();
        image.scale(50,50);
    }
    public void act()
    {
        move(-4);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
