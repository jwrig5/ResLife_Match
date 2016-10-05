package teambool.reslife_matcher;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.nio.channels.Pipe;

import static org.junit.Assert.*;

import teambool.API.Pipeline;

/**
 * Created by Bekhzod Umarov on 9/12/16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 21, constants = BuildConfig.class, manifest = Config.NONE)

public class PipelineTest {
    private Pipeline p;
    private JSONObject data;

    @Before
    public void setUp() throws Exception {
        p = new Pipeline();
        String data = p.authenticate("bumar1@unh.newhaven.edu", "umarov");
        assertNotNull(data);
    }
    @Test
    public void connection_test() throws Exception {
        data = p.getData();
        assertNotNull(data);
    }
    @Test
    public void matches_test() throws Exception {
        data = p.getMatchesForUser(1001);
        assertNotNull(data);
    }
    @Test
    public void categories_test() throws Exception {
        data = p.getCategories();
        System.out.println(data.names().toString());
        assertNotNull(data);
    }
    @Test
    public void subcategories_test() throws Exception {
        data = p.getSubcategories(1);
        assertNotNull(data);
    }
}
