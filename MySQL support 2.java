package pato.gremios.mx;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
 
public class MysqlMain extends JavaPlugin implements Listener {
    private Connection connection;
    public String host, database, username, password, table;
    public int port;
 
    private void onEnable() {
        loadConfig();
        mysqlSetup();
 
        this.getServer().getPluginManager().registerEvents(new MysqlSetterGetter(), this);
    }
    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
 
    private void createTable() {
 
        try {
 
            Statement statement = c.createStatement();
 
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS ctokens (PlayerUUID varchar(200), Guild varchar(200))");
 
            ResultSet res = statement.executeQuery("");
            res.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
    public void mysqlSetup() {
        host = this.getConfig().getString("host");
        port = this.getConfig().getInt("port");
        database = this.getConfig().getString("database");
        username = this.getConfig().getString("username");
        password = this.getConfig().getString("password");
        table = this.getConfig().getString("table");
 
        try {
            synchronized (this) {
                if (getConnection() != null && !getConnection().isClosed()) {
                    return;
                }
                Class.forName("com.mysql.jdbc.Driver");
                setConnection(
                        connection = (Connection)DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + options, username, password);
                                
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MYSQL CONNECTED");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
GremiosPlugin.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
   EventsManager.registerEvents(this);
    @Override
    public void run() {
        this.gremios = new Config((Plugin)this, "gremios.sql", true); 
    Bukkit.broadcastMessage("This message is shown inmediately and then repeated every 300seconds");
    }
}, 6000L);
	}
}