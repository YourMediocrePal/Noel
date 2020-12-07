package mod.yourmediocrepal.noel.capabilities;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Calendar;

public class Advent implements IAdventCapability {
    private int used;
    int lastLogin;
    @Override
    public int getUsed() {
        return this.used;
    }

    @Override
    public void setUsed(int used) {
        this.used = used;
    }

    @Override
    public void setLastLogin(int lastLogin) {
        this.lastLogin = lastLogin;
    }


    Calendar cal = Calendar.getInstance();
    int month;
    int dayOfMonth;

    public Advent() {
        this.month = this.cal.get(2);
        this.dayOfMonth = this.cal.get(5);
    }

    public void set(int lastLogin) {
        this.lastLogin = this.dayOfMonth;
    }

    public boolean testSameDay() {
        return this.lastLogin == this.dayOfMonth;
    }

    public int getLastLogin() {
        return this.lastLogin;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDayOfMonth() {
        return this.dayOfMonth;
    }
}
