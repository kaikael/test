/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportradartest;

import com.sportradar.sdk.feed.common.entities.EventIdentifier;
import com.sportradar.sdk.feed.common.entities.HomeAway;
import com.sportradar.sdk.feed.common.entities.IdNameTuple;
import com.sportradar.sdk.feed.livescout.entities.MatchHeaderEntity;
import com.sportradar.sdk.feed.livescout.entities.MatchUpdateEntity;
import com.sportradar.sdk.feed.livescout.entities.ScoutEventEntity;
import com.sportradar.sdk.feed.livescout.enums.ScoutMatchStatus;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;

/**
 *
 * @author PH1286
 */
public class MatchEntity {
    
    public MatchEntity(){
        
    }
    
    private EventIdentifier eventId;
    private List<ScoutEventEntity> scoutEventEntityList;
    private MatchHeaderEntity matchHeaderEntity;
    private ScoutMatchStatus scoutMatchStatus;
    private Map<String,HomeAway<Double>> score;
    
    private long matchId;
    private String matchTime;
    private DateTime startTime;
    private IdNameTuple team1;
    private IdNameTuple team2;

    /**
     * @return the eventId
     */
    public EventIdentifier getEventId() {
        return eventId;
    }

    /**
     * @param eventId the eventId to set
     */
    public void setEventId(EventIdentifier eventId) {
        this.eventId = eventId;
    }

    /**
     * @return the scoutEventEntityList
     */
    public List<ScoutEventEntity> getScoutEventEntityList() {
        return scoutEventEntityList;
    }

    /**
     * @param scoutEventEntityList the scoutEventEntityList to set
     */
    public void setScoutEventEntityList(List<ScoutEventEntity> scoutEventEntityList) {
        this.scoutEventEntityList = scoutEventEntityList;
    }

    /**
     * @return the matchHeaderEntity
     */
    public MatchHeaderEntity getMatchHeaderEntity() {
        return matchHeaderEntity;
    }

    /**
     * @param matchHeaderEntity the matchHeaderEntity to set
     */
    public void setMatchHeaderEntity(MatchHeaderEntity matchHeaderEntity) {
        this.matchHeaderEntity = matchHeaderEntity;
    }

    /**
     * @return the scoutMatchStatus
     */
    public ScoutMatchStatus getScoutMatchStatus() {
        return scoutMatchStatus;
    }

    /**
     * @param scoutMatchStatus the scoutMatchStatus to set
     */
    public void setScoutMatchStatus(ScoutMatchStatus scoutMatchStatus) {
        this.scoutMatchStatus = scoutMatchStatus;
    }

    /**
     * @return the score
     */
    public Map<String,HomeAway<Double>> getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Map<String,HomeAway<Double>> score) {
        this.score = score;
    }

    /**
     * @return the matchId
     */
    public long getMatchId() {
        return matchId;
    }

    /**
     * @param matchId the matchId to set
     */
    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    /**
     * @return the matchTime
     */
    public String getMatchTime() {
        return matchTime;
    }

    /**
     * @param matchTime the matchTime to set
     */
    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    /**
     * @return the startTime
     */
    public DateTime getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the team1
     */
    public IdNameTuple getTeam1() {
        return team1;
    }

    /**
     * @param team1 the team1 to set
     */
    public void setTeam1(IdNameTuple team1) {
        this.team1 = team1;
    }

    /**
     * @return the team2
     */
    public IdNameTuple getTeam2() {
        return team2;
    }

    /**
     * @param team2 the team2 to set
     */
    public void setTeam2(IdNameTuple team2) {
        this.team2 = team2;
    }

    
    
}
