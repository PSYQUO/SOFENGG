package test.testModel;

import model.RawItem;
import test.*;
import java.time.*;

public class TestRawItem extends Test
{
  public void test()
  {
    check0();
  }

  public void check0()
  {
    RawItem ri = new RawItem("patty", 100, 20.00);
  }
}
