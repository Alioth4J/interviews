import java.util.*;

public class VerificationCodeLimitV1 {

    // 最多3次
    private static final int MAX_ATTEMPTS = 3;

    // 时间间隔为10分钟
    private static final long TIME_INTERVAL = 10 * 60 * 1000;

    private Map<String, List<Long>> userAttempts = new ConcurrentHashMap<>();

    public boolean allowSend(String userId) {
        long currentTime = System.currentTimeMillis();
        List<Long> attempts = userAttempts.computeIfAbsent(userId, k -> new ArrayList<>());
        synchronized (attempts) {
            // 清理过期的时间戳
            attempts.removeIf(timestamp -> currentTime - timestamp > TIME_INTERVAL);

            if (attempts.size() < MAX_ATTEMPTS) {
                attempts.add(currentTime);
                return true;
            } else {
                return false;
            }
        }
    }

}

