/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportradartest;

import com.sportradar.sdk.common.exceptions.SdkException;
import com.sportradar.sdk.feed.common.entities.EventIdentifier;
import com.sportradar.sdk.feed.livescout.interfaces.LiveScoutFeed;
import com.sportradar.sdk.feed.livescout.interfaces.LiveScoutFeedListener;
import com.sportradar.sdk.feed.sdk.Sdk;

/**
 *
 * @author ph1286
 */
public class SportradarTest {

    /**
     * @param args the command line arguments
     */
    
    private Sdk sdk;
    private LiveScoutFeed liveScoutFeed;
    private LiveScoutFeedListener scoutFeedListener;
    private UI ui;
    
    public SportradarTest(UI ui){
        this.ui = ui;
    }
    
    public void start() throws SdkException {

        sdk = Sdk.getInstance();
        liveScoutFeed = sdk.getLiveScout();
        scoutFeedListener = new LiveScoutFeedListenerImpl(ui);
        liveScoutFeed.open(scoutFeedListener);
    }

    public void getMatches(){
        System.out.println("getMatches");
        liveScoutFeed.getMatchList(24, 24, true);
    }
    
    public void subscribeMatch(EventIdentifier[] ei){
       liveScoutFeed.subscribe(ei);
    }
    
}
