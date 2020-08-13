package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMoney {
    public static final int MONEY_PER_GAME = 1000;

    private final int money;

    public LottoMoney(int money) {
        this.money = money;
    }

    public List<LottoNumbers> generateLottoGame() {
        List<LottoNumbers> lottoGames = new ArrayList<>();
        int gameCount = money / MONEY_PER_GAME;

        for (int i = 0; i < gameCount; i++) {
            lottoGames.add(new LottoNumbers(RandomGenerator.getSixRandomNumber()));
        }

        return lottoGames;
    }

    public double getBenefitRate(double winningMoney) {
        return winningMoney / money;
    }
}
