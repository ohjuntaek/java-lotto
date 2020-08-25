import domain.Number;
import domain.*;
import view.InputView;
import view.OutputView;

import java.util.Set;

public class LottoGameApp {
    public static void main(String[] args) {
        int money = InputView.getMoney();
        LottoMoney lottoMoney = new LottoMoney(money);
        LottoGame lottoGame = LottoGame.of(money);
        OutputView.printLottoGames(lottoGame.getLottoNumbersList());
        Set<Number> winningNumber = InputView.getWinningNumber();
        LottoNumbers lottoWinningNumbers = new LottoNumbers(winningNumber);
        Number bonusNumber = InputView.getBonusNumber(lottoWinningNumbers);

        WinningInfos winningInfos = OutputView.printWinningInfo(lottoGame, lottoWinningNumbers, bonusNumber);
        OutputView.printBenefitRate(lottoGame, lottoMoney, winningInfos);
    }
}
