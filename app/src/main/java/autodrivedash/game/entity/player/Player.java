package autodrivedash.game.entity.player;

public final class Player {
    private String[] charSelection = {"car"};

    private static boolean isInvincible = false;
    public static boolean isInvincible(){ return isInvincible; }
    public static void setIsInvincible(boolean newIsInvincible){ isInvincible = newIsInvincible; }

    private static int invincibilityDuration = 2;
    public static int invincibilityDuration(){ return invincibilityDuration; }
    public static void setInvincibilityDuration(int newInvincibilityDuration){ invincibilityDuration = newInvincibilityDuration; }

    private static PlayerMovement movement;
    public static PlayerMovement getMovement(){ return movement; }
    public static void setMovement(PlayerMovement newMovement){ movement = newMovement; }
}
