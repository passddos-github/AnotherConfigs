package pato.gremios.mx.commands;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MysqlMain extends JavaPlugin {
	private Connection connection;
	public String host, database, username, password;
	public int port;

	public void onEnable() {
		mysqlSetup();
	}

	public void mysqlSetup(){
		host = "	";
		port = ;
		database = "	";
		username = "	";
		password = "	";

		try{

			synchronized (this){
				if(getConnection() != null && !getConnection().isClosed()){
					return;
				}

				Class.forName("com.mysql.jdbc.Driver");
				setConnection( DriverManager.getConnection("jdbc:mysql://" + this.host + ":" 
				+ this.port + "/" + this.database, this.username, this.password));

				Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MYSQL CONNECTED");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
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
	