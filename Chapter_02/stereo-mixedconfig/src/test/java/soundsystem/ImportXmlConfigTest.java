package soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoundSystemConfig.class)
public class ImportXmlConfigTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private MediaPlayer player;


    @Test
    public void play() {
        player.play();
        String logged = log.getLog().replaceAll("[\n\r]", "");
        assertEquals(
                "Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles" +
                        "-Track: Sgt. Pepper's Lonely Hearts Club Band" +
                        "-Track: With a Little Help from My Friends" +
                        "-Track: Lucy in the Sky with Diamonds" +
                        "-Track: Getting Better" +
                        "-Track: Fixing a Hole", logged);

    }

}
