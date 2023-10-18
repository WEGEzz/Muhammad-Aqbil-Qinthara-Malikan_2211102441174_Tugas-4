import greenfoot.*;  


public class ObjectSpecial extends Actor {
    private int speed = 3;
    
    public ObjectSpecial() {
        GreenfootImage image = getImage();
        image.scale(40, 40);
    }
    
    public void act() {
        moveLeft();
        checkForCollision();
    }
    
    public void moveLeft() {
        setLocation(getX() - speed, getY());
    }
    
    public void checkForCollision() {
        Actor character = getOneIntersectingObject(Character.class);
        if (character != null) {
            ((Character) character).increaseScore();
            getWorld().removeObject(this);
        } else if (getX() <= 0) {
            getWorld().removeObject(this);
        }
    }
}