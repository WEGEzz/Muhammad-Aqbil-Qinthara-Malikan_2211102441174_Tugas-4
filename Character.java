import greenfoot.*;  

public class Character extends Actor{
    private int score = 0;
    private boolean gameIsOver = false;
    private boolean gameIsWin = false;
    private GreenfootSound soundEffect = new GreenfootSound("score.mp3");
    
    public Character() {
        GreenfootImage image = getImage();
        image.scale(50, 40);
    }

    public void act()
    {
        checkForCollision();
        moveWithArrowKeys();
    }
    
    public void moveWithArrowKeys() {
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 3); // Geser karakter ke atas
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 3); // Geser karakter ke bawah
        }
    }
    
    public void checkForCollision() {
        
        Actor object = getOneIntersectingObject(ObjectSpecial.class);
        if (object != null) {
            increaseScore();
            getWorld().removeObject(object); 
            
            
        }
        
        Actor enemy = getOneIntersectingObject(enemy.class);
        if (enemy != null) {
            gameover();      
        }
        
        if (score >= 100) {
            win();
        }
    }
    
    public void increaseScore() {
        score += 10;
        getWorld().showText("Score: " + score, 60, 25);
        Greenfoot.playSound("score.mp3");
        }
    
    public void win(){
        gameIsWin= true;
        Greenfoot.playSound("UWU Sound.mp3");
        getWorld().showText("YOU WIN", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        Greenfoot.stop();
    }
        
    public void gameover(){
        gameIsOver = true;
        Greenfoot.playSound("peng.mp3");
        getWorld().addObject(new GameOver(), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        Greenfoot.stop();
    }
}
