package botbot;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import discord.Discord;

public class HelloAppEngineTest {

  @Test
  public void test() throws IOException {
    MockHttpServletResponse response = new MockHttpServletResponse();
    new Discord().doGet(null, response);
    Assert.assertEquals("text/plain", response.getContentType());
    Assert.assertEquals("UTF-8", response.getCharacterEncoding());
    Assert.assertEquals("Hello App Engine!\r\n", response.getWriterContent().toString());
  }
}
