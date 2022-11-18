package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameHistory {

    private List<String> bridgeHistory;
    private int currentIndex;

    public BridgeGameHistory() {
        this.bridgeHistory = new ArrayList<>();
        this.currentIndex = 0;
    }

    public void addBridgeHistory(String next) {
        bridgeHistory.add(next);
        currentIndex++;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public List<String> getBridgeHistory() {
        return bridgeHistory;
    }
}
