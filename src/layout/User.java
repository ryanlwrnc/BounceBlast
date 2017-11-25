package layout;

public class User
{
	public String username;
	public String password;
	public Integer score;
	
	public User() {};
	
	public User(String p)
	{
		password = p;
		score = 0;
	}	
	
	public User(String p, Integer s)
	{
		password = p;
		score = s;
	}	
	
	public User(String n, String p)
	{
		username = n;
		password = p;
		score = 0;
	}	
	
	public User(String n, String p, Integer s)
	{
		username = n;
		password = p;
		score = s;

	}	
}