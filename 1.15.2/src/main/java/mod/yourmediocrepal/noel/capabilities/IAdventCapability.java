package mod.yourmediocrepal.noel.capabilities;

public interface IAdventCapability {
    /*public int getUsed();
    public void setUsed(int used);
    public int getLastDate();
    public void setLastDate(int lastDate);*/

    boolean testSameDay();

    int getLastLogin();

    int getMonth();

    int getDayOfMonth();

    void set(int var1);
}
