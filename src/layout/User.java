package layout;

public class User
{
	public String username;
	public String password;
	public int score;
	
	public User(String un, String p, int s)
	{
		username = un;
		password = p;
		score = s;
	}
	
	public User(String p, int s)
	{
		password = p;
		score = s;
	}
}
