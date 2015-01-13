
public class PathNotFound extends Exception
{
	public PathNotFound(){
        super("There is no path between the verticies.");
    }

    public PathNotFound(String message)
    {
        super(message);
    }
}
