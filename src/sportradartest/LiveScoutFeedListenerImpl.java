/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportradartest;

import com.sportradar.sdk.common.enums.FeedEventType;
import com.sportradar.sdk.feed.livescout.entities.LineupsEntity;
import com.sportradar.sdk.feed.livescout.entities.MatchBookingEntity;
import com.sportradar.sdk.feed.livescout.entities.MatchDataEntity;
import com.sportradar.sdk.feed.livescout.entities.MatchListEntity;
import com.sportradar.sdk.feed.livescout.entities.MatchListUpdateEntity;
import com.sportradar.sdk.feed.livescout.entities.MatchStopEntity;
import com.sportradar.sdk.feed.livescout.entities.MatchUpdateEntity;
import com.sportradar.sdk.feed.livescout.entities.OddsSuggestionsEntity;
import com.sportradar.sdk.feed.livescout.entities.ServerTimeEntity;
import com.sportradar.sdk.feed.livescout.interfaces.LiveScoutFeed;
import com.sportradar.sdk.feed.livescout.interfaces.LiveScoutFeedListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ph1286
 */
public class LiveScoutFeedListenerImpl implements LiveScoutFeedListener {
    
    private UI ui;
    List<MatchUpdateEntity> matchList = null;
    
    public LiveScoutFeedListenerImpl(UI ui) {
      this.ui = ui;
    }

    @Override
    public void onFullMatchUpdateReceived(LiveScoutFeed lsf, MatchUpdateEntity mue) {
        System.out.println("onFullMatchUpdateReceived");
        ui.displayEvents(mue);
    }

    @Override
    public void onLineupsReceived(LiveScoutFeed lsf, LineupsEntity le) {
        System.out.println("onLineupsReceived");
    }

    @Override
    public void onMatchBooked(LiveScoutFeed lsf, MatchBookingEntity mbe) {
        System.out.println("onMatchBooked");
    }

    @Override
    public void onMatchDataReceived(LiveScoutFeed lsf, MatchDataEntity mde) {
        System.out.println("onMatchDataReceived");
    }

    @Override
    public void onMatchDeltaUpdateReceived(LiveScoutFeed lsf, MatchUpdateEntity mue) {
        System.out.println("onMatchDeltaUpdateReceived");
        
    }

    @Override
    public void onMatchDeltaUpdateUpdateReceived(LiveScoutFeed lsf, MatchUpdateEntity mue) {
        System.out.println("onMatchDeltaUpdateUpdateReceived");
        
    }

    @Override
    public void onMatchListReceived(LiveScoutFeed lsf, MatchListEntity mle) {
        System.out.println("onMatchListReceived");
        
        if(matchList == null){
            matchList = mle.getMatches();
        }
        List<MatchUpdateEntity> mueList = new ArrayList<>();
        mueList = mle.getMatches();
        for(MatchUpdateEntity mue: mueList){
            if(!matchList.contains(mue)){
                matchList.add(mue);
            }
        }
        
        ui.displayMatches(matchList);
        System.out.println(matchList.size());
    }

    @Override
    public void onMatchListUpdateReceived(LiveScoutFeed lsf, MatchListUpdateEntity mlue) {
        System.out.println("onMatchListUpdateReceived");
    }

    @Override
    public void onMatchStopped(LiveScoutFeed lsf, MatchStopEntity mse) {
        System.out.println("onMatchStopped");
    }

    @Override
    public void onMatchUpdateReceived(LiveScoutFeed lsf, MatchUpdateEntity mue) {
        System.out.println("onMatchUpdateReceived");
    }

    @Override
    public void onOddsSuggestionReceived(LiveScoutFeed lsf, OddsSuggestionsEntity ose) {
        System.out.println("onOddsSuggestionReceived");
    }

    @Override
    public void onServerTimeReceived(LiveScoutFeed lsf, ServerTimeEntity ste) {
        System.out.println("onServerTimeReceived");
    }

    @Override
    public void onInitialized(LiveScoutFeed t) {
        System.out.println("onInitialized");
    }

    @Override
    public void onClosed(LiveScoutFeed t) {
        System.out.println("onClosed");
    }

    @Override
    public void onFeedEvent(LiveScoutFeed t, FeedEventType fet) {
        System.out.println("onFeedEvent");
//        t.getMatchList(240, 240, true);
    }

    @Override
    public void onOpened(LiveScoutFeed t) {
        System.out.println("onOpened");
//        sportradarTest.getMatches();
    }
    
}
