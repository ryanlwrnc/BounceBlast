package layout;

public class User
{
	public String username;
	public String password;
	public Integer score;
	public Integer win;
	public Integer loss;
	
	public User() {};
	
	public User(String p)
	{
		password = p;
		score = 0;
		win = 0;
		loss = 0;
	}	
	
	public User(String p, Integer s)
	{
		password = p;
		score = s;
		win = 0;
		loss = 0;
	}	
	
	public User(String n, String p)
	{
		username = n;
		password = p;
		score = 0;
		win = 0;
		loss = 0;
	}	
	
	public User(String n, String p, Integer s)
	{
		username = n;
		password = p;
		score = s;
		win = 0;
		loss = 0;
	}	
	
	public Integer getScore()
	{
		return score;
	}
	
	public Integer getWin()
	{
		return win;
	}
	
	public Integer getLoss()
	{
		return loss;
	}
}