public class RankingServiceFactory {
    private static boolean isTestMode;

    public static void setTestMode(boolean testMode) {
        isTestMode = testMode;
    }

    public static RankingService getRankingService() {
        if(isTestMode)
            return new FakeRankingService();
        return new RankingService();
    }
}
