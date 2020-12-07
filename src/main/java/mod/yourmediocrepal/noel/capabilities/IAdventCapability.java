package mod.yourmediocrepal.noel.capabilities;

public interface IAdventCapability {
    public int getUsed();
    public void setUsed(int used);
    public void setLastLogin(int lastLogin);

    boolean testSameDay();

    int getLastLogin();

    int getMonth();

    int getDayOfMonth();

    public void set(int var1);
}
