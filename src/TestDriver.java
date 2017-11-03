import test.testModel.*;
import test.*;

public class TestDriver
{
	public static void UserCheck()
	{
		Test t = new TestUser ();
		try {
			t.testAndGenerate ("model/testUser4.txt", 4);
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}

	public static void RawItemCheck()
	{
		Test t = new TestRawItem();
		try
		{
			t.testAndGenerate("model/TestRawItem1.txt", 1);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main (String[] args)
	{
		RawItemCheck();
	}
}
