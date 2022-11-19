package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private BridgeGameHistory bridgeGameHistory;
    private BridgeGameAnswer bridgeGameAnswer;
    private BridgeGameStatus bridgeGameStatus;

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGameHistory = new BridgeGameHistory();
        bridgeGameStatus = new BridgeGameStatus();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String location) {
        bridgeGameHistory.addBridgeHistory(location);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void createBridge(int size) {
        bridgeGameAnswer = new BridgeGameAnswer(bridgeMaker.makeBridge(size));
    }

    public List<List<String>> getResult() {
        return bridgeGameAnswer.getResultByHistory(bridgeGameHistory.getBridgeHistory());
    }

    public boolean checkGameStatus() {
        return bridgeGameStatus.canPlayGame();
    }

    public void updateGameStatus(String moveLocation) {
        bridgeGameStatus.updateStatus(
                bridgeGameAnswer.isAnswer(moveLocation,
                        bridgeGameHistory.getCurrentIndex()));
    }
}
