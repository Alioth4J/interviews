import java.util.*;

public class VerificationCodeLimitV2 {

    // 最多3次
    private static final int MAX_ATTEMPTS = 3;

    // 时间间隔为10分钟
    private static final long INTERRUPT_TIME = 10 * 60 * 1000;

    private Map<String, Deque<Long>> userAttempts = new ConcurrentHashMap<>();

    public boolean allowSend(String userId) {
        long currentTime = System.currentTimeMillis();
        Deque<Long> attempts = userAttempts.computeIfAbsent(userId, k -> new ArrayDeque<>());
        synchronized (attempts) {
            while (!attempts.isEmpty() && currentTime - attempts.getFirst() > INTERRUPT_TIME) {
                attempts.removeFirst();
            }
            if (attempts.size() < MAX_ATTEMPTS) {
                attempts.addLast(currentTime);
                return true;
            } else {
                return false;
            }
        }
    }

}

