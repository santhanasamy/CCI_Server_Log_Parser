package com.santhana.logger.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Payload1 {

    private static final String TAG = Payload1.class.getSimpleName();

    private Integer mCCIGameInstanceId;
    // Game Properties : Start
    @SerializedName("game_instance_id")
    @Expose
    private Integer gameInstanceId;

    @SerializedName("game_name")
    @Expose
    private String gameName;

    @SerializedName("game_id")
    @Expose
    private String gameId;

    @SerializedName("memory_utilization_MB")
    @Expose
    private Integer memoryUtilizationMB;

    @SerializedName("is_foreground")
    @Expose
    private Boolean isForeground;

    // Game Properties : End

    @SerializedName("shot_number")
    @Expose
    private Integer shotNumber;

    @SerializedName("ball_speed_mps")
    @Expose
    private Double ballSpeedMps;

    @SerializedName("launch_angle_deg")
    @Expose
    private Double launchAngleDeg;

    @SerializedName("azimuth_angle_deg")
    @Expose
    private Double azimuthAngleDeg;

    @SerializedName("backspin_rpm")
    @Expose
    private Double backspinRpm;

    @SerializedName("sidespin_rpm")
    @Expose
    private Double sidespinRpm;

    @SerializedName("carry_distance_m")
    @Expose
    private Double carryDistanceM;

    @SerializedName("world_start_x_m")
    @Expose
    private Double worldStartXM;

    @SerializedName("world_start_y_m")
    @Expose
    private Double worldStartYM;

    @SerializedName("world_start_z_m")
    @Expose
    private Double worldStartZM;

    @SerializedName("resolution_width")
    @Expose
    private Integer resolutionWidth;

    @SerializedName("resolution_height")
    @Expose
    private Integer resolutionHeight;

    @SerializedName("format")
    @Expose
    private Integer format;

    @SerializedName("frame_count")
    @Expose
    private Integer frameCount;

    @SerializedName("data_encoding")
    @Expose
    private String dataEncoding;

    @SerializedName("image_data")
    @Expose
    private String imageData;

    @SerializedName("score")
    @Expose
    private String score;

    @SerializedName("club_speed_mph")
    @Expose
    private Double clubSpeedMph;

    @SerializedName("club_speed_at_impact_mph")
    @Expose
    private Double clubSpeedAtImpactMph;

    @SerializedName("efficiency")
    @Expose
    private Double efficiency;

    @SerializedName("angle_of_attack_deg")
    @Expose
    private Double angleOfAttackDeg;

    @SerializedName("lie_deg")
    @Expose
    private Double lieDeg;

    @SerializedName("loft_deg")
    @Expose
    private Double loftDeg;

    @SerializedName("f_axis_deg")
    @Expose
    private Double fAxisDeg;

    @SerializedName("horizontal_impact_mm")
    @Expose
    private Double horizontalImpactMm;

    @SerializedName("vertical_impact_mm")
    @Expose
    private Double verticalImpactMm;

    @SerializedName("face_to_target_deg")
    @Expose
    private Double faceToTargetDeg;

    @SerializedName("closing_rate_dps")
    @Expose
    private Double closingRateDps;

    @SerializedName("club_path_deg")
    @Expose
    private Double clubPathDeg;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("isLoaded")
    @Expose
    private Boolean isLoaded;

    @SerializedName("selected_tee")
    @Expose
    private Integer selectedTee;

    @SerializedName("profile_id")
    @Expose
    private List<String>  profileId;

    @SerializedName("player_name")
    @Expose
    private String playerName;

    @SerializedName("handicap")
    @Expose
    private Integer handicap;

    @SerializedName("handedness")
    @Expose
    private String handedness;

    public boolean isGameSelected() {
        return isGameSelected;
    }

    public void setGameSelected(boolean gameSelected) {
        isGameSelected = gameSelected;
    }

    @SerializedName("tee_box_id")
    @Expose
    private String teeBoxId = "white";

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("details")
    @Expose
    private String details;

    private Map<String, String> monsterHealth = new HashMap<>();

    private int mHeaderposition = 0;

    private boolean isGameSelected;

    private String terms = null;

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public Payload1() {
    }

    public Payload1(String playerName, String teamName) {
        this.playerName = playerName;
        this.teamName = teamName;
    }

    public List<String> getProfileId() {
        return profileId;
    }

    public void setProfileId(List<String> profileId) {
        this.profileId = profileId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getHandicap() {
        return handicap;
    }

    public void setHandicap(Integer handicap) {
        this.handicap = handicap;
    }

    public String getHandedness() {
        return handedness;
    }

    public void setHandedness(String handedness) {
        this.handedness = handedness;
    }

    public String getTeeBoxId() {
        return teeBoxId;
    }

    public void setTeeBoxId(String teeBoxId) {
        this.teeBoxId = teeBoxId;
    }

    private String totalScore = "0";

    private String shackjackFinalScore = "0";

    private String roundNumber = "-1";

    private Map<Integer, String> scoreList = new HashMap<>();

    private Map<Integer, List<String>> scoreSnapShot = new HashMap<>();

    private boolean isPlaying = false;

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public String getShackJackFinalScore() {
        return shackjackFinalScore;
    }

    public void setShackJackFinalScore(String shackjackTotalScore) {
        this.shackjackFinalScore = shackjackTotalScore;
    }

    public Map<Integer, List<String>> getScoreSnapShot() {
        return scoreSnapShot;
    }

    public void setScoreSnapShot(HashMap<Integer, List<String>> scoreSnapShot) {
        this.scoreSnapShot = scoreSnapShot;
    }

    public Map<Integer, String> getScoreList() {
        return scoreList;
    }

    public String getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(String roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void setScoreList(HashMap<Integer, String> scoreList) {
        this.scoreList = scoreList;
    }

    public Integer getShotNumber() {
        return shotNumber;
    }

    public void setShotNumber(Integer shotNumber) {
        this.shotNumber = shotNumber;
    }

    public Double getBallSpeedMps() {
        return ballSpeedMps;
    }

    public void setBallSpeedMps(Double ballSpeedMps) {
        this.ballSpeedMps = ballSpeedMps;
    }

    public Double getLaunchAngleDeg() {
        return launchAngleDeg;
    }

    public void setLaunchAngleDeg(Double launchAngleDeg) {
        this.launchAngleDeg = launchAngleDeg;
    }

    public Double getAzimuthAngleDeg() {
        return azimuthAngleDeg;
    }

    public void setAzimuthAngleDeg(Double azimuthAngleDeg) {
        this.azimuthAngleDeg = azimuthAngleDeg;
    }

    public Double getBackspinRpm() {
        return backspinRpm;
    }

    public void setBackspinRpm(Double backspinRpm) {
        this.backspinRpm = backspinRpm;
    }

    public Double getSidespinRpm() {
        return sidespinRpm;
    }

    public void setSidespinRpm(Double sidespinRpm) {
        this.sidespinRpm = sidespinRpm;
    }

    public Double getCarryDistanceM() {
        return carryDistanceM;
    }

    public void setCarryDistanceM(Double carryDistanceM) {
        this.carryDistanceM = carryDistanceM;
    }

    public Double getWorldStartXM() {
        return worldStartXM;
    }

    public void setWorldStartXM(Double worldStartXM) {
        this.worldStartXM = worldStartXM;
    }

    public Double getWorldStartYM() {
        return worldStartYM;
    }

    public void setWorldStartYM(Double worldStartYM) {
        this.worldStartYM = worldStartYM;
    }

    public Double getWorldStartZM() {
        return worldStartZM;
    }

    public void setWorldStartZM(Double worldStartZM) {
        this.worldStartZM = worldStartZM;
    }

    public Integer getResolutionWidth() {
        return resolutionWidth;
    }

    public void setResolutionWidth(Integer resolutionWidth) {
        this.resolutionWidth = resolutionWidth;
    }

    public Integer getResolutionHeight() {
        return resolutionHeight;
    }

    public void setResolutionHeight(Integer resolutionHeight) {
        this.resolutionHeight = resolutionHeight;
    }

    public Integer getFormat() {
        return format;
    }

    public void setFormat(Integer format) {
        this.format = format;
    }

    public Integer getFrameCount() {
        return frameCount;
    }

    public void setFrameCount(Integer frameCount) {
        this.frameCount = frameCount;
    }

    public String getDataEncoding() {
        return dataEncoding;
    }

    public void setDataEncoding(String dataEncoding) {
        this.dataEncoding = dataEncoding;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Double getClubSpeedMph() {
        return clubSpeedMph;
    }

    public void setClubSpeedMph(Double clubSpeedMph) {
        this.clubSpeedMph = clubSpeedMph;
    }

    public Double getClubSpeedAtImpactMph() {
        return clubSpeedAtImpactMph;
    }

    public void setClubSpeedAtImpactMph(Double clubSpeedAtImpactMph) {
        this.clubSpeedAtImpactMph = clubSpeedAtImpactMph;
    }

    public Double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(Double efficiency) {
        this.efficiency = efficiency;
    }

    public Double getAngleOfAttackDeg() {
        return angleOfAttackDeg;
    }

    public void setAngleOfAttackDeg(Double angleOfAttackDeg) {
        this.angleOfAttackDeg = angleOfAttackDeg;
    }

    public Double getLieDeg() {
        return lieDeg;
    }

    public void setLieDeg(Double lieDeg) {
        this.lieDeg = lieDeg;
    }

    public Double getLoftDeg() {
        return loftDeg;
    }

    public void setLoftDeg(Double loftDeg) {
        this.loftDeg = loftDeg;
    }

    public Double getFAxisDeg() {
        return fAxisDeg;
    }

    public void setFAxisDeg(Double fAxisDeg) {
        this.fAxisDeg = fAxisDeg;
    }

    public Double getHorizontalImpactMm() {
        return horizontalImpactMm;
    }

    public void setHorizontalImpactMm(Double horizontalImpactMm) {
        this.horizontalImpactMm = horizontalImpactMm;
    }

    public Double getVerticalImpactMm() {
        return verticalImpactMm;
    }

    public void setVerticalImpactMm(Double verticalImpactMm) {
        this.verticalImpactMm = verticalImpactMm;
    }

    public Double getFaceToTargetDeg() {
        return faceToTargetDeg;
    }

    public void setFaceToTargetDeg(Double faceToTargetDeg) {
        this.faceToTargetDeg = faceToTargetDeg;
    }

    public Double getClosingRateDps() {
        return closingRateDps;
    }

    public void setClosingRateDps(Double closingRateDps) {
        this.closingRateDps = closingRateDps;
    }

    public Double getClubPathDeg() {
        return clubPathDeg;
    }

    public void setClubPathDeg(Double clubPathDeg) {
        this.clubPathDeg = clubPathDeg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean isGameLoaded() {
        return isLoaded;
    }

    public void setIsLoaded(Boolean isLoaded) {
        this.isLoaded = isLoaded;
    }

    public Integer getSelectedTee() {
        return selectedTee;
    }

    public void setSelectedTee(Integer selectedTee) {
        this.selectedTee = selectedTee;
    }

    @SerializedName("connected")
    @Expose
    private Boolean connected;

    @SerializedName("connection_type_id")
    @Expose
    private String connectionTypeId;

    @SerializedName("product_name")
    @Expose
    private String productName;

    @SerializedName("model_number")
    @Expose
    private String modelNumber;

    @SerializedName("serial")
    @Expose
    private String serial;

    private String teamName;

    public Integer getGameInstanceId() {
        return gameInstanceId;
    }

    public void setGameInstanceId(Integer gameInstanceId) {
        this.gameInstanceId = gameInstanceId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Integer getMemoryUtilizationMB() {
        return memoryUtilizationMB;
    }

    public void setMemoryUtilizationMB(Integer memoryUtilizationMB) {
        this.memoryUtilizationMB = memoryUtilizationMB;
    }

    public Boolean getIsForeground() {
        return isForeground;
    }

    public void setIsForeground(Boolean isForeground) {
        this.isForeground = isForeground;
    }

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public String getConnectionTypeId() {
        return connectionTypeId;
    }

    public void setConnectionTypeId(String connectionTypeId) {
        this.connectionTypeId = connectionTypeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getHeaderposition() {
        return mHeaderposition;
    }

    public void setHeaderposition(int aHeaderposition) {
        this.mHeaderposition = aHeaderposition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String aStatus) {
        status = aStatus;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String aDetails) {
        details = aDetails;
    }

    @SerializedName("peak_height_ft")
    @Expose
    private String peakHeightFt;

    @SerializedName("ball_speed_mph")
    @Expose
    private String ballSpeedMph;

    @SerializedName("total_spin_rpm")
    @Expose
    private String totalSpinRpm;

    @SerializedName("carry_distance_yds")
    @Expose
    private String carryDistanceYds;

    @SerializedName("total_distance_yds")
    @Expose
    private String totalDistanceYds;

    @SerializedName("avgPeakHeightFt")
    @Expose
    private String avgPeakHeightFt;

    @SerializedName("avgBallSpeedMph")
    @Expose
    private String avgBallSpeedMph;

    @SerializedName("avgTotalSpinRpm")
    @Expose
    private String avgTotalSpinRpm;

    @SerializedName("avgCarryDistanceYds")
    @Expose
    private String avgCarryDistanceYds;

    @SerializedName("avgTotalDistanceYds")
    @Expose
    private String avgTotalDistanceYds;
    boolean isPositionSelection;
    String clubType = null;


    public String getAvgPeakHeightFt() {
        return avgPeakHeightFt;
    }

    public void setAvgPeakHeightFt(String avgPeakHeightFt) {
        this.avgPeakHeightFt = avgPeakHeightFt;
    }

    public String getAvgBallSpeedMph() {
        return avgBallSpeedMph;
    }

    public void setAvgBallSpeedMph(String avgBallSpeedMph) {
        this.avgBallSpeedMph = avgBallSpeedMph;
    }

    public String getAvgTotalSpinRpm() {
        return avgTotalSpinRpm;
    }

    public void setAvgTotalSpinRpm(String avgTotalSpinRpm) {
        this.avgTotalSpinRpm = avgTotalSpinRpm;
    }

    public String getAvgCarryDistanceYds() {
        return avgCarryDistanceYds;
    }

    public void setAvgCarryDistanceYds(String avgCarryDistanceYds) {
        this.avgCarryDistanceYds = avgCarryDistanceYds;
    }

    public String getAvgTotalDistanceYds() {
        return avgTotalDistanceYds;
    }

    public void setAvgTotalDistanceYds(String avgTotalDistanceYds) {
        this.avgTotalDistanceYds = avgTotalDistanceYds;
    }

    public String getPeakHeightFt() {
        return peakHeightFt;
    }

    public void setPeakHeightFt(String peakHeightFt) {
        this.peakHeightFt = peakHeightFt;
    }

    public String getBallSpeedMph() {
        return ballSpeedMph;
    }

    public void setBallSpeedMph(String ballSpeedMph) {
        this.ballSpeedMph = ballSpeedMph;
    }

    public String getTotalSpinRpm() {
        return totalSpinRpm;
    }

    public void setTotalSpinRpm(String totalSpinRpm) {
        this.totalSpinRpm = totalSpinRpm;
    }

    public String getCarryDistanceYds() {
        return carryDistanceYds;
    }

    public void setCarryDistanceYds(String carryDistanceYds) {
        this.carryDistanceYds = carryDistanceYds;
    }

    public String getTotalDistanceYds() {
        return totalDistanceYds;
    }

    public void setTotalDistanceYds(String totalDistanceYds) {
        this.totalDistanceYds = totalDistanceYds;
    }


    public void reSetProPracticeScore() {
        this.peakHeightFt = "0";
        this.ballSpeedMph = "0";
        this.totalSpinRpm = "0";
        this.carryDistanceYds = "0";
        this.totalDistanceYds = "0";
        this.shotNumber = 0;

    }


    public boolean isPositionSelection() {
        return isPositionSelection;
    }

    public void setPositionSelection(boolean positionSelection) {
        isPositionSelection = positionSelection;
    }

    public Integer getCCIGameInstanceID() {
        return mCCIGameInstanceId;
    }

    public void setCCIGameInstanceID(Integer aCCIGameInstanceId) {
        this.mCCIGameInstanceId = aCCIGameInstanceId;
    }

    public Map<String, String> getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(Map<String, String> monsterHealth) {
        this.monsterHealth = monsterHealth;
    }

    public String getClubType() {
        return clubType;
    }

    public void setClubType(String clubType) {
        this.clubType = clubType;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "mCCIGameInstanceId=" + mCCIGameInstanceId +
                ", gameInstanceId=" + gameInstanceId +
                ", gameName='" + gameName + '\'' +
                ", gameId='" + gameId + '\'' +
                ", memoryUtilizationMB=" + memoryUtilizationMB +
                ", isForeground=" + isForeground +
                ", shotNumber=" + shotNumber +
                ", ballSpeedMps=" + ballSpeedMps +
                ", launchAngleDeg=" + launchAngleDeg +
                ", azimuthAngleDeg=" + azimuthAngleDeg +
                ", backspinRpm=" + backspinRpm +
                ", sidespinRpm=" + sidespinRpm +
                ", carryDistanceM=" + carryDistanceM +
                ", worldStartXM=" + worldStartXM +
                ", worldStartYM=" + worldStartYM +
                ", worldStartZM=" + worldStartZM +
                ", resolutionWidth=" + resolutionWidth +
                ", resolutionHeight=" + resolutionHeight +
                ", format=" + format +
                ", frameCount=" + frameCount +
                ", dataEncoding='" + dataEncoding + '\'' +
                ", imageData='" + imageData + '\'' +
                ", score='" + score + '\'' +
                ", clubSpeedMph=" + clubSpeedMph +
                ", clubSpeedAtImpactMph=" + clubSpeedAtImpactMph +
                ", efficiency=" + efficiency +
                ", angleOfAttackDeg=" + angleOfAttackDeg +
                ", lieDeg=" + lieDeg +
                ", loftDeg=" + loftDeg +
                ", fAxisDeg=" + fAxisDeg +
                ", horizontalImpactMm=" + horizontalImpactMm +
                ", verticalImpactMm=" + verticalImpactMm +
                ", faceToTargetDeg=" + faceToTargetDeg +
                ", closingRateDps=" + closingRateDps +
                ", clubPathDeg=" + clubPathDeg +
                ", message='" + message + '\'' +
                ", isLoaded=" + isLoaded +
                ", selectedTee=" + selectedTee +
                ", profileId='" + profileId + '\'' +
                ", playerName='" + playerName + '\'' +
                ", handicap=" + handicap +
                ", handedness='" + handedness + '\'' +
                ", teeBoxId='" + teeBoxId + '\'' +
                ", status='" + status + '\'' +
                ", details='" + details + '\'' +
                ", monsterHealth=" + monsterHealth +
                ", mHeaderposition=" + mHeaderposition +
                ", isGameSelected=" + isGameSelected +
                ", terms='" + terms + '\'' +
                ", totalScore='" + totalScore + '\'' +
                ", shackjackFinalScore='" + shackjackFinalScore + '\'' +
                ", roundNumber='" + roundNumber + '\'' +
                ", scoreList=" + scoreList +
                ", scoreSnapShot=" + scoreSnapShot +
                ", isPlaying=" + isPlaying +
                ", connected=" + connected +
                ", connectionTypeId='" + connectionTypeId + '\'' +
                ", productName='" + productName + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                ", serial='" + serial + '\'' +
                ", teamName='" + teamName + '\'' +
                ", peakHeightFt='" + peakHeightFt + '\'' +
                ", ballSpeedMph='" + ballSpeedMph + '\'' +
                ", totalSpinRpm='" + totalSpinRpm + '\'' +
                ", carryDistanceYds='" + carryDistanceYds + '\'' +
                ", totalDistanceYds='" + totalDistanceYds + '\'' +
                ", avgPeakHeightFt='" + avgPeakHeightFt + '\'' +
                ", avgBallSpeedMph='" + avgBallSpeedMph + '\'' +
                ", avgTotalSpinRpm='" + avgTotalSpinRpm + '\'' +
                ", avgCarryDistanceYds='" + avgCarryDistanceYds + '\'' +
                ", avgTotalDistanceYds='" + avgTotalDistanceYds + '\'' +
                ", isPositionSelection=" + isPositionSelection +
                ", clubType='" + clubType + '\'' +
                '}';
    }
}
